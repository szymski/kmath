package kscience.kmath.operations

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class QuaternionFieldTest {
    @Test
    fun testAddition() {
        assertEquals(Quaternion(42, 42), QuaternionField { Quaternion(16, 16) + Quaternion(26, 26) })
        assertEquals(Quaternion(42, 16), QuaternionField { Quaternion(16, 16) + 26 })
        assertEquals(Quaternion(42, 16), QuaternionField { 26 + Quaternion(16, 16) })
    }

    @Test
    fun testSubtraction() {
        assertEquals(Quaternion(42, 42), QuaternionField { Quaternion(86, 55) - Quaternion(44, 13) })
        assertEquals(Quaternion(42, 56), QuaternionField { Quaternion(86, 56) - 44 })
        assertTrue(Quaternion(42, 56) - QuaternionField { 86 - Quaternion(44, -56) } < 1e-10.toQuaternion())
    }

    @Test
    fun testMultiplication() {
        assertEquals(Quaternion(42, 42), QuaternionField { Quaternion(4.2, 0) * Quaternion(10, 10) })
        assertEquals(Quaternion(42, 21), QuaternionField { Quaternion(4.2, 2.1) * 10 })
        assertEquals(Quaternion(42, 21), QuaternionField { 10 * Quaternion(4.2, 2.1) })
    }

    @Test
    fun testDivision() {
        assertEquals(Quaternion(42, 42), QuaternionField { Quaternion(0, 168) / Quaternion(2, 2) })
        assertEquals(Quaternion(42, 56), QuaternionField { Quaternion(86, 56) - 44 })
        assertTrue(Quaternion(42, 56) - QuaternionField { 86 - Quaternion(44, -56) } < 1e-10.toQuaternion())
    }

    @Test
    fun testPower() {
        assertEquals(QuaternionField.zero, QuaternionField { zero pow 2 })
        assertEquals(QuaternionField.zero, QuaternionField { zero pow 2 })

        assertEquals(
            QuaternionField { i * 8 }.let { it.x.toInt() to it.w.toInt() },
            QuaternionField { Quaternion(2, 2) pow 2 }.let { it.x.toInt() to it.w.toInt() })
    }
}
