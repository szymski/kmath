package scientifik.kmath.operations

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertEquals

@kotlin.ExperimentalUnsignedTypes
class KBigIntegerConstructorTest {
    @Test
    fun testConstructorZero() {
        assertEquals(KBigInteger(0), KBigInteger(0, uintArrayOf()))
    }

    @Test
    fun testConstructor8() {
        assertEquals(KBigInteger(8), KBigInteger(1, uintArrayOf(8U)))
    }

    @Test
    fun testConstructor_0xffffffffaL() {
        val x = KBigInteger(-0xffffffffaL)
        val y = KBigInteger(-1, uintArrayOf(0xfffffffaU, 0xfU))
        assertEquals(x, y)
    }
}

@kotlin.ExperimentalUnsignedTypes
class KBigIntegerCompareTest {
    @Test
    fun testCompare1_2() {
        val x = KBigInteger(1)
        val y = KBigInteger(2)
        assertTrue { x < y }
    }

    @Test
    fun testCompare0_0() {
        val x = KBigInteger(0)
        val y = KBigInteger(0)
        assertEquals(x, y)
    }

    @Test
    fun testCompare1__2() {
        val x = KBigInteger(1)
        val y = KBigInteger(-2)
        assertTrue { x > y }
    }

    @Test
    fun testCompare_1__2() {
        val x = KBigInteger(-1)
        val y = KBigInteger(-2)
        assertTrue { x > y }
    }

    @Test
    fun testCompare_2__1() {
        val x = KBigInteger(-2)
        val y = KBigInteger(-1)
        assertTrue { x < y }
    }

    @Test
    fun testCompare12345_12345() {
        val x = KBigInteger(12345)
        val y = KBigInteger(12345)
        assertEquals(x, y)
    }

    @Test
    fun testEqualsWithLong() {
        val x = KBigInteger(12345)
        assertTrue { x == KBigInteger(12345L) }
    }

    @Test
    fun testEqualsWithULong() {
        val x = KBigInteger(12345)
        assertTrue { x == KBigInteger(12345UL) }
    }

    @Test
    fun testCompareBigNumbersGreater() {
        val x = KBigInteger(0xfffffffffL)
        val y = KBigInteger(0xffffffffaL)
        assertTrue { x > y }
    }

    @Test
    fun testCompareBigNumbersEqual() {
        val x = KBigInteger(0xffffffffaL)
        val y = KBigInteger(0xffffffffaL)
        assertEquals(x, y)
    }

    @Test
    fun testCompareBigNumbersLess() {
        val x = KBigInteger(-0xffffffffaL)
        val y = KBigInteger(0xffffffffaL)
        assertTrue { x < y }
    }
}

@kotlin.ExperimentalUnsignedTypes
class KBigIntegerOperationsTest {
    @Test
    fun testPlus_1_1() {
        val x = KBigInteger(1)
        val y = KBigInteger(1)

        val res = x + y
        val sum = KBigInteger(2)

        assertEquals(sum, res)
    }

    @Test
    fun testPlusBigNumbers() {
        val x = KBigInteger(0x7fffffff)
        val y = KBigInteger(0x7fffffff)
        val z = KBigInteger(0x7fffffff)

        val res = x + y + z
        val sum = KBigInteger(1, uintArrayOf(0x7ffffffdU, 0x1U))

        assertEquals(sum, res)
    }

    @Test
    fun testUnaryMinus() {
        val x = KBigInteger(1234)
        val y = KBigInteger(-1234)
        assertEquals(-x, y)
    }

    @Test
    fun testMinus_2_1() {
        val x = KBigInteger(2)
        val y = KBigInteger(1)

        val res = x - y
        val sum = KBigInteger(1)

        assertEquals(sum, res)
    }

    @Test
    fun testMinus__2_1() {
        val x = KBigInteger(-2)
        val y = KBigInteger(1)

        val res = x - y
        val sum = KBigInteger(-3)

        assertEquals(sum, res)
    }

    @Test
    fun testMinus___2_1() {
        val x = KBigInteger(-2)
        val y = KBigInteger(1)

        val res = -x - y
        val sum = KBigInteger(1)

        assertEquals(sum, res)
    }

