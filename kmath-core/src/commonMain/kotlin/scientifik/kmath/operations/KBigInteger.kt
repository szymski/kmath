package scientifik.kmath.operations

import kotlin.math.max
import kotlin.math.sign

/*
 * Kotlin Multiplatform implementation of Big Integer numbers (KBigInteger).
 * Initial version from https://github.com/robdrynkin/kotlin-big-integer
 */

@kotlin.ExperimentalUnsignedTypes
typealias Magnitude = UIntArray

@kotlin.ExperimentalUnsignedTypes
typealias TBase = ULong

object KBigIntegerRing: Ring<KBigInteger> {
    override val zero: KBigInteger = KBigInteger.ZERO
    override val one: KBigInteger = KBigInteger.ONE

    override fun add(a: KBigInteger, b: KBigInteger): KBigInteger = a.plus(b)

    override fun multiply(a: KBigInteger, k: Number): KBigInteger = a.times(k.toLong())

    override fun multiply(a: KBigInteger, b: KBigInteger): KBigInteger = a.times(b)

    operator fun String.unaryPlus(): KBigInteger = KBigInteger(this)!!

    operator fun String.unaryMinus(): KBigInteger = -KBigInteger(this)!!

}


@kotlin.ExperimentalUnsignedTypes
class KBigInteger(sign: Int = 0, magnitude: Magnitude = Magnitude(0)):
        RingElement<KBigInteger, KBigInteger, KBigIntegerRing>, Comparable<KBigInteger> {

    constructor(x: Int) : this(x.sign, uintArrayOf(kotlin.math.abs(x).toUInt()))
    constructor(x: Long) : this(x.sign, uintArrayOf(
            (kotlin.math.abs(x).toULong() and BASE).toUInt(),
            ((kotlin.math.abs(x).toULong() shr BASE_SIZE) and BASE).toUInt()))

    val magnitude = stripLeadingZeros(magnitude)
    val sign = if (this.magnitude.isNotEmpty()) sign else 0
    val sizeByte: Int = magnitude.size * BASE_SIZE / 4

    override val context: KBigIntegerRing get() = KBigIntegerRing

    override fun unwrap(): KBigInteger = this
    override fun KBigInteger.wrap(): KBigInteger = this

    companion object {
        val BASE = 0xffffffffUL
        const val BASE_SIZE: Int = 32
        val ZERO: KBigInteger = KBigInteger()
        val ONE: KBigInteger = KBigInteger(1)

        private val hexMapping: HashMap<UInt, String> =
                hashMapOf(
                        0U to "0", 1U to "1", 2U to "2", 3U to "3", 4U to "4", 5U to "5", 6U to "6", 7U to "7", 8U to "8",
                        9U to "9", 10U to "a", 11U to "b", 12U to "c", 13U to "d", 14U to "e", 15U to "f"
                )

        private fun stripLeadingZeros(mag: Magnitude): Magnitude {
            // TODO: optimize performance
            if (mag.isEmpty()) {
                return mag
            }
            var resSize: Int = mag.size - 1
            while (mag[resSize] == 0U) {
                if (resSize == 0)
                    break
                resSize -= 1
            }
            return mag.sliceArray(IntRange(0, resSize))
        }

        private fun compareMagnitudes(mag1: Magnitude, mag2: Magnitude): Int {
            when {
                mag1.size > mag2.size -> return 1
                mag1.size < mag2.size -> return -1
                else -> {
                    for (i in mag1.size - 1 downTo 0) {
                        if (mag1[i] > mag2[i]) {
                            return 1
                        } else if (mag1[i] < mag2[i]) {
                            return -1
                        }
                    }
                    return 0
                }
            }
        }

        private fun addMagnitudes(mag1: Magnitude, mag2: Magnitude): Magnitude {
            val resultLength: Int = max(mag1.size, mag2.size) + 1
            val result = Magnitude(resultLength)
            var carry: TBase = 0UL

            for (i in 0 until resultLength - 1) {
                val res = when {
                    i >= mag1.size -> mag2[i].toULong() + carry
                    i >= mag2.size -> mag1[i].toULong() + carry
                    else -> mag1[i].toULong() + mag2[i].toULong() + carry
                }
                result[i] = (res and BASE).toUInt()
                carry = (res shr BASE_SIZE)
            }
            result[resultLength - 1] = carry.toUInt()
            return result
        }

        private fun subtractMagnitudes(mag1: Magnitude, mag2: Magnitude): Magnitude {
            val resultLength: Int = mag1.size
            val result = Magnitude(resultLength)
            var carry = 0L

            for (i in 0 until resultLength) {
                var res: Long =
                        if (i < mag2.size) mag1[i].toLong() - mag2[i].toLong() - carry
                        else mag1[i].toLong() - carry

                carry = if (res < 0) 1 else 0
                res += carry * (BASE + 1UL).toLong()

                result[i] = res.toUInt()
            }

            return result
        }

        private fun multiplyMagnitudeByUInt(mag: Magnitude, x: UInt): Magnitude {
            val resultLength: Int = mag.size + 1
            val result = Magnitude(resultLength)
            var carry: ULong = 0UL

            for (i in mag.indices) {
                val cur: ULong = carry + mag[i].toULong() * x.toULong()
                result[i] = (cur and BASE.toULong()).toUInt()
                carry = cur shr BASE_SIZE
            }
            result[resultLength - 1] = (carry and BASE).toUInt()

            return result
        }

        private fun multiplyMagnitudes(mag1: Magnitude, mag2: Magnitude): Magnitude {
            val resultLength: Int = mag1.size + mag2.size
            val result = Magnitude(resultLength)

            for (i in mag1.indices) {
                var carry: ULong = 0UL
                for (j in mag2.indices) {
                    val cur: ULong = result[i + j].toULong() + mag1[i].toULong() * mag2[j].toULong() + carry
                    result[i + j] = (cur and BASE.toULong()).toUInt()
                    carry = cur shr BASE_SIZE
                }
                result[i + mag2.size] = (carry and BASE).toUInt()
            }

            return result
        }

        internal fun divideMagnitudeByUInt(mag: Magnitude, x: UInt): Magnitude {
            val resultLength: Int = mag.size
            val result = Magnitude(resultLength)
            var carry: ULong = 0UL

            for (i in mag.size - 1 downTo 0) {
                val cur: ULong = mag[i].toULong() + (carry shl BASE_SIZE)
                result[i] = (cur / x).toUInt()
                carry = cur % x
            }
            return result
        }

        internal fun divideMagnitudes(mag1_: Magnitude, mag2: Magnitude): Magnitude {
            val mag1 = ULongArray(mag1_.size) { mag1_[it].toULong() }

            val resultLength: Int = mag1.size - mag2.size + 1
            val result = LongArray(resultLength)

            for (i in mag1.size - 1 downTo mag2.size - 1) {
                val div: ULong = mag1[i] / mag2[mag2.size - 1]
                result[i - mag2.size + 1] = div.toLong()
                for (j in mag2.indices) {
                    mag1[i - j] -= mag2[mag2.size - 1 - j] * div
                }
                if (i > 0) {
                    mag1[i - 1] += (mag1[i] shl BASE_SIZE)
                }
            }

            val normalizedResult = Magnitude(resultLength)
            var carry = 0L

            for (i in result.indices) {
                result[i] += carry
                if (result[i] < 0L) {
                    normalizedResult[i] = (result[i] + (BASE + 1UL).toLong()).toUInt()
                    carry = -1
                } else {
                    normalizedResult[i] = result[i].toUInt()
                    carry = 0
                }
            }

            return normalizedResult
        }
    }

    override fun compareTo(other: KBigInteger): Int {
        return when {
            (this.sign == 0) and (other.sign == 0) -> 0
            this.sign < other.sign -> -1
            this.sign > other.sign -> 1
            else -> this.sign * compareMagnitudes(this.magnitude, other.magnitude)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other is KBigInteger) {
            return this.compareTo(other) == 0
        }
        else error("Can't compare KBigInteger to a different type")
    }

    override fun hashCode(): Int {
        return magnitude.hashCode() + this.sign
    }

    operator fun unaryMinus(): KBigInteger {
        return if (this.sign == 0) this else KBigInteger(-this.sign, this.magnitude)
    }

    override operator fun plus(b: KBigInteger): KBigInteger {
        return when {
            b.sign == 0 -> this
            this.sign == 0 -> b
            this == -b -> ZERO
            this.sign == b.sign -> KBigInteger(this.sign, addMagnitudes(this.magnitude, b.magnitude))
            else -> {
                val comp: Int = compareMagnitudes(this.magnitude, b.magnitude)

                if (comp == 1) {
                    KBigInteger(this.sign, subtractMagnitudes(this.magnitude, b.magnitude))
                } else {
                    KBigInteger(-this.sign, subtractMagnitudes(b.magnitude, this.magnitude))
                }
            }
        }
    }

    override operator fun minus(b: KBigInteger): KBigInteger {
        return this + (-b)
    }

    override operator fun times(b: KBigInteger): KBigInteger {
        return when {
            this.sign == 0 -> ZERO
            b.sign == 0 -> ZERO
//          TODO: Karatsuba
            else -> KBigInteger(this.sign * b.sign, multiplyMagnitudes(this.magnitude, b.magnitude))
        }
    }

    operator fun times(other: UInt): KBigInteger {
        return when {
            this.sign == 0 -> ZERO
            other == 0U -> ZERO
            else -> KBigInteger(this.sign, multiplyMagnitudeByUInt(this.magnitude, other))
        }
    }

    operator fun times(other: Int): KBigInteger {
        return if (other > 0)
            this * kotlin.math.abs(other).toUInt()
        else
            -this * kotlin.math.abs(other).toUInt()
    }

    operator fun div(other: UInt): KBigInteger {
        return KBigInteger(this.sign, divideMagnitudeByUInt(this.magnitude, other))
    }

    operator fun div(other: Int): KBigInteger {
        return KBigInteger(this.sign * other.sign, divideMagnitudeByUInt(this.magnitude, kotlin.math.abs(other).toUInt()))
    }

    operator fun div(other: KBigInteger): KBigInteger {
        return when {
            this < other -> ZERO
            this == other -> ONE
            else -> KBigInteger(this.sign * other.sign, divideMagnitudes(this.magnitude, other.magnitude))
        }
    }

    operator fun rem(other: Int): Int {
        val res = this - (this / other) * other
        return if (res == ZERO) 0 else res.sign * res.magnitude[0].toInt()
    }

    operator fun rem(other: KBigInteger): KBigInteger {
        return this - (this / other) * other
    }

    fun modPow(exponent: KBigInteger, m: KBigInteger): KBigInteger {
        return when {
            exponent == ZERO -> ONE
            exponent % 2 == 1 -> (this * modPow(exponent - ONE, m)) % m
            else -> {
                val sqRoot = modPow(exponent / 2, m)
                (sqRoot * sqRoot) % m
            }
        }
    }

    override fun toString(): String {
        if (this.sign == 0) {
            return "0x0"
        }
        var res: String = if (this.sign == -1) "-0x" else "0x"
        var numberStarted = false

        for (i in this.magnitude.size - 1 downTo 0) {
            for (j in BASE_SIZE / 4 - 1 downTo 0) {
                val curByte = (this.magnitude[i] shr 4 * j) and 0xfU
                if (numberStarted or (curByte != 0U)) {
                    numberStarted = true
                    res += hexMapping[curByte]
                }
            }
        }

        return res
    }
}