    @Test
    fun testMinusBigNumbers() {
        val x = KBigInteger(12345)
        val y = KBigInteger(0xffffffffaL)

        val res = x - y
        val sum = KBigInteger(-0xfffffcfc1L)

        assertEquals(sum, res)
    }

    @Test
    fun testMultiply_2_3() {
        val x = KBigInteger(2)
        val y = KBigInteger(3)

        val res = x * y
        val prod = KBigInteger(6)

        assertEquals(prod, res)
    }

    @Test
    fun testMultiply__2_3() {
        val x = KBigInteger(-2)
        val y = KBigInteger(3)

        val res = x * y
        val prod = KBigInteger(-6)

        assertEquals(prod, res)
    }

    @Test
    fun testMultiply_0xfff123_0xfff456() {
        val x = KBigInteger(0xfff123)
        val y = KBigInteger(0xfff456)

        val res = x * y
        val prod = KBigInteger(0xffe579ad5dc2L)

        assertEquals(prod, res)
    }

    @Test
    fun testMultiplyUInt_0xfff123_0xfff456() {
        val x = KBigInteger(0xfff123)
        val y = 0xfff456U

        val res = x * y
        val prod = KBigInteger(0xffe579ad5dc2L)

        assertEquals(prod, res)
    }

    @Test
    fun testMultiplyInt_0xfff123__0xfff456() {
        val x = KBigInteger(0xfff123)
        val y = -0xfff456

        val res = x * y
        val prod = KBigInteger(-0xffe579ad5dc2L)

        assertEquals(prod, res)
    }

    @Test
    fun testMultiply_0xffffffff_0xffffffff() {
        val x = KBigInteger(0xffffffffL)
        val y = KBigInteger(0xffffffffL)

        val res = x * y
        val prod = KBigInteger(0xfffffffe00000001UL)

        assertEquals(prod, res)
    }

    @Test
    fun test_square_0x11223344U_0xad2ffffdU_0x17eU() {
        val num = KBigInteger(-1, uintArrayOf(0x11223344U, 0xad2ffffdU, 0x17eU ))
        println(num)
        val res = num * num
        assertEquals(res, KBigInteger(1, uintArrayOf(0xb0542a10U, 0xbbd85bc8U, 0x2a1fa515U, 0x5069e03bU, 0x23c09U)))
    }

    @Test
    fun testDivision_6_3() {
        val x = KBigInteger(6)
        val y = 3U

        val res = x / y
        val div = KBigInteger(2)

        assertEquals(div, res)
    }

    @Test
    fun testBigDivision_6_3() {
        val x = KBigInteger(6)
        val y = KBigInteger(3)

        val res = x / y
        val div = KBigInteger(2)

        assertEquals(div, res)
    }

    @Test
    fun testDivision_20__3() {
        val x = KBigInteger(20)
        val y = -3

        val res = x / y
        val div = KBigInteger(-6)

        assertEquals(div, res)
    }

    @Test
    fun testBigDivision_20__3() {
        val x = KBigInteger(20)
        val y = KBigInteger(-3)

        val res = x / y
        val div = KBigInteger(-6)

        assertEquals(div, res)
    }

    @Test
    fun testDivision_0xfffffffe00000001_0xffffffff() {
        val x = KBigInteger(0xfffffffe00000001UL)
        val y = 0xffffffffU

        val res = x / y
        val div = KBigInteger(0xffffffffL)

        assertEquals(div, res)
    }

    @Test
    fun testBigDivision_0xfffffffe00000001_0xffffffff() {
        val x = KBigInteger(0xfffffffe00000001UL)
        val y = KBigInteger(0xffffffffU)

        val res = x / y
        val div = KBigInteger(0xffffffffL)

        assertEquals(div, res)
    }

    @Test
    fun testMod_20_3() {
        val x = KBigInteger(20)
        val y = 3

        val res = x % y
        val mod = 2

        assertEquals(mod, res)
    }

    @Test
    fun testBigMod_20_3() {
        val x = KBigInteger(20)
        val y = KBigInteger(3)

        val res = x % y
        val mod = KBigInteger(2)

        assertEquals(mod, res)
    }