@kotlin.ExperimentalUnsignedTypes
fun abs(x: KBigInteger): KBigInteger {
    return if (x.sign == 0) x else KBigInteger(1, x.magnitude)
}

@kotlin.ExperimentalUnsignedTypes
// Can't put it as constructor in class due to platform declaration clash with KBigInteger(Int)
fun KBigInteger(x: UInt): KBigInteger
        = KBigInteger(1, uintArrayOf(x))

@kotlin.ExperimentalUnsignedTypes
// Can't put it as constructor in class due to platform declaration clash with KBigInteger(Long)
fun KBigInteger(x: ULong): KBigInteger
        = KBigInteger(1, uintArrayOf((x and KBigInteger.BASE).toUInt(), ((x shr KBigInteger.BASE_SIZE) and KBigInteger.BASE).toUInt()))

val hexChToInt = hashMapOf('0' to 0, '1' to 1, '2' to 2, '3' to 3, '4' to 4, '5' to 5, '6' to 6, '7' to 7,
        '8' to 8, '9' to 9, 'A' to 10, 'B' to 11, 'C' to 12, 'D' to 13, 'E' to 14, 'F' to 15)

// Returns None if a valid number can not be read from a string
fun KBigInteger(s: String): KBigInteger? {
    val sign: Int
    val sPositive: String
    when {
        s[0] == '+' -> {
            sign = +1
            sPositive = s.substring(1)
        }
        s[0] == '-' -> {
            sign = -1
            sPositive = s.substring(1)
        }
        else -> {
            sPositive = s
            sign = +1
        }
    }
    var res = KBigInteger.ZERO
    var digitValue = KBigInteger.ONE
    val sPositiveUpper = sPositive.toUpperCase()
    if (sPositiveUpper.startsWith("0X")) {  // hex representation
        val sHex = sPositiveUpper.substring(2)
        for (ch in sHex.reversed()) {
            if (ch == '_') continue
            res +=  digitValue * (hexChToInt[ch] ?: return null)
            digitValue *= KBigInteger(16)
        }
    }
    else { // decimal representation
        val sDecimal = sPositiveUpper
        for (ch in sDecimal.reversed()) {
            if (ch == '_') continue
            if (ch !in '0'..'9') {
                return null
            }
            res +=  digitValue * (ch.toInt() - '0'.toInt())
            digitValue *= KBigInteger(10)
        }
    }
    return  res * sign
}