    @Test
    fun testMod_0xfffffffe00000001_12345() {
        val x = KBigInteger(0xfffffffe00000001UL)
        val y = 12345

        val res = x % y
        val mod = 1980

        assertEquals(mod, res)
    }

    @Test
    fun testBigMod_0xfffffffe00000001_12345() {
        val x = KBigInteger(0xfffffffe00000001UL)
        val y = KBigInteger(12345)

        val res = x % y
        val mod = KBigInteger(1980)

        assertEquals(mod, res)
    }

    @Test
    fun testModPow_3_10_17() {
        val x = KBigInteger(3)
        val exp = KBigInteger(10)
        val mod = KBigInteger(17)

        val res = KBigInteger(8)

        return assertEquals(res, x.modPow(exp, mod))
    }

    @Test
    fun testModPowBigNumbers() {
        val x = KBigInteger(0xfffffffeabcdef01UL)
        val exp = KBigInteger(2)
        val mod = KBigInteger(0xfffffffeabcUL)

        val res = KBigInteger(0x6deec7895faUL)

        return assertEquals(res, x.modPow(exp, mod))
    }

    @Test
    fun testModBigNumbers() {
        val x = KBigInteger(0xfffffffeabcdef01UL)
        val mod = KBigInteger(0xfffffffeabcUL)

        val res = KBigInteger(0xdef01)

        return assertEquals(res, x % mod)
    }
}

@kotlin.ExperimentalUnsignedTypes
class KBigIntegerConversionsTest {
    @Test
    fun testToString0x10() {
        val x = KBigInteger(0x10)
        assertEquals("0x10", x.toString())
    }

    @Test
    fun testToString0x17ffffffd() {
        val x = KBigInteger(0x17ffffffdL)
        assertEquals("0x17ffffffd", x.toString())
    }

    @Test
    fun testToString_0x17ead2ffffd() {
        val x = KBigInteger(-0x17ead2ffffdL)
        assertEquals("-0x17ead2ffffd", x.toString())
    }

    @Test
    fun testToString_0x17ead2ffffd11223344() {
        val x = KBigInteger(-1, uintArrayOf(0x11223344U, 0xad2ffffdU, 0x17eU ))
        assertEquals("-0x17ead2ffffd11223344", x.toString())
    }

    @Test
    fun testFromString_0x17ead2ffffd11223344() {
        val x = KBigInteger("0x17ead2ffffd11223344")!!
        assertEquals( "0x17ead2ffffd11223344", x.toString())
    }

    @Test
    fun testFromString_7059135710711894913860() {
        val x = KBigInteger("-7059135710711894913860")
        assertEquals("-0x17ead2ffffd11223344", x.toString())
    }
}

@kotlin.ExperimentalUnsignedTypes
class DivisionTests {
    // TODO
    @Test
    fun test_0xfffffffeabcdef01UL_0xfffffffeabc() {
        val res = KBigInteger(0xfffffffeabcdef01UL) / KBigInteger(0xfffffffeabc)
        assertEquals(res, KBigInteger(0x100000))

    }

//        println(KBigInteger(+1, uintArrayOf(1000U, 1000U, 1000U)) / KBigInteger(0xfffffffeabc)  )
        // >>> hex((1000 + 1000*2**32 + 1000*2**64)/ 0xfffffffeabc) == 0x3e800000L
//        println(KBigInteger(+1, KBigInteger.divideMagnitudeByUInt(uintArrayOf(1000U, 1000U, 1000U),456789U)))
        // 0x8f789719813969L

}

class KBigIntegerRingTest {
    @Test
    fun testSum() {
        val res = KBigIntegerRing {
            KBigInteger(1_000L) * KBigInteger(1_000L)
        }
        assertEquals(res, KBigInteger(1_000_000) )
    }

    @Test
    fun test_sum_100_000_000__100_000_000() {
        KBigIntegerRing {
            val sum = +"100_000_000" + +"100_000_000"
            assertEquals(sum, KBigInteger("200_000_000"))
        }
    }

    @Test
    fun test_mul_3__4() {
        KBigIntegerRing {
            val prod = +"0x3000_0000_0000" * +"0x4000_0000_0000_0000_0000"
            assertEquals(prod, KBigInteger("0xc00_0000_0000_0000_0000_0000_0000_0000"))
        }
    }

}

