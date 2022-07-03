/*
 * Copyright 2018-2021 KMath contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package space.kscience.kmath.functions

import space.kscience.kmath.test.misc.Rational
import space.kscience.kmath.test.misc.RationalField
import space.kscience.kmath.test.misc.assertEquals
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals


class NumberedPolynomialUtilTest {
    @Test
    fun test_Polynomial_substitute_Double_Map() {
        assertEquals(
            NumberedPolynomialAsIs(emptyList<UInt>() to 0.0),
            NumberedPolynomialAsIs(
                listOf<UInt>() to 1.0,
                listOf(1u) to -2.0,
                listOf(2u) to 1.0,
            ).substitute(mapOf(
                0 to 1.0
            )),
            0.001,
            "test 1"
        )
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to 0.8597048543814783,
                listOf(1u) to 0.22997637465889875,
                listOf(2u) to 0.32675302591924016,
                listOf(0u, 1u) to 0.4561746111587508,
                listOf(1u, 1u) to 0.5304946210170756,
                listOf(2u, 1u) to 0.6244313712888998,
                listOf(0u, 2u) to 0.2700930201481795,
                listOf(1u, 2u) to -0.06962351375204712,
                listOf(2u, 2u) to -0.015206988092131501,
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to 0.8597048543814783,
                listOf(1u) to 0.22997637465889875,
                listOf(2u) to 0.32675302591924016,
                listOf(0u, 1u) to 0.4561746111587508,
                listOf(1u, 1u) to 0.5304946210170756,
                listOf(2u, 1u) to 0.6244313712888998,
                listOf(0u, 2u) to 0.2700930201481795,
                listOf(1u, 2u) to -0.06962351375204712,
                listOf(2u, 2u) to -0.015206988092131501,
            ).substitute(mapOf()),
            0.001,
            "test 2"
        )
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to 0.8597048543814783,
                listOf(1u) to 0.22997637465889875,
                listOf(2u) to 0.32675302591924016,
                listOf(0u, 1u) to 0.4561746111587508,
                listOf(1u, 1u) to 0.5304946210170756,
                listOf(2u, 1u) to 0.6244313712888998,
                listOf(0u, 2u) to 0.2700930201481795,
                listOf(1u, 2u) to -0.06962351375204712,
                listOf(2u, 2u) to -0.015206988092131501,
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to 0.8597048543814783,
                listOf(1u) to 0.22997637465889875,
                listOf(2u) to 0.32675302591924016,
                listOf(0u, 1u) to 0.4561746111587508,
                listOf(1u, 1u) to 0.5304946210170756,
                listOf(2u, 1u) to 0.6244313712888998,
                listOf(0u, 2u) to 0.2700930201481795,
                listOf(1u, 2u) to -0.06962351375204712,
                listOf(2u, 2u) to -0.015206988092131501,
            ).substitute(mapOf(
                5 to 0.9211194782050933
            )),
            0.001,
            "test 2'"
        )
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to 0.8597048543814783,
                listOf(0u, 1u) to 0.4561746111587508,
                listOf(0u, 2u) to 0.2700930201481795,
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to 0.8597048543814783,
                listOf(1u) to 0.22997637465889875,
                listOf(2u) to 0.32675302591924016,
                listOf(0u, 1u) to 0.4561746111587508,
                listOf(1u, 1u) to 0.5304946210170756,
                listOf(2u, 1u) to 0.6244313712888998,
                listOf(0u, 2u) to 0.2700930201481795,
                listOf(1u, 2u) to -0.06962351375204712,
                listOf(2u, 2u) to -0.015206988092131501,
            ).substitute(mapOf(
                0 to 0.0
            )),
            0.001,
            "test 3"
        )
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to 0.8597048543814783,
                listOf(0u, 1u) to 0.4561746111587508,
                listOf(0u, 2u) to 0.2700930201481795,
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to 0.8597048543814783,
                listOf(1u) to 0.22997637465889875,
                listOf(2u) to 0.32675302591924016,
                listOf(0u, 1u) to 0.4561746111587508,
                listOf(1u, 1u) to 0.5304946210170756,
                listOf(2u, 1u) to 0.6244313712888998,
                listOf(0u, 2u) to 0.2700930201481795,
                listOf(1u, 2u) to -0.06962351375204712,
                listOf(2u, 2u) to -0.015206988092131501,
            ).substitute(mapOf(
                0 to 0.0,
                5 to 0.9211194782050933
            )),
            0.001,
            "test 3'"
        )
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to 1.433510890645169,
                listOf(1u) to 0.6264844682514724,
                listOf(2u) to 0.8405727903771333,
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to 0.8597048543814783,
                listOf(1u) to 0.22997637465889875,
                listOf(2u) to 0.32675302591924016,
                listOf(0u, 1u) to 0.4561746111587508,
                listOf(1u, 1u) to 0.5304946210170756,
                listOf(2u, 1u) to 0.6244313712888998,
                listOf(0u, 2u) to 0.2700930201481795,
                listOf(1u, 2u) to -0.06962351375204712,
                listOf(2u, 2u) to -0.015206988092131501,
            ).substitute(mapOf(
                1 to 0.8400458576651112
            )),
            0.001,
            "test 4"
        )
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to 1.433510890645169,
                listOf(1u) to 0.6264844682514724,
                listOf(2u) to 0.8405727903771333,
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to 0.8597048543814783,
                listOf(1u) to 0.22997637465889875,
                listOf(2u) to 0.32675302591924016,
                listOf(0u, 1u) to 0.4561746111587508,
                listOf(1u, 1u) to 0.5304946210170756,
                listOf(2u, 1u) to 0.6244313712888998,
                listOf(0u, 2u) to 0.2700930201481795,
                listOf(1u, 2u) to -0.06962351375204712,
                listOf(2u, 2u) to -0.015206988092131501,
            ).substitute(mapOf(
                1 to 0.8400458576651112,
                5 to 0.9211194782050933
            )),
            0.001,
            "test 4'"
        )
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to 1.934530767358133,
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to 0.8597048543814783,
                listOf(1u) to 0.22997637465889875,
                listOf(2u) to 0.32675302591924016,
                listOf(0u, 1u) to 0.4561746111587508,
                listOf(1u, 1u) to 0.5304946210170756,
                listOf(2u, 1u) to 0.6244313712888998,
                listOf(0u, 2u) to 0.2700930201481795,
                listOf(1u, 2u) to -0.06962351375204712,
                listOf(2u, 2u) to -0.015206988092131501,
            ).substitute(mapOf(
                0 to 0.4846192734143442,
                1 to 0.8400458576651112,
            )),
            0.001,
            "test 5"
        )
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to 1.934530767358133,
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to 0.8597048543814783,
                listOf(1u) to 0.22997637465889875,
                listOf(2u) to 0.32675302591924016,
                listOf(0u, 1u) to 0.4561746111587508,
                listOf(1u, 1u) to 0.5304946210170756,
                listOf(2u, 1u) to 0.6244313712888998,
                listOf(0u, 2u) to 0.2700930201481795,
                listOf(1u, 2u) to -0.06962351375204712,
                listOf(2u, 2u) to -0.015206988092131501,
            ).substitute(mapOf(
                0 to 0.4846192734143442,
                1 to 0.8400458576651112,
                5 to 0.9211194782050933
            )),
            0.001,
            "test 5'"
        )
    }
    @Test
    fun test_Polynomial_substitute_Constant_Map() {
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(0)
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(1),
                listOf(1u) to Rational(-2),
                listOf(2u) to Rational(1)
            ).substitute(RationalField, mapOf(
                0 to Rational(1)
            )),
            "test 1"
        )
        // https://www.wolframalpha.com/input?i=%28-3%2F2+%2B+8%2F6+x+%2B+14%2F6+x%5E2%29+%2B+%28-3%2F1+%2B+-19%2F2+x+%2B+9%2F4+x%5E2%29+y+%2B+%285%2F5+%2B+18%2F9+x+%2B+5%2F2+x%5E2%29+y%5E2+where+x+%3D+-2%2F5%2C+y+%3D+12%2F9
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(143, 150)
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(8, 6),
                listOf(2u) to Rational(14, 6),
                listOf(0u, 1u) to Rational(-3, 1),
                listOf(1u, 1u) to Rational(-19, 2),
                listOf(2u, 1u) to Rational(9, 4),
                listOf(0u, 2u) to Rational(5, 5),
                listOf(1u, 2u) to Rational(18, 9),
                listOf(2u, 2u) to Rational(5, 2),
            ).substitute(RationalField, mapOf(
                0 to Rational(-2, 5),
                1 to Rational(12, 9),
            )),
            "test 2"
        )
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(143, 150)
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(8, 6),
                listOf(2u) to Rational(14, 6),
                listOf(0u, 1u) to Rational(-3, 1),
                listOf(1u, 1u) to Rational(-19, 2),
                listOf(2u, 1u) to Rational(9, 4),
                listOf(0u, 2u) to Rational(5, 5),
                listOf(1u, 2u) to Rational(18, 9),
                listOf(2u, 2u) to Rational(5, 2),
            ).substitute(RationalField, mapOf(
                0 to Rational(-2, 5),
                1 to Rational(12, 9),
                5 to Rational(57, 179),
            )),
            "test 2'"
        )
        // https://www.wolframalpha.com/input?i=%28-3%2F2+%2B+8%2F6+x+%2B+14%2F6+x%5E2%29+%2B+%28-3%2F1+%2B+-19%2F2+x+%2B+9%2F4+x%5E2%29+y+%2B+%285%2F5+%2B+18%2F9+x+%2B+5%2F2+x%5E2%29+y%5E2+where+y+%3D+12%2F9
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-67, 18),
                listOf(1u) to Rational(-70, 9),
                listOf(2u) to Rational(88, 9),
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(8, 6),
                listOf(2u) to Rational(14, 6),
                listOf(0u, 1u) to Rational(-3, 1),
                listOf(1u, 1u) to Rational(-19, 2),
                listOf(2u, 1u) to Rational(9, 4),
                listOf(0u, 2u) to Rational(5, 5),
                listOf(1u, 2u) to Rational(18, 9),
                listOf(2u, 2u) to Rational(5, 2),
            ).substitute(RationalField, mapOf(
                1 to Rational(12, 9),
            )),
            "test 3"
        )
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-67, 18),
                listOf(1u) to Rational(-70, 9),
                listOf(2u) to Rational(88, 9),
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(8, 6),
                listOf(2u) to Rational(14, 6),
                listOf(0u, 1u) to Rational(-3, 1),
                listOf(1u, 1u) to Rational(-19, 2),
                listOf(2u, 1u) to Rational(9, 4),
                listOf(0u, 2u) to Rational(5, 5),
                listOf(1u, 2u) to Rational(18, 9),
                listOf(2u, 2u) to Rational(5, 2),
            ).substitute(RationalField, mapOf(
                1 to Rational(12, 9),
                5 to Rational(57, 179),
            )),
            "test 3'"
        )
        // https://www.wolframalpha.com/input?i=%28-3%2F2+%2B+8%2F6+x+%2B+14%2F6+x%5E2%29+%2B+%28-3%2F1+%2B+-19%2F2+x+%2B+9%2F4+x%5E2%29+y+%2B+%285%2F5+%2B+18%2F9+x+%2B+5%2F2+x%5E2%29+y%5E2+where+x+%3D+-2%2F5
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-83, 50),
                listOf(0u, 1u) to Rational(29, 25),
                listOf(0u, 2u) to Rational(3, 5),
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(8, 6),
                listOf(2u) to Rational(14, 6),
                listOf(0u, 1u) to Rational(-3, 1),
                listOf(1u, 1u) to Rational(-19, 2),
                listOf(2u, 1u) to Rational(9, 4),
                listOf(0u, 2u) to Rational(5, 5),
                listOf(1u, 2u) to Rational(18, 9),
                listOf(2u, 2u) to Rational(5, 2),
            ).substitute(RationalField, mapOf(
                0 to Rational(-2, 5),
            )),
            "test 4"
        )
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-83, 50),
                listOf(0u, 1u) to Rational(29, 25),
                listOf(0u, 2u) to Rational(3, 5),
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(8, 6),
                listOf(2u) to Rational(14, 6),
                listOf(0u, 1u) to Rational(-3, 1),
                listOf(1u, 1u) to Rational(-19, 2),
                listOf(2u, 1u) to Rational(9, 4),
                listOf(0u, 2u) to Rational(5, 5),
                listOf(1u, 2u) to Rational(18, 9),
                listOf(2u, 2u) to Rational(5, 2),
            ).substitute(RationalField, mapOf(
                0 to Rational(-2, 5),
                5 to Rational(57, 179),
            )),
            "test 4'"
        )
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(8, 6),
                listOf(2u) to Rational(14, 6),
                listOf(0u, 1u) to Rational(-3, 1),
                listOf(1u, 1u) to Rational(-19, 2),
                listOf(2u, 1u) to Rational(9, 4),
                listOf(0u, 2u) to Rational(5, 5),
                listOf(1u, 2u) to Rational(18, 9),
                listOf(2u, 2u) to Rational(5, 2),
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(8, 6),
                listOf(2u) to Rational(14, 6),
                listOf(0u, 1u) to Rational(-3, 1),
                listOf(1u, 1u) to Rational(-19, 2),
                listOf(2u, 1u) to Rational(9, 4),
                listOf(0u, 2u) to Rational(5, 5),
                listOf(1u, 2u) to Rational(18, 9),
                listOf(2u, 2u) to Rational(5, 2),
            ).substitute(RationalField, mapOf<Int, Rational>()),
            "test 5"
        )
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(8, 6),
                listOf(2u) to Rational(14, 6),
                listOf(0u, 1u) to Rational(-3, 1),
                listOf(1u, 1u) to Rational(-19, 2),
                listOf(2u, 1u) to Rational(9, 4),
                listOf(0u, 2u) to Rational(5, 5),
                listOf(1u, 2u) to Rational(18, 9),
                listOf(2u, 2u) to Rational(5, 2),
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(8, 6),
                listOf(2u) to Rational(14, 6),
                listOf(0u, 1u) to Rational(-3, 1),
                listOf(1u, 1u) to Rational(-19, 2),
                listOf(2u, 1u) to Rational(9, 4),
                listOf(0u, 2u) to Rational(5, 5),
                listOf(1u, 2u) to Rational(18, 9),
                listOf(2u, 2u) to Rational(5, 2),
            ).substitute(RationalField, mapOf(
                5 to Rational(57, 179),
            )),
            "test 5'"
        )
        // https://www.wolframalpha.com/input?i=%28%28-3%2F2+%2B+8%2F6+x+%2B+14%2F6+x%5E2%29+%2B+%28-3%2F1+%2B+-19%2F2+x+%2B+9%2F4+x%5E2%29+y+%2B+%285%2F5+%2B+18%2F9+x+%2B+5%2F2+x%5E2%29+y%5E2%29+p%5E8+where+x+%3D+q%2Fp%2C+y+%3D+x%5E3%2C+p+%3D+-2%2F5%2C+q+%3D+12%2F9
        assertEquals(
            NumberedPolynomialAsIs(
            listOf<UInt>() to Rational(47639065216, 2562890625)
            ),
            NumberedPolynomialAsIs(
                listOf(8u) to Rational(-3, 2),
                listOf(7u, 1u) to Rational(8, 6),
                listOf(6u, 2u) to Rational(14, 6),
                listOf(5u, 3u) to Rational(-3, 1),
                listOf(4u, 4u) to Rational(-19, 2),
                listOf(3u, 5u) to Rational(9, 4),
                listOf(2u, 6u) to Rational(5, 5),
                listOf(1u, 7u) to Rational(18, 9),
                listOf(0u, 8u) to Rational(5, 2),
            ).substitute(RationalField, mapOf(
                0 to Rational(-2, 5),
                1 to Rational(12, 9),
            )),
            "test 6"
        )
    }
    @Test
    fun test_Polynomial_substitute_Polynomial_Map() {
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(0)
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(1),
                listOf(1u) to Rational(-2),
                listOf(2u) to Rational(1)
            ).substitute(RationalField, mapOf(
                0 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1)
                )
            )),
            "test 1"
        )
        // https://www.wolframalpha.com/input?i=%28-3%2F2+%2B+8%2F6+x+%2B+14%2F6+x%5E2%29+%2B+%28-3%2F1+%2B+-19%2F2+x+%2B+9%2F4+x%5E2%29+y+%2B+%285%2F5+%2B+18%2F9+x+%2B+5%2F2+x%5E2%29+y%5E2+where+x+%3D+-5%2F1+s+%2B+2%2F8+t%2C+y+%3D+11%2F7+t
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(0u, 1u) to Rational(-92, 21),
                listOf(0u, 2u) to Rational(-2627, 2352),
                listOf(0u, 3u) to Rational(4565, 3136),
                listOf(0u, 4u) to Rational(605, 1568),
                listOf(1u) to Rational(-20, 3),
                listOf(1u, 1u) to Rational(1445, 21),
                listOf(1u, 2u) to Rational(-13145, 392),
                listOf(1u, 3u) to Rational(-3025, 196),
                listOf(2u) to Rational(175, 3),
                listOf(2u, 1u) to Rational(2475, 28),
                listOf(2u, 2u) to Rational(15125, 98),
                listOf(3u) to Rational(0),
                listOf(3u, 1u) to Rational(0),
                listOf(4u) to Rational(0),
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(8, 6),
                listOf(2u) to Rational(14, 6),
                listOf(0u, 1u) to Rational(-3, 1),
                listOf(1u, 1u) to Rational(-19, 2),
                listOf(2u, 1u) to Rational(9, 4),
                listOf(0u, 2u) to Rational(5, 5),
                listOf(1u, 2u) to Rational(18, 9),
                listOf(2u, 2u) to Rational(5, 2),
            ).substitute(RationalField, mapOf(
                0 to NumberedPolynomialAsIs(
                    listOf(1u) to Rational(-5, 1),
                    listOf(0u, 1u) to Rational(2, 8),
                ),
                1 to NumberedPolynomialAsIs(
                    listOf(1u) to Rational(0, 5),
                    listOf(0u, 1u) to Rational(11, 7),
                ),
            )),
            "test 2"
        )
        // (-3/2 + 8/6 x + 14/6 x^2) + (-3/1 + -19/2 x + 9/4 x^2) y + (5/5 + 18/9 x + 5/2 x^2) y^2 where x = (0/6 + 14/8 s + -14/2 s^2) + (-3/5 + 11/1 s + 3/7 s^2) t + (-3/7 + -18/5 s + -9/1 s^2) t^2, y = (-9/2 + 2/7 s + 9/1 s^2) + (13/1 + -1/8 s + 2/8 s^2) t + (19/4 + 15/7 s + -19/4 s^2) t^2
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(129, 4),
                listOf(1u) to Rational(48583, 336),
                listOf(2u) to Rational(-913477, 1568),
                listOf(3u) to Rational(-967567, 672),
                listOf(4u) to Rational(4722043, 1344),
                listOf(5u) to Rational(8855, 2),
                listOf(6u) to Rational(-311971, 32),
                listOf(7u) to Rational(-17325, 4),
                listOf(8u) to Rational(19845, 2),
                listOf(0u, 1u) to Rational(-827, 4),
                listOf(1u, 1u) to Rational(191927, 840),
                listOf(2u, 1u) to Rational(9592627, 2352),
                listOf(3u, 1u) to Rational(-105400711, 53760),
                listOf(4u, 1u) to Rational(-10054101459, 439040),
                listOf(5u, 1u) to Rational(2127351, 128),
                listOf(6u, 1u) to Rational(116680973, 3136),
                listOf(7u, 1u) to Rational(-220445, 7),
                listOf(8u, 1u) to Rational(-2655, 4),
                listOf(0u, 2u) to Rational(30567, 100),
                listOf(1u, 2u) to Rational(-156284953, 39200),
                listOf(2u, 2u) to Rational(-57661541711, 6585600),
                listOf(3u, 2u) to Rational(131931579, 3136),
                listOf(4u, 2u) to Rational(98818124791, 3512320),
                listOf(5u, 2u) to Rational(-94458855053, 878080),
                listOf(6u, 2u) to Rational(13937705305, 1229312),
                listOf(7u, 2u) to Rational(335706887, 21952),
                listOf(8u, 2u) to Rational(23549165, 1568),
                listOf(0u, 3u) to Rational(111367, 1400),
                listOf(1u, 3u) to Rational(4937369, 700),
                listOf(2u, 3u) to Rational(-4449423711, 274400),
                listOf(3u, 3u) to Rational(-351873325703, 4390400),
                listOf(4u, 3u) to Rational(23495875029, 307328),
                listOf(5u, 3u) to Rational(17576300919, 878080),
                listOf(6u, 3u) to Rational(230316993, 12544),
                listOf(7u, 3u) to Rational(-191130515, 21952),
                listOf(8u, 3u) to Rational(332435, 392),
                listOf(0u, 4u) to Rational(-275084, 1225),
                listOf(1u, 4u) to Rational(-266774603, 137200),
                listOf(2u, 4u) to Rational(2176279167121, 30732800),
                listOf(3u, 4u) to Rational(10904913303, 2195200),
                listOf(4u, 4u) to Rational(-10769286147, 2195200),
                listOf(5u, 4u) to Rational(-26277119793, 439040),
                listOf(6u, 4u) to Rational(25859735869, 6146560),
                listOf(7u, 4u) to Rational(38906289, 2744),
                listOf(8u, 4u) to Rational(-3072025, 392),
                listOf(0u, 5u) to Rational(9573, 98),
                listOf(1u, 5u) to Rational(-4154651399, 548800),
                listOf(2u, 5u) to Rational(3446069019, 548800),
                listOf(3u, 5u) to Rational(-7851500623, 137200),
                listOf(4u, 5u) to Rational(-53205142903, 1920800),
                listOf(5u, 5u) to Rational(-31953611, 3430),
                listOf(6u, 5u) to Rational(1447380313, 109760),
                listOf(7u, 5u) to Rational(764158625, 21952),
                listOf(8u, 5u) to Rational(1153515, 784),
                listOf(0u, 6u) to Rational(1722351, 7840),
                listOf(1u, 6u) to Rational(-164554821, 109760),
                listOf(2u, 6u) to Rational(-79096147243, 7683200),
                listOf(3u, 6u) to Rational(-624721089, 15680),
                listOf(4u, 6u) to Rational(11147305567, 548800),
                listOf(5u, 6u) to Rational(8318333679, 109760),
                listOf(6u, 6u) to Rational(32981871553, 1536640),
                listOf(7u, 6u) to Rational(-225359619, 21952),
                listOf(8u, 6u) to Rational(-3973995, 392),
                listOf(0u, 7u) to Rational(67203, 784),
                listOf(1u, 7u) to Rational(39281469, 54880),
                listOf(2u, 7u) to Rational(70162551, 27440),
                listOf(3u, 7u) to Rational(413630709, 54880),
                listOf(4u, 7u) to Rational(4640410269, 192080),
                listOf(5u, 7u) to Rational(802712247, 54880),
                listOf(6u, 7u) to Rational(-473517603, 27440),
                listOf(7u, 7u) to Rational(-17055459, 1568),
                listOf(8u, 7u) to Rational(-12825, 14),
                listOf(0u, 8u) to Rational(16245, 1568),
                listOf(1u, 8u) to Rational(503253, 2744),
                listOf(2u, 8u) to Rational(125292591, 96040),
                listOf(3u, 8u) to Rational(12033171, 2744),
                listOf(4u, 8u) to Rational(154352673, 27440),
                listOf(5u, 8u) to Rational(-1302291, 392),
                listOf(6u, 8u) to Rational(-20265741, 1960),
                listOf(7u, 8u) to Rational(-26163, 56),
                listOf(8u, 8u) to Rational(146205, 32),
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(8, 6),
                listOf(2u) to Rational(14, 6),
                listOf(0u, 1u) to Rational(-3, 1),
                listOf(1u, 1u) to Rational(-19, 2),
                listOf(2u, 1u) to Rational(9, 4),
                listOf(0u, 2u) to Rational(5, 5),
                listOf(1u, 2u) to Rational(18, 9),
                listOf(2u, 2u) to Rational(5, 2),
            ).substitute(RationalField, mapOf(
                0 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(0, 6),
                    listOf(1u) to Rational(14, 8),
                    listOf(2u) to Rational(-14, 2),
                    listOf(0u, 1u) to Rational(-3, 5),
                    listOf(1u, 1u) to Rational(11, 1),
                    listOf(2u, 1u) to Rational(3, 7),
                    listOf(0u, 2u) to Rational(-3, 7),
                    listOf(1u, 2u) to Rational(-18, 5),
                    listOf(2u, 2u) to Rational(-9, 1),
                ),
                1 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-9, 2),
                    listOf(1u) to Rational(2, 7),
                    listOf(2u) to Rational(9, 1),
                    listOf(0u, 1u) to Rational(13, 1),
                    listOf(1u, 1u) to Rational(-1, 8),
                    listOf(2u, 1u) to Rational(2, 8),
                    listOf(0u, 2u) to Rational(19, 4),
                    listOf(1u, 2u) to Rational(15, 7),
                    listOf(2u, 2u) to Rational(-19, 4),
                ),
            )),
            "test 3"
        )
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(129, 4),
                listOf(1u) to Rational(48583, 336),
                listOf(2u) to Rational(-913477, 1568),
                listOf(3u) to Rational(-967567, 672),
                listOf(4u) to Rational(4722043, 1344),
                listOf(5u) to Rational(8855, 2),
                listOf(6u) to Rational(-311971, 32),
                listOf(7u) to Rational(-17325, 4),
                listOf(8u) to Rational(19845, 2),
                listOf(0u, 1u) to Rational(-827, 4),
                listOf(1u, 1u) to Rational(191927, 840),
                listOf(2u, 1u) to Rational(9592627, 2352),
                listOf(3u, 1u) to Rational(-105400711, 53760),
                listOf(4u, 1u) to Rational(-10054101459, 439040),
                listOf(5u, 1u) to Rational(2127351, 128),
                listOf(6u, 1u) to Rational(116680973, 3136),
                listOf(7u, 1u) to Rational(-220445, 7),
                listOf(8u, 1u) to Rational(-2655, 4),
                listOf(0u, 2u) to Rational(30567, 100),
                listOf(1u, 2u) to Rational(-156284953, 39200),
                listOf(2u, 2u) to Rational(-57661541711, 6585600),
                listOf(3u, 2u) to Rational(131931579, 3136),
                listOf(4u, 2u) to Rational(98818124791, 3512320),
                listOf(5u, 2u) to Rational(-94458855053, 878080),
                listOf(6u, 2u) to Rational(13937705305, 1229312),
                listOf(7u, 2u) to Rational(335706887, 21952),
                listOf(8u, 2u) to Rational(23549165, 1568),
                listOf(0u, 3u) to Rational(111367, 1400),
                listOf(1u, 3u) to Rational(4937369, 700),
                listOf(2u, 3u) to Rational(-4449423711, 274400),
                listOf(3u, 3u) to Rational(-351873325703, 4390400),
                listOf(4u, 3u) to Rational(23495875029, 307328),
                listOf(5u, 3u) to Rational(17576300919, 878080),
                listOf(6u, 3u) to Rational(230316993, 12544),
                listOf(7u, 3u) to Rational(-191130515, 21952),
                listOf(8u, 3u) to Rational(332435, 392),
                listOf(0u, 4u) to Rational(-275084, 1225),
                listOf(1u, 4u) to Rational(-266774603, 137200),
                listOf(2u, 4u) to Rational(2176279167121, 30732800),
                listOf(3u, 4u) to Rational(10904913303, 2195200),
                listOf(4u, 4u) to Rational(-10769286147, 2195200),
                listOf(5u, 4u) to Rational(-26277119793, 439040),
                listOf(6u, 4u) to Rational(25859735869, 6146560),
                listOf(7u, 4u) to Rational(38906289, 2744),
                listOf(8u, 4u) to Rational(-3072025, 392),
                listOf(0u, 5u) to Rational(9573, 98),
                listOf(1u, 5u) to Rational(-4154651399, 548800),
                listOf(2u, 5u) to Rational(3446069019, 548800),
                listOf(3u, 5u) to Rational(-7851500623, 137200),
                listOf(4u, 5u) to Rational(-53205142903, 1920800),
                listOf(5u, 5u) to Rational(-31953611, 3430),
                listOf(6u, 5u) to Rational(1447380313, 109760),
                listOf(7u, 5u) to Rational(764158625, 21952),
                listOf(8u, 5u) to Rational(1153515, 784),
                listOf(0u, 6u) to Rational(1722351, 7840),
                listOf(1u, 6u) to Rational(-164554821, 109760),
                listOf(2u, 6u) to Rational(-79096147243, 7683200),
                listOf(3u, 6u) to Rational(-624721089, 15680),
                listOf(4u, 6u) to Rational(11147305567, 548800),
                listOf(5u, 6u) to Rational(8318333679, 109760),
                listOf(6u, 6u) to Rational(32981871553, 1536640),
                listOf(7u, 6u) to Rational(-225359619, 21952),
                listOf(8u, 6u) to Rational(-3973995, 392),
                listOf(0u, 7u) to Rational(67203, 784),
                listOf(1u, 7u) to Rational(39281469, 54880),
                listOf(2u, 7u) to Rational(70162551, 27440),
                listOf(3u, 7u) to Rational(413630709, 54880),
                listOf(4u, 7u) to Rational(4640410269, 192080),
                listOf(5u, 7u) to Rational(802712247, 54880),
                listOf(6u, 7u) to Rational(-473517603, 27440),
                listOf(7u, 7u) to Rational(-17055459, 1568),
                listOf(8u, 7u) to Rational(-12825, 14),
                listOf(0u, 8u) to Rational(16245, 1568),
                listOf(1u, 8u) to Rational(503253, 2744),
                listOf(2u, 8u) to Rational(125292591, 96040),
                listOf(3u, 8u) to Rational(12033171, 2744),
                listOf(4u, 8u) to Rational(154352673, 27440),
                listOf(5u, 8u) to Rational(-1302291, 392),
                listOf(6u, 8u) to Rational(-20265741, 1960),
                listOf(7u, 8u) to Rational(-26163, 56),
                listOf(8u, 8u) to Rational(146205, 32),
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(8, 6),
                listOf(2u) to Rational(14, 6),
                listOf(0u, 1u) to Rational(-3, 1),
                listOf(1u, 1u) to Rational(-19, 2),
                listOf(2u, 1u) to Rational(9, 4),
                listOf(0u, 2u) to Rational(5, 5),
                listOf(1u, 2u) to Rational(18, 9),
                listOf(2u, 2u) to Rational(5, 2),
            ).substitute(RationalField, mapOf(
                0 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(0, 6),
                    listOf(1u) to Rational(14, 8),
                    listOf(2u) to Rational(-14, 2),
                    listOf(0u, 1u) to Rational(-3, 5),
                    listOf(1u, 1u) to Rational(11, 1),
                    listOf(2u, 1u) to Rational(3, 7),
                    listOf(0u, 2u) to Rational(-3, 7),
                    listOf(1u, 2u) to Rational(-18, 5),
                    listOf(2u, 2u) to Rational(-9, 1),
                ),
                1 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-9, 2),
                    listOf(1u) to Rational(2, 7),
                    listOf(2u) to Rational(9, 1),
                    listOf(0u, 1u) to Rational(13, 1),
                    listOf(1u, 1u) to Rational(-1, 8),
                    listOf(2u, 1u) to Rational(2, 8),
                    listOf(0u, 2u) to Rational(19, 4),
                    listOf(1u, 2u) to Rational(15, 7),
                    listOf(2u, 2u) to Rational(-19, 4),
                ),
                5 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-11, 3),
                    listOf(1u) to Rational(5, 2),
                    listOf(2u) to Rational(13, 7),
                    listOf(0u, 1u) to Rational(16, 9),
                    listOf(1u, 1u) to Rational(14, 7),
                    listOf(2u, 1u) to Rational(6, 1),
                    listOf(0u, 2u) to Rational(-14, 3),
                    listOf(1u, 2u) to Rational(-2, 7),
                    listOf(2u, 2u) to Rational(-10, 8),
                )
            )),
            "test 3'"
        )
        // (-3/2 + 8/6 x + 14/6 x^2) + (-3/1 + -19/2 x + 9/4 x^2) y + (5/5 + 18/9 x + 5/2 x^2) y^2 where x = s, y = (-9/2 + 2/7 s + 9/1 s^2) + (13/1 + -1/8 s + 2/8 s^2) t + (19/4 + 15/7 s + -19/4 s^2) t^2
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(129, 4),
                listOf(1u) to Rational(6817, 84),
                listOf(2u) to Rational(-21445, 294),
                listOf(3u) to Rational(-12151, 49),
                listOf(4u) to Rational(-17789, 196),
                listOf(5u) to Rational(1224, 7),
                listOf(6u) to Rational(405, 2),
                listOf(0u, 1u) to Rational(-156),
                listOf(1u, 1u) to Rational(-2440, 7),
                listOf(2u, 1u) to Rational(-1571, 112),
                listOf(3u, 1u) to Rational(107515, 224),
                listOf(4u, 1u) to Rational(64965, 112),
                listOf(5u, 1u) to Rational(209, 56),
                listOf(6u, 1u) to Rational(45, 4),
                listOf(0u, 2u) to Rational(112),
                listOf(1u, 2u) to Rational(1449, 8),
                listOf(2u, 2u) to Rational(1306309, 3136),
                listOf(3u, 2u) to Rational(483207, 1568),
                listOf(4u, 2u) to Rational(1978437, 6272),
                listOf(5u, 2u) to Rational(-18231, 224),
                listOf(6u, 2u) to Rational(-6835, 32),
                listOf(0u, 3u) to Rational(247, 2),
                listOf(1u, 3u) to Rational(33771, 112),
                listOf(2u, 3u) to Rational(2073, 7),
                listOf(3u, 3u) to Rational(-23463, 224),
                listOf(4u, 3u) to Rational(-33825, 112),
                listOf(5u, 3u) to Rational(201, 224),
                listOf(6u, 3u) to Rational(-95, 16),
                listOf(0u, 4u) to Rational(361, 16),
                listOf(1u, 4u) to Rational(3667, 56),
                listOf(2u, 4u) to Rational(88729, 1568),
                listOf(3u, 4u) to Rational(-2476, 49),
                listOf(4u, 4u) to Rational(-23419, 196),
                listOf(5u, 4u) to Rational(-323, 56),
                listOf(6u, 4u) to Rational(1805, 32),
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(8, 6),
                listOf(2u) to Rational(14, 6),
                listOf(0u, 1u) to Rational(-3, 1),
                listOf(1u, 1u) to Rational(-19, 2),
                listOf(2u, 1u) to Rational(9, 4),
                listOf(0u, 2u) to Rational(5, 5),
                listOf(1u, 2u) to Rational(18, 9),
                listOf(2u, 2u) to Rational(5, 2),
            ).substitute(RationalField, mapOf(
                1 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-9, 2),
                    listOf(1u) to Rational(2, 7),
                    listOf(2u) to Rational(9, 1),
                    listOf(0u, 1u) to Rational(13, 1),
                    listOf(1u, 1u) to Rational(-1, 8),
                    listOf(2u, 1u) to Rational(2, 8),
                    listOf(0u, 2u) to Rational(19, 4),
                    listOf(1u, 2u) to Rational(15, 7),
                    listOf(2u, 2u) to Rational(-19, 4),
                ),
            )),
            "test 4"
        )
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(129, 4),
                listOf(1u) to Rational(6817, 84),
                listOf(2u) to Rational(-21445, 294),
                listOf(3u) to Rational(-12151, 49),
                listOf(4u) to Rational(-17789, 196),
                listOf(5u) to Rational(1224, 7),
                listOf(6u) to Rational(405, 2),
                listOf(0u, 1u) to Rational(-156),
                listOf(1u, 1u) to Rational(-2440, 7),
                listOf(2u, 1u) to Rational(-1571, 112),
                listOf(3u, 1u) to Rational(107515, 224),
                listOf(4u, 1u) to Rational(64965, 112),
                listOf(5u, 1u) to Rational(209, 56),
                listOf(6u, 1u) to Rational(45, 4),
                listOf(0u, 2u) to Rational(112),
                listOf(1u, 2u) to Rational(1449, 8),
                listOf(2u, 2u) to Rational(1306309, 3136),
                listOf(3u, 2u) to Rational(483207, 1568),
                listOf(4u, 2u) to Rational(1978437, 6272),
                listOf(5u, 2u) to Rational(-18231, 224),
                listOf(6u, 2u) to Rational(-6835, 32),
                listOf(0u, 3u) to Rational(247, 2),
                listOf(1u, 3u) to Rational(33771, 112),
                listOf(2u, 3u) to Rational(2073, 7),
                listOf(3u, 3u) to Rational(-23463, 224),
                listOf(4u, 3u) to Rational(-33825, 112),
                listOf(5u, 3u) to Rational(201, 224),
                listOf(6u, 3u) to Rational(-95, 16),
                listOf(0u, 4u) to Rational(361, 16),
                listOf(1u, 4u) to Rational(3667, 56),
                listOf(2u, 4u) to Rational(88729, 1568),
                listOf(3u, 4u) to Rational(-2476, 49),
                listOf(4u, 4u) to Rational(-23419, 196),
                listOf(5u, 4u) to Rational(-323, 56),
                listOf(6u, 4u) to Rational(1805, 32),
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(8, 6),
                listOf(2u) to Rational(14, 6),
                listOf(0u, 1u) to Rational(-3, 1),
                listOf(1u, 1u) to Rational(-19, 2),
                listOf(2u, 1u) to Rational(9, 4),
                listOf(0u, 2u) to Rational(5, 5),
                listOf(1u, 2u) to Rational(18, 9),
                listOf(2u, 2u) to Rational(5, 2),
            ).substitute(RationalField, mapOf(
                1 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-9, 2),
                    listOf(1u) to Rational(2, 7),
                    listOf(2u) to Rational(9, 1),
                    listOf(0u, 1u) to Rational(13, 1),
                    listOf(1u, 1u) to Rational(-1, 8),
                    listOf(2u, 1u) to Rational(2, 8),
                    listOf(0u, 2u) to Rational(19, 4),
                    listOf(1u, 2u) to Rational(15, 7),
                    listOf(2u, 2u) to Rational(-19, 4),
                ),
                5 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-11, 3),
                    listOf(1u) to Rational(5, 2),
                    listOf(2u) to Rational(13, 7),
                    listOf(0u, 1u) to Rational(16, 9),
                    listOf(1u, 1u) to Rational(14, 7),
                    listOf(2u, 1u) to Rational(6, 1),
                    listOf(0u, 2u) to Rational(-14, 3),
                    listOf(1u, 2u) to Rational(-2, 7),
                    listOf(2u, 2u) to Rational(-10, 8),
                )
            )),
            "test 4'"
        )
        // (-3/2 + 8/6 x + 14/6 x^2) + (-3/1 + -19/2 x + 9/4 x^2) y + (5/5 + 18/9 x + 5/2 x^2) y^2 where x = (0/6 + 14/8 s + -14/2 s^2) + (-3/5 + 11/1 s + 3/7 s^2) t + (-3/7 + -18/5 s + -9/1 s^2) t^2, y = t
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(7, 3),
                listOf(2u) to Rational(-35, 16),
                listOf(3u) to Rational(-343, 6),
                listOf(4u) to Rational(343, 3),
                listOf(0u, 1u) to Rational(-19, 5),
                listOf(1u, 1u) to Rational(-823, 120),
                listOf(2u, 1u) to Rational(1232417, 6720),
                listOf(3u, 1u) to Rational(-9863, 24),
                listOf(4u, 1u) to Rational(385, 4),
                listOf(0u, 2u) to Rational(2439, 350),
                listOf(1u, 2u) to Rational(-5793, 40),
                listOf(2u, 2u) to Rational(1172113, 3360),
                listOf(3u, 2u) to Rational(-13531, 40),
                listOf(4u, 2u) to Rational(2824, 7),
                listOf(0u, 3u) to Rational(3417, 700),
                listOf(1u, 3u) to Rational(1191, 200),
                listOf(2u, 3u) to Rational(8383, 28),
                listOf(3u, 3u) to Rational(-220279, 280),
                listOf(4u, 3u) to Rational(49179, 196),
                listOf(0u, 4u) to Rational(57, 35),
                listOf(1u, 4u) to Rational(-33771, 700),
                listOf(2u, 4u) to Rational(196279, 1225),
                listOf(3u, 4u) to Rational(-32259, 140),
                listOf(4u, 4u) to Rational(23868, 49),
                listOf(0u, 5u) to Rational(333, 196),
                listOf(1u, 5u) to Rational(-204, 35),
                listOf(2u, 5u) to Rational(-307233, 2450),
                listOf(3u, 5u) to Rational(-12492, 35),
                listOf(4u, 5u) to Rational(4563, 28),
                listOf(0u, 6u) to Rational(45, 98),
                listOf(1u, 6u) to Rational(54, 7),
                listOf(2u, 6u) to Rational(1809, 35),
                listOf(3u, 6u) to Rational(162),
                listOf(4u, 6u) to Rational(405, 2),
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(8, 6),
                listOf(2u) to Rational(14, 6),
                listOf(0u, 1u) to Rational(-3, 1),
                listOf(1u, 1u) to Rational(-19, 2),
                listOf(2u, 1u) to Rational(9, 4),
                listOf(0u, 2u) to Rational(5, 5),
                listOf(1u, 2u) to Rational(18, 9),
                listOf(2u, 2u) to Rational(5, 2),
            ).substitute(RationalField, mapOf(
                0 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(0, 6),
                    listOf(1u) to Rational(14, 8),
                    listOf(2u) to Rational(-14, 2),
                    listOf(0u, 1u) to Rational(-3, 5),
                    listOf(1u, 1u) to Rational(11, 1),
                    listOf(2u, 1u) to Rational(3, 7),
                    listOf(0u, 2u) to Rational(-3, 7),
                    listOf(1u, 2u) to Rational(-18, 5),
                    listOf(2u, 2u) to Rational(-9, 1),
                ),
            )),
            "test 5"
        )
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(7, 3),
                listOf(2u) to Rational(-35, 16),
                listOf(3u) to Rational(-343, 6),
                listOf(4u) to Rational(343, 3),
                listOf(0u, 1u) to Rational(-19, 5),
                listOf(1u, 1u) to Rational(-823, 120),
                listOf(2u, 1u) to Rational(1232417, 6720),
                listOf(3u, 1u) to Rational(-9863, 24),
                listOf(4u, 1u) to Rational(385, 4),
                listOf(0u, 2u) to Rational(2439, 350),
                listOf(1u, 2u) to Rational(-5793, 40),
                listOf(2u, 2u) to Rational(1172113, 3360),
                listOf(3u, 2u) to Rational(-13531, 40),
                listOf(4u, 2u) to Rational(2824, 7),
                listOf(0u, 3u) to Rational(3417, 700),
                listOf(1u, 3u) to Rational(1191, 200),
                listOf(2u, 3u) to Rational(8383, 28),
                listOf(3u, 3u) to Rational(-220279, 280),
                listOf(4u, 3u) to Rational(49179, 196),
                listOf(0u, 4u) to Rational(57, 35),
                listOf(1u, 4u) to Rational(-33771, 700),
                listOf(2u, 4u) to Rational(196279, 1225),
                listOf(3u, 4u) to Rational(-32259, 140),
                listOf(4u, 4u) to Rational(23868, 49),
                listOf(0u, 5u) to Rational(333, 196),
                listOf(1u, 5u) to Rational(-204, 35),
                listOf(2u, 5u) to Rational(-307233, 2450),
                listOf(3u, 5u) to Rational(-12492, 35),
                listOf(4u, 5u) to Rational(4563, 28),
                listOf(0u, 6u) to Rational(45, 98),
                listOf(1u, 6u) to Rational(54, 7),
                listOf(2u, 6u) to Rational(1809, 35),
                listOf(3u, 6u) to Rational(162),
                listOf(4u, 6u) to Rational(405, 2),
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(8, 6),
                listOf(2u) to Rational(14, 6),
                listOf(0u, 1u) to Rational(-3, 1),
                listOf(1u, 1u) to Rational(-19, 2),
                listOf(2u, 1u) to Rational(9, 4),
                listOf(0u, 2u) to Rational(5, 5),
                listOf(1u, 2u) to Rational(18, 9),
                listOf(2u, 2u) to Rational(5, 2),
            ).substitute(RationalField, mapOf(
                0 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(0, 6),
                    listOf(1u) to Rational(14, 8),
                    listOf(2u) to Rational(-14, 2),
                    listOf(0u, 1u) to Rational(-3, 5),
                    listOf(1u, 1u) to Rational(11, 1),
                    listOf(2u, 1u) to Rational(3, 7),
                    listOf(0u, 2u) to Rational(-3, 7),
                    listOf(1u, 2u) to Rational(-18, 5),
                    listOf(2u, 2u) to Rational(-9, 1),
                ),
                5 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-11, 3),
                    listOf(1u) to Rational(5, 2),
                    listOf(2u) to Rational(13, 7),
                    listOf(0u, 1u) to Rational(16, 9),
                    listOf(1u, 1u) to Rational(14, 7),
                    listOf(2u, 1u) to Rational(6, 1),
                    listOf(0u, 2u) to Rational(-14, 3),
                    listOf(1u, 2u) to Rational(-2, 7),
                    listOf(2u, 2u) to Rational(-10, 8),
                )
            )),
            "test 5'"
        )
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(8, 6),
                listOf(2u) to Rational(14, 6),
                listOf(0u, 1u) to Rational(-3, 1),
                listOf(1u, 1u) to Rational(-19, 2),
                listOf(2u, 1u) to Rational(9, 4),
                listOf(0u, 2u) to Rational(5, 5),
                listOf(1u, 2u) to Rational(18, 9),
                listOf(2u, 2u) to Rational(5, 2),
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(8, 6),
                listOf(2u) to Rational(14, 6),
                listOf(0u, 1u) to Rational(-3, 1),
                listOf(1u, 1u) to Rational(-19, 2),
                listOf(2u, 1u) to Rational(9, 4),
                listOf(0u, 2u) to Rational(5, 5),
                listOf(1u, 2u) to Rational(18, 9),
                listOf(2u, 2u) to Rational(5, 2),
            ).substitute(RationalField, mapOf<Int, NumberedPolynomial<Rational>>()),
            "test 6"
        )
        assertEquals(
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(8, 6),
                listOf(2u) to Rational(14, 6),
                listOf(0u, 1u) to Rational(-3, 1),
                listOf(1u, 1u) to Rational(-19, 2),
                listOf(2u, 1u) to Rational(9, 4),
                listOf(0u, 2u) to Rational(5, 5),
                listOf(1u, 2u) to Rational(18, 9),
                listOf(2u, 2u) to Rational(5, 2),
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(-3, 2),
                listOf(1u) to Rational(8, 6),
                listOf(2u) to Rational(14, 6),
                listOf(0u, 1u) to Rational(-3, 1),
                listOf(1u, 1u) to Rational(-19, 2),
                listOf(2u, 1u) to Rational(9, 4),
                listOf(0u, 2u) to Rational(5, 5),
                listOf(1u, 2u) to Rational(18, 9),
                listOf(2u, 2u) to Rational(5, 2),
            ).substitute(RationalField, mapOf(
                5 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-11, 3),
                    listOf(1u) to Rational(5, 2),
                    listOf(2u) to Rational(13, 7),
                    listOf(0u, 1u) to Rational(16, 9),
                    listOf(1u, 1u) to Rational(14, 7),
                    listOf(2u, 1u) to Rational(6, 1),
                    listOf(0u, 2u) to Rational(-14, 3),
                    listOf(1u, 2u) to Rational(-2, 7),
                    listOf(2u, 2u) to Rational(-10, 8),
                )
            )),
            "test 6'"
        )
    }
    @Test
    @Ignore // FIXME: This tests work only for sane realisations of the substitutions. Currently, it is not.
            //  Sane algorithm for substitution p(q/r) (p, q, and r are polynomials) should return denominator r^deg(p),
            //  not r^(deg(p)(deg(p)+1)/2) as it is now.
    fun test_Polynomial_substitute_RationalFunction_Map() {
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(0)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1)
                )
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(1),
                listOf(1u) to Rational(-2),
                listOf(2u) to Rational(1)
            ).substitute(RationalField, mapOf(
                0 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(1)
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(1)
                    )
                )
            )),
            "test 1"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf(4u) to Rational(-194071, 4900),
                    listOf(3u, 1u) to Rational(394811, 225),
                    listOf(2u, 2u) to Rational(-444183161, 66150),
                    listOf(1u, 3u) to Rational(70537618, 59535),
                    listOf(0u, 4u) to Rational(9655504, 2835),
                ),
                NumberedPolynomialAsIs(
                    listOf(4u) to Rational(9, 1),
                    listOf(3u, 1u) to Rational(61, 1),
                    listOf(2u, 2u) to Rational(2137, 36),
                    listOf(1u, 3u) to Rational(-1342, 9),
                    listOf(0u, 4u) to Rational(484, 9),
                )
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(15, 7),
                listOf(1u) to Rational(1, 5),
                listOf(2u) to Rational(-7, 4),
                listOf(0u, 1u) to Rational(-1, 9),
                listOf(1u, 1u) to Rational(-2, 7),
                listOf(2u, 1u) to Rational(17, 3),
                listOf(0u, 2u) to Rational(2, 6),
                listOf(1u, 2u) to Rational(-17, 6),
                listOf(2u, 2u) to Rational(-6, 2),
            ).substitute(RationalField, mapOf(
                0 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf(1u) to Rational(17, 7),
                        listOf(0u, 1u) to Rational(-13, 1),
                    ),
                    NumberedPolynomialAsIs(
                        listOf(1u) to Rational(-18, 6),
                        listOf(0u, 1u) to Rational(11, 6),
                    )
                ),
                1 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf(1u) to Rational(18, 5),
                        listOf(0u, 1u) to Rational(-16, 3),
                    ),
                    NumberedPolynomialAsIs(
                        listOf(1u) to Rational(-1, 1),
                        listOf(0u, 1u) to Rational(-4, 1),
                    )
                ),
            )),
            "test 2"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-6443599, 10000),
                    listOf(1u) to Rational(166251223, 210000),
                    listOf(2u) to Rational(-4606805099, 3528000),
                    listOf(3u) to Rational(51204379, 19600),
                    listOf(4u) to Rational(-529045460659, 277830000),
                    listOf(5u) to Rational(2630836709, 1488375),
                    listOf(6u) to Rational(-42675691369, 25004700),
                    listOf(7u) to Rational(495825223, 1250235),
                    listOf(8u) to Rational(-22531756, 1750329),
                    listOf(0u, 1u) to Rational(-2526552797, 420000),
                    listOf(1u, 1u) to Rational(31108840471, 2520000),
                    listOf(2u, 1u) to Rational(-4789740847, 1102500),
                    listOf(3u, 1u) to Rational(186594307807, 11340000),
                    listOf(4u, 1u) to Rational(-11677815943, 1488375),
                    listOf(5u, 1u) to Rational(-181118486447, 27783000),
                    listOf(6u, 1u) to Rational(-16123292162, 14586075),
                    listOf(7u, 1u) to Rational(-140339343808, 26254935),
                    listOf(8u, 1u) to Rational(4570171616, 5250987),
                    listOf(0u, 2u) to Rational(-181436530573, 10080000),
                    listOf(1u, 2u) to Rational(6700437957491, 105840000),
                    listOf(2u, 2u) to Rational(-3527267461, 1417500),
                    listOf(3u, 2u) to Rational(-38084563451, 5556600),
                    listOf(4u, 2u) to Rational(-565662040631, 13891500),
                    listOf(5u, 2u) to Rational(-35479071126397, 583443000),
                    listOf(6u, 2u) to Rational(-11717559078469, 525098700),
                    listOf(7u, 2u) to Rational(-2043385293517, 225042300),
                    listOf(8u, 2u) to Rational(-3644439630451, 551353635),
                    listOf(0u, 3u) to Rational(-1760423269, 126000),
                    listOf(1u, 3u) to Rational(310176758299, 2352000),
                    listOf(2u, 3u) to Rational(-907229584837, 21168000),
                    listOf(3u, 3u) to Rational(-16717135885963, 95256000),
                    listOf(4u, 3u) to Rational(-43762928025353, 333396000),
                    listOf(5u, 3u) to Rational(-328427480571607, 3000564000),
                    listOf(6u, 3u) to Rational(-7722675917197, 210039480),
                    listOf(7u, 3u) to Rational(1713350137019, 1225230300),
                    listOf(8u, 3u) to Rational(156695935643, 31505922),
                    listOf(0u, 4u) to Rational(18362364269, 1008000),
                    listOf(1u, 4u) to Rational(955674858553, 10584000),
                    listOf(2u, 4u) to Rational(-71937470607371, 444528000),
                    listOf(3u, 4u) to Rational(-34097985615163, 95256000),
                    listOf(4u, 4u) to Rational(-340736178775883, 2000376000),
                    listOf(5u, 4u) to Rational(-511324523441897, 10501974000),
                    listOf(6u, 4u) to Rational(-125375649409151, 8821658160),
                    listOf(7u, 4u) to Rational(-2813518533421, 1575296100),
                    listOf(8u, 4u) to Rational(-17044089109, 5250987),
                    listOf(0u, 5u) to Rational(600086461, 20160),
                    listOf(1u, 5u) to Rational(-18959931367, 423360),
                    listOf(2u, 5u) to Rational(-9178804929607, 44452800),
                    listOf(3u, 5u) to Rational(-1460114275979, 5334336),
                    listOf(4u, 5u) to Rational(-342533479090169, 4200789600),
                    listOf(5u, 5u) to Rational(20335453022963, 4200789600),
                    listOf(6u, 5u) to Rational(-21649775090197, 6301184400),
                    listOf(7u, 5u) to Rational(-197301716069, 131274675),
                    listOf(8u, 5u) to Rational(18711357470, 15752961),
                    listOf(0u, 6u) to Rational(621417991, 100800),
                    listOf(1u, 6u) to Rational(-159236792977, 2116800),
                    listOf(2u, 6u) to Rational(-6602528890883, 66679200),
                    listOf(3u, 6u) to Rational(-1086091664047, 19051200),
                    listOf(4u, 6u) to Rational(3769375009003, 1680315840),
                    listOf(5u, 6u) to Rational(-12920385574769, 1050197400),
                    listOf(6u, 6u) to Rational(-90219591809287, 6301184400),
                    listOf(7u, 6u) to Rational(656361553391, 1575296100),
                    listOf(8u, 6u) to Rational(757900793, 2250423),
                    listOf(0u, 7u) to Rational(-100770017, 15120),
                    listOf(1u, 7u) to Rational(-316364851, 17640),
                    listOf(2u, 7u) to Rational(-85118560057, 6667920),
                    listOf(3u, 7u) to Rational(6286563719, 416745),
                    listOf(4u, 7u) to Rational(26803885301, 1714608),
                    listOf(5u, 7u) to Rational(-13767154393, 4286520),
                    listOf(6u, 7u) to Rational(-3875138933, 1224720),
                    listOf(7u, 7u) to Rational(65193755, 333396),
                    listOf(8u, 7u) to Rational(90974351, 2500470),
                    listOf(0u, 8u) to Rational(-3182197, 1260),
                    listOf(1u, 8u) to Rational(24899923, 8820),
                    listOf(2u, 8u) to Rational(-19999556, 19845),
                    listOf(3u, 8u) to Rational(3276587, 3969),
                    listOf(4u, 8u) to Rational(13719549239, 5000940),
                    listOf(5u, 8u) to Rational(-961839938, 1250235),
                    listOf(6u, 8u) to Rational(-198184871, 833490),
                    listOf(7u, 8u) to Rational(230659711, 5000940),
                    listOf(8u, 8u) to Rational(292447, 35721)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(9, 100),
                    listOf(1u) to Rational(-21, 50),
                    listOf(2u) to Rational(293, 700),
                    listOf(3u) to Rational(29, 210),
                    listOf(4u) to Rational(3233, 8820),
                    listOf(5u) to Rational(-289, 441),
                    listOf(6u) to Rational(-1, 9),
                    listOf(7u) to Rational(-20, 441),
                    listOf(8u) to Rational(100, 441),
                    listOf(0u, 1u) to Rational(-57, 80),
                    listOf(1u, 1u) to Rational(-121, 400),
                    listOf(2u, 1u) to Rational(37117, 8400),
                    listOf(3u, 1u) to Rational(-4853, 3150),
                    listOf(4u, 1u) to Rational(1166203, 132300),
                    listOf(5u, 1u) to Rational(-2708, 567),
                    listOf(6u, 1u) to Rational(-287159, 416745),
                    listOf(7u, 1u) to Rational(-478204, 83349),
                    listOf(8u, 1u) to Rational(176320, 83349),
                    listOf(0u, 2u) to Rational(-6239, 6400),
                    listOf(1u, 2u) to Rational(264211, 11200),
                    listOf(2u, 2u) to Rational(-1591999, 100800),
                    listOf(3u, 2u) to Rational(12450091, 529200),
                    listOf(4u, 2u) to Rational(9230759, 226800),
                    listOf(5u, 2u) to Rational(18995554, 2083725),
                    listOf(6u, 2u) to Rational(136706258, 6251175),
                    listOf(7u, 2u) to Rational(-120907496, 3750705),
                    listOf(8u, 2u) to Rational(117200176, 15752961),
                    listOf(0u, 3u) to Rational(5653, 320),
                    listOf(1u, 3u) to Rational(-130853, 8400),
                    listOf(2u, 3u) to Rational(-20939327, 151200),
                    listOf(3u, 3u) to Rational(2566691, 25200),
                    listOf(4u, 3u) to Rational(-68441519, 476280),
                    listOf(5u, 3u) to Rational(2462904247, 12502350),
                    listOf(6u, 3u) to Rational(353667161, 18753525),
                    listOf(7u, 3u) to Rational(-1689134372, 26254935),
                    listOf(8u, 3u) to Rational(35084104, 2250423),
                    listOf(0u, 4u) to Rational(-3587, 300),
                    listOf(1u, 4u) to Rational(-10513243, 33600),
                    listOf(2u, 4u) to Rational(30766733, 176400),
                    listOf(3u, 4u) to Rational(-65680021, 198450),
                    listOf(4u, 4u) to Rational(-8108910547, 20003760),
                    listOf(5u, 4u) to Rational(2922125159, 6251175),
                    listOf(6u, 4u) to Rational(-4245279943, 131274675),
                    listOf(7u, 4u) to Rational(-371946872, 3750705),
                    listOf(8u, 4u) to Rational(61286752, 2250423),
                    listOf(0u, 5u) to Rational(-20477, 160),
                    listOf(1u, 5u) to Rational(215741, 1120),
                    listOf(2u, 5u) to Rational(30785843, 31752),
                    listOf(3u, 5u) to Rational(-357495959, 317520),
                    listOf(4u, 5u) to Rational(-1611242993, 10001880),
                    listOf(5u, 5u) to Rational(345925495, 500094),
                    listOf(6u, 5u) to Rational(-755948411, 3750705),
                    listOf(7u, 5u) to Rational(-108643496, 1250235),
                    listOf(8u, 5u) to Rational(1122512, 35721),
                    listOf(0u, 6u) to Rational(358037, 2880),
                    listOf(1u, 6u) to Rational(3895837, 3360),
                    listOf(2u, 6u) to Rational(359419201, 1270080),
                    listOf(3u, 6u) to Rational(-158522587, 105840),
                    listOf(4u, 6u) to Rational(10909002599, 20003760),
                    listOf(5u, 6u) to Rational(76846972, 138915),
                    listOf(6u, 6u) to Rational(-327696553, 1250235),
                    listOf(7u, 6u) to Rational(-1687328, 35721),
                    listOf(8u, 6u) to Rational(1016836, 35721),
                    listOf(0u, 7u) to Rational(658, 3),
                    listOf(1u, 7u) to Rational(48035, 168),
                    listOf(2u, 7u) to Rational(-5777875, 5292),
                    listOf(3u, 7u) to Rational(-7893899, 10584),
                    listOf(4u, 7u) to Rational(10191652, 11907),
                    listOf(5u, 7u) to Rational(2920121, 23814),
                    listOf(6u, 7u) to Rational(-2699780, 11907),
                    listOf(7u, 7u) to Rational(4556, 441),
                    listOf(8u, 7u) to Rational(3440, 189),
                    listOf(0u, 8u) to Rational(64, 1),
                    listOf(1u, 8u) to Rational(-808, 7),
                    listOf(2u, 8u) to Rational(-360895, 1764),
                    listOf(3u, 8u) to Rational(257657, 882),
                    listOf(4u, 8u) to Rational(3779917, 15876),
                    listOf(5u, 8u) to Rational(-610279, 3969),
                    listOf(6u, 8u) to Rational(-25091, 441),
                    listOf(7u, 8u) to Rational(9560, 567),
                    listOf(8u, 8u) to Rational(400, 81)
                )
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(15, 7),
                listOf(1u) to Rational(1, 5),
                listOf(2u) to Rational(-7, 4),
                listOf(0u, 1u) to Rational(-1, 9),
                listOf(1u, 1u) to Rational(-2, 7),
                listOf(2u, 1u) to Rational(17, 3),
                listOf(0u, 2u) to Rational(2, 6),
                listOf(1u, 2u) to Rational(-17, 6),
                listOf(2u, 2u) to Rational(-6, 2),
            ).substitute(RationalField, mapOf(
                0 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(17, 5),
                        listOf(1u) to Rational(11, 6),
                        listOf(2u) to Rational(14, 3),
                        listOf(0u, 1u) to Rational(17, 1),
                        listOf(1u, 1u) to Rational(12, 3),
                        listOf(2u, 1u) to Rational(-6, 2),
                        listOf(0u, 2u) to Rational(17, 1),
                        listOf(1u, 2u) to Rational(-4, 3),
                        listOf(2u, 2u) to Rational(2, 6),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(3, 5),
                        listOf(1u) to Rational(3, 5),
                        listOf(2u) to Rational(3, 7),
                        listOf(0u, 1u) to Rational(-3, 8),
                        listOf(1u, 1u) to Rational(-1, 1),
                        listOf(2u, 1u) to Rational(17, 9),
                        listOf(0u, 2u) to Rational(-8, 1),
                        listOf(1u, 2u) to Rational(6, 4),
                        listOf(2u, 2u) to Rational(10, 9),
                    )
                ),
                1 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(18, 5),
                        listOf(1u) to Rational(-17, 5),
                        listOf(2u) to Rational(-2, 7),
                        listOf(0u, 1u) to Rational(6, 5),
                        listOf(1u, 1u) to Rational(-5, 1),
                        listOf(2u, 1u) to Rational(-9, 1),
                        listOf(0u, 2u) to Rational(-8, 8),
                        listOf(1u, 2u) to Rational(2, 7),
                        listOf(2u, 2u) to Rational(-13, 7),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(-4, 8),
                        listOf(1u) to Rational(15, 9),
                        listOf(2u) to Rational(-10, 9),
                        listOf(0u, 1u) to Rational(5, 3),
                        listOf(1u, 1u) to Rational(4, 1),
                        listOf(2u, 1u) to Rational(-2, 7),
                        listOf(0u, 2u) to Rational(2, 2),
                        listOf(1u, 2u) to Rational(-5, 7),
                        listOf(2u, 2u) to Rational(-18, 9),
                    )
                ),
            )),
            "test 3"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-6443599, 10000),
                    listOf(1u) to Rational(166251223, 210000),
                    listOf(2u) to Rational(-4606805099, 3528000),
                    listOf(3u) to Rational(51204379, 19600),
                    listOf(4u) to Rational(-529045460659, 277830000),
                    listOf(5u) to Rational(2630836709, 1488375),
                    listOf(6u) to Rational(-42675691369, 25004700),
                    listOf(7u) to Rational(495825223, 1250235),
                    listOf(8u) to Rational(-22531756, 1750329),
                    listOf(0u, 1u) to Rational(-2526552797, 420000),
                    listOf(1u, 1u) to Rational(31108840471, 2520000),
                    listOf(2u, 1u) to Rational(-4789740847, 1102500),
                    listOf(3u, 1u) to Rational(186594307807, 11340000),
                    listOf(4u, 1u) to Rational(-11677815943, 1488375),
                    listOf(5u, 1u) to Rational(-181118486447, 27783000),
                    listOf(6u, 1u) to Rational(-16123292162, 14586075),
                    listOf(7u, 1u) to Rational(-140339343808, 26254935),
                    listOf(8u, 1u) to Rational(4570171616, 5250987),
                    listOf(0u, 2u) to Rational(-181436530573, 10080000),
                    listOf(1u, 2u) to Rational(6700437957491, 105840000),
                    listOf(2u, 2u) to Rational(-3527267461, 1417500),
                    listOf(3u, 2u) to Rational(-38084563451, 5556600),
                    listOf(4u, 2u) to Rational(-565662040631, 13891500),
                    listOf(5u, 2u) to Rational(-35479071126397, 583443000),
                    listOf(6u, 2u) to Rational(-11717559078469, 525098700),
                    listOf(7u, 2u) to Rational(-2043385293517, 225042300),
                    listOf(8u, 2u) to Rational(-3644439630451, 551353635),
                    listOf(0u, 3u) to Rational(-1760423269, 126000),
                    listOf(1u, 3u) to Rational(310176758299, 2352000),
                    listOf(2u, 3u) to Rational(-907229584837, 21168000),
                    listOf(3u, 3u) to Rational(-16717135885963, 95256000),
                    listOf(4u, 3u) to Rational(-43762928025353, 333396000),
                    listOf(5u, 3u) to Rational(-328427480571607, 3000564000),
                    listOf(6u, 3u) to Rational(-7722675917197, 210039480),
                    listOf(7u, 3u) to Rational(1713350137019, 1225230300),
                    listOf(8u, 3u) to Rational(156695935643, 31505922),
                    listOf(0u, 4u) to Rational(18362364269, 1008000),
                    listOf(1u, 4u) to Rational(955674858553, 10584000),
                    listOf(2u, 4u) to Rational(-71937470607371, 444528000),
                    listOf(3u, 4u) to Rational(-34097985615163, 95256000),
                    listOf(4u, 4u) to Rational(-340736178775883, 2000376000),
                    listOf(5u, 4u) to Rational(-511324523441897, 10501974000),
                    listOf(6u, 4u) to Rational(-125375649409151, 8821658160),
                    listOf(7u, 4u) to Rational(-2813518533421, 1575296100),
                    listOf(8u, 4u) to Rational(-17044089109, 5250987),
                    listOf(0u, 5u) to Rational(600086461, 20160),
                    listOf(1u, 5u) to Rational(-18959931367, 423360),
                    listOf(2u, 5u) to Rational(-9178804929607, 44452800),
                    listOf(3u, 5u) to Rational(-1460114275979, 5334336),
                    listOf(4u, 5u) to Rational(-342533479090169, 4200789600),
                    listOf(5u, 5u) to Rational(20335453022963, 4200789600),
                    listOf(6u, 5u) to Rational(-21649775090197, 6301184400),
                    listOf(7u, 5u) to Rational(-197301716069, 131274675),
                    listOf(8u, 5u) to Rational(18711357470, 15752961),
                    listOf(0u, 6u) to Rational(621417991, 100800),
                    listOf(1u, 6u) to Rational(-159236792977, 2116800),
                    listOf(2u, 6u) to Rational(-6602528890883, 66679200),
                    listOf(3u, 6u) to Rational(-1086091664047, 19051200),
                    listOf(4u, 6u) to Rational(3769375009003, 1680315840),
                    listOf(5u, 6u) to Rational(-12920385574769, 1050197400),
                    listOf(6u, 6u) to Rational(-90219591809287, 6301184400),
                    listOf(7u, 6u) to Rational(656361553391, 1575296100),
                    listOf(8u, 6u) to Rational(757900793, 2250423),
                    listOf(0u, 7u) to Rational(-100770017, 15120),
                    listOf(1u, 7u) to Rational(-316364851, 17640),
                    listOf(2u, 7u) to Rational(-85118560057, 6667920),
                    listOf(3u, 7u) to Rational(6286563719, 416745),
                    listOf(4u, 7u) to Rational(26803885301, 1714608),
                    listOf(5u, 7u) to Rational(-13767154393, 4286520),
                    listOf(6u, 7u) to Rational(-3875138933, 1224720),
                    listOf(7u, 7u) to Rational(65193755, 333396),
                    listOf(8u, 7u) to Rational(90974351, 2500470),
                    listOf(0u, 8u) to Rational(-3182197, 1260),
                    listOf(1u, 8u) to Rational(24899923, 8820),
                    listOf(2u, 8u) to Rational(-19999556, 19845),
                    listOf(3u, 8u) to Rational(3276587, 3969),
                    listOf(4u, 8u) to Rational(13719549239, 5000940),
                    listOf(5u, 8u) to Rational(-961839938, 1250235),
                    listOf(6u, 8u) to Rational(-198184871, 833490),
                    listOf(7u, 8u) to Rational(230659711, 5000940),
                    listOf(8u, 8u) to Rational(292447, 35721)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(9, 100),
                    listOf(1u) to Rational(-21, 50),
                    listOf(2u) to Rational(293, 700),
                    listOf(3u) to Rational(29, 210),
                    listOf(4u) to Rational(3233, 8820),
                    listOf(5u) to Rational(-289, 441),
                    listOf(6u) to Rational(-1, 9),
                    listOf(7u) to Rational(-20, 441),
                    listOf(8u) to Rational(100, 441),
                    listOf(0u, 1u) to Rational(-57, 80),
                    listOf(1u, 1u) to Rational(-121, 400),
                    listOf(2u, 1u) to Rational(37117, 8400),
                    listOf(3u, 1u) to Rational(-4853, 3150),
                    listOf(4u, 1u) to Rational(1166203, 132300),
                    listOf(5u, 1u) to Rational(-2708, 567),
                    listOf(6u, 1u) to Rational(-287159, 416745),
                    listOf(7u, 1u) to Rational(-478204, 83349),
                    listOf(8u, 1u) to Rational(176320, 83349),
                    listOf(0u, 2u) to Rational(-6239, 6400),
                    listOf(1u, 2u) to Rational(264211, 11200),
                    listOf(2u, 2u) to Rational(-1591999, 100800),
                    listOf(3u, 2u) to Rational(12450091, 529200),
                    listOf(4u, 2u) to Rational(9230759, 226800),
                    listOf(5u, 2u) to Rational(18995554, 2083725),
                    listOf(6u, 2u) to Rational(136706258, 6251175),
                    listOf(7u, 2u) to Rational(-120907496, 3750705),
                    listOf(8u, 2u) to Rational(117200176, 15752961),
                    listOf(0u, 3u) to Rational(5653, 320),
                    listOf(1u, 3u) to Rational(-130853, 8400),
                    listOf(2u, 3u) to Rational(-20939327, 151200),
                    listOf(3u, 3u) to Rational(2566691, 25200),
                    listOf(4u, 3u) to Rational(-68441519, 476280),
                    listOf(5u, 3u) to Rational(2462904247, 12502350),
                    listOf(6u, 3u) to Rational(353667161, 18753525),
                    listOf(7u, 3u) to Rational(-1689134372, 26254935),
                    listOf(8u, 3u) to Rational(35084104, 2250423),
                    listOf(0u, 4u) to Rational(-3587, 300),
                    listOf(1u, 4u) to Rational(-10513243, 33600),
                    listOf(2u, 4u) to Rational(30766733, 176400),
                    listOf(3u, 4u) to Rational(-65680021, 198450),
                    listOf(4u, 4u) to Rational(-8108910547, 20003760),
                    listOf(5u, 4u) to Rational(2922125159, 6251175),
                    listOf(6u, 4u) to Rational(-4245279943, 131274675),
                    listOf(7u, 4u) to Rational(-371946872, 3750705),
                    listOf(8u, 4u) to Rational(61286752, 2250423),
                    listOf(0u, 5u) to Rational(-20477, 160),
                    listOf(1u, 5u) to Rational(215741, 1120),
                    listOf(2u, 5u) to Rational(30785843, 31752),
                    listOf(3u, 5u) to Rational(-357495959, 317520),
                    listOf(4u, 5u) to Rational(-1611242993, 10001880),
                    listOf(5u, 5u) to Rational(345925495, 500094),
                    listOf(6u, 5u) to Rational(-755948411, 3750705),
                    listOf(7u, 5u) to Rational(-108643496, 1250235),
                    listOf(8u, 5u) to Rational(1122512, 35721),
                    listOf(0u, 6u) to Rational(358037, 2880),
                    listOf(1u, 6u) to Rational(3895837, 3360),
                    listOf(2u, 6u) to Rational(359419201, 1270080),
                    listOf(3u, 6u) to Rational(-158522587, 105840),
                    listOf(4u, 6u) to Rational(10909002599, 20003760),
                    listOf(5u, 6u) to Rational(76846972, 138915),
                    listOf(6u, 6u) to Rational(-327696553, 1250235),
                    listOf(7u, 6u) to Rational(-1687328, 35721),
                    listOf(8u, 6u) to Rational(1016836, 35721),
                    listOf(0u, 7u) to Rational(658, 3),
                    listOf(1u, 7u) to Rational(48035, 168),
                    listOf(2u, 7u) to Rational(-5777875, 5292),
                    listOf(3u, 7u) to Rational(-7893899, 10584),
                    listOf(4u, 7u) to Rational(10191652, 11907),
                    listOf(5u, 7u) to Rational(2920121, 23814),
                    listOf(6u, 7u) to Rational(-2699780, 11907),
                    listOf(7u, 7u) to Rational(4556, 441),
                    listOf(8u, 7u) to Rational(3440, 189),
                    listOf(0u, 8u) to Rational(64, 1),
                    listOf(1u, 8u) to Rational(-808, 7),
                    listOf(2u, 8u) to Rational(-360895, 1764),
                    listOf(3u, 8u) to Rational(257657, 882),
                    listOf(4u, 8u) to Rational(3779917, 15876),
                    listOf(5u, 8u) to Rational(-610279, 3969),
                    listOf(6u, 8u) to Rational(-25091, 441),
                    listOf(7u, 8u) to Rational(9560, 567),
                    listOf(8u, 8u) to Rational(400, 81)
                )
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(15, 7),
                listOf(1u) to Rational(1, 5),
                listOf(2u) to Rational(-7, 4),
                listOf(0u, 1u) to Rational(-1, 9),
                listOf(1u, 1u) to Rational(-2, 7),
                listOf(2u, 1u) to Rational(17, 3),
                listOf(0u, 2u) to Rational(2, 6),
                listOf(1u, 2u) to Rational(-17, 6),
                listOf(2u, 2u) to Rational(-6, 2),
            ).substitute(RationalField, mapOf(
                0 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(17, 5),
                        listOf(1u) to Rational(11, 6),
                        listOf(2u) to Rational(14, 3),
                        listOf(0u, 1u) to Rational(17, 1),
                        listOf(1u, 1u) to Rational(12, 3),
                        listOf(2u, 1u) to Rational(-6, 2),
                        listOf(0u, 2u) to Rational(17, 1),
                        listOf(1u, 2u) to Rational(-4, 3),
                        listOf(2u, 2u) to Rational(2, 6),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(3, 5),
                        listOf(1u) to Rational(3, 5),
                        listOf(2u) to Rational(3, 7),
                        listOf(0u, 1u) to Rational(-3, 8),
                        listOf(1u, 1u) to Rational(-1, 1),
                        listOf(2u, 1u) to Rational(17, 9),
                        listOf(0u, 2u) to Rational(-8, 1),
                        listOf(1u, 2u) to Rational(6, 4),
                        listOf(2u, 2u) to Rational(10, 9),
                    )
                ),
                1 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(18, 5),
                        listOf(1u) to Rational(-17, 5),
                        listOf(2u) to Rational(-2, 7),
                        listOf(0u, 1u) to Rational(6, 5),
                        listOf(1u, 1u) to Rational(-5, 1),
                        listOf(2u, 1u) to Rational(-9, 1),
                        listOf(0u, 2u) to Rational(-8, 8),
                        listOf(1u, 2u) to Rational(2, 7),
                        listOf(2u, 2u) to Rational(-13, 7),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(-4, 8),
                        listOf(1u) to Rational(15, 9),
                        listOf(2u) to Rational(-10, 9),
                        listOf(0u, 1u) to Rational(5, 3),
                        listOf(1u, 1u) to Rational(4, 1),
                        listOf(2u, 1u) to Rational(-2, 7),
                        listOf(0u, 2u) to Rational(2, 2),
                        listOf(1u, 2u) to Rational(-5, 7),
                        listOf(2u, 2u) to Rational(-18, 9),
                    )
                ),
                5 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(-2, 9),
                        listOf(1u) to Rational(-6, 3),
                        listOf(2u) to Rational(10, 9),
                        listOf(0u, 1u) to Rational(13, 3),
                        listOf(1u, 1u) to Rational(-12, 4),
                        listOf(2u, 1u) to Rational(3, 6),
                        listOf(0u, 2u) to Rational(2, 9),
                        listOf(1u, 2u) to Rational(7, 3),
                        listOf(2u, 2u) to Rational(16, 5),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(-6, 2),
                        listOf(1u) to Rational(6, 2),
                        listOf(2u) to Rational(2, 7),
                        listOf(0u, 1u) to Rational(-18, 1),
                        listOf(1u, 1u) to Rational(-11, 3),
                        listOf(2u, 1u) to Rational(7, 5),
                        listOf(0u, 2u) to Rational(8, 1),
                        listOf(1u, 2u) to Rational(6, 7),
                        listOf(2u, 2u) to Rational(17, 4),
                    )
                )
            )),
            "test 3'"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-66677, 3500),
                    listOf(1u) to Rational(-206281, 10500),
                    listOf(2u) to Rational(-412567, 7056),
                    listOf(3u) to Rational(-310081, 11025),
                    listOf(4u) to Rational(-575996, 15435),
                    listOf(0u, 1u) to Rational(-573701, 4200),
                    listOf(1u, 1u) to Rational(-2239001, 25200),
                    listOf(2u, 1u) to Rational(-8817889, 132300),
                    listOf(3u, 1u) to Rational(2317919, 44100),
                    listOf(4u, 1u) to Rational(1169471, 6615),
                    listOf(0u, 2u) to Rational(-4057819, 33600),
                    listOf(1u, 2u) to Rational(1373311, 12600),
                    listOf(2u, 2u) to Rational(32433493, 52920),
                    listOf(3u, 2u) to Rational(4998053, 33075),
                    listOf(4u, 2u) to Rational(-2147779, 8820),
                    listOf(0u, 3u) to Rational(2018481, 2240),
                    listOf(1u, 3u) to Rational(941713, 1440),
                    listOf(2u, 3u) to Rational(183749, 6615),
                    listOf(3u, 3u) to Rational(-4631023, 15876),
                    listOf(4u, 3u) to Rational(25609336, 178605),
                    listOf(0u, 4u) to Rational(11886431, 6720),
                    listOf(1u, 4u) to Rational(18433, 504),
                    listOf(2u, 4u) to Rational(-39613331, 45360),
                    listOf(3u, 4u) to Rational(681619, 5670),
                    listOf(4u, 4u) to Rational(-864841, 20412),
                    listOf(0u, 5u) to Rational(343535, 1008),
                    listOf(1u, 5u) to Rational(-33583, 72),
                    listOf(2u, 5u) to Rational(1194625, 9072),
                    listOf(3u, 5u) to Rational(-62917, 2268),
                    listOf(4u, 5u) to Rational(157645, 10206),
                    listOf(0u, 6u) to Rational(-1381, 3),
                    listOf(1u, 6u) to Rational(919, 36),
                    listOf(2u, 6u) to Rational(-3053, 36),
                    listOf(3u, 6u) to Rational(2125, 324),
                    listOf(4u, 6u) to Rational(-236, 243)
                ),
                NumberedPolynomialAsIs(listOf<UInt>() to Rational(0, 1),
                    listOf<UInt>() to Rational(1, 4),
                    listOf(1u) to Rational(-5, 3),
                    listOf(2u) to Rational(35, 9),
                    listOf(3u) to Rational(-100, 27),
                    listOf(4u) to Rational(100, 81),
                    listOf(0u, 1u) to Rational(-5, 3),
                    listOf(1u, 1u) to Rational(14, 9),
                    listOf(2u, 1u) to Rational(1874, 189),
                    listOf(3u, 1u) to Rational(-620, 63),
                    listOf(4u, 1u) to Rational(40, 63),
                    listOf(0u, 2u) to Rational(16, 9),
                    listOf(1u, 2u) to Rational(365, 21),
                    listOf(2u, 2u) to Rational(112, 9),
                    listOf(3u, 2u) to Rational(-464, 63),
                    listOf(4u, 2u) to Rational(1996, 441),
                    listOf(0u, 3u) to Rational(10, 3),
                    listOf(1u, 3u) to Rational(118, 21),
                    listOf(2u, 3u) to Rational(-272, 21),
                    listOf(3u, 3u) to Rational(-764, 49),
                    listOf(4u, 3u) to Rational(8, 7),
                    listOf(0u, 4u) to Rational(1, 1),
                    listOf(1u, 4u) to Rational(-10, 7),
                    listOf(2u, 4u) to Rational(-171, 49),
                    listOf(3u, 4u) to Rational(20, 7),
                    listOf(4u, 4u) to Rational(4, 1)
                )
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(15, 7),
                listOf(1u) to Rational(1, 5),
                listOf(2u) to Rational(-7, 4),
                listOf(0u, 1u) to Rational(-1, 9),
                listOf(1u, 1u) to Rational(-2, 7),
                listOf(2u, 1u) to Rational(17, 3),
                listOf(0u, 2u) to Rational(2, 6),
                listOf(1u, 2u) to Rational(-17, 6),
                listOf(2u, 2u) to Rational(-6, 2),
            ).substitute(RationalField, mapOf(
                0 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(17, 5),
                        listOf(1u) to Rational(11, 6),
                        listOf(2u) to Rational(14, 3),
                        listOf(0u, 1u) to Rational(17, 1),
                        listOf(1u, 1u) to Rational(12, 3),
                        listOf(2u, 1u) to Rational(-6, 2),
                        listOf(0u, 2u) to Rational(17, 1),
                        listOf(1u, 2u) to Rational(-4, 3),
                        listOf(2u, 2u) to Rational(2, 6),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(3, 5),
                        listOf(1u) to Rational(3, 5),
                        listOf(2u) to Rational(3, 7),
                        listOf(0u, 1u) to Rational(-3, 8),
                        listOf(1u, 1u) to Rational(-1, 1),
                        listOf(2u, 1u) to Rational(17, 9),
                        listOf(0u, 2u) to Rational(-8, 1),
                        listOf(1u, 2u) to Rational(6, 4),
                        listOf(2u, 2u) to Rational(10, 9),
                    )
                ),
            )),
            "test 4"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-66677, 3500),
                    listOf(1u) to Rational(-206281, 10500),
                    listOf(2u) to Rational(-412567, 7056),
                    listOf(3u) to Rational(-310081, 11025),
                    listOf(4u) to Rational(-575996, 15435),
                    listOf(0u, 1u) to Rational(-573701, 4200),
                    listOf(1u, 1u) to Rational(-2239001, 25200),
                    listOf(2u, 1u) to Rational(-8817889, 132300),
                    listOf(3u, 1u) to Rational(2317919, 44100),
                    listOf(4u, 1u) to Rational(1169471, 6615),
                    listOf(0u, 2u) to Rational(-4057819, 33600),
                    listOf(1u, 2u) to Rational(1373311, 12600),
                    listOf(2u, 2u) to Rational(32433493, 52920),
                    listOf(3u, 2u) to Rational(4998053, 33075),
                    listOf(4u, 2u) to Rational(-2147779, 8820),
                    listOf(0u, 3u) to Rational(2018481, 2240),
                    listOf(1u, 3u) to Rational(941713, 1440),
                    listOf(2u, 3u) to Rational(183749, 6615),
                    listOf(3u, 3u) to Rational(-4631023, 15876),
                    listOf(4u, 3u) to Rational(25609336, 178605),
                    listOf(0u, 4u) to Rational(11886431, 6720),
                    listOf(1u, 4u) to Rational(18433, 504),
                    listOf(2u, 4u) to Rational(-39613331, 45360),
                    listOf(3u, 4u) to Rational(681619, 5670),
                    listOf(4u, 4u) to Rational(-864841, 20412),
                    listOf(0u, 5u) to Rational(343535, 1008),
                    listOf(1u, 5u) to Rational(-33583, 72),
                    listOf(2u, 5u) to Rational(1194625, 9072),
                    listOf(3u, 5u) to Rational(-62917, 2268),
                    listOf(4u, 5u) to Rational(157645, 10206),
                    listOf(0u, 6u) to Rational(-1381, 3),
                    listOf(1u, 6u) to Rational(919, 36),
                    listOf(2u, 6u) to Rational(-3053, 36),
                    listOf(3u, 6u) to Rational(2125, 324),
                    listOf(4u, 6u) to Rational(-236, 243)
                ),
                NumberedPolynomialAsIs(listOf<UInt>() to Rational(0, 1),
                    listOf<UInt>() to Rational(1, 4),
                    listOf(1u) to Rational(-5, 3),
                    listOf(2u) to Rational(35, 9),
                    listOf(3u) to Rational(-100, 27),
                    listOf(4u) to Rational(100, 81),
                    listOf(0u, 1u) to Rational(-5, 3),
                    listOf(1u, 1u) to Rational(14, 9),
                    listOf(2u, 1u) to Rational(1874, 189),
                    listOf(3u, 1u) to Rational(-620, 63),
                    listOf(4u, 1u) to Rational(40, 63),
                    listOf(0u, 2u) to Rational(16, 9),
                    listOf(1u, 2u) to Rational(365, 21),
                    listOf(2u, 2u) to Rational(112, 9),
                    listOf(3u, 2u) to Rational(-464, 63),
                    listOf(4u, 2u) to Rational(1996, 441),
                    listOf(0u, 3u) to Rational(10, 3),
                    listOf(1u, 3u) to Rational(118, 21),
                    listOf(2u, 3u) to Rational(-272, 21),
                    listOf(3u, 3u) to Rational(-764, 49),
                    listOf(4u, 3u) to Rational(8, 7),
                    listOf(0u, 4u) to Rational(1, 1),
                    listOf(1u, 4u) to Rational(-10, 7),
                    listOf(2u, 4u) to Rational(-171, 49),
                    listOf(3u, 4u) to Rational(20, 7),
                    listOf(4u, 4u) to Rational(4, 1)
                )
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(15, 7),
                listOf(1u) to Rational(1, 5),
                listOf(2u) to Rational(-7, 4),
                listOf(0u, 1u) to Rational(-1, 9),
                listOf(1u, 1u) to Rational(-2, 7),
                listOf(2u, 1u) to Rational(17, 3),
                listOf(0u, 2u) to Rational(2, 6),
                listOf(1u, 2u) to Rational(-17, 6),
                listOf(2u, 2u) to Rational(-6, 2),
            ).substitute(RationalField, mapOf(
                0 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(17, 5),
                        listOf(1u) to Rational(11, 6),
                        listOf(2u) to Rational(14, 3),
                        listOf(0u, 1u) to Rational(17, 1),
                        listOf(1u, 1u) to Rational(12, 3),
                        listOf(2u, 1u) to Rational(-6, 2),
                        listOf(0u, 2u) to Rational(17, 1),
                        listOf(1u, 2u) to Rational(-4, 3),
                        listOf(2u, 2u) to Rational(2, 6),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(3, 5),
                        listOf(1u) to Rational(3, 5),
                        listOf(2u) to Rational(3, 7),
                        listOf(0u, 1u) to Rational(-3, 8),
                        listOf(1u, 1u) to Rational(-1, 1),
                        listOf(2u, 1u) to Rational(17, 9),
                        listOf(0u, 2u) to Rational(-8, 1),
                        listOf(1u, 2u) to Rational(6, 4),
                        listOf(2u, 2u) to Rational(10, 9),
                    )
                ),
                5 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(-2, 9),
                        listOf(1u) to Rational(-6, 3),
                        listOf(2u) to Rational(10, 9),
                        listOf(0u, 1u) to Rational(13, 3),
                        listOf(1u, 1u) to Rational(-12, 4),
                        listOf(2u, 1u) to Rational(3, 6),
                        listOf(0u, 2u) to Rational(2, 9),
                        listOf(1u, 2u) to Rational(7, 3),
                        listOf(2u, 2u) to Rational(16, 5),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(-6, 2),
                        listOf(1u) to Rational(6, 2),
                        listOf(2u) to Rational(2, 7),
                        listOf(0u, 1u) to Rational(-18, 1),
                        listOf(1u, 1u) to Rational(-11, 3),
                        listOf(2u, 1u) to Rational(7, 5),
                        listOf(0u, 2u) to Rational(8, 1),
                        listOf(1u, 2u) to Rational(6, 7),
                        listOf(2u, 2u) to Rational(17, 4),
                    )
                )
            )),
            "test 4'"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(3539, 700),
                    listOf(1u) to Rational(-307079, 6300),
                    listOf(2u) to Rational(451609, 15120),
                    listOf(3u) to Rational(35287733, 396900),
                    listOf(4u) to Rational(-37242617, 396900),
                    listOf(5u) to Rational(382747, 19845),
                    listOf(6u) to Rational(-2407, 3969),
                    listOf(0u, 1u) to Rational(-226, 175),
                    listOf(1u, 1u) to Rational(-74113, 1890),
                    listOf(2u, 1u) to Rational(250931, 1764),
                    listOf(3u, 1u) to Rational(30071473, 99225),
                    listOf(4u, 1u) to Rational(-286466, 1323),
                    listOf(5u, 1u) to Rational(-2285282, 9261),
                    listOf(6u, 1u) to Rational(17900, 441),
                    listOf(0u, 2u) to Rational(3817, 3150),
                    listOf(1u, 2u) to Rational(577568, 11025),
                    listOf(2u, 2u) to Rational(9073553, 99225),
                    listOf(3u, 2u) to Rational(-1415849, 79380),
                    listOf(4u, 2u) to Rational(-124715629, 277830),
                    listOf(5u, 2u) to Rational(-1328953, 1890),
                    listOf(6u, 2u) to Rational(-297148, 1323),
                    listOf(0u, 3u) to Rational(6043, 945),
                    listOf(1u, 3u) to Rational(160381, 6615),
                    listOf(2u, 3u) to Rational(-673249, 13230),
                    listOf(3u, 3u) to Rational(-319255, 2058),
                    listOf(4u, 3u) to Rational(-98144, 1029),
                    listOf(5u, 3u) to Rational(-320239, 5145),
                    listOf(6u, 3u) to Rational(400, 147),
                    listOf(0u, 4u) to Rational(163, 63),
                    listOf(1u, 4u) to Rational(-25183, 4410),
                    listOf(2u, 4u) to Rational(-21369, 1372),
                    listOf(3u, 4u) to Rational(127499, 30870),
                    listOf(4u, 4u) to Rational(86971, 12348),
                    listOf(5u, 4u) to Rational(-11129, 1470),
                    listOf(6u, 4u) to Rational(544, 147)
                ),
                NumberedPolynomialAsIs(listOf<UInt>() to Rational(0, 1),
                    listOf<UInt>() to Rational(1, 4),
                    listOf(1u) to Rational(-5, 3),
                    listOf(2u) to Rational(35, 9),
                    listOf(3u) to Rational(-100, 27),
                    listOf(4u) to Rational(100, 81),
                    listOf(0u, 1u) to Rational(-5, 3),
                    listOf(1u, 1u) to Rational(14, 9),
                    listOf(2u, 1u) to Rational(1874, 189),
                    listOf(3u, 1u) to Rational(-620, 63),
                    listOf(4u, 1u) to Rational(40, 63),
                    listOf(0u, 2u) to Rational(16, 9),
                    listOf(1u, 2u) to Rational(365, 21),
                    listOf(2u, 2u) to Rational(112, 9),
                    listOf(3u, 2u) to Rational(-464, 63),
                    listOf(4u, 2u) to Rational(1996, 441),
                    listOf(0u, 3u) to Rational(10, 3),
                    listOf(1u, 3u) to Rational(118, 21),
                    listOf(2u, 3u) to Rational(-272, 21),
                    listOf(3u, 3u) to Rational(-764, 49),
                    listOf(4u, 3u) to Rational(8, 7),
                    listOf(0u, 4u) to Rational(1, 1),
                    listOf(1u, 4u) to Rational(-10, 7),
                    listOf(2u, 4u) to Rational(-171, 49),
                    listOf(3u, 4u) to Rational(20, 7),
                    listOf(4u, 4u) to Rational(4, 1)
                )
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(15, 7),
                listOf(1u) to Rational(1, 5),
                listOf(2u) to Rational(-7, 4),
                listOf(0u, 1u) to Rational(-1, 9),
                listOf(1u, 1u) to Rational(-2, 7),
                listOf(2u, 1u) to Rational(17, 3),
                listOf(0u, 2u) to Rational(2, 6),
                listOf(1u, 2u) to Rational(-17, 6),
                listOf(2u, 2u) to Rational(-6, 2),
            ).substitute(RationalField, mapOf(
                1 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(18, 5),
                        listOf(1u) to Rational(-17, 5),
                        listOf(2u) to Rational(-2, 7),
                        listOf(0u, 1u) to Rational(6, 5),
                        listOf(1u, 1u) to Rational(-5, 1),
                        listOf(2u, 1u) to Rational(-9, 1),
                        listOf(0u, 2u) to Rational(-8, 8),
                        listOf(1u, 2u) to Rational(2, 7),
                        listOf(2u, 2u) to Rational(-13, 7),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(-4, 8),
                        listOf(1u) to Rational(15, 9),
                        listOf(2u) to Rational(-10, 9),
                        listOf(0u, 1u) to Rational(5, 3),
                        listOf(1u, 1u) to Rational(4, 1),
                        listOf(2u, 1u) to Rational(-2, 7),
                        listOf(0u, 2u) to Rational(2, 2),
                        listOf(1u, 2u) to Rational(-5, 7),
                        listOf(2u, 2u) to Rational(-18, 9),
                    )
                ),
            )),
            "test 5"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(3539, 700),
                    listOf(1u) to Rational(-307079, 6300),
                    listOf(2u) to Rational(451609, 15120),
                    listOf(3u) to Rational(35287733, 396900),
                    listOf(4u) to Rational(-37242617, 396900),
                    listOf(5u) to Rational(382747, 19845),
                    listOf(6u) to Rational(-2407, 3969),
                    listOf(0u, 1u) to Rational(-226, 175),
                    listOf(1u, 1u) to Rational(-74113, 1890),
                    listOf(2u, 1u) to Rational(250931, 1764),
                    listOf(3u, 1u) to Rational(30071473, 99225),
                    listOf(4u, 1u) to Rational(-286466, 1323),
                    listOf(5u, 1u) to Rational(-2285282, 9261),
                    listOf(6u, 1u) to Rational(17900, 441),
                    listOf(0u, 2u) to Rational(3817, 3150),
                    listOf(1u, 2u) to Rational(577568, 11025),
                    listOf(2u, 2u) to Rational(9073553, 99225),
                    listOf(3u, 2u) to Rational(-1415849, 79380),
                    listOf(4u, 2u) to Rational(-124715629, 277830),
                    listOf(5u, 2u) to Rational(-1328953, 1890),
                    listOf(6u, 2u) to Rational(-297148, 1323),
                    listOf(0u, 3u) to Rational(6043, 945),
                    listOf(1u, 3u) to Rational(160381, 6615),
                    listOf(2u, 3u) to Rational(-673249, 13230),
                    listOf(3u, 3u) to Rational(-319255, 2058),
                    listOf(4u, 3u) to Rational(-98144, 1029),
                    listOf(5u, 3u) to Rational(-320239, 5145),
                    listOf(6u, 3u) to Rational(400, 147),
                    listOf(0u, 4u) to Rational(163, 63),
                    listOf(1u, 4u) to Rational(-25183, 4410),
                    listOf(2u, 4u) to Rational(-21369, 1372),
                    listOf(3u, 4u) to Rational(127499, 30870),
                    listOf(4u, 4u) to Rational(86971, 12348),
                    listOf(5u, 4u) to Rational(-11129, 1470),
                    listOf(6u, 4u) to Rational(544, 147)
                ),
                NumberedPolynomialAsIs(listOf<UInt>() to Rational(0, 1),
                    listOf<UInt>() to Rational(1, 4),
                    listOf(1u) to Rational(-5, 3),
                    listOf(2u) to Rational(35, 9),
                    listOf(3u) to Rational(-100, 27),
                    listOf(4u) to Rational(100, 81),
                    listOf(0u, 1u) to Rational(-5, 3),
                    listOf(1u, 1u) to Rational(14, 9),
                    listOf(2u, 1u) to Rational(1874, 189),
                    listOf(3u, 1u) to Rational(-620, 63),
                    listOf(4u, 1u) to Rational(40, 63),
                    listOf(0u, 2u) to Rational(16, 9),
                    listOf(1u, 2u) to Rational(365, 21),
                    listOf(2u, 2u) to Rational(112, 9),
                    listOf(3u, 2u) to Rational(-464, 63),
                    listOf(4u, 2u) to Rational(1996, 441),
                    listOf(0u, 3u) to Rational(10, 3),
                    listOf(1u, 3u) to Rational(118, 21),
                    listOf(2u, 3u) to Rational(-272, 21),
                    listOf(3u, 3u) to Rational(-764, 49),
                    listOf(4u, 3u) to Rational(8, 7),
                    listOf(0u, 4u) to Rational(1, 1),
                    listOf(1u, 4u) to Rational(-10, 7),
                    listOf(2u, 4u) to Rational(-171, 49),
                    listOf(3u, 4u) to Rational(20, 7),
                    listOf(4u, 4u) to Rational(4, 1)
                )
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(15, 7),
                listOf(1u) to Rational(1, 5),
                listOf(2u) to Rational(-7, 4),
                listOf(0u, 1u) to Rational(-1, 9),
                listOf(1u, 1u) to Rational(-2, 7),
                listOf(2u, 1u) to Rational(17, 3),
                listOf(0u, 2u) to Rational(2, 6),
                listOf(1u, 2u) to Rational(-17, 6),
                listOf(2u, 2u) to Rational(-6, 2),
            ).substitute(RationalField, mapOf(
                1 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(18, 5),
                        listOf(1u) to Rational(-17, 5),
                        listOf(2u) to Rational(-2, 7),
                        listOf(0u, 1u) to Rational(6, 5),
                        listOf(1u, 1u) to Rational(-5, 1),
                        listOf(2u, 1u) to Rational(-9, 1),
                        listOf(0u, 2u) to Rational(-8, 8),
                        listOf(1u, 2u) to Rational(2, 7),
                        listOf(2u, 2u) to Rational(-13, 7),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(-4, 8),
                        listOf(1u) to Rational(15, 9),
                        listOf(2u) to Rational(-10, 9),
                        listOf(0u, 1u) to Rational(5, 3),
                        listOf(1u, 1u) to Rational(4, 1),
                        listOf(2u, 1u) to Rational(-2, 7),
                        listOf(0u, 2u) to Rational(2, 2),
                        listOf(1u, 2u) to Rational(-5, 7),
                        listOf(2u, 2u) to Rational(-18, 9),
                    )
                ),
                5 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(-2, 9),
                        listOf(1u) to Rational(-6, 3),
                        listOf(2u) to Rational(10, 9),
                        listOf(0u, 1u) to Rational(13, 3),
                        listOf(1u, 1u) to Rational(-12, 4),
                        listOf(2u, 1u) to Rational(3, 6),
                        listOf(0u, 2u) to Rational(2, 9),
                        listOf(1u, 2u) to Rational(7, 3),
                        listOf(2u, 2u) to Rational(16, 5),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(-6, 2),
                        listOf(1u) to Rational(6, 2),
                        listOf(2u) to Rational(2, 7),
                        listOf(0u, 1u) to Rational(-18, 1),
                        listOf(1u, 1u) to Rational(-11, 3),
                        listOf(2u, 1u) to Rational(7, 5),
                        listOf(0u, 2u) to Rational(8, 1),
                        listOf(1u, 2u) to Rational(6, 7),
                        listOf(2u, 2u) to Rational(17, 4),
                    )
                )
            )),
            "test 5'"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(15, 7),
                    listOf(1u) to Rational(1, 5),
                    listOf(2u) to Rational(-7, 4),
                    listOf(0u, 1u) to Rational(-1, 9),
                    listOf(1u, 1u) to Rational(-2, 7),
                    listOf(2u, 1u) to Rational(17, 3),
                    listOf(0u, 2u) to Rational(2, 6),
                    listOf(1u, 2u) to Rational(-17, 6),
                    listOf(2u, 2u) to Rational(-6, 2),
                ),
                NumberedPolynomialAsIs(listOf<UInt>() to Rational(0, 1),
                    listOf<UInt>() to Rational(0, 1)
                )
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(15, 7),
                listOf(1u) to Rational(1, 5),
                listOf(2u) to Rational(-7, 4),
                listOf(0u, 1u) to Rational(-1, 9),
                listOf(1u, 1u) to Rational(-2, 7),
                listOf(2u, 1u) to Rational(17, 3),
                listOf(0u, 2u) to Rational(2, 6),
                listOf(1u, 2u) to Rational(-17, 6),
                listOf(2u, 2u) to Rational(-6, 2),
            ).substitute(RationalField, mapOf<Int, NumberedRationalFunction<Rational>>()),
            "test 6"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(15, 7),
                    listOf(1u) to Rational(1, 5),
                    listOf(2u) to Rational(-7, 4),
                    listOf(0u, 1u) to Rational(-1, 9),
                    listOf(1u, 1u) to Rational(-2, 7),
                    listOf(2u, 1u) to Rational(17, 3),
                    listOf(0u, 2u) to Rational(2, 6),
                    listOf(1u, 2u) to Rational(-17, 6),
                    listOf(2u, 2u) to Rational(-6, 2),
                ),
                NumberedPolynomialAsIs(listOf<UInt>() to Rational(0, 1),
                    listOf<UInt>() to Rational(0, 1)
                )
            ),
            NumberedPolynomialAsIs(
                listOf<UInt>() to Rational(15, 7),
                listOf(1u) to Rational(1, 5),
                listOf(2u) to Rational(-7, 4),
                listOf(0u, 1u) to Rational(-1, 9),
                listOf(1u, 1u) to Rational(-2, 7),
                listOf(2u, 1u) to Rational(17, 3),
                listOf(0u, 2u) to Rational(2, 6),
                listOf(1u, 2u) to Rational(-17, 6),
                listOf(2u, 2u) to Rational(-6, 2),
            ).substitute(RationalField, mapOf(
                5 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(-2, 9),
                        listOf(1u) to Rational(-6, 3),
                        listOf(2u) to Rational(10, 9),
                        listOf(0u, 1u) to Rational(13, 3),
                        listOf(1u, 1u) to Rational(-12, 4),
                        listOf(2u, 1u) to Rational(3, 6),
                        listOf(0u, 2u) to Rational(2, 9),
                        listOf(1u, 2u) to Rational(7, 3),
                        listOf(2u, 2u) to Rational(16, 5),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(-6, 2),
                        listOf(1u) to Rational(6, 2),
                        listOf(2u) to Rational(2, 7),
                        listOf(0u, 1u) to Rational(-18, 1),
                        listOf(1u, 1u) to Rational(-11, 3),
                        listOf(2u, 1u) to Rational(7, 5),
                        listOf(0u, 2u) to Rational(8, 1),
                        listOf(1u, 2u) to Rational(6, 7),
                        listOf(2u, 2u) to Rational(17, 4),
                    )
                )
            )),
            "test 6'"
        )
    }
    @Test
    fun test_RationalFunction_substitute_Double_Map() {
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(emptyList<UInt>() to 0.0),
                NumberedPolynomialAsIs(emptyList<UInt>() to 1.0),
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 1.0,
                    listOf(1u) to -2.0,
                    listOf(2u) to 1.0,
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 1.0,
                )
            ).substitute(mapOf(
                0 to 1.0
            )),
            0.001,
            "test 1"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 6.593754860231304,
                    listOf(1u) to -7.853302571550634,
                    listOf(2u) to 1.2265042281530025,
                    listOf(0u, 1u) to 3.762648877294904,
                    listOf(1u, 1u) to -8.945144619305292,
                    listOf(2u, 1u) to -5.141384718042281,
                    listOf(0u, 2u) to 7.359794483988782,
                    listOf(1u, 2u) to -4.3526172680518815,
                    listOf(2u, 2u) to 0.907910924854372,
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 9.533292132172562,
                    listOf(1u) to -1.982814534018857,
                    listOf(2u) to -5.974248303415283,
                    listOf(0u, 1u) to 1.5876716499288879,
                    listOf(1u, 1u) to -7.535152566659664,
                    listOf(2u, 1u) to 0.7549300500153517,
                    listOf(0u, 2u) to -5.242030058021028,
                    listOf(1u, 2u) to -0.7265704289690582,
                    listOf(2u, 2u) to -7.139677818189821,
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 6.593754860231304,
                    listOf(1u) to -7.853302571550634,
                    listOf(2u) to 1.2265042281530025,
                    listOf(0u, 1u) to 3.762648877294904,
                    listOf(1u, 1u) to -8.945144619305292,
                    listOf(2u, 1u) to -5.141384718042281,
                    listOf(0u, 2u) to 7.359794483988782,
                    listOf(1u, 2u) to -4.3526172680518815,
                    listOf(2u, 2u) to 0.907910924854372,
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 9.533292132172562,
                    listOf(1u) to -1.982814534018857,
                    listOf(2u) to -5.974248303415283,
                    listOf(0u, 1u) to 1.5876716499288879,
                    listOf(1u, 1u) to -7.535152566659664,
                    listOf(2u, 1u) to 0.7549300500153517,
                    listOf(0u, 2u) to -5.242030058021028,
                    listOf(1u, 2u) to -0.7265704289690582,
                    listOf(2u, 2u) to -7.139677818189821,
                )
            ).substitute(mapOf()),
            0.001,
            "test 2"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 6.593754860231304,
                    listOf(1u) to -7.853302571550634,
                    listOf(2u) to 1.2265042281530025,
                    listOf(0u, 1u) to 3.762648877294904,
                    listOf(1u, 1u) to -8.945144619305292,
                    listOf(2u, 1u) to -5.141384718042281,
                    listOf(0u, 2u) to 7.359794483988782,
                    listOf(1u, 2u) to -4.3526172680518815,
                    listOf(2u, 2u) to 0.907910924854372,
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 9.533292132172562,
                    listOf(1u) to -1.982814534018857,
                    listOf(2u) to -5.974248303415283,
                    listOf(0u, 1u) to 1.5876716499288879,
                    listOf(1u, 1u) to -7.535152566659664,
                    listOf(2u, 1u) to 0.7549300500153517,
                    listOf(0u, 2u) to -5.242030058021028,
                    listOf(1u, 2u) to -0.7265704289690582,
                    listOf(2u, 2u) to -7.139677818189821,
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 6.593754860231304,
                    listOf(1u) to -7.853302571550634,
                    listOf(2u) to 1.2265042281530025,
                    listOf(0u, 1u) to 3.762648877294904,
                    listOf(1u, 1u) to -8.945144619305292,
                    listOf(2u, 1u) to -5.141384718042281,
                    listOf(0u, 2u) to 7.359794483988782,
                    listOf(1u, 2u) to -4.3526172680518815,
                    listOf(2u, 2u) to 0.907910924854372,
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 9.533292132172562,
                    listOf(1u) to -1.982814534018857,
                    listOf(2u) to -5.974248303415283,
                    listOf(0u, 1u) to 1.5876716499288879,
                    listOf(1u, 1u) to -7.535152566659664,
                    listOf(2u, 1u) to 0.7549300500153517,
                    listOf(0u, 2u) to -5.242030058021028,
                    listOf(1u, 2u) to -0.7265704289690582,
                    listOf(2u, 2u) to -7.139677818189821,
                )
            ).substitute(mapOf(
                5 to 0.9211194782050933
            )),
            0.001,
            "test 2'"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 151.1502229133916,
                    listOf(0u, 1u) to -262.3790170577034,
                    listOf(0u, 2u) to 102.5097937392923,
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to -367.9969733169944,
                    listOf(0u, 1u) to 112.4911133334554,
                    listOf(0u, 2u) to -469.755906895345,
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 6.593754860231304,
                    listOf(1u) to -7.853302571550634,
                    listOf(2u) to 1.2265042281530025,
                    listOf(0u, 1u) to 3.762648877294904,
                    listOf(1u, 1u) to -8.945144619305292,
                    listOf(2u, 1u) to -5.141384718042281,
                    listOf(0u, 2u) to 7.359794483988782,
                    listOf(1u, 2u) to -4.3526172680518815,
                    listOf(2u, 2u) to 0.907910924854372,
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 9.533292132172562,
                    listOf(1u) to -1.982814534018857,
                    listOf(2u) to -5.974248303415283,
                    listOf(0u, 1u) to 1.5876716499288879,
                    listOf(1u, 1u) to -7.535152566659664,
                    listOf(2u, 1u) to 0.7549300500153517,
                    listOf(0u, 2u) to -5.242030058021028,
                    listOf(1u, 2u) to -0.7265704289690582,
                    listOf(2u, 2u) to -7.139677818189821,
                )
            ).substitute(mapOf(
                0 to -8.11707689492641,
            )),
            0.001,
            "test 3"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 151.1502229133916,
                    listOf(0u, 1u) to -262.3790170577034,
                    listOf(0u, 2u) to 102.5097937392923,
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to -367.9969733169944,
                    listOf(0u, 1u) to 112.4911133334554,
                    listOf(0u, 2u) to -469.755906895345,
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 6.593754860231304,
                    listOf(1u) to -7.853302571550634,
                    listOf(2u) to 1.2265042281530025,
                    listOf(0u, 1u) to 3.762648877294904,
                    listOf(1u, 1u) to -8.945144619305292,
                    listOf(2u, 1u) to -5.141384718042281,
                    listOf(0u, 2u) to 7.359794483988782,
                    listOf(1u, 2u) to -4.3526172680518815,
                    listOf(2u, 2u) to 0.907910924854372,
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 9.533292132172562,
                    listOf(1u) to -1.982814534018857,
                    listOf(2u) to -5.974248303415283,
                    listOf(0u, 1u) to 1.5876716499288879,
                    listOf(1u, 1u) to -7.535152566659664,
                    listOf(2u, 1u) to 0.7549300500153517,
                    listOf(0u, 2u) to -5.242030058021028,
                    listOf(1u, 2u) to -0.7265704289690582,
                    listOf(2u, 2u) to -7.139677818189821,
                )
            ).substitute(mapOf(
                0 to -8.11707689492641,
                5 to 0.9211194782050933
            )),
            0.001,
            "test 3'"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 14.24074356896978,
                    listOf(1u) to -17.71987055153461,
                    listOf(2u) to -2.288056483312383,
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 7.480604285873397,
                    listOf(1u) to -8.43478016688617,
                    listOf(2u) to -9.88934943900592,
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 6.593754860231304,
                    listOf(1u) to -7.853302571550634,
                    listOf(2u) to 1.2265042281530025,
                    listOf(0u, 1u) to 3.762648877294904,
                    listOf(1u, 1u) to -8.945144619305292,
                    listOf(2u, 1u) to -5.141384718042281,
                    listOf(0u, 2u) to 7.359794483988782,
                    listOf(1u, 2u) to -4.3526172680518815,
                    listOf(2u, 2u) to 0.907910924854372,
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 9.533292132172562,
                    listOf(1u) to -1.982814534018857,
                    listOf(2u) to -5.974248303415283,
                    listOf(0u, 1u) to 1.5876716499288879,
                    listOf(1u, 1u) to -7.535152566659664,
                    listOf(2u, 1u) to 0.7549300500153517,
                    listOf(0u, 2u) to -5.242030058021028,
                    listOf(1u, 2u) to -0.7265704289690582,
                    listOf(2u, 2u) to -7.139677818189821,
                )
            ).substitute(mapOf(
                1 to 0.795265651276015,
            )),
            0.001,
            "test 4"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 14.24074356896978,
                    listOf(1u) to -17.71987055153461,
                    listOf(2u) to -2.288056483312383,
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 7.480604285873397,
                    listOf(1u) to -8.43478016688617,
                    listOf(2u) to -9.88934943900592,
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 6.593754860231304,
                    listOf(1u) to -7.853302571550634,
                    listOf(2u) to 1.2265042281530025,
                    listOf(0u, 1u) to 3.762648877294904,
                    listOf(1u, 1u) to -8.945144619305292,
                    listOf(2u, 1u) to -5.141384718042281,
                    listOf(0u, 2u) to 7.359794483988782,
                    listOf(1u, 2u) to -4.3526172680518815,
                    listOf(2u, 2u) to 0.907910924854372,
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 9.533292132172562,
                    listOf(1u) to -1.982814534018857,
                    listOf(2u) to -5.974248303415283,
                    listOf(0u, 1u) to 1.5876716499288879,
                    listOf(1u, 1u) to -7.535152566659664,
                    listOf(2u, 1u) to 0.7549300500153517,
                    listOf(0u, 2u) to -5.242030058021028,
                    listOf(1u, 2u) to -0.7265704289690582,
                    listOf(2u, 2u) to -7.139677818189821,
                )
            ).substitute(mapOf(
                1 to 0.795265651276015,
                5 to 0.9211194782050933
            )),
            0.001,
            "test 4'"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 7.321261307532708,
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to -575.6325831127576,
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 6.593754860231304,
                    listOf(1u) to -7.853302571550634,
                    listOf(2u) to 1.2265042281530025,
                    listOf(0u, 1u) to 3.762648877294904,
                    listOf(1u, 1u) to -8.945144619305292,
                    listOf(2u, 1u) to -5.141384718042281,
                    listOf(0u, 2u) to 7.359794483988782,
                    listOf(1u, 2u) to -4.3526172680518815,
                    listOf(2u, 2u) to 0.907910924854372,
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 9.533292132172562,
                    listOf(1u) to -1.982814534018857,
                    listOf(2u) to -5.974248303415283,
                    listOf(0u, 1u) to 1.5876716499288879,
                    listOf(1u, 1u) to -7.535152566659664,
                    listOf(2u, 1u) to 0.7549300500153517,
                    listOf(0u, 2u) to -5.242030058021028,
                    listOf(1u, 2u) to -0.7265704289690582,
                    listOf(2u, 2u) to -7.139677818189821,
                )
            ).substitute(mapOf(
                0 to -8.11707689492641,
                1 to 0.795265651276015,
            )),
            0.001,
            "test 5"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 7.321261307532708,
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to -575.6325831127576,
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 6.593754860231304,
                    listOf(1u) to -7.853302571550634,
                    listOf(2u) to 1.2265042281530025,
                    listOf(0u, 1u) to 3.762648877294904,
                    listOf(1u, 1u) to -8.945144619305292,
                    listOf(2u, 1u) to -5.141384718042281,
                    listOf(0u, 2u) to 7.359794483988782,
                    listOf(1u, 2u) to -4.3526172680518815,
                    listOf(2u, 2u) to 0.907910924854372,
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to 9.533292132172562,
                    listOf(1u) to -1.982814534018857,
                    listOf(2u) to -5.974248303415283,
                    listOf(0u, 1u) to 1.5876716499288879,
                    listOf(1u, 1u) to -7.535152566659664,
                    listOf(2u, 1u) to 0.7549300500153517,
                    listOf(0u, 2u) to -5.242030058021028,
                    listOf(1u, 2u) to -0.7265704289690582,
                    listOf(2u, 2u) to -7.139677818189821,
                )
            ).substitute(mapOf(
                0 to -8.11707689492641,
                1 to 0.795265651276015,
                5 to 0.9211194782050933
            )),
            0.001,
            "test 5'"
        )
    }
    @Test
    fun test_RationalFunction_substitute_Constant_Map() {
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(0)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1)
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1),
                    listOf(1u) to Rational(-2),
                    listOf(2u) to Rational(1)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1)
                )
            ).substitute(RationalField, mapOf(
                0 to Rational(1)
            )),
            "test 1"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(22047, 2450),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-2204953, 147000),
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-3, 5),
                    listOf(1u) to Rational(-18, 4),
                    listOf(2u) to Rational(9, 8),
                    listOf(0u, 1u) to Rational(-11, 6),
                    listOf(1u, 1u) to Rational(-16, 3),
                    listOf(2u, 1u) to Rational(12, 2),
                    listOf(0u, 2u) to Rational(5, 3),
                    listOf(1u, 2u) to Rational(17, 8),
                    listOf(2u, 2u) to Rational(1, 3),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(11, 1),
                    listOf(1u) to Rational(4, 1),
                    listOf(2u) to Rational(-18, 3),
                    listOf(0u, 1u) to Rational(12, 9),
                    listOf(1u, 1u) to Rational(14, 7),
                    listOf(2u, 1u) to Rational(-17, 5),
                    listOf(0u, 2u) to Rational(-4, 1),
                    listOf(1u, 2u) to Rational(-5, 5),
                    listOf(2u, 2u) to Rational(-7, 8),
                )
            ).substitute(RationalField, mapOf(
                0 to Rational(7, 5),
                1 to Rational(-13, 7),
            )),
            "test 2"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(22047, 2450),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-2204953, 147000),
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-3, 5),
                    listOf(1u) to Rational(-18, 4),
                    listOf(2u) to Rational(9, 8),
                    listOf(0u, 1u) to Rational(-11, 6),
                    listOf(1u, 1u) to Rational(-16, 3),
                    listOf(2u, 1u) to Rational(12, 2),
                    listOf(0u, 2u) to Rational(5, 3),
                    listOf(1u, 2u) to Rational(17, 8),
                    listOf(2u, 2u) to Rational(1, 3),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(11, 1),
                    listOf(1u) to Rational(4, 1),
                    listOf(2u) to Rational(-18, 3),
                    listOf(0u, 1u) to Rational(12, 9),
                    listOf(1u, 1u) to Rational(14, 7),
                    listOf(2u, 1u) to Rational(-17, 5),
                    listOf(0u, 2u) to Rational(-4, 1),
                    listOf(1u, 2u) to Rational(-5, 5),
                    listOf(2u, 2u) to Rational(-7, 8),
                )
            ).substitute(RationalField, mapOf(
                0 to Rational(7, 5),
                1 to Rational(-13, 7),
                5 to Rational(-16, 4),
            )),
            "test 2'"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(4191, 490),
                    listOf(1u) to Rational(14975, 1176),
                    listOf(2u) to Rational(-10429, 1176)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-775, 147),
                    listOf(1u) to Rational(-155, 49),
                    listOf(2u) to Rational(-757, 280)
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-3, 5),
                    listOf(1u) to Rational(-18, 4),
                    listOf(2u) to Rational(9, 8),
                    listOf(0u, 1u) to Rational(-11, 6),
                    listOf(1u, 1u) to Rational(-16, 3),
                    listOf(2u, 1u) to Rational(12, 2),
                    listOf(0u, 2u) to Rational(5, 3),
                    listOf(1u, 2u) to Rational(17, 8),
                    listOf(2u, 2u) to Rational(1, 3),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(11, 1),
                    listOf(1u) to Rational(4, 1),
                    listOf(2u) to Rational(-18, 3),
                    listOf(0u, 1u) to Rational(12, 9),
                    listOf(1u, 1u) to Rational(14, 7),
                    listOf(2u, 1u) to Rational(-17, 5),
                    listOf(0u, 2u) to Rational(-4, 1),
                    listOf(1u, 2u) to Rational(-5, 5),
                    listOf(2u, 2u) to Rational(-7, 8),
                )
            ).substitute(RationalField, mapOf(
                1 to Rational(-13, 7),
            )),
            "test 3"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(4191, 490),
                    listOf(1u) to Rational(14975, 1176),
                    listOf(2u) to Rational(-10429, 1176)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-775, 147),
                    listOf(1u) to Rational(-155, 49),
                    listOf(2u) to Rational(-757, 280)
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-3, 5),
                    listOf(1u) to Rational(-18, 4),
                    listOf(2u) to Rational(9, 8),
                    listOf(0u, 1u) to Rational(-11, 6),
                    listOf(1u, 1u) to Rational(-16, 3),
                    listOf(2u, 1u) to Rational(12, 2),
                    listOf(0u, 2u) to Rational(5, 3),
                    listOf(1u, 2u) to Rational(17, 8),
                    listOf(2u, 2u) to Rational(1, 3),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(11, 1),
                    listOf(1u) to Rational(4, 1),
                    listOf(2u) to Rational(-18, 3),
                    listOf(0u, 1u) to Rational(12, 9),
                    listOf(1u, 1u) to Rational(14, 7),
                    listOf(2u, 1u) to Rational(-17, 5),
                    listOf(0u, 2u) to Rational(-4, 1),
                    listOf(1u, 2u) to Rational(-5, 5),
                    listOf(2u, 2u) to Rational(-7, 8),
                )
            ).substitute(RationalField, mapOf(
                1 to Rational(-13, 7),
                5 to Rational(-16, 4),
            )),
            "test 3'"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-939, 200),
                    listOf(0u, 1u) to Rational(123, 50),
                    listOf(0u, 2u) to Rational(1059, 200)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(121, 25),
                    listOf(0u, 1u) to Rational(-949, 375),
                    listOf(0u, 2u) to Rational(-1423, 200)
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-3, 5),
                    listOf(1u) to Rational(-18, 4),
                    listOf(2u) to Rational(9, 8),
                    listOf(0u, 1u) to Rational(-11, 6),
                    listOf(1u, 1u) to Rational(-16, 3),
                    listOf(2u, 1u) to Rational(12, 2),
                    listOf(0u, 2u) to Rational(5, 3),
                    listOf(1u, 2u) to Rational(17, 8),
                    listOf(2u, 2u) to Rational(1, 3),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(11, 1),
                    listOf(1u) to Rational(4, 1),
                    listOf(2u) to Rational(-18, 3),
                    listOf(0u, 1u) to Rational(12, 9),
                    listOf(1u, 1u) to Rational(14, 7),
                    listOf(2u, 1u) to Rational(-17, 5),
                    listOf(0u, 2u) to Rational(-4, 1),
                    listOf(1u, 2u) to Rational(-5, 5),
                    listOf(2u, 2u) to Rational(-7, 8),
                )
            ).substitute(RationalField, mapOf(
                0 to Rational(7, 5),
            )),
            "test 4"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-939, 200),
                    listOf(0u, 1u) to Rational(123, 50),
                    listOf(0u, 2u) to Rational(1059, 200)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(121, 25),
                    listOf(0u, 1u) to Rational(-949, 375),
                    listOf(0u, 2u) to Rational(-1423, 200)
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-3, 5),
                    listOf(1u) to Rational(-18, 4),
                    listOf(2u) to Rational(9, 8),
                    listOf(0u, 1u) to Rational(-11, 6),
                    listOf(1u, 1u) to Rational(-16, 3),
                    listOf(2u, 1u) to Rational(12, 2),
                    listOf(0u, 2u) to Rational(5, 3),
                    listOf(1u, 2u) to Rational(17, 8),
                    listOf(2u, 2u) to Rational(1, 3),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(11, 1),
                    listOf(1u) to Rational(4, 1),
                    listOf(2u) to Rational(-18, 3),
                    listOf(0u, 1u) to Rational(12, 9),
                    listOf(1u, 1u) to Rational(14, 7),
                    listOf(2u, 1u) to Rational(-17, 5),
                    listOf(0u, 2u) to Rational(-4, 1),
                    listOf(1u, 2u) to Rational(-5, 5),
                    listOf(2u, 2u) to Rational(-7, 8),
                )
            ).substitute(RationalField, mapOf(
                0 to Rational(7, 5),
                5 to Rational(-16, 4),
            )),
            "test 4'"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-3, 5),
                    listOf(1u) to Rational(-18, 4),
                    listOf(2u) to Rational(9, 8),
                    listOf(0u, 1u) to Rational(-11, 6),
                    listOf(1u, 1u) to Rational(-16, 3),
                    listOf(2u, 1u) to Rational(12, 2),
                    listOf(0u, 2u) to Rational(5, 3),
                    listOf(1u, 2u) to Rational(17, 8),
                    listOf(2u, 2u) to Rational(1, 3),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(11, 1),
                    listOf(1u) to Rational(4, 1),
                    listOf(2u) to Rational(-18, 3),
                    listOf(0u, 1u) to Rational(12, 9),
                    listOf(1u, 1u) to Rational(14, 7),
                    listOf(2u, 1u) to Rational(-17, 5),
                    listOf(0u, 2u) to Rational(-4, 1),
                    listOf(1u, 2u) to Rational(-5, 5),
                    listOf(2u, 2u) to Rational(-7, 8),
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-3, 5),
                    listOf(1u) to Rational(-18, 4),
                    listOf(2u) to Rational(9, 8),
                    listOf(0u, 1u) to Rational(-11, 6),
                    listOf(1u, 1u) to Rational(-16, 3),
                    listOf(2u, 1u) to Rational(12, 2),
                    listOf(0u, 2u) to Rational(5, 3),
                    listOf(1u, 2u) to Rational(17, 8),
                    listOf(2u, 2u) to Rational(1, 3),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(11, 1),
                    listOf(1u) to Rational(4, 1),
                    listOf(2u) to Rational(-18, 3),
                    listOf(0u, 1u) to Rational(12, 9),
                    listOf(1u, 1u) to Rational(14, 7),
                    listOf(2u, 1u) to Rational(-17, 5),
                    listOf(0u, 2u) to Rational(-4, 1),
                    listOf(1u, 2u) to Rational(-5, 5),
                    listOf(2u, 2u) to Rational(-7, 8),
                )
            ).substitute(RationalField, mapOf<Int, Rational>()),
            "test 5"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-3, 5),
                    listOf(1u) to Rational(-18, 4),
                    listOf(2u) to Rational(9, 8),
                    listOf(0u, 1u) to Rational(-11, 6),
                    listOf(1u, 1u) to Rational(-16, 3),
                    listOf(2u, 1u) to Rational(12, 2),
                    listOf(0u, 2u) to Rational(5, 3),
                    listOf(1u, 2u) to Rational(17, 8),
                    listOf(2u, 2u) to Rational(1, 3),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(11, 1),
                    listOf(1u) to Rational(4, 1),
                    listOf(2u) to Rational(-18, 3),
                    listOf(0u, 1u) to Rational(12, 9),
                    listOf(1u, 1u) to Rational(14, 7),
                    listOf(2u, 1u) to Rational(-17, 5),
                    listOf(0u, 2u) to Rational(-4, 1),
                    listOf(1u, 2u) to Rational(-5, 5),
                    listOf(2u, 2u) to Rational(-7, 8),
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-3, 5),
                    listOf(1u) to Rational(-18, 4),
                    listOf(2u) to Rational(9, 8),
                    listOf(0u, 1u) to Rational(-11, 6),
                    listOf(1u, 1u) to Rational(-16, 3),
                    listOf(2u, 1u) to Rational(12, 2),
                    listOf(0u, 2u) to Rational(5, 3),
                    listOf(1u, 2u) to Rational(17, 8),
                    listOf(2u, 2u) to Rational(1, 3),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(11, 1),
                    listOf(1u) to Rational(4, 1),
                    listOf(2u) to Rational(-18, 3),
                    listOf(0u, 1u) to Rational(12, 9),
                    listOf(1u, 1u) to Rational(14, 7),
                    listOf(2u, 1u) to Rational(-17, 5),
                    listOf(0u, 2u) to Rational(-4, 1),
                    listOf(1u, 2u) to Rational(-5, 5),
                    listOf(2u, 2u) to Rational(-7, 8),
                )
            ).substitute(RationalField, mapOf(
                5 to Rational(-16, 4),
            )),
            "test 5'"
        )
    }
    @Test
    fun test_RationalFunction_substitute_Polynomial_Map() {
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(0)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1)
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1),
                    listOf(1u) to Rational(-2),
                    listOf(2u) to Rational(1)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1)
                )
            ).substitute(RationalField, mapOf(
                0 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1)
                )
            )),
            "test 1"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(5, 6),
                    listOf(1u) to Rational(211, 4),
                    listOf(2u) to Rational(88, 3),
                    listOf(3u) to Rational(-63, 8),
                    listOf(4u) to Rational(441, 16),
                    listOf(0u, 1u) to Rational(-671, 15),
                    listOf(1u, 1u) to Rational(-551, 21),
                    listOf(2u, 1u) to Rational(279, 25),
                    listOf(3u, 1u) to Rational(231, 20),
                    listOf(0u, 2u) to Rational(-1436, 1575),
                    listOf(1u, 2u) to Rational(2471, 250),
                    listOf(2u, 2u) to Rational(-4919, 100),
                    listOf(0u, 3u) to Rational(-1464, 125),
                    listOf(1u, 3u) to Rational(-264, 25),
                    listOf(0u, 4u) to Rational(576, 25),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-11, 9),
                    listOf(1u) to Rational(-9, 4),
                    listOf(2u) to Rational(943, 8),
                    listOf(3u) to Rational(117, 8),
                    listOf(4u) to Rational(147, 16),
                    listOf(0u, 1u) to Rational(289, 90),
                    listOf(1u, 1u) to Rational(-2692, 15),
                    listOf(2u, 1u) to Rational(-1629, 140),
                    listOf(3u, 1u) to Rational(77, 20),
                    listOf(0u, 2u) to Rational(6187, 75),
                    listOf(1u, 2u) to Rational(-2879, 175),
                    listOf(2u, 2u) to Rational(-4919, 300),
                    listOf(0u, 3u) to Rational(336, 25),
                    listOf(1u, 3u) to Rational(-88, 25),
                    listOf(0u, 4u) to Rational(192, 25),
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(5, 6),
                    listOf(1u) to Rational(1, 6),
                    listOf(2u) to Rational(-2, 9),
                    listOf(0u, 1u) to Rational(15, 1),
                    listOf(1u, 1u) to Rational(18, 7),
                    listOf(2u, 1u) to Rational(2, 5),
                    listOf(0u, 2u) to Rational(12, 9),
                    listOf(1u, 2u) to Rational(-3, 5),
                    listOf(2u, 2u) to Rational(4, 4),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-11, 9),
                    listOf(1u) to Rational(4, 9),
                    listOf(2u) to Rational(11, 6),
                    listOf(0u, 1u) to Rational(-5, 6),
                    listOf(1u, 1u) to Rational(4, 6),
                    listOf(2u, 1u) to Rational(-1, 7),
                    listOf(0u, 2u) to Rational(9, 1),
                    listOf(1u, 2u) to Rational(6, 7),
                    listOf(2u, 2u) to Rational(1, 3),
                )
            ).substitute(RationalField, mapOf(
                0 to NumberedPolynomialAsIs(
                    listOf(1u) to Rational(3, 2),
                    listOf(0u, 1u) to Rational(8, 5),
                ),
                1 to NumberedPolynomialAsIs(
                    listOf(1u) to Rational(7, 2),
                    listOf(0u, 1u) to Rational(-3, 1),
                )
            )),
            "test 2"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1202861, 210),
                    listOf(1u) to Rational(-215117, 45),
                    listOf(2u) to Rational(10889651, 19845),
                    listOf(3u) to Rational(-3503956, 6615),
                    listOf(4u) to Rational(809066, 2205),
                    listOf(5u) to Rational(-9056, 735),
                    listOf(6u) to Rational(5396, 315),
                    listOf(7u) to Rational(-752, 147),
                    listOf(8u) to Rational(16, 49),
                    listOf(0u, 1u) to Rational(1738469, 1470),
                    listOf(1u, 1u) to Rational(-926238703, 52920),
                    listOf(2u, 1u) to Rational(-44113982, 6615),
                    listOf(3u, 1u) to Rational(10423519, 5292),
                    listOf(4u, 1u) to Rational(3769712, 2205),
                    listOf(5u, 1u) to Rational(8905046, 6615),
                    listOf(6u, 1u) to Rational(1186972, 6615),
                    listOf(7u, 1u) to Rational(22124, 441),
                    listOf(8u, 1u) to Rational(-1504, 147),
                    listOf(0u, 2u) to Rational(-54723628, 2205),
                    listOf(1u, 2u) to Rational(70109407, 1323),
                    listOf(2u, 2u) to Rational(151072591, 17640),
                    listOf(3u, 2u) to Rational(1216428107, 52920),
                    listOf(4u, 2u) to Rational(2587873193, 317520),
                    listOf(5u, 2u) to Rational(393536369, 79380),
                    listOf(6u, 2u) to Rational(137614937, 79380),
                    listOf(7u, 2u) to Rational(566866, 1323),
                    listOf(8u, 2u) to Rational(41848, 441),
                    listOf(0u, 3u) to Rational(-19470406, 2205),
                    listOf(1u, 3u) to Rational(72514195, 882),
                    listOf(2u, 3u) to Rational(-78090707, 1764),
                    listOf(3u, 3u) to Rational(-1988237707, 26460),
                    listOf(4u, 3u) to Rational(-802137919, 17640),
                    listOf(5u, 3u) to Rational(-139989463, 5880),
                    listOf(6u, 3u) to Rational(-26066641, 3780),
                    listOf(7u, 3u) to Rational(-2363369, 1323),
                    listOf(8u, 3u) to Rational(-108280, 441),
                    listOf(0u, 4u) to Rational(14878516, 441),
                    listOf(1u, 4u) to Rational(-253416724, 2205),
                    listOf(2u, 4u) to Rational(16699157, 840),
                    listOf(3u, 4u) to Rational(-105220979, 13230),
                    listOf(4u, 4u) to Rational(208266383, 5880),
                    listOf(5u, 4u) to Rational(650135309, 26460),
                    listOf(6u, 4u) to Rational(123808663, 11760),
                    listOf(7u, 4u) to Rational(8563385, 2646),
                    listOf(8u, 4u) to Rational(19721, 49),
                    listOf(0u, 5u) to Rational(675645, 49),
                    listOf(1u, 5u) to Rational(-70554077, 588),
                    listOf(2u, 5u) to Rational(157884029, 980),
                    listOf(3u, 5u) to Rational(489548623, 4410),
                    listOf(4u, 5u) to Rational(148540519, 17640),
                    listOf(5u, 5u) to Rational(-5559551, 392),
                    listOf(6u, 5u) to Rational(-18335711, 1470),
                    listOf(7u, 5u) to Rational(-38437, 9),
                    listOf(8u, 5u) to Rational(-29620, 63),
                    listOf(0u, 6u) to Rational(-727625, 49),
                    listOf(1u, 6u) to Rational(7046685, 98),
                    listOf(2u, 6u) to Rational(-334814231, 7056),
                    listOf(3u, 6u) to Rational(-243971737, 17640),
                    listOf(4u, 6u) to Rational(-571116659, 35280),
                    listOf(5u, 6u) to Rational(567538, 315),
                    listOf(6u, 6u) to Rational(3199768, 315),
                    listOf(7u, 6u) to Rational(227744, 63),
                    listOf(8u, 6u) to Rational(23116, 63),
                    listOf(0u, 7u) to Rational(-27500, 7),
                    listOf(1u, 7u) to Rational(120125, 3),
                    listOf(2u, 7u) to Rational(-279200, 3),
                    listOf(3u, 7u) to Rational(-100160, 7),
                    listOf(4u, 7u) to Rational(920452, 21),
                    listOf(5u, 7u) to Rational(226481, 21),
                    listOf(6u, 7u) to Rational(-34428, 7),
                    listOf(7u, 7u) to Rational(-6232, 3),
                    listOf(8u, 7u) to Rational(-608, 3),
                    listOf(0u, 8u) to Rational(2500, 1),
                    listOf(1u, 8u) to Rational(-19000, 1),
                    listOf(2u, 8u) to Rational(37900, 1),
                    listOf(3u, 8u) to Rational(-1840, 1),
                    listOf(4u, 8u) to Rational(-17876, 1),
                    listOf(5u, 8u) to Rational(-1240, 1),
                    listOf(6u, 8u) to Rational(2788, 1),
                    listOf(7u, 8u) to Rational(800, 1),
                    listOf(8u, 8u) to Rational(64, 1)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(162487, 63),
                    listOf(1u) to Rational(-92713, 54),
                    listOf(2u) to Rational(802436, 1323),
                    listOf(3u) to Rational(-55088, 441),
                    listOf(4u) to Rational(1404034, 9261),
                    listOf(5u) to Rational(-5804, 1029),
                    listOf(6u) to Rational(51556, 9261),
                    listOf(7u) to Rational(-752, 441),
                    listOf(8u) to Rational(16, 147),
                    listOf(0u, 1u) to Rational(296071, 441),
                    listOf(1u, 1u) to Rational(-4991281, 882),
                    listOf(2u, 1u) to Rational(-18702811, 9261),
                    listOf(3u, 1u) to Rational(40759043, 27783),
                    listOf(4u, 1u) to Rational(19768501, 27783),
                    listOf(5u, 1u) to Rational(14307337, 27783),
                    listOf(6u, 1u) to Rational(1655684, 27783),
                    listOf(7u, 1u) to Rational(22124, 1323),
                    listOf(8u, 1u) to Rational(-1504, 441),
                    listOf(0u, 2u) to Rational(-27667474, 3087),
                    listOf(1u, 2u) to Rational(265605901, 12348),
                    listOf(2u, 2u) to Rational(160360775, 98784),
                    listOf(3u, 2u) to Rational(1169992093, 148176),
                    listOf(4u, 2u) to Rational(3978014077, 1333584),
                    listOf(5u, 2u) to Rational(567058123, 333396),
                    listOf(6u, 2u) to Rational(205132579, 333396),
                    listOf(7u, 2u) to Rational(566866, 3969),
                    listOf(8u, 2u) to Rational(41848, 1323),
                    listOf(0u, 3u) to Rational(-2228822, 1029),
                    listOf(1u, 3u) to Rational(80179390, 3087),
                    listOf(2u, 3u) to Rational(-1378630487, 74088),
                    listOf(3u, 3u) to Rational(-3385811693, 111132),
                    listOf(4u, 3u) to Rational(-820686977, 49392),
                    listOf(5u, 3u) to Rational(-89101027, 10584),
                    listOf(6u, 3u) to Rational(-37847387, 15876),
                    listOf(7u, 3u) to Rational(-2363369, 3969),
                    listOf(8u, 3u) to Rational(-108280, 1323),
                    listOf(0u, 4u) to Rational(12619982, 1029),
                    listOf(1u, 4u) to Rational(-277723177, 6174),
                    listOf(2u, 4u) to Rational(649414169, 49392),
                    listOf(3u, 4u) to Rational(14457595, 63504),
                    listOf(4u, 4u) to Rational(139270339, 10584),
                    listOf(5u, 4u) to Rational(140367961, 15876),
                    listOf(6u, 4u) to Rational(25467083, 7056),
                    listOf(7u, 4u) to Rational(8563385, 7938),
                    listOf(8u, 4u) to Rational(19721, 147),
                    listOf(0u, 5u) to Rational(643850, 147),
                    listOf(1u, 5u) to Rational(-11818025, 294),
                    listOf(2u, 5u) to Rational(33963203, 588),
                    listOf(3u, 5u) to Rational(207216235, 5292),
                    listOf(4u, 5u) to Rational(2861021, 1512),
                    listOf(5u, 5u) to Rational(-6302335, 1176),
                    listOf(6u, 5u) to Rational(-3738587, 882),
                    listOf(7u, 5u) to Rational(-38437, 27),
                    listOf(8u, 5u) to Rational(-29620, 189),
                    listOf(0u, 6u) to Rational(-248725, 49),
                    listOf(1u, 6u) to Rational(2478535, 98),
                    listOf(2u, 6u) to Rational(-399721367, 21168),
                    listOf(3u, 6u) to Rational(-54309317, 10584),
                    listOf(4u, 6u) to Rational(-95398327, 21168),
                    listOf(5u, 6u) to Rational(173750, 189),
                    listOf(6u, 6u) to Rational(92216, 27),
                    listOf(7u, 6u) to Rational(227744, 189),
                    listOf(8u, 6u) to Rational(23116, 189),
                    listOf(0u, 7u) to Rational(-27500, 21),
                    listOf(1u, 7u) to Rational(120125, 9),
                    listOf(2u, 7u) to Rational(-279200, 9),
                    listOf(3u, 7u) to Rational(-100160, 21),
                    listOf(4u, 7u) to Rational(920452, 63),
                    listOf(5u, 7u) to Rational(226481, 63),
                    listOf(6u, 7u) to Rational(-11476, 7),
                    listOf(7u, 7u) to Rational(-6232, 9),
                    listOf(8u, 7u) to Rational(-608, 9),
                    listOf(0u, 8u) to Rational(2500, 3),
                    listOf(1u, 8u) to Rational(-19000, 3),
                    listOf(2u, 8u) to Rational(37900, 3),
                    listOf(3u, 8u) to Rational(-1840, 3),
                    listOf(4u, 8u) to Rational(-17876, 3),
                    listOf(5u, 8u) to Rational(-1240, 3),
                    listOf(6u, 8u) to Rational(2788, 3),
                    listOf(7u, 8u) to Rational(800, 3),
                    listOf(8u, 8u) to Rational(64, 3)
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(5, 6),
                    listOf(1u) to Rational(1, 6),
                    listOf(2u) to Rational(-2, 9),
                    listOf(0u, 1u) to Rational(15, 1),
                    listOf(1u, 1u) to Rational(18, 7),
                    listOf(2u, 1u) to Rational(2, 5),
                    listOf(0u, 2u) to Rational(12, 9),
                    listOf(1u, 2u) to Rational(-3, 5),
                    listOf(2u, 2u) to Rational(4, 4),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-11, 9),
                    listOf(1u) to Rational(4, 9),
                    listOf(2u) to Rational(11, 6),
                    listOf(0u, 1u) to Rational(-5, 6),
                    listOf(1u, 1u) to Rational(4, 6),
                    listOf(2u, 1u) to Rational(-1, 7),
                    listOf(0u, 2u) to Rational(9, 1),
                    listOf(1u, 2u) to Rational(6, 7),
                    listOf(2u, 2u) to Rational(1, 3),
                )
            ).substitute(RationalField, mapOf(
                0 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(18, 1),
                    listOf(1u) to Rational(16, 3),
                    listOf(2u) to Rational(12, 6),
                    listOf(0u, 1u) to Rational(13, 1),
                    listOf(1u, 1u) to Rational(-11, 4),
                    listOf(2u, 1u) to Rational(-1, 1),
                    listOf(0u, 2u) to Rational(-10, 1),
                    listOf(1u, 2u) to Rational(4, 1),
                    listOf(2u, 2u) to Rational(2, 1),
                ),
                1 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(8, 2),
                    listOf(1u) to Rational(-15, 5),
                    listOf(2u) to Rational(2, 7),
                    listOf(0u, 1u) to Rational(-18, 7),
                    listOf(1u, 1u) to Rational(-16, 6),
                    listOf(2u, 1u) to Rational(-13, 3),
                    listOf(0u, 2u) to Rational(-5, 1),
                    listOf(1u, 2u) to Rational(17, 1),
                    listOf(2u, 2u) to Rational(8, 2),
                ),
            )),
            "test 3"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1202861, 210),
                    listOf(1u) to Rational(-215117, 45),
                    listOf(2u) to Rational(10889651, 19845),
                    listOf(3u) to Rational(-3503956, 6615),
                    listOf(4u) to Rational(809066, 2205),
                    listOf(5u) to Rational(-9056, 735),
                    listOf(6u) to Rational(5396, 315),
                    listOf(7u) to Rational(-752, 147),
                    listOf(8u) to Rational(16, 49),
                    listOf(0u, 1u) to Rational(1738469, 1470),
                    listOf(1u, 1u) to Rational(-926238703, 52920),
                    listOf(2u, 1u) to Rational(-44113982, 6615),
                    listOf(3u, 1u) to Rational(10423519, 5292),
                    listOf(4u, 1u) to Rational(3769712, 2205),
                    listOf(5u, 1u) to Rational(8905046, 6615),
                    listOf(6u, 1u) to Rational(1186972, 6615),
                    listOf(7u, 1u) to Rational(22124, 441),
                    listOf(8u, 1u) to Rational(-1504, 147),
                    listOf(0u, 2u) to Rational(-54723628, 2205),
                    listOf(1u, 2u) to Rational(70109407, 1323),
                    listOf(2u, 2u) to Rational(151072591, 17640),
                    listOf(3u, 2u) to Rational(1216428107, 52920),
                    listOf(4u, 2u) to Rational(2587873193, 317520),
                    listOf(5u, 2u) to Rational(393536369, 79380),
                    listOf(6u, 2u) to Rational(137614937, 79380),
                    listOf(7u, 2u) to Rational(566866, 1323),
                    listOf(8u, 2u) to Rational(41848, 441),
                    listOf(0u, 3u) to Rational(-19470406, 2205),
                    listOf(1u, 3u) to Rational(72514195, 882),
                    listOf(2u, 3u) to Rational(-78090707, 1764),
                    listOf(3u, 3u) to Rational(-1988237707, 26460),
                    listOf(4u, 3u) to Rational(-802137919, 17640),
                    listOf(5u, 3u) to Rational(-139989463, 5880),
                    listOf(6u, 3u) to Rational(-26066641, 3780),
                    listOf(7u, 3u) to Rational(-2363369, 1323),
                    listOf(8u, 3u) to Rational(-108280, 441),
                    listOf(0u, 4u) to Rational(14878516, 441),
                    listOf(1u, 4u) to Rational(-253416724, 2205),
                    listOf(2u, 4u) to Rational(16699157, 840),
                    listOf(3u, 4u) to Rational(-105220979, 13230),
                    listOf(4u, 4u) to Rational(208266383, 5880),
                    listOf(5u, 4u) to Rational(650135309, 26460),
                    listOf(6u, 4u) to Rational(123808663, 11760),
                    listOf(7u, 4u) to Rational(8563385, 2646),
                    listOf(8u, 4u) to Rational(19721, 49),
                    listOf(0u, 5u) to Rational(675645, 49),
                    listOf(1u, 5u) to Rational(-70554077, 588),
                    listOf(2u, 5u) to Rational(157884029, 980),
                    listOf(3u, 5u) to Rational(489548623, 4410),
                    listOf(4u, 5u) to Rational(148540519, 17640),
                    listOf(5u, 5u) to Rational(-5559551, 392),
                    listOf(6u, 5u) to Rational(-18335711, 1470),
                    listOf(7u, 5u) to Rational(-38437, 9),
                    listOf(8u, 5u) to Rational(-29620, 63),
                    listOf(0u, 6u) to Rational(-727625, 49),
                    listOf(1u, 6u) to Rational(7046685, 98),
                    listOf(2u, 6u) to Rational(-334814231, 7056),
                    listOf(3u, 6u) to Rational(-243971737, 17640),
                    listOf(4u, 6u) to Rational(-571116659, 35280),
                    listOf(5u, 6u) to Rational(567538, 315),
                    listOf(6u, 6u) to Rational(3199768, 315),
                    listOf(7u, 6u) to Rational(227744, 63),
                    listOf(8u, 6u) to Rational(23116, 63),
                    listOf(0u, 7u) to Rational(-27500, 7),
                    listOf(1u, 7u) to Rational(120125, 3),
                    listOf(2u, 7u) to Rational(-279200, 3),
                    listOf(3u, 7u) to Rational(-100160, 7),
                    listOf(4u, 7u) to Rational(920452, 21),
                    listOf(5u, 7u) to Rational(226481, 21),
                    listOf(6u, 7u) to Rational(-34428, 7),
                    listOf(7u, 7u) to Rational(-6232, 3),
                    listOf(8u, 7u) to Rational(-608, 3),
                    listOf(0u, 8u) to Rational(2500, 1),
                    listOf(1u, 8u) to Rational(-19000, 1),
                    listOf(2u, 8u) to Rational(37900, 1),
                    listOf(3u, 8u) to Rational(-1840, 1),
                    listOf(4u, 8u) to Rational(-17876, 1),
                    listOf(5u, 8u) to Rational(-1240, 1),
                    listOf(6u, 8u) to Rational(2788, 1),
                    listOf(7u, 8u) to Rational(800, 1),
                    listOf(8u, 8u) to Rational(64, 1)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(162487, 63),
                    listOf(1u) to Rational(-92713, 54),
                    listOf(2u) to Rational(802436, 1323),
                    listOf(3u) to Rational(-55088, 441),
                    listOf(4u) to Rational(1404034, 9261),
                    listOf(5u) to Rational(-5804, 1029),
                    listOf(6u) to Rational(51556, 9261),
                    listOf(7u) to Rational(-752, 441),
                    listOf(8u) to Rational(16, 147),
                    listOf(0u, 1u) to Rational(296071, 441),
                    listOf(1u, 1u) to Rational(-4991281, 882),
                    listOf(2u, 1u) to Rational(-18702811, 9261),
                    listOf(3u, 1u) to Rational(40759043, 27783),
                    listOf(4u, 1u) to Rational(19768501, 27783),
                    listOf(5u, 1u) to Rational(14307337, 27783),
                    listOf(6u, 1u) to Rational(1655684, 27783),
                    listOf(7u, 1u) to Rational(22124, 1323),
                    listOf(8u, 1u) to Rational(-1504, 441),
                    listOf(0u, 2u) to Rational(-27667474, 3087),
                    listOf(1u, 2u) to Rational(265605901, 12348),
                    listOf(2u, 2u) to Rational(160360775, 98784),
                    listOf(3u, 2u) to Rational(1169992093, 148176),
                    listOf(4u, 2u) to Rational(3978014077, 1333584),
                    listOf(5u, 2u) to Rational(567058123, 333396),
                    listOf(6u, 2u) to Rational(205132579, 333396),
                    listOf(7u, 2u) to Rational(566866, 3969),
                    listOf(8u, 2u) to Rational(41848, 1323),
                    listOf(0u, 3u) to Rational(-2228822, 1029),
                    listOf(1u, 3u) to Rational(80179390, 3087),
                    listOf(2u, 3u) to Rational(-1378630487, 74088),
                    listOf(3u, 3u) to Rational(-3385811693, 111132),
                    listOf(4u, 3u) to Rational(-820686977, 49392),
                    listOf(5u, 3u) to Rational(-89101027, 10584),
                    listOf(6u, 3u) to Rational(-37847387, 15876),
                    listOf(7u, 3u) to Rational(-2363369, 3969),
                    listOf(8u, 3u) to Rational(-108280, 1323),
                    listOf(0u, 4u) to Rational(12619982, 1029),
                    listOf(1u, 4u) to Rational(-277723177, 6174),
                    listOf(2u, 4u) to Rational(649414169, 49392),
                    listOf(3u, 4u) to Rational(14457595, 63504),
                    listOf(4u, 4u) to Rational(139270339, 10584),
                    listOf(5u, 4u) to Rational(140367961, 15876),
                    listOf(6u, 4u) to Rational(25467083, 7056),
                    listOf(7u, 4u) to Rational(8563385, 7938),
                    listOf(8u, 4u) to Rational(19721, 147),
                    listOf(0u, 5u) to Rational(643850, 147),
                    listOf(1u, 5u) to Rational(-11818025, 294),
                    listOf(2u, 5u) to Rational(33963203, 588),
                    listOf(3u, 5u) to Rational(207216235, 5292),
                    listOf(4u, 5u) to Rational(2861021, 1512),
                    listOf(5u, 5u) to Rational(-6302335, 1176),
                    listOf(6u, 5u) to Rational(-3738587, 882),
                    listOf(7u, 5u) to Rational(-38437, 27),
                    listOf(8u, 5u) to Rational(-29620, 189),
                    listOf(0u, 6u) to Rational(-248725, 49),
                    listOf(1u, 6u) to Rational(2478535, 98),
                    listOf(2u, 6u) to Rational(-399721367, 21168),
                    listOf(3u, 6u) to Rational(-54309317, 10584),
                    listOf(4u, 6u) to Rational(-95398327, 21168),
                    listOf(5u, 6u) to Rational(173750, 189),
                    listOf(6u, 6u) to Rational(92216, 27),
                    listOf(7u, 6u) to Rational(227744, 189),
                    listOf(8u, 6u) to Rational(23116, 189),
                    listOf(0u, 7u) to Rational(-27500, 21),
                    listOf(1u, 7u) to Rational(120125, 9),
                    listOf(2u, 7u) to Rational(-279200, 9),
                    listOf(3u, 7u) to Rational(-100160, 21),
                    listOf(4u, 7u) to Rational(920452, 63),
                    listOf(5u, 7u) to Rational(226481, 63),
                    listOf(6u, 7u) to Rational(-11476, 7),
                    listOf(7u, 7u) to Rational(-6232, 9),
                    listOf(8u, 7u) to Rational(-608, 9),
                    listOf(0u, 8u) to Rational(2500, 3),
                    listOf(1u, 8u) to Rational(-19000, 3),
                    listOf(2u, 8u) to Rational(37900, 3),
                    listOf(3u, 8u) to Rational(-1840, 3),
                    listOf(4u, 8u) to Rational(-17876, 3),
                    listOf(5u, 8u) to Rational(-1240, 3),
                    listOf(6u, 8u) to Rational(2788, 3),
                    listOf(7u, 8u) to Rational(800, 3),
                    listOf(8u, 8u) to Rational(64, 3)
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(5, 6),
                    listOf(1u) to Rational(1, 6),
                    listOf(2u) to Rational(-2, 9),
                    listOf(0u, 1u) to Rational(15, 1),
                    listOf(1u, 1u) to Rational(18, 7),
                    listOf(2u, 1u) to Rational(2, 5),
                    listOf(0u, 2u) to Rational(12, 9),
                    listOf(1u, 2u) to Rational(-3, 5),
                    listOf(2u, 2u) to Rational(4, 4),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-11, 9),
                    listOf(1u) to Rational(4, 9),
                    listOf(2u) to Rational(11, 6),
                    listOf(0u, 1u) to Rational(-5, 6),
                    listOf(1u, 1u) to Rational(4, 6),
                    listOf(2u, 1u) to Rational(-1, 7),
                    listOf(0u, 2u) to Rational(9, 1),
                    listOf(1u, 2u) to Rational(6, 7),
                    listOf(2u, 2u) to Rational(1, 3),
                )
            ).substitute(RationalField, mapOf(
                0 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(18, 1),
                    listOf(1u) to Rational(16, 3),
                    listOf(2u) to Rational(12, 6),
                    listOf(0u, 1u) to Rational(13, 1),
                    listOf(1u, 1u) to Rational(-11, 4),
                    listOf(2u, 1u) to Rational(-1, 1),
                    listOf(0u, 2u) to Rational(-10, 1),
                    listOf(1u, 2u) to Rational(4, 1),
                    listOf(2u, 2u) to Rational(2, 1),
                ),
                1 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(8, 2),
                    listOf(1u) to Rational(-15, 5),
                    listOf(2u) to Rational(2, 7),
                    listOf(0u, 1u) to Rational(-18, 7),
                    listOf(1u, 1u) to Rational(-16, 6),
                    listOf(2u, 1u) to Rational(-13, 3),
                    listOf(0u, 2u) to Rational(-5, 1),
                    listOf(1u, 2u) to Rational(17, 1),
                    listOf(2u, 2u) to Rational(8, 2),
                ),
                5 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-6, 1),
                    listOf(1u) to Rational(-9, 8),
                    listOf(2u) to Rational(17, 5),
                    listOf(0u, 1u) to Rational(-2, 3),
                    listOf(1u, 1u) to Rational(1, 5),
                    listOf(2u, 1u) to Rational(-11, 7),
                    listOf(0u, 2u) to Rational(13, 6),
                    listOf(1u, 2u) to Rational(-15, 2),
                    listOf(2u, 2u) to Rational(-14, 4),
                )
            )),
            "test 3'"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(493, 6),
                    listOf(1u) to Rational(-15991, 210),
                    listOf(2u) to Rational(2734, 63),
                    listOf(3u) to Rational(-8213, 245),
                    listOf(4u) to Rational(1843, 147),
                    listOf(5u) to Rational(-432, 245),
                    listOf(6u) to Rational(4, 49),
                    listOf(0u, 1u) to Rational(-66, 1),
                    listOf(1u, 1u) to Rational(-92924, 2205),
                    listOf(2u, 1u) to Rational(-257461, 2205),
                    listOf(3u, 1u) to Rational(58658, 2205),
                    listOf(4u, 1u) to Rational(-87884, 2205),
                    listOf(5u, 1u) to Rational(2726, 105),
                    listOf(6u, 1u) to Rational(-52, 21),
                    listOf(0u, 2u) to Rational(-17569, 147),
                    listOf(1u, 2u) to Rational(368819, 735),
                    listOf(2u, 2u) to Rational(-644626, 6615),
                    listOf(3u, 2u) to Rational(221738, 945),
                    listOf(4u, 2u) to Rational(-18022, 945),
                    listOf(5u, 2u) to Rational(-1201, 315),
                    listOf(6u, 2u) to Rational(1327, 63),
                    listOf(0u, 3u) to Rational(240, 7),
                    listOf(1u, 3u) to Rational(-868, 9),
                    listOf(2u, 3u) to Rational(-8936, 315),
                    listOf(3u, 3u) to Rational(-77146, 315),
                    listOf(4u, 3u) to Rational(-4072, 315),
                    listOf(5u, 3u) to Rational(-2218, 15),
                    listOf(6u, 3u) to Rational(-104, 3),
                    listOf(0u, 4u) to Rational(100, 3),
                    listOf(1u, 4u) to Rational(-725, 3),
                    listOf(2u, 4u) to Rational(459, 1),
                    listOf(3u, 4u) to Rational(-2071, 15),
                    listOf(4u, 4u) to Rational(2831, 15),
                    listOf(5u, 4u) to Rational(632, 5),
                    listOf(6u, 4u) to Rational(16, 1)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1255, 9),
                    listOf(1u) to Rational(-24781, 126),
                    listOf(2u) to Rational(1195, 14),
                    listOf(3u) to Rational(-1931, 147),
                    listOf(4u) to Rational(439, 147),
                    listOf(5u) to Rational(-172, 343),
                    listOf(6u) to Rational(4, 147),
                    listOf(0u, 1u) to Rational(-183, 1),
                    listOf(1u, 1u) to Rational(-30988, 441),
                    listOf(2u, 1u) to Rational(-56137, 294),
                    listOf(3u, 1u) to Rational(204308, 1029),
                    listOf(4u, 1u) to Rational(-3263, 441),
                    listOf(5u, 1u) to Rational(2662, 441),
                    listOf(6u, 1u) to Rational(-52, 63),
                    listOf(0u, 2u) to Rational(-87119, 294),
                    listOf(1u, 2u) to Rational(1077919, 686),
                    listOf(2u, 2u) to Rational(-35209, 147),
                    listOf(3u, 2u) to Rational(15041, 147),
                    listOf(4u, 2u) to Rational(240889, 1323),
                    listOf(5u, 2u) to Rational(27778, 1323),
                    listOf(6u, 2u) to Rational(1327, 189),
                    listOf(0u, 3u) to Rational(1620, 7),
                    listOf(1u, 3u) to Rational(-25716, 49),
                    listOf(2u, 3u) to Rational(-32078, 49),
                    listOf(3u, 3u) to Rational(-704038, 441),
                    listOf(4u, 3u) to Rational(-30190, 63),
                    listOf(5u, 3u) to Rational(-5414, 63),
                    listOf(6u, 3u) to Rational(-104, 9),
                    listOf(0u, 4u) to Rational(225, 1),
                    listOf(1u, 4u) to Rational(-10560, 7),
                    listOf(2u, 4u) to Rational(44176, 21),
                    listOf(3u, 4u) to Rational(28996, 21),
                    listOf(4u, 4u) to Rational(2405, 7),
                    listOf(5u, 4u) to Rational(1240, 21),
                    listOf(6u, 4u) to Rational(16, 3)
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(5, 6),
                    listOf(1u) to Rational(1, 6),
                    listOf(2u) to Rational(-2, 9),
                    listOf(0u, 1u) to Rational(15, 1),
                    listOf(1u, 1u) to Rational(18, 7),
                    listOf(2u, 1u) to Rational(2, 5),
                    listOf(0u, 2u) to Rational(12, 9),
                    listOf(1u, 2u) to Rational(-3, 5),
                    listOf(2u, 2u) to Rational(4, 4),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-11, 9),
                    listOf(1u) to Rational(4, 9),
                    listOf(2u) to Rational(11, 6),
                    listOf(0u, 1u) to Rational(-5, 6),
                    listOf(1u, 1u) to Rational(4, 6),
                    listOf(2u, 1u) to Rational(-1, 7),
                    listOf(0u, 2u) to Rational(9, 1),
                    listOf(1u, 2u) to Rational(6, 7),
                    listOf(2u, 2u) to Rational(1, 3),
                )
            ).substitute(RationalField, mapOf(
                1 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(8, 2),
                    listOf(1u) to Rational(-15, 5),
                    listOf(2u) to Rational(2, 7),
                    listOf(0u, 1u) to Rational(-18, 7),
                    listOf(1u, 1u) to Rational(-16, 6),
                    listOf(2u, 1u) to Rational(-13, 3),
                    listOf(0u, 2u) to Rational(-5, 1),
                    listOf(1u, 2u) to Rational(17, 1),
                    listOf(2u, 2u) to Rational(8, 2),
                ),
            )),
            "test 4"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(493, 6),
                    listOf(1u) to Rational(-15991, 210),
                    listOf(2u) to Rational(2734, 63),
                    listOf(3u) to Rational(-8213, 245),
                    listOf(4u) to Rational(1843, 147),
                    listOf(5u) to Rational(-432, 245),
                    listOf(6u) to Rational(4, 49),
                    listOf(0u, 1u) to Rational(-66, 1),
                    listOf(1u, 1u) to Rational(-92924, 2205),
                    listOf(2u, 1u) to Rational(-257461, 2205),
                    listOf(3u, 1u) to Rational(58658, 2205),
                    listOf(4u, 1u) to Rational(-87884, 2205),
                    listOf(5u, 1u) to Rational(2726, 105),
                    listOf(6u, 1u) to Rational(-52, 21),
                    listOf(0u, 2u) to Rational(-17569, 147),
                    listOf(1u, 2u) to Rational(368819, 735),
                    listOf(2u, 2u) to Rational(-644626, 6615),
                    listOf(3u, 2u) to Rational(221738, 945),
                    listOf(4u, 2u) to Rational(-18022, 945),
                    listOf(5u, 2u) to Rational(-1201, 315),
                    listOf(6u, 2u) to Rational(1327, 63),
                    listOf(0u, 3u) to Rational(240, 7),
                    listOf(1u, 3u) to Rational(-868, 9),
                    listOf(2u, 3u) to Rational(-8936, 315),
                    listOf(3u, 3u) to Rational(-77146, 315),
                    listOf(4u, 3u) to Rational(-4072, 315),
                    listOf(5u, 3u) to Rational(-2218, 15),
                    listOf(6u, 3u) to Rational(-104, 3),
                    listOf(0u, 4u) to Rational(100, 3),
                    listOf(1u, 4u) to Rational(-725, 3),
                    listOf(2u, 4u) to Rational(459, 1),
                    listOf(3u, 4u) to Rational(-2071, 15),
                    listOf(4u, 4u) to Rational(2831, 15),
                    listOf(5u, 4u) to Rational(632, 5),
                    listOf(6u, 4u) to Rational(16, 1)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1255, 9),
                    listOf(1u) to Rational(-24781, 126),
                    listOf(2u) to Rational(1195, 14),
                    listOf(3u) to Rational(-1931, 147),
                    listOf(4u) to Rational(439, 147),
                    listOf(5u) to Rational(-172, 343),
                    listOf(6u) to Rational(4, 147),
                    listOf(0u, 1u) to Rational(-183, 1),
                    listOf(1u, 1u) to Rational(-30988, 441),
                    listOf(2u, 1u) to Rational(-56137, 294),
                    listOf(3u, 1u) to Rational(204308, 1029),
                    listOf(4u, 1u) to Rational(-3263, 441),
                    listOf(5u, 1u) to Rational(2662, 441),
                    listOf(6u, 1u) to Rational(-52, 63),
                    listOf(0u, 2u) to Rational(-87119, 294),
                    listOf(1u, 2u) to Rational(1077919, 686),
                    listOf(2u, 2u) to Rational(-35209, 147),
                    listOf(3u, 2u) to Rational(15041, 147),
                    listOf(4u, 2u) to Rational(240889, 1323),
                    listOf(5u, 2u) to Rational(27778, 1323),
                    listOf(6u, 2u) to Rational(1327, 189),
                    listOf(0u, 3u) to Rational(1620, 7),
                    listOf(1u, 3u) to Rational(-25716, 49),
                    listOf(2u, 3u) to Rational(-32078, 49),
                    listOf(3u, 3u) to Rational(-704038, 441),
                    listOf(4u, 3u) to Rational(-30190, 63),
                    listOf(5u, 3u) to Rational(-5414, 63),
                    listOf(6u, 3u) to Rational(-104, 9),
                    listOf(0u, 4u) to Rational(225, 1),
                    listOf(1u, 4u) to Rational(-10560, 7),
                    listOf(2u, 4u) to Rational(44176, 21),
                    listOf(3u, 4u) to Rational(28996, 21),
                    listOf(4u, 4u) to Rational(2405, 7),
                    listOf(5u, 4u) to Rational(1240, 21),
                    listOf(6u, 4u) to Rational(16, 3)
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(5, 6),
                    listOf(1u) to Rational(1, 6),
                    listOf(2u) to Rational(-2, 9),
                    listOf(0u, 1u) to Rational(15, 1),
                    listOf(1u, 1u) to Rational(18, 7),
                    listOf(2u, 1u) to Rational(2, 5),
                    listOf(0u, 2u) to Rational(12, 9),
                    listOf(1u, 2u) to Rational(-3, 5),
                    listOf(2u, 2u) to Rational(4, 4),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-11, 9),
                    listOf(1u) to Rational(4, 9),
                    listOf(2u) to Rational(11, 6),
                    listOf(0u, 1u) to Rational(-5, 6),
                    listOf(1u, 1u) to Rational(4, 6),
                    listOf(2u, 1u) to Rational(-1, 7),
                    listOf(0u, 2u) to Rational(9, 1),
                    listOf(1u, 2u) to Rational(6, 7),
                    listOf(2u, 2u) to Rational(1, 3),
                )
            ).substitute(RationalField, mapOf(
                1 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(8, 2),
                    listOf(1u) to Rational(-15, 5),
                    listOf(2u) to Rational(2, 7),
                    listOf(0u, 1u) to Rational(-18, 7),
                    listOf(1u, 1u) to Rational(-16, 6),
                    listOf(2u, 1u) to Rational(-13, 3),
                    listOf(0u, 2u) to Rational(-5, 1),
                    listOf(1u, 2u) to Rational(17, 1),
                    listOf(2u, 2u) to Rational(8, 2),
                ),
                5 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-6, 1),
                    listOf(1u) to Rational(-9, 8),
                    listOf(2u) to Rational(17, 5),
                    listOf(0u, 1u) to Rational(-2, 3),
                    listOf(1u, 1u) to Rational(1, 5),
                    listOf(2u, 1u) to Rational(-11, 7),
                    listOf(0u, 2u) to Rational(13, 6),
                    listOf(1u, 2u) to Rational(-15, 2),
                    listOf(2u, 2u) to Rational(-14, 4),
                )
            )),
            "test 4'"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-409, 6),
                    listOf(1u) to Rational(-376, 9),
                    listOf(2u) to Rational(-1781, 81),
                    listOf(3u) to Rational(-128, 27),
                    listOf(4u) to Rational(-8, 9),
                    listOf(0u, 1u) to Rational(18701, 210),
                    listOf(1u, 1u) to Rational(614183, 7560),
                    listOf(2u, 1u) to Rational(90941, 1890),
                    listOf(3u, 1u) to Rational(1802, 135),
                    listOf(4u, 1u) to Rational(112, 45),
                    listOf(0u, 2u) to Rational(181421, 315),
                    listOf(1u, 2u) to Rational(77813, 378),
                    listOf(2u, 2u) to Rational(598583, 7560),
                    listOf(3u, 2u) to Rational(85, 27),
                    listOf(4u, 2u) to Rational(2, 5),
                    listOf(0u, 3u) to Rational(130997, 315),
                    listOf(1u, 3u) to Rational(1093, 420),
                    listOf(2u, 3u) to Rational(9551, 2520),
                    listOf(3u, 3u) to Rational(-14, 45),
                    listOf(4u, 3u) to Rational(22, 45),
                    listOf(0u, 4u) to Rational(-2801, 9),
                    listOf(1u, 4u) to Rational(4033, 90),
                    listOf(2u, 4u) to Rational(6429, 80),
                    listOf(3u, 4u) to Rational(2851, 90),
                    listOf(4u, 4u) to Rational(293, 45),
                    listOf(0u, 5u) to Rational(-220, 1),
                    listOf(1u, 5u) to Rational(127, 1),
                    listOf(2u, 5u) to Rational(202, 5),
                    listOf(3u, 5u) to Rational(-63, 5),
                    listOf(4u, 5u) to Rational(-12, 5),
                    listOf(0u, 6u) to Rational(100, 1),
                    listOf(1u, 6u) to Rational(-80, 1),
                    listOf(2u, 6u) to Rational(-24, 1),
                    listOf(3u, 6u) to Rational(16, 1),
                    listOf(4u, 6u) to Rational(4, 1)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(5407, 9),
                    listOf(1u) to Rational(9568, 27),
                    listOf(2u) to Rational(4996, 27),
                    listOf(3u) to Rational(352, 9),
                    listOf(4u) to Rational(22, 3),
                    listOf(0u, 1u) to Rational(104411, 126),
                    listOf(1u, 1u) to Rational(6001, 126),
                    listOf(2u, 1u) to Rational(-796, 21),
                    listOf(3u, 1u) to Rational(-5389, 126),
                    listOf(4u, 1u) to Rational(-166, 21),
                    listOf(0u, 2u) to Rational(-35327, 126),
                    listOf(1u, 2u) to Rational(53, 252),
                    listOf(2u, 2u) to Rational(849197, 6048),
                    listOf(3u, 2u) to Rational(22361, 252),
                    listOf(4u, 2u) to Rational(773, 42),
                    listOf(0u, 3u) to Rational(-6067, 21),
                    listOf(1u, 3u) to Rational(39049, 126),
                    listOf(2u, 3u) to Rational(80303, 1008),
                    listOf(3u, 3u) to Rational(-3035, 63),
                    listOf(4u, 3u) to Rational(-209, 21),
                    listOf(0u, 4u) to Rational(3113, 21),
                    listOf(1u, 4u) to Rational(-22345, 126),
                    listOf(2u, 4u) to Rational(-30931, 1008),
                    listOf(3u, 4u) to Rational(5837, 126),
                    listOf(4u, 4u) to Rational(229, 21),
                    listOf(0u, 5u) to Rational(-2120, 21),
                    listOf(1u, 5u) to Rational(451, 7),
                    listOf(2u, 5u) to Rational(422, 21),
                    listOf(3u, 5u) to Rational(-181, 21),
                    listOf(4u, 5u) to Rational(-40, 21),
                    listOf(0u, 6u) to Rational(100, 3),
                    listOf(1u, 6u) to Rational(-80, 3),
                    listOf(2u, 6u) to Rational(-8, 1),
                    listOf(3u, 6u) to Rational(16, 3),
                    listOf(4u, 6u) to Rational(4, 3)
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(5, 6),
                    listOf(1u) to Rational(1, 6),
                    listOf(2u) to Rational(-2, 9),
                    listOf(0u, 1u) to Rational(15, 1),
                    listOf(1u, 1u) to Rational(18, 7),
                    listOf(2u, 1u) to Rational(2, 5),
                    listOf(0u, 2u) to Rational(12, 9),
                    listOf(1u, 2u) to Rational(-3, 5),
                    listOf(2u, 2u) to Rational(4, 4),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-11, 9),
                    listOf(1u) to Rational(4, 9),
                    listOf(2u) to Rational(11, 6),
                    listOf(0u, 1u) to Rational(-5, 6),
                    listOf(1u, 1u) to Rational(4, 6),
                    listOf(2u, 1u) to Rational(-1, 7),
                    listOf(0u, 2u) to Rational(9, 1),
                    listOf(1u, 2u) to Rational(6, 7),
                    listOf(2u, 2u) to Rational(1, 3),
                )
            ).substitute(RationalField, mapOf(
                0 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(18, 1),
                    listOf(1u) to Rational(16, 3),
                    listOf(2u) to Rational(12, 6),
                    listOf(0u, 1u) to Rational(13, 1),
                    listOf(1u, 1u) to Rational(-11, 4),
                    listOf(2u, 1u) to Rational(-1, 1),
                    listOf(0u, 2u) to Rational(-10, 1),
                    listOf(1u, 2u) to Rational(4, 1),
                    listOf(2u, 2u) to Rational(2, 1),
                ),
            )),
            "test 5"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-409, 6),
                    listOf(1u) to Rational(-376, 9),
                    listOf(2u) to Rational(-1781, 81),
                    listOf(3u) to Rational(-128, 27),
                    listOf(4u) to Rational(-8, 9),
                    listOf(0u, 1u) to Rational(18701, 210),
                    listOf(1u, 1u) to Rational(614183, 7560),
                    listOf(2u, 1u) to Rational(90941, 1890),
                    listOf(3u, 1u) to Rational(1802, 135),
                    listOf(4u, 1u) to Rational(112, 45),
                    listOf(0u, 2u) to Rational(181421, 315),
                    listOf(1u, 2u) to Rational(77813, 378),
                    listOf(2u, 2u) to Rational(598583, 7560),
                    listOf(3u, 2u) to Rational(85, 27),
                    listOf(4u, 2u) to Rational(2, 5),
                    listOf(0u, 3u) to Rational(130997, 315),
                    listOf(1u, 3u) to Rational(1093, 420),
                    listOf(2u, 3u) to Rational(9551, 2520),
                    listOf(3u, 3u) to Rational(-14, 45),
                    listOf(4u, 3u) to Rational(22, 45),
                    listOf(0u, 4u) to Rational(-2801, 9),
                    listOf(1u, 4u) to Rational(4033, 90),
                    listOf(2u, 4u) to Rational(6429, 80),
                    listOf(3u, 4u) to Rational(2851, 90),
                    listOf(4u, 4u) to Rational(293, 45),
                    listOf(0u, 5u) to Rational(-220, 1),
                    listOf(1u, 5u) to Rational(127, 1),
                    listOf(2u, 5u) to Rational(202, 5),
                    listOf(3u, 5u) to Rational(-63, 5),
                    listOf(4u, 5u) to Rational(-12, 5),
                    listOf(0u, 6u) to Rational(100, 1),
                    listOf(1u, 6u) to Rational(-80, 1),
                    listOf(2u, 6u) to Rational(-24, 1),
                    listOf(3u, 6u) to Rational(16, 1),
                    listOf(4u, 6u) to Rational(4, 1)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(5407, 9),
                    listOf(1u) to Rational(9568, 27),
                    listOf(2u) to Rational(4996, 27),
                    listOf(3u) to Rational(352, 9),
                    listOf(4u) to Rational(22, 3),
                    listOf(0u, 1u) to Rational(104411, 126),
                    listOf(1u, 1u) to Rational(6001, 126),
                    listOf(2u, 1u) to Rational(-796, 21),
                    listOf(3u, 1u) to Rational(-5389, 126),
                    listOf(4u, 1u) to Rational(-166, 21),
                    listOf(0u, 2u) to Rational(-35327, 126),
                    listOf(1u, 2u) to Rational(53, 252),
                    listOf(2u, 2u) to Rational(849197, 6048),
                    listOf(3u, 2u) to Rational(22361, 252),
                    listOf(4u, 2u) to Rational(773, 42),
                    listOf(0u, 3u) to Rational(-6067, 21),
                    listOf(1u, 3u) to Rational(39049, 126),
                    listOf(2u, 3u) to Rational(80303, 1008),
                    listOf(3u, 3u) to Rational(-3035, 63),
                    listOf(4u, 3u) to Rational(-209, 21),
                    listOf(0u, 4u) to Rational(3113, 21),
                    listOf(1u, 4u) to Rational(-22345, 126),
                    listOf(2u, 4u) to Rational(-30931, 1008),
                    listOf(3u, 4u) to Rational(5837, 126),
                    listOf(4u, 4u) to Rational(229, 21),
                    listOf(0u, 5u) to Rational(-2120, 21),
                    listOf(1u, 5u) to Rational(451, 7),
                    listOf(2u, 5u) to Rational(422, 21),
                    listOf(3u, 5u) to Rational(-181, 21),
                    listOf(4u, 5u) to Rational(-40, 21),
                    listOf(0u, 6u) to Rational(100, 3),
                    listOf(1u, 6u) to Rational(-80, 3),
                    listOf(2u, 6u) to Rational(-8, 1),
                    listOf(3u, 6u) to Rational(16, 3),
                    listOf(4u, 6u) to Rational(4, 3)
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(5, 6),
                    listOf(1u) to Rational(1, 6),
                    listOf(2u) to Rational(-2, 9),
                    listOf(0u, 1u) to Rational(15, 1),
                    listOf(1u, 1u) to Rational(18, 7),
                    listOf(2u, 1u) to Rational(2, 5),
                    listOf(0u, 2u) to Rational(12, 9),
                    listOf(1u, 2u) to Rational(-3, 5),
                    listOf(2u, 2u) to Rational(4, 4),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-11, 9),
                    listOf(1u) to Rational(4, 9),
                    listOf(2u) to Rational(11, 6),
                    listOf(0u, 1u) to Rational(-5, 6),
                    listOf(1u, 1u) to Rational(4, 6),
                    listOf(2u, 1u) to Rational(-1, 7),
                    listOf(0u, 2u) to Rational(9, 1),
                    listOf(1u, 2u) to Rational(6, 7),
                    listOf(2u, 2u) to Rational(1, 3),
                )
            ).substitute(RationalField, mapOf(
                0 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(18, 1),
                    listOf(1u) to Rational(16, 3),
                    listOf(2u) to Rational(12, 6),
                    listOf(0u, 1u) to Rational(13, 1),
                    listOf(1u, 1u) to Rational(-11, 4),
                    listOf(2u, 1u) to Rational(-1, 1),
                    listOf(0u, 2u) to Rational(-10, 1),
                    listOf(1u, 2u) to Rational(4, 1),
                    listOf(2u, 2u) to Rational(2, 1),
                ),
                5 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-6, 1),
                    listOf(1u) to Rational(-9, 8),
                    listOf(2u) to Rational(17, 5),
                    listOf(0u, 1u) to Rational(-2, 3),
                    listOf(1u, 1u) to Rational(1, 5),
                    listOf(2u, 1u) to Rational(-11, 7),
                    listOf(0u, 2u) to Rational(13, 6),
                    listOf(1u, 2u) to Rational(-15, 2),
                    listOf(2u, 2u) to Rational(-14, 4),
                )
            )),
            "test 5'"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(5, 6),
                    listOf(1u) to Rational(1, 6),
                    listOf(2u) to Rational(-2, 9),
                    listOf(0u, 1u) to Rational(15, 1),
                    listOf(1u, 1u) to Rational(18, 7),
                    listOf(2u, 1u) to Rational(2, 5),
                    listOf(0u, 2u) to Rational(12, 9),
                    listOf(1u, 2u) to Rational(-3, 5),
                    listOf(2u, 2u) to Rational(4, 4),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-11, 9),
                    listOf(1u) to Rational(4, 9),
                    listOf(2u) to Rational(11, 6),
                    listOf(0u, 1u) to Rational(-5, 6),
                    listOf(1u, 1u) to Rational(4, 6),
                    listOf(2u, 1u) to Rational(-1, 7),
                    listOf(0u, 2u) to Rational(9, 1),
                    listOf(1u, 2u) to Rational(6, 7),
                    listOf(2u, 2u) to Rational(1, 3),
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(5, 6),
                    listOf(1u) to Rational(1, 6),
                    listOf(2u) to Rational(-2, 9),
                    listOf(0u, 1u) to Rational(15, 1),
                    listOf(1u, 1u) to Rational(18, 7),
                    listOf(2u, 1u) to Rational(2, 5),
                    listOf(0u, 2u) to Rational(12, 9),
                    listOf(1u, 2u) to Rational(-3, 5),
                    listOf(2u, 2u) to Rational(4, 4),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-11, 9),
                    listOf(1u) to Rational(4, 9),
                    listOf(2u) to Rational(11, 6),
                    listOf(0u, 1u) to Rational(-5, 6),
                    listOf(1u, 1u) to Rational(4, 6),
                    listOf(2u, 1u) to Rational(-1, 7),
                    listOf(0u, 2u) to Rational(9, 1),
                    listOf(1u, 2u) to Rational(6, 7),
                    listOf(2u, 2u) to Rational(1, 3),
                )
            ).substitute(RationalField, mapOf<Int, NumberedPolynomial<Rational>>()),
            "test 6"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(5, 6),
                    listOf(1u) to Rational(1, 6),
                    listOf(2u) to Rational(-2, 9),
                    listOf(0u, 1u) to Rational(15, 1),
                    listOf(1u, 1u) to Rational(18, 7),
                    listOf(2u, 1u) to Rational(2, 5),
                    listOf(0u, 2u) to Rational(12, 9),
                    listOf(1u, 2u) to Rational(-3, 5),
                    listOf(2u, 2u) to Rational(4, 4),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-11, 9),
                    listOf(1u) to Rational(4, 9),
                    listOf(2u) to Rational(11, 6),
                    listOf(0u, 1u) to Rational(-5, 6),
                    listOf(1u, 1u) to Rational(4, 6),
                    listOf(2u, 1u) to Rational(-1, 7),
                    listOf(0u, 2u) to Rational(9, 1),
                    listOf(1u, 2u) to Rational(6, 7),
                    listOf(2u, 2u) to Rational(1, 3),
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(5, 6),
                    listOf(1u) to Rational(1, 6),
                    listOf(2u) to Rational(-2, 9),
                    listOf(0u, 1u) to Rational(15, 1),
                    listOf(1u, 1u) to Rational(18, 7),
                    listOf(2u, 1u) to Rational(2, 5),
                    listOf(0u, 2u) to Rational(12, 9),
                    listOf(1u, 2u) to Rational(-3, 5),
                    listOf(2u, 2u) to Rational(4, 4),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-11, 9),
                    listOf(1u) to Rational(4, 9),
                    listOf(2u) to Rational(11, 6),
                    listOf(0u, 1u) to Rational(-5, 6),
                    listOf(1u, 1u) to Rational(4, 6),
                    listOf(2u, 1u) to Rational(-1, 7),
                    listOf(0u, 2u) to Rational(9, 1),
                    listOf(1u, 2u) to Rational(6, 7),
                    listOf(2u, 2u) to Rational(1, 3),
                )
            ).substitute(RationalField, mapOf(
                5 to NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-6, 1),
                    listOf(1u) to Rational(-9, 8),
                    listOf(2u) to Rational(17, 5),
                    listOf(0u, 1u) to Rational(-2, 3),
                    listOf(1u, 1u) to Rational(1, 5),
                    listOf(2u, 1u) to Rational(-11, 7),
                    listOf(0u, 2u) to Rational(13, 6),
                    listOf(1u, 2u) to Rational(-15, 2),
                    listOf(2u, 2u) to Rational(-14, 4),
                )
            )),
            "test 6'"
        )
    }
    @Test
    @Ignore // FIXME: This tests work only for sane realisations of the substitutions. Currently, it is not.
            //  Sane algorithm for substitution p(q/r) (p, q, and r are polynomials) should return denominator r^deg(p),
            //  not r^(deg(p)(deg(p)+1)/2) as it is now.
    fun test_RationalFunction_substitute_RationalFunction_Map() {
        // TODO
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(0)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1)
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1),
                    listOf(1u) to Rational(-2),
                    listOf(2u) to Rational(1)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1)
                ),
            ).substitute(RationalField, mapOf(
                0 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(1)
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(1)
                    )
                )
            )),
            "test 1"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf(4u) to Rational(-17166109, 793800),
                    listOf(3u, 1u) to Rational(-930960143, 5556600),
                    listOf(2u, 2u) to Rational(-144665109691, 350065800),
                    listOf(1u, 3u) to Rational(-17232577, 52920),
                    listOf(0u, 4u) to Rational(-68141, 1323),
                ),
                NumberedPolynomialAsIs(
                    listOf(4u) to Rational(-57522533, 14288400),
                    listOf(3u, 1u) to Rational(-13085162953, 300056400),
                    listOf(2u, 2u) to Rational(-92093367341, 525098700),
                    listOf(1u, 3u) to Rational(-1979342797, 6667920),
                    listOf(0u, 4u) to Rational(-3082727, 21168),
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(10, 2),
                    listOf(1u) to Rational(6, 7),
                    listOf(2u) to Rational(-16, 1),
                    listOf(0u, 1u) to Rational(13, 8),
                    listOf(1u, 1u) to Rational(-12, 1),
                    listOf(2u, 1u) to Rational(16, 8),
                    listOf(0u, 2u) to Rational(10, 4),
                    listOf(1u, 2u) to Rational(4, 1),
                    listOf(2u, 2u) to Rational(-11, 3),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1, 4),
                    listOf(1u) to Rational(-17, 4),
                    listOf(2u) to Rational(-14, 8),
                    listOf(0u, 1u) to Rational(17, 9),
                    listOf(1u, 1u) to Rational(1, 3),
                    listOf(2u, 1u) to Rational(7, 6),
                    listOf(0u, 2u) to Rational(16, 3),
                    listOf(1u, 2u) to Rational(-17, 1),
                    listOf(2u, 2u) to Rational(-10, 8),
                )
            ).substitute(RationalField, mapOf(
                0 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf(1u) to Rational(11, 5),
                        listOf(0u, 1u) to Rational(8, 4),
                    ),
                    NumberedPolynomialAsIs(
                        listOf(1u) to Rational(1, 9),
                        listOf(0u, 1u) to Rational(11, 7),
                    )
                ),
                1 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf(1u) to Rational(-2, 7),
                        listOf(0u, 1u) to Rational(-4, 3),
                    ),
                    NumberedPolynomialAsIs(
                        listOf(1u) to Rational(3, 6),
                        listOf(0u, 1u) to Rational(12, 8),
                    )
                ),
            )),
            "test 2"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-130778291, 76800),
                    listOf(1u) to Rational(-445270919, 230400),
                    listOf(2u) to Rational(44578444937, 14515200),
                    listOf(3u) to Rational(17329402153, 1555200),
                    listOf(4u) to Rational(89239926809, 2332800),
                    listOf(5u) to Rational(2808812267, 145152),
                    listOf(6u) to Rational(-21362661007, 725760),
                    listOf(7u) to Rational(-258455443, 2016),
                    listOf(8u) to Rational(-21454693, 96),
                    listOf(0u, 1u) to Rational(-1002137, 15360),
                    listOf(1u, 1u) to Rational(-1704849697, 430080),
                    listOf(2u, 1u) to Rational(-57657676789, 4838400),
                    listOf(3u, 1u) to Rational(-101331731, 89600),
                    listOf(4u, 1u) to Rational(5362280079329, 130636800),
                    listOf(5u, 1u) to Rational(4069896167053, 130636800),
                    listOf(6u, 1u) to Rational(12011514569, 544320),
                    listOf(7u, 1u) to Rational(138293195623, 725760),
                    listOf(8u, 1u) to Rational(6228779419, 48384),
                    listOf(0u, 2u) to Rational(-32395872823, 8064000),
                    listOf(1u, 2u) to Rational(-7398505523, 2304000),
                    listOf(2u, 2u) to Rational(95217051699521, 3048192000),
                    listOf(3u, 2u) to Rational(198026968812079, 3657830400),
                    listOf(4u, 2u) to Rational(4291645618499, 228614400),
                    listOf(5u, 2u) to Rational(-33211690942439, 914457600),
                    listOf(6u, 2u) to Rational(-637385538163153, 1371686400),
                    listOf(7u, 2u) to Rational(-138671528276273, 182891520),
                    listOf(8u, 2u) to Rational(-14566368751, 217728),
                    listOf(0u, 3u) to Rational(-10538718719, 2016000),
                    listOf(1u, 3u) to Rational(-1844485375199, 84672000),
                    listOf(2u, 3u) to Rational(103968665891, 12096000),
                    listOf(3u, 3u) to Rational(175402107278351, 1828915200),
                    listOf(4u, 3u) to Rational(8020699588879, 114307200),
                    listOf(5u, 3u) to Rational(3414841894991, 38102400),
                    listOf(6u, 3u) to Rational(1848405591611, 4665600),
                    listOf(7u, 3u) to Rational(39486708738989, 137168640),
                    listOf(8u, 3u) to Rational(255926289517, 9144576),
                    listOf(0u, 4u) to Rational(-655379564629, 105840000),
                    listOf(1u, 4u) to Rational(-208336039441, 127008000),
                    listOf(2u, 4u) to Rational(40173146771411, 1143072000),
                    listOf(3u, 4u) to Rational(150473493581239, 2667168000),
                    listOf(4u, 4u) to Rational(38833783990483, 1143072000),
                    listOf(5u, 4u) to Rational(-1963676248203053, 4800902400),
                    listOf(6u, 4u) to Rational(-2598759412825747, 3200601600),
                    listOf(7u, 4u) to Rational(-192895352019667, 1280240640),
                    listOf(8u, 4u) to Rational(3737382679, 6858432),
                    listOf(0u, 5u) to Rational(-16959378721, 1890000),
                    listOf(1u, 5u) to Rational(-1864802244743, 79380000),
                    listOf(2u, 5u) to Rational(13449261536489, 666792000),
                    listOf(3u, 5u) to Rational(215272234137329, 2667168000),
                    listOf(4u, 5u) to Rational(6040691379277, 83349000),
                    listOf(5u, 5u) to Rational(153687143525887, 800150400),
                    listOf(6u, 5u) to Rational(475602854903563, 2400451200),
                    listOf(7u, 5u) to Rational(27315599358749, 640120320),
                    listOf(8u, 5u) to Rational(-2630413357, 10668672),
                    listOf(0u, 6u) to Rational(-6654999511, 2646000),
                    listOf(1u, 6u) to Rational(-67885252327, 15876000),
                    listOf(2u, 6u) to Rational(5786776220983, 2667168000),
                    listOf(3u, 6u) to Rational(60615922629083, 1143072000),
                    listOf(4u, 6u) to Rational(-34703539637627407, 672126336000),
                    listOf(5u, 6u) to Rational(-744694192134101, 2240421120),
                    listOf(6u, 6u) to Rational(-1782470617231, 14817600),
                    listOf(7u, 6u) to Rational(59123208433, 8890560),
                    listOf(8u, 6u) to Rational(-141653, 5292),
                    listOf(0u, 7u) to Rational(-338051969, 441000),
                    listOf(1u, 7u) to Rational(468850013, 1764000),
                    listOf(2u, 7u) to Rational(2102343426101, 222264000),
                    listOf(3u, 7u) to Rational(7836130602007, 1333584000),
                    listOf(4u, 7u) to Rational(16239111865997, 746807040),
                    listOf(5u, 7u) to Rational(3824649185383, 88905600),
                    listOf(6u, 7u) to Rational(56058614459, 3457440),
                    listOf(7u, 7u) to Rational(-396766339, 493920),
                    listOf(8u, 7u) to Rational(-165147, 2744),
                    listOf(0u, 8u) to Rational(-3088619, 58800),
                    listOf(1u, 8u) to Rational(155343347, 88200),
                    listOf(2u, 8u) to Rational(100098736469, 7408800),
                    listOf(3u, 8u) to Rational(109725511381, 7408800),
                    listOf(4u, 8u) to Rational(-2431199641013, 59270400),
                    listOf(5u, 8u) to Rational(-102872383249, 3457440),
                    listOf(6u, 8u) to Rational(1449461309, 576240),
                    listOf(7u, 8u) to Rational(812775, 1372),
                    listOf(8u, 8u) to Rational(-16461, 343)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(164202773, 230400),
                    listOf(1u) to Rational(-70345303, 518400),
                    listOf(2u) to Rational(-4229702731, 4665600),
                    listOf(3u) to Rational(3262171027, 6998400),
                    listOf(4u) to Rational(-25423104169, 13996800),
                    listOf(5u) to Rational(64061869, 349920),
                    listOf(6u) to Rational(-1655878091, 116640),
                    listOf(7u) to Rational(-7991441, 648),
                    listOf(8u) to Rational(-502591, 18),
                    listOf(0u, 1u) to Rational(-8780429, 3840),
                    listOf(1u, 1u) to Rational(434272361, 115200),
                    listOf(2u, 1u) to Rational(429825727, 41472),
                    listOf(3u, 1u) to Rational(-10066790339, 6998400),
                    listOf(4u, 1u) to Rational(70022035471, 20995200),
                    listOf(5u, 1u) to Rational(-32070283493, 1399680),
                    listOf(6u, 1u) to Rational(-22051101001, 1399680),
                    listOf(7u, 1u) to Rational(-126493427, 12960),
                    listOf(8u, 1u) to Rational(3050245, 864),
                    listOf(0u, 2u) to Rational(-1194654631, 345600),
                    listOf(1u, 2u) to Rational(-542961452671, 31104000),
                    listOf(2u, 2u) to Rational(-234000873607, 48988800),
                    listOf(3u, 2u) to Rational(140520538087, 3628800),
                    listOf(4u, 2u) to Rational(9215088876563, 130636800),
                    listOf(5u, 2u) to Rational(27590569647253, 293932800),
                    listOf(6u, 2u) to Rational(5129057792891, 97977600),
                    listOf(7u, 2u) to Rational(-106334191, 5103),
                    listOf(8u, 2u) to Rational(-1024113911, 435456),
                    listOf(0u, 3u) to Rational(76223843, 6000),
                    listOf(1u, 3u) to Rational(57425857357, 2592000),
                    listOf(2u, 3u) to Rational(-2044736497573, 46656000),
                    listOf(3u, 3u) to Rational(-26155810120031, 293932800),
                    listOf(4u, 3u) to Rational(-1064419459813, 6998400),
                    listOf(5u, 3u) to Rational(-753782018389, 4082400),
                    listOf(6u, 3u) to Rational(-291973360873, 2799360),
                    listOf(7u, 3u) to Rational(-46372122599, 816480),
                    listOf(8u, 3u) to Rational(3579859657, 653184),
                    listOf(0u, 4u) to Rational(-13374241901, 4320000),
                    listOf(1u, 4u) to Rational(306606499811, 54432000),
                    listOf(2u, 4u) to Rational(964267124745437, 13716864000),
                    listOf(3u, 4u) to Rational(21603809415373, 182891520),
                    listOf(4u, 4u) to Rational(1097860214654027, 6858432000),
                    listOf(5u, 4u) to Rational(161615254570669, 914457600),
                    listOf(6u, 4u) to Rational(758415239461, 22861440),
                    listOf(7u, 4u) to Rational(2585568355471, 274337280),
                    listOf(8u, 4u) to Rational(-70433747863, 9144576),
                    listOf(0u, 5u) to Rational(-9582586217, 2520000),
                    listOf(1u, 5u) to Rational(-19093471394171, 635040000),
                    listOf(2u, 5u) to Rational(-13010261944411, 381024000),
                    listOf(3u, 5u) to Rational(-259039825301861, 4572288000),
                    listOf(4u, 5u) to Rational(-305081119071079, 2286144000),
                    listOf(5u, 5u) to Rational(-1923114383311, 19595520),
                    listOf(6u, 5u) to Rational(-14181787253231, 228614400),
                    listOf(7u, 5u) to Rational(-3959584789, 4354560),
                    listOf(8u, 5u) to Rational(4691742523, 762048),
                    listOf(0u, 6u) to Rational(-588323437, 180000),
                    listOf(1u, 6u) to Rational(5952234691, 52920000),
                    listOf(2u, 6u) to Rational(21001851056959, 1088640000),
                    listOf(3u, 6u) to Rational(84668034357563, 2133734400),
                    listOf(4u, 6u) to Rational(2029754605811557, 25604812800),
                    listOf(5u, 6u) to Rational(11721216739823, 426746880),
                    listOf(6u, 6u) to Rational(-8275903187003, 2133734400),
                    listOf(7u, 6u) to Rational(-4730447299, 2540160),
                    listOf(8u, 6u) to Rational(-46069985, 21168),
                    listOf(0u, 7u) to Rational(-75711301, 117600),
                    listOf(1u, 7u) to Rational(32430417413, 7056000),
                    listOf(2u, 7u) to Rational(677988533153, 98784000),
                    listOf(3u, 7u) to Rational(-948417645827, 71124480),
                    listOf(4u, 7u) to Rational(-11320265215207, 711244800),
                    listOf(5u, 7u) to Rational(-676438627783, 50803200),
                    listOf(6u, 7u) to Rational(-7382274253, 1975680),
                    listOf(7u, 7u) to Rational(6505733, 2205),
                    listOf(8u, 7u) to Rational(450137, 882),
                    listOf(0u, 8u) to Rational(-8368253, 78400),
                    listOf(1u, 8u) to Rational(6833783, 117600),
                    listOf(2u, 8u) to Rational(4528971133, 5927040),
                    listOf(3u, 8u) to Rational(146252636617, 29635200),
                    listOf(4u, 8u) to Rational(8321882556889, 1659571200),
                    listOf(5u, 8u) to Rational(-4686033011, 1975680),
                    listOf(6u, 8u) to Rational(-1074445963, 987840),
                    listOf(7u, 8u) to Rational(-142313, 588),
                    listOf(8u, 8u) to Rational(-4281, 49)
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(10, 2),
                    listOf(1u) to Rational(6, 7),
                    listOf(2u) to Rational(-16, 1),
                    listOf(0u, 1u) to Rational(13, 8),
                    listOf(1u, 1u) to Rational(-12, 1),
                    listOf(2u, 1u) to Rational(16, 8),
                    listOf(0u, 2u) to Rational(10, 4),
                    listOf(1u, 2u) to Rational(4, 1),
                    listOf(2u, 2u) to Rational(-11, 3),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1, 4),
                    listOf(1u) to Rational(-17, 4),
                    listOf(2u) to Rational(-14, 8),
                    listOf(0u, 1u) to Rational(17, 9),
                    listOf(1u, 1u) to Rational(1, 3),
                    listOf(2u, 1u) to Rational(7, 6),
                    listOf(0u, 2u) to Rational(16, 3),
                    listOf(1u, 2u) to Rational(-17, 1),
                    listOf(2u, 2u) to Rational(-10, 8),
                )
            ).substitute(RationalField, mapOf(
                0 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(-17, 5),
                        listOf(1u) to Rational(2, 6),
                        listOf(2u) to Rational(14, 1),
                        listOf(0u, 1u) to Rational(-6, 6),
                        listOf(1u, 1u) to Rational(-7, 3),
                        listOf(2u, 1u) to Rational(-2, 9),
                        listOf(0u, 2u) to Rational(-9, 6),
                        listOf(1u, 2u) to Rational(17, 4),
                        listOf(2u, 2u) to Rational(2, 1),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(5, 4),
                        listOf(1u) to Rational(-5, 9),
                        listOf(2u) to Rational(-3, 6),
                        listOf(0u, 1u) to Rational(6, 5),
                        listOf(1u, 1u) to Rational(14, 5),
                        listOf(2u, 1u) to Rational(5, 2),
                        listOf(0u, 2u) to Rational(-18, 7),
                        listOf(1u, 2u) to Rational(-8, 2),
                        listOf(2u, 2u) to Rational(18, 9),
                    )
                ),
                1 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(14, 4),
                        listOf(1u) to Rational(7, 6),
                        listOf(2u) to Rational(7, 2),
                        listOf(0u, 1u) to Rational(-15, 2),
                        listOf(1u, 1u) to Rational(-13, 8),
                        listOf(2u, 1u) to Rational(-14, 3),
                        listOf(0u, 2u) to Rational(-7, 6),
                        listOf(1u, 2u) to Rational(7, 4),
                        listOf(2u, 2u) to Rational(9, 7),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(-7, 4),
                        listOf(1u) to Rational(-6, 3),
                        listOf(2u) to Rational(-16, 2),
                        listOf(0u, 1u) to Rational(-15, 5),
                        listOf(1u, 1u) to Rational(4, 6),
                        listOf(2u, 1u) to Rational(5, 4),
                        listOf(0u, 2u) to Rational(-12, 5),
                        listOf(1u, 2u) to Rational(-18, 2),
                        listOf(2u, 2u) to Rational(6, 7),
                    )
                ),
            )),
            "test 3"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-130778291, 76800),
                    listOf(1u) to Rational(-445270919, 230400),
                    listOf(2u) to Rational(44578444937, 14515200),
                    listOf(3u) to Rational(17329402153, 1555200),
                    listOf(4u) to Rational(89239926809, 2332800),
                    listOf(5u) to Rational(2808812267, 145152),
                    listOf(6u) to Rational(-21362661007, 725760),
                    listOf(7u) to Rational(-258455443, 2016),
                    listOf(8u) to Rational(-21454693, 96),
                    listOf(0u, 1u) to Rational(-1002137, 15360),
                    listOf(1u, 1u) to Rational(-1704849697, 430080),
                    listOf(2u, 1u) to Rational(-57657676789, 4838400),
                    listOf(3u, 1u) to Rational(-101331731, 89600),
                    listOf(4u, 1u) to Rational(5362280079329, 130636800),
                    listOf(5u, 1u) to Rational(4069896167053, 130636800),
                    listOf(6u, 1u) to Rational(12011514569, 544320),
                    listOf(7u, 1u) to Rational(138293195623, 725760),
                    listOf(8u, 1u) to Rational(6228779419, 48384),
                    listOf(0u, 2u) to Rational(-32395872823, 8064000),
                    listOf(1u, 2u) to Rational(-7398505523, 2304000),
                    listOf(2u, 2u) to Rational(95217051699521, 3048192000),
                    listOf(3u, 2u) to Rational(198026968812079, 3657830400),
                    listOf(4u, 2u) to Rational(4291645618499, 228614400),
                    listOf(5u, 2u) to Rational(-33211690942439, 914457600),
                    listOf(6u, 2u) to Rational(-637385538163153, 1371686400),
                    listOf(7u, 2u) to Rational(-138671528276273, 182891520),
                    listOf(8u, 2u) to Rational(-14566368751, 217728),
                    listOf(0u, 3u) to Rational(-10538718719, 2016000),
                    listOf(1u, 3u) to Rational(-1844485375199, 84672000),
                    listOf(2u, 3u) to Rational(103968665891, 12096000),
                    listOf(3u, 3u) to Rational(175402107278351, 1828915200),
                    listOf(4u, 3u) to Rational(8020699588879, 114307200),
                    listOf(5u, 3u) to Rational(3414841894991, 38102400),
                    listOf(6u, 3u) to Rational(1848405591611, 4665600),
                    listOf(7u, 3u) to Rational(39486708738989, 137168640),
                    listOf(8u, 3u) to Rational(255926289517, 9144576),
                    listOf(0u, 4u) to Rational(-655379564629, 105840000),
                    listOf(1u, 4u) to Rational(-208336039441, 127008000),
                    listOf(2u, 4u) to Rational(40173146771411, 1143072000),
                    listOf(3u, 4u) to Rational(150473493581239, 2667168000),
                    listOf(4u, 4u) to Rational(38833783990483, 1143072000),
                    listOf(5u, 4u) to Rational(-1963676248203053, 4800902400),
                    listOf(6u, 4u) to Rational(-2598759412825747, 3200601600),
                    listOf(7u, 4u) to Rational(-192895352019667, 1280240640),
                    listOf(8u, 4u) to Rational(3737382679, 6858432),
                    listOf(0u, 5u) to Rational(-16959378721, 1890000),
                    listOf(1u, 5u) to Rational(-1864802244743, 79380000),
                    listOf(2u, 5u) to Rational(13449261536489, 666792000),
                    listOf(3u, 5u) to Rational(215272234137329, 2667168000),
                    listOf(4u, 5u) to Rational(6040691379277, 83349000),
                    listOf(5u, 5u) to Rational(153687143525887, 800150400),
                    listOf(6u, 5u) to Rational(475602854903563, 2400451200),
                    listOf(7u, 5u) to Rational(27315599358749, 640120320),
                    listOf(8u, 5u) to Rational(-2630413357, 10668672),
                    listOf(0u, 6u) to Rational(-6654999511, 2646000),
                    listOf(1u, 6u) to Rational(-67885252327, 15876000),
                    listOf(2u, 6u) to Rational(5786776220983, 2667168000),
                    listOf(3u, 6u) to Rational(60615922629083, 1143072000),
                    listOf(4u, 6u) to Rational(-34703539637627407, 672126336000),
                    listOf(5u, 6u) to Rational(-744694192134101, 2240421120),
                    listOf(6u, 6u) to Rational(-1782470617231, 14817600),
                    listOf(7u, 6u) to Rational(59123208433, 8890560),
                    listOf(8u, 6u) to Rational(-141653, 5292),
                    listOf(0u, 7u) to Rational(-338051969, 441000),
                    listOf(1u, 7u) to Rational(468850013, 1764000),
                    listOf(2u, 7u) to Rational(2102343426101, 222264000),
                    listOf(3u, 7u) to Rational(7836130602007, 1333584000),
                    listOf(4u, 7u) to Rational(16239111865997, 746807040),
                    listOf(5u, 7u) to Rational(3824649185383, 88905600),
                    listOf(6u, 7u) to Rational(56058614459, 3457440),
                    listOf(7u, 7u) to Rational(-396766339, 493920),
                    listOf(8u, 7u) to Rational(-165147, 2744),
                    listOf(0u, 8u) to Rational(-3088619, 58800),
                    listOf(1u, 8u) to Rational(155343347, 88200),
                    listOf(2u, 8u) to Rational(100098736469, 7408800),
                    listOf(3u, 8u) to Rational(109725511381, 7408800),
                    listOf(4u, 8u) to Rational(-2431199641013, 59270400),
                    listOf(5u, 8u) to Rational(-102872383249, 3457440),
                    listOf(6u, 8u) to Rational(1449461309, 576240),
                    listOf(7u, 8u) to Rational(812775, 1372),
                    listOf(8u, 8u) to Rational(-16461, 343)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(164202773, 230400),
                    listOf(1u) to Rational(-70345303, 518400),
                    listOf(2u) to Rational(-4229702731, 4665600),
                    listOf(3u) to Rational(3262171027, 6998400),
                    listOf(4u) to Rational(-25423104169, 13996800),
                    listOf(5u) to Rational(64061869, 349920),
                    listOf(6u) to Rational(-1655878091, 116640),
                    listOf(7u) to Rational(-7991441, 648),
                    listOf(8u) to Rational(-502591, 18),
                    listOf(0u, 1u) to Rational(-8780429, 3840),
                    listOf(1u, 1u) to Rational(434272361, 115200),
                    listOf(2u, 1u) to Rational(429825727, 41472),
                    listOf(3u, 1u) to Rational(-10066790339, 6998400),
                    listOf(4u, 1u) to Rational(70022035471, 20995200),
                    listOf(5u, 1u) to Rational(-32070283493, 1399680),
                    listOf(6u, 1u) to Rational(-22051101001, 1399680),
                    listOf(7u, 1u) to Rational(-126493427, 12960),
                    listOf(8u, 1u) to Rational(3050245, 864),
                    listOf(0u, 2u) to Rational(-1194654631, 345600),
                    listOf(1u, 2u) to Rational(-542961452671, 31104000),
                    listOf(2u, 2u) to Rational(-234000873607, 48988800),
                    listOf(3u, 2u) to Rational(140520538087, 3628800),
                    listOf(4u, 2u) to Rational(9215088876563, 130636800),
                    listOf(5u, 2u) to Rational(27590569647253, 293932800),
                    listOf(6u, 2u) to Rational(5129057792891, 97977600),
                    listOf(7u, 2u) to Rational(-106334191, 5103),
                    listOf(8u, 2u) to Rational(-1024113911, 435456),
                    listOf(0u, 3u) to Rational(76223843, 6000),
                    listOf(1u, 3u) to Rational(57425857357, 2592000),
                    listOf(2u, 3u) to Rational(-2044736497573, 46656000),
                    listOf(3u, 3u) to Rational(-26155810120031, 293932800),
                    listOf(4u, 3u) to Rational(-1064419459813, 6998400),
                    listOf(5u, 3u) to Rational(-753782018389, 4082400),
                    listOf(6u, 3u) to Rational(-291973360873, 2799360),
                    listOf(7u, 3u) to Rational(-46372122599, 816480),
                    listOf(8u, 3u) to Rational(3579859657, 653184),
                    listOf(0u, 4u) to Rational(-13374241901, 4320000),
                    listOf(1u, 4u) to Rational(306606499811, 54432000),
                    listOf(2u, 4u) to Rational(964267124745437, 13716864000),
                    listOf(3u, 4u) to Rational(21603809415373, 182891520),
                    listOf(4u, 4u) to Rational(1097860214654027, 6858432000),
                    listOf(5u, 4u) to Rational(161615254570669, 914457600),
                    listOf(6u, 4u) to Rational(758415239461, 22861440),
                    listOf(7u, 4u) to Rational(2585568355471, 274337280),
                    listOf(8u, 4u) to Rational(-70433747863, 9144576),
                    listOf(0u, 5u) to Rational(-9582586217, 2520000),
                    listOf(1u, 5u) to Rational(-19093471394171, 635040000),
                    listOf(2u, 5u) to Rational(-13010261944411, 381024000),
                    listOf(3u, 5u) to Rational(-259039825301861, 4572288000),
                    listOf(4u, 5u) to Rational(-305081119071079, 2286144000),
                    listOf(5u, 5u) to Rational(-1923114383311, 19595520),
                    listOf(6u, 5u) to Rational(-14181787253231, 228614400),
                    listOf(7u, 5u) to Rational(-3959584789, 4354560),
                    listOf(8u, 5u) to Rational(4691742523, 762048),
                    listOf(0u, 6u) to Rational(-588323437, 180000),
                    listOf(1u, 6u) to Rational(5952234691, 52920000),
                    listOf(2u, 6u) to Rational(21001851056959, 1088640000),
                    listOf(3u, 6u) to Rational(84668034357563, 2133734400),
                    listOf(4u, 6u) to Rational(2029754605811557, 25604812800),
                    listOf(5u, 6u) to Rational(11721216739823, 426746880),
                    listOf(6u, 6u) to Rational(-8275903187003, 2133734400),
                    listOf(7u, 6u) to Rational(-4730447299, 2540160),
                    listOf(8u, 6u) to Rational(-46069985, 21168),
                    listOf(0u, 7u) to Rational(-75711301, 117600),
                    listOf(1u, 7u) to Rational(32430417413, 7056000),
                    listOf(2u, 7u) to Rational(677988533153, 98784000),
                    listOf(3u, 7u) to Rational(-948417645827, 71124480),
                    listOf(4u, 7u) to Rational(-11320265215207, 711244800),
                    listOf(5u, 7u) to Rational(-676438627783, 50803200),
                    listOf(6u, 7u) to Rational(-7382274253, 1975680),
                    listOf(7u, 7u) to Rational(6505733, 2205),
                    listOf(8u, 7u) to Rational(450137, 882),
                    listOf(0u, 8u) to Rational(-8368253, 78400),
                    listOf(1u, 8u) to Rational(6833783, 117600),
                    listOf(2u, 8u) to Rational(4528971133, 5927040),
                    listOf(3u, 8u) to Rational(146252636617, 29635200),
                    listOf(4u, 8u) to Rational(8321882556889, 1659571200),
                    listOf(5u, 8u) to Rational(-4686033011, 1975680),
                    listOf(6u, 8u) to Rational(-1074445963, 987840),
                    listOf(7u, 8u) to Rational(-142313, 588),
                    listOf(8u, 8u) to Rational(-4281, 49)
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(10, 2),
                    listOf(1u) to Rational(6, 7),
                    listOf(2u) to Rational(-16, 1),
                    listOf(0u, 1u) to Rational(13, 8),
                    listOf(1u, 1u) to Rational(-12, 1),
                    listOf(2u, 1u) to Rational(16, 8),
                    listOf(0u, 2u) to Rational(10, 4),
                    listOf(1u, 2u) to Rational(4, 1),
                    listOf(2u, 2u) to Rational(-11, 3),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1, 4),
                    listOf(1u) to Rational(-17, 4),
                    listOf(2u) to Rational(-14, 8),
                    listOf(0u, 1u) to Rational(17, 9),
                    listOf(1u, 1u) to Rational(1, 3),
                    listOf(2u, 1u) to Rational(7, 6),
                    listOf(0u, 2u) to Rational(16, 3),
                    listOf(1u, 2u) to Rational(-17, 1),
                    listOf(2u, 2u) to Rational(-10, 8),
                )
            ).substitute(RationalField, mapOf(
                0 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(-17, 5),
                        listOf(1u) to Rational(2, 6),
                        listOf(2u) to Rational(14, 1),
                        listOf(0u, 1u) to Rational(-6, 6),
                        listOf(1u, 1u) to Rational(-7, 3),
                        listOf(2u, 1u) to Rational(-2, 9),
                        listOf(0u, 2u) to Rational(-9, 6),
                        listOf(1u, 2u) to Rational(17, 4),
                        listOf(2u, 2u) to Rational(2, 1),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(5, 4),
                        listOf(1u) to Rational(-5, 9),
                        listOf(2u) to Rational(-3, 6),
                        listOf(0u, 1u) to Rational(6, 5),
                        listOf(1u, 1u) to Rational(14, 5),
                        listOf(2u, 1u) to Rational(5, 2),
                        listOf(0u, 2u) to Rational(-18, 7),
                        listOf(1u, 2u) to Rational(-8, 2),
                        listOf(2u, 2u) to Rational(18, 9),
                    )
                ),
                1 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(14, 4),
                        listOf(1u) to Rational(7, 6),
                        listOf(2u) to Rational(7, 2),
                        listOf(0u, 1u) to Rational(-15, 2),
                        listOf(1u, 1u) to Rational(-13, 8),
                        listOf(2u, 1u) to Rational(-14, 3),
                        listOf(0u, 2u) to Rational(-7, 6),
                        listOf(1u, 2u) to Rational(7, 4),
                        listOf(2u, 2u) to Rational(9, 7),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(-7, 4),
                        listOf(1u) to Rational(-6, 3),
                        listOf(2u) to Rational(-16, 2),
                        listOf(0u, 1u) to Rational(-15, 5),
                        listOf(1u, 1u) to Rational(4, 6),
                        listOf(2u, 1u) to Rational(5, 4),
                        listOf(0u, 2u) to Rational(-12, 5),
                        listOf(1u, 2u) to Rational(-18, 2),
                        listOf(2u, 2u) to Rational(6, 7),
                    )
                ),
                5 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(5, 8),
                        listOf(1u) to Rational(-12, 6),
                        listOf(2u) to Rational(7, 6),
                        listOf(0u, 1u) to Rational(-10, 4),
                        listOf(1u, 1u) to Rational(-7, 6),
                        listOf(2u, 1u) to Rational(8, 9),
                        listOf(0u, 2u) to Rational(16, 3),
                        listOf(1u, 2u) to Rational(-13, 4),
                        listOf(2u, 2u) to Rational(5, 1),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(10, 6),
                        listOf(1u) to Rational(-18, 6),
                        listOf(2u) to Rational(5, 1),
                        listOf(0u, 1u) to Rational(17, 7),
                        listOf(1u, 1u) to Rational(8, 4),
                        listOf(2u, 1u) to Rational(-4, 9),
                        listOf(0u, 2u) to Rational(-6, 5),
                        listOf(1u, 2u) to Rational(-15, 8),
                        listOf(2u, 2u) to Rational(-18, 5),
                    )
                ),
            )),
            "test 3'"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(2303, 64),
                    listOf(1u) to Rational(31843, 192),
                    listOf(2u) to Rational(118891, 576),
                    listOf(3u) to Rational(94453, 168),
                    listOf(4u) to Rational(-179203, 1512),
                    listOf(5u) to Rational(-16979, 126),
                    listOf(6u) to Rational(-13499, 12),
                    listOf(0u, 1u) to Rational(-4767, 64),
                    listOf(1u, 1u) to Rational(-58689, 256),
                    listOf(2u, 1u) to Rational(-757333, 4032),
                    listOf(3u, 1u) to Rational(-4921205, 4032),
                    listOf(4u, 1u) to Rational(-2930815, 4032),
                    listOf(5u, 1u) to Rational(-398803, 1512),
                    listOf(6u, 1u) to Rational(18835, 36),
                    listOf(0u, 2u) to Rational(224101, 960),
                    listOf(1u, 2u) to Rational(9139699, 40320),
                    listOf(2u, 2u) to Rational(3848803, 5760),
                    listOf(3u, 2u) to Rational(93102371, 241920),
                    listOf(4u, 2u) to Rational(-65821229, 141120),
                    listOf(5u, 2u) to Rational(-15675899, 7056),
                    listOf(6u, 2u) to Rational(10459, 189),
                    listOf(0u, 3u) to Rational(2411, 16),
                    listOf(1u, 3u) to Rational(1294543, 10080),
                    listOf(2u, 3u) to Rational(-1740199, 1440),
                    listOf(3u, 3u) to Rational(-266994841, 282240),
                    listOf(4u, 3u) to Rational(-41261893, 211680),
                    listOf(5u, 3u) to Rational(1717357, 3528),
                    listOf(6u, 3u) to Rational(69, 14),
                    listOf(0u, 4u) to Rational(13231, 360),
                    listOf(1u, 4u) to Rational(4858831, 25200),
                    listOf(2u, 4u) to Rational(15565759, 75600),
                    listOf(3u, 4u) to Rational(-15583391, 35280),
                    listOf(4u, 4u) to Rational(-13345747, 11760),
                    listOf(5u, 4u) to Rational(140103, 686),
                    listOf(6u, 4u) to Rational(-765, 49)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(31409, 576),
                    listOf(1u) to Rational(-337099, 1728),
                    listOf(2u) to Rational(-211429, 1728),
                    listOf(3u) to Rational(-259241, 432),
                    listOf(4u) to Rational(-13777, 36),
                    listOf(5u) to Rational(-41389, 72),
                    listOf(6u) to Rational(-7679, 48),
                    listOf(0u, 1u) to Rational(-3269, 12),
                    listOf(1u, 1u) to Rational(629569, 864),
                    listOf(2u, 1u) to Rational(53867, 324),
                    listOf(3u, 1u) to Rational(2290577, 1728),
                    listOf(4u, 1u) to Rational(101507, 216),
                    listOf(5u, 1u) to Rational(213109, 288),
                    listOf(6u, 1u) to Rational(17927, 144),
                    listOf(0u, 2u) to Rational(314587, 1080),
                    listOf(1u, 2u) to Rational(-109771, 144),
                    listOf(2u, 2u) to Rational(-6469, 16),
                    listOf(3u, 2u) to Rational(-298291681, 181440),
                    listOf(4u, 2u) to Rational(-59147357, 48384),
                    listOf(5u, 2u) to Rational(-4982365, 6048),
                    listOf(6u, 2u) to Rational(-18727, 576),
                    listOf(0u, 3u) to Rational(12379, 90),
                    listOf(1u, 3u) to Rational(-542911, 1620),
                    listOf(2u, 3u) to Rational(143123, 1260),
                    listOf(3u, 3u) to Rational(9859177, 30240),
                    listOf(4u, 3u) to Rational(9312529, 20160),
                    listOf(5u, 3u) to Rational(207001, 672),
                    listOf(6u, 3u) to Rational(203, 24),
                    listOf(0u, 4u) to Rational(9442, 675),
                    listOf(1u, 4u) to Rational(-13729, 300),
                    listOf(2u, 4u) to Rational(-3490471, 25200),
                    listOf(3u, 4u) to Rational(-333031, 840),
                    listOf(4u, 4u) to Rational(-7572211, 47040),
                    listOf(5u, 4u) to Rational(-1189, 56),
                    listOf(6u, 4u) to Rational(-405, 196)
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(10, 2),
                    listOf(1u) to Rational(6, 7),
                    listOf(2u) to Rational(-16, 1),
                    listOf(0u, 1u) to Rational(13, 8),
                    listOf(1u, 1u) to Rational(-12, 1),
                    listOf(2u, 1u) to Rational(16, 8),
                    listOf(0u, 2u) to Rational(10, 4),
                    listOf(1u, 2u) to Rational(4, 1),
                    listOf(2u, 2u) to Rational(-11, 3),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1, 4),
                    listOf(1u) to Rational(-17, 4),
                    listOf(2u) to Rational(-14, 8),
                    listOf(0u, 1u) to Rational(17, 9),
                    listOf(1u, 1u) to Rational(1, 3),
                    listOf(2u, 1u) to Rational(7, 6),
                    listOf(0u, 2u) to Rational(16, 3),
                    listOf(1u, 2u) to Rational(-17, 1),
                    listOf(2u, 2u) to Rational(-10, 8),
                )
            ).substitute(RationalField, mapOf(
                1 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(14, 4),
                        listOf(1u) to Rational(7, 6),
                        listOf(2u) to Rational(7, 2),
                        listOf(0u, 1u) to Rational(-15, 2),
                        listOf(1u, 1u) to Rational(-13, 8),
                        listOf(2u, 1u) to Rational(-14, 3),
                        listOf(0u, 2u) to Rational(-7, 6),
                        listOf(1u, 2u) to Rational(7, 4),
                        listOf(2u, 2u) to Rational(9, 7),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(-7, 4),
                        listOf(1u) to Rational(-6, 3),
                        listOf(2u) to Rational(-16, 2),
                        listOf(0u, 1u) to Rational(-15, 5),
                        listOf(1u, 1u) to Rational(4, 6),
                        listOf(2u, 1u) to Rational(5, 4),
                        listOf(0u, 2u) to Rational(-12, 5),
                        listOf(1u, 2u) to Rational(-18, 2),
                        listOf(2u, 2u) to Rational(6, 7),
                    )
                ),
            )),
            "test 4"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(2303, 64),
                    listOf(1u) to Rational(31843, 192),
                    listOf(2u) to Rational(118891, 576),
                    listOf(3u) to Rational(94453, 168),
                    listOf(4u) to Rational(-179203, 1512),
                    listOf(5u) to Rational(-16979, 126),
                    listOf(6u) to Rational(-13499, 12),
                    listOf(0u, 1u) to Rational(-4767, 64),
                    listOf(1u, 1u) to Rational(-58689, 256),
                    listOf(2u, 1u) to Rational(-757333, 4032),
                    listOf(3u, 1u) to Rational(-4921205, 4032),
                    listOf(4u, 1u) to Rational(-2930815, 4032),
                    listOf(5u, 1u) to Rational(-398803, 1512),
                    listOf(6u, 1u) to Rational(18835, 36),
                    listOf(0u, 2u) to Rational(224101, 960),
                    listOf(1u, 2u) to Rational(9139699, 40320),
                    listOf(2u, 2u) to Rational(3848803, 5760),
                    listOf(3u, 2u) to Rational(93102371, 241920),
                    listOf(4u, 2u) to Rational(-65821229, 141120),
                    listOf(5u, 2u) to Rational(-15675899, 7056),
                    listOf(6u, 2u) to Rational(10459, 189),
                    listOf(0u, 3u) to Rational(2411, 16),
                    listOf(1u, 3u) to Rational(1294543, 10080),
                    listOf(2u, 3u) to Rational(-1740199, 1440),
                    listOf(3u, 3u) to Rational(-266994841, 282240),
                    listOf(4u, 3u) to Rational(-41261893, 211680),
                    listOf(5u, 3u) to Rational(1717357, 3528),
                    listOf(6u, 3u) to Rational(69, 14),
                    listOf(0u, 4u) to Rational(13231, 360),
                    listOf(1u, 4u) to Rational(4858831, 25200),
                    listOf(2u, 4u) to Rational(15565759, 75600),
                    listOf(3u, 4u) to Rational(-15583391, 35280),
                    listOf(4u, 4u) to Rational(-13345747, 11760),
                    listOf(5u, 4u) to Rational(140103, 686),
                    listOf(6u, 4u) to Rational(-765, 49)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(31409, 576),
                    listOf(1u) to Rational(-337099, 1728),
                    listOf(2u) to Rational(-211429, 1728),
                    listOf(3u) to Rational(-259241, 432),
                    listOf(4u) to Rational(-13777, 36),
                    listOf(5u) to Rational(-41389, 72),
                    listOf(6u) to Rational(-7679, 48),
                    listOf(0u, 1u) to Rational(-3269, 12),
                    listOf(1u, 1u) to Rational(629569, 864),
                    listOf(2u, 1u) to Rational(53867, 324),
                    listOf(3u, 1u) to Rational(2290577, 1728),
                    listOf(4u, 1u) to Rational(101507, 216),
                    listOf(5u, 1u) to Rational(213109, 288),
                    listOf(6u, 1u) to Rational(17927, 144),
                    listOf(0u, 2u) to Rational(314587, 1080),
                    listOf(1u, 2u) to Rational(-109771, 144),
                    listOf(2u, 2u) to Rational(-6469, 16),
                    listOf(3u, 2u) to Rational(-298291681, 181440),
                    listOf(4u, 2u) to Rational(-59147357, 48384),
                    listOf(5u, 2u) to Rational(-4982365, 6048),
                    listOf(6u, 2u) to Rational(-18727, 576),
                    listOf(0u, 3u) to Rational(12379, 90),
                    listOf(1u, 3u) to Rational(-542911, 1620),
                    listOf(2u, 3u) to Rational(143123, 1260),
                    listOf(3u, 3u) to Rational(9859177, 30240),
                    listOf(4u, 3u) to Rational(9312529, 20160),
                    listOf(5u, 3u) to Rational(207001, 672),
                    listOf(6u, 3u) to Rational(203, 24),
                    listOf(0u, 4u) to Rational(9442, 675),
                    listOf(1u, 4u) to Rational(-13729, 300),
                    listOf(2u, 4u) to Rational(-3490471, 25200),
                    listOf(3u, 4u) to Rational(-333031, 840),
                    listOf(4u, 4u) to Rational(-7572211, 47040),
                    listOf(5u, 4u) to Rational(-1189, 56),
                    listOf(6u, 4u) to Rational(-405, 196)
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(10, 2),
                    listOf(1u) to Rational(6, 7),
                    listOf(2u) to Rational(-16, 1),
                    listOf(0u, 1u) to Rational(13, 8),
                    listOf(1u, 1u) to Rational(-12, 1),
                    listOf(2u, 1u) to Rational(16, 8),
                    listOf(0u, 2u) to Rational(10, 4),
                    listOf(1u, 2u) to Rational(4, 1),
                    listOf(2u, 2u) to Rational(-11, 3),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1, 4),
                    listOf(1u) to Rational(-17, 4),
                    listOf(2u) to Rational(-14, 8),
                    listOf(0u, 1u) to Rational(17, 9),
                    listOf(1u, 1u) to Rational(1, 3),
                    listOf(2u, 1u) to Rational(7, 6),
                    listOf(0u, 2u) to Rational(16, 3),
                    listOf(1u, 2u) to Rational(-17, 1),
                    listOf(2u, 2u) to Rational(-10, 8),
                )
            ).substitute(RationalField, mapOf(
                1 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(14, 4),
                        listOf(1u) to Rational(7, 6),
                        listOf(2u) to Rational(7, 2),
                        listOf(0u, 1u) to Rational(-15, 2),
                        listOf(1u, 1u) to Rational(-13, 8),
                        listOf(2u, 1u) to Rational(-14, 3),
                        listOf(0u, 2u) to Rational(-7, 6),
                        listOf(1u, 2u) to Rational(7, 4),
                        listOf(2u, 2u) to Rational(9, 7),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(-7, 4),
                        listOf(1u) to Rational(-6, 3),
                        listOf(2u) to Rational(-16, 2),
                        listOf(0u, 1u) to Rational(-15, 5),
                        listOf(1u, 1u) to Rational(4, 6),
                        listOf(2u, 1u) to Rational(5, 4),
                        listOf(0u, 2u) to Rational(-12, 5),
                        listOf(1u, 2u) to Rational(-18, 2),
                        listOf(2u, 2u) to Rational(6, 7),
                    )
                ),
                5 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(5, 8),
                        listOf(1u) to Rational(-12, 6),
                        listOf(2u) to Rational(7, 6),
                        listOf(0u, 1u) to Rational(-10, 4),
                        listOf(1u, 1u) to Rational(-7, 6),
                        listOf(2u, 1u) to Rational(8, 9),
                        listOf(0u, 2u) to Rational(16, 3),
                        listOf(1u, 2u) to Rational(-13, 4),
                        listOf(2u, 2u) to Rational(5, 1),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(10, 6),
                        listOf(1u) to Rational(-18, 6),
                        listOf(2u) to Rational(5, 1),
                        listOf(0u, 1u) to Rational(17, 7),
                        listOf(1u, 1u) to Rational(8, 4),
                        listOf(2u, 1u) to Rational(-4, 9),
                        listOf(0u, 2u) to Rational(-6, 5),
                        listOf(1u, 2u) to Rational(-15, 8),
                        listOf(2u, 2u) to Rational(-18, 5),
                    )
                ),
            )),
            "test 4'"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-506213, 2800),
                    listOf(1u) to Rational(9859, 315),
                    listOf(2u) to Rational(17384377, 11340),
                    listOf(3u) to Rational(-9662, 63),
                    listOf(4u) to Rational(-12563, 4),
                    listOf(0u, 1u) to Rational(-486293, 22400),
                    listOf(1u, 1u) to Rational(-6530947, 25200),
                    listOf(2u, 1u) to Rational(866125, 18144),
                    listOf(3u, 1u) to Rational(2948747, 2520),
                    listOf(4u, 1u) to Rational(1196611, 2016),
                    listOf(0u, 2u) to Rational(-20266021, 117600),
                    listOf(1u, 2u) to Rational(26656339, 44100),
                    listOf(2u, 2u) to Rational(19499183, 18144),
                    listOf(3u, 2u) to Rational(-19801849, 7560),
                    listOf(4u, 2u) to Rational(-2639635, 1296),
                    listOf(0u, 3u) to Rational(-5017697, 29400),
                    listOf(1u, 3u) to Rational(-606007, 1575),
                    listOf(2u, 3u) to Rational(127494487, 132300),
                    listOf(3u, 3u) to Rational(166567, 105),
                    listOf(4u, 3u) to Rational(486403, 18144),
                    listOf(0u, 4u) to Rational(-32182, 735),
                    listOf(1u, 4u) to Rational(2420671, 8820),
                    listOf(2u, 4u) to Rational(-12619193, 26460),
                    listOf(3u, 4u) to Rational(-6823067, 5670),
                    listOf(4u, 4u) to Rational(-2311693, 13608),
                    listOf(0u, 5u) to Rational(-13324, 245),
                    listOf(1u, 5u) to Rational(1966, 35),
                    listOf(2u, 5u) to Rational(1052719, 2520),
                    listOf(3u, 5u) to Rational(19153, 270),
                    listOf(4u, 5u) to Rational(701, 54),
                    listOf(0u, 6u) to Rational(4647, 196),
                    listOf(1u, 6u) to Rational(2197, 28),
                    listOf(2u, 6u) to Rational(-43853, 336),
                    listOf(3u, 6u) to Rational(-301, 3),
                    listOf(4u, 6u) to Rational(34, 3)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-2843, 1600),
                    listOf(1u) to Rational(-1483, 240),
                    listOf(2u) to Rational(110623, 1296),
                    listOf(3u) to Rational(1265, 72),
                    listOf(4u) to Rational(-5011, 16),
                    listOf(0u, 1u) to Rational(47743, 1800),
                    listOf(1u, 1u) to Rational(619229, 32400),
                    listOf(2u, 1u) to Rational(-5978369, 58320),
                    listOf(3u, 1u) to Rational(-86081, 1620),
                    listOf(4u, 1u) to Rational(6325, 72),
                    listOf(0u, 2u) to Rational(110951, 3360),
                    listOf(1u, 2u) to Rational(-9550649, 302400),
                    listOf(2u, 2u) to Rational(6542933, 85050),
                    listOf(3u, 2u) to Rational(4708291, 38880),
                    listOf(4u, 2u) to Rational(-433327, 1296),
                    listOf(0u, 3u) to Rational(56143, 600),
                    listOf(1u, 3u) to Rational(94243, 720),
                    listOf(2u, 3u) to Rational(-46779139, 226800),
                    listOf(3u, 3u) to Rational(-6948253, 12960),
                    listOf(4u, 3u) to Rational(-260261, 486),
                    listOf(0u, 4u) to Rational(-3205317, 19600),
                    listOf(1u, 4u) to Rational(-201253, 1050),
                    listOf(2u, 4u) to Rational(332192677, 302400),
                    listOf(3u, 4u) to Rational(351511, 360),
                    listOf(4u, 4u) to Rational(-40547, 81),
                    listOf(0u, 5u) to Rational(-65421, 1960),
                    listOf(1u, 5u) to Rational(-10118, 35),
                    listOf(2u, 5u) to Rational(-4341709, 10080),
                    listOf(3u, 5u) to Rational(-91703, 360),
                    listOf(4u, 5u) to Rational(-85, 9),
                    listOf(0u, 6u) to Rational(-25965, 784),
                    listOf(1u, 6u) to Rational(3351, 16),
                    listOf(2u, 6u) to Rational(595159, 1344),
                    listOf(3u, 6u) to Rational(-1381, 12),
                    listOf(4u, 6u) to Rational(-155, 3)
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(10, 2),
                    listOf(1u) to Rational(6, 7),
                    listOf(2u) to Rational(-16, 1),
                    listOf(0u, 1u) to Rational(13, 8),
                    listOf(1u, 1u) to Rational(-12, 1),
                    listOf(2u, 1u) to Rational(16, 8),
                    listOf(0u, 2u) to Rational(10, 4),
                    listOf(1u, 2u) to Rational(4, 1),
                    listOf(2u, 2u) to Rational(-11, 3),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1, 4),
                    listOf(1u) to Rational(-17, 4),
                    listOf(2u) to Rational(-14, 8),
                    listOf(0u, 1u) to Rational(17, 9),
                    listOf(1u, 1u) to Rational(1, 3),
                    listOf(2u, 1u) to Rational(7, 6),
                    listOf(0u, 2u) to Rational(16, 3),
                    listOf(1u, 2u) to Rational(-17, 1),
                    listOf(2u, 2u) to Rational(-10, 8),
                )
            ).substitute(RationalField, mapOf(
                0 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(-17, 5),
                        listOf(1u) to Rational(2, 6),
                        listOf(2u) to Rational(14, 1),
                        listOf(0u, 1u) to Rational(-6, 6),
                        listOf(1u, 1u) to Rational(-7, 3),
                        listOf(2u, 1u) to Rational(-2, 9),
                        listOf(0u, 2u) to Rational(-9, 6),
                        listOf(1u, 2u) to Rational(17, 4),
                        listOf(2u, 2u) to Rational(2, 1),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(5, 4),
                        listOf(1u) to Rational(-5, 9),
                        listOf(2u) to Rational(-3, 6),
                        listOf(0u, 1u) to Rational(6, 5),
                        listOf(1u, 1u) to Rational(14, 5),
                        listOf(2u, 1u) to Rational(5, 2),
                        listOf(0u, 2u) to Rational(-18, 7),
                        listOf(1u, 2u) to Rational(-8, 2),
                        listOf(2u, 2u) to Rational(18, 9),
                    )
                ),
            )),
            "test 5"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-506213, 2800),
                    listOf(1u) to Rational(9859, 315),
                    listOf(2u) to Rational(17384377, 11340),
                    listOf(3u) to Rational(-9662, 63),
                    listOf(4u) to Rational(-12563, 4),
                    listOf(0u, 1u) to Rational(-486293, 22400),
                    listOf(1u, 1u) to Rational(-6530947, 25200),
                    listOf(2u, 1u) to Rational(866125, 18144),
                    listOf(3u, 1u) to Rational(2948747, 2520),
                    listOf(4u, 1u) to Rational(1196611, 2016),
                    listOf(0u, 2u) to Rational(-20266021, 117600),
                    listOf(1u, 2u) to Rational(26656339, 44100),
                    listOf(2u, 2u) to Rational(19499183, 18144),
                    listOf(3u, 2u) to Rational(-19801849, 7560),
                    listOf(4u, 2u) to Rational(-2639635, 1296),
                    listOf(0u, 3u) to Rational(-5017697, 29400),
                    listOf(1u, 3u) to Rational(-606007, 1575),
                    listOf(2u, 3u) to Rational(127494487, 132300),
                    listOf(3u, 3u) to Rational(166567, 105),
                    listOf(4u, 3u) to Rational(486403, 18144),
                    listOf(0u, 4u) to Rational(-32182, 735),
                    listOf(1u, 4u) to Rational(2420671, 8820),
                    listOf(2u, 4u) to Rational(-12619193, 26460),
                    listOf(3u, 4u) to Rational(-6823067, 5670),
                    listOf(4u, 4u) to Rational(-2311693, 13608),
                    listOf(0u, 5u) to Rational(-13324, 245),
                    listOf(1u, 5u) to Rational(1966, 35),
                    listOf(2u, 5u) to Rational(1052719, 2520),
                    listOf(3u, 5u) to Rational(19153, 270),
                    listOf(4u, 5u) to Rational(701, 54),
                    listOf(0u, 6u) to Rational(4647, 196),
                    listOf(1u, 6u) to Rational(2197, 28),
                    listOf(2u, 6u) to Rational(-43853, 336),
                    listOf(3u, 6u) to Rational(-301, 3),
                    listOf(4u, 6u) to Rational(34, 3)
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(-2843, 1600),
                    listOf(1u) to Rational(-1483, 240),
                    listOf(2u) to Rational(110623, 1296),
                    listOf(3u) to Rational(1265, 72),
                    listOf(4u) to Rational(-5011, 16),
                    listOf(0u, 1u) to Rational(47743, 1800),
                    listOf(1u, 1u) to Rational(619229, 32400),
                    listOf(2u, 1u) to Rational(-5978369, 58320),
                    listOf(3u, 1u) to Rational(-86081, 1620),
                    listOf(4u, 1u) to Rational(6325, 72),
                    listOf(0u, 2u) to Rational(110951, 3360),
                    listOf(1u, 2u) to Rational(-9550649, 302400),
                    listOf(2u, 2u) to Rational(6542933, 85050),
                    listOf(3u, 2u) to Rational(4708291, 38880),
                    listOf(4u, 2u) to Rational(-433327, 1296),
                    listOf(0u, 3u) to Rational(56143, 600),
                    listOf(1u, 3u) to Rational(94243, 720),
                    listOf(2u, 3u) to Rational(-46779139, 226800),
                    listOf(3u, 3u) to Rational(-6948253, 12960),
                    listOf(4u, 3u) to Rational(-260261, 486),
                    listOf(0u, 4u) to Rational(-3205317, 19600),
                    listOf(1u, 4u) to Rational(-201253, 1050),
                    listOf(2u, 4u) to Rational(332192677, 302400),
                    listOf(3u, 4u) to Rational(351511, 360),
                    listOf(4u, 4u) to Rational(-40547, 81),
                    listOf(0u, 5u) to Rational(-65421, 1960),
                    listOf(1u, 5u) to Rational(-10118, 35),
                    listOf(2u, 5u) to Rational(-4341709, 10080),
                    listOf(3u, 5u) to Rational(-91703, 360),
                    listOf(4u, 5u) to Rational(-85, 9),
                    listOf(0u, 6u) to Rational(-25965, 784),
                    listOf(1u, 6u) to Rational(3351, 16),
                    listOf(2u, 6u) to Rational(595159, 1344),
                    listOf(3u, 6u) to Rational(-1381, 12),
                    listOf(4u, 6u) to Rational(-155, 3)
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(10, 2),
                    listOf(1u) to Rational(6, 7),
                    listOf(2u) to Rational(-16, 1),
                    listOf(0u, 1u) to Rational(13, 8),
                    listOf(1u, 1u) to Rational(-12, 1),
                    listOf(2u, 1u) to Rational(16, 8),
                    listOf(0u, 2u) to Rational(10, 4),
                    listOf(1u, 2u) to Rational(4, 1),
                    listOf(2u, 2u) to Rational(-11, 3),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1, 4),
                    listOf(1u) to Rational(-17, 4),
                    listOf(2u) to Rational(-14, 8),
                    listOf(0u, 1u) to Rational(17, 9),
                    listOf(1u, 1u) to Rational(1, 3),
                    listOf(2u, 1u) to Rational(7, 6),
                    listOf(0u, 2u) to Rational(16, 3),
                    listOf(1u, 2u) to Rational(-17, 1),
                    listOf(2u, 2u) to Rational(-10, 8),
                )
            ).substitute(RationalField, mapOf(
                0 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(-17, 5),
                        listOf(1u) to Rational(2, 6),
                        listOf(2u) to Rational(14, 1),
                        listOf(0u, 1u) to Rational(-6, 6),
                        listOf(1u, 1u) to Rational(-7, 3),
                        listOf(2u, 1u) to Rational(-2, 9),
                        listOf(0u, 2u) to Rational(-9, 6),
                        listOf(1u, 2u) to Rational(17, 4),
                        listOf(2u, 2u) to Rational(2, 1),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(5, 4),
                        listOf(1u) to Rational(-5, 9),
                        listOf(2u) to Rational(-3, 6),
                        listOf(0u, 1u) to Rational(6, 5),
                        listOf(1u, 1u) to Rational(14, 5),
                        listOf(2u, 1u) to Rational(5, 2),
                        listOf(0u, 2u) to Rational(-18, 7),
                        listOf(1u, 2u) to Rational(-8, 2),
                        listOf(2u, 2u) to Rational(18, 9),
                    )
                ),
                5 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(5, 8),
                        listOf(1u) to Rational(-12, 6),
                        listOf(2u) to Rational(7, 6),
                        listOf(0u, 1u) to Rational(-10, 4),
                        listOf(1u, 1u) to Rational(-7, 6),
                        listOf(2u, 1u) to Rational(8, 9),
                        listOf(0u, 2u) to Rational(16, 3),
                        listOf(1u, 2u) to Rational(-13, 4),
                        listOf(2u, 2u) to Rational(5, 1),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(10, 6),
                        listOf(1u) to Rational(-18, 6),
                        listOf(2u) to Rational(5, 1),
                        listOf(0u, 1u) to Rational(17, 7),
                        listOf(1u, 1u) to Rational(8, 4),
                        listOf(2u, 1u) to Rational(-4, 9),
                        listOf(0u, 2u) to Rational(-6, 5),
                        listOf(1u, 2u) to Rational(-15, 8),
                        listOf(2u, 2u) to Rational(-18, 5),
                    )
                ),
            )),
            "test 5'"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(10, 2),
                    listOf(1u) to Rational(6, 7),
                    listOf(2u) to Rational(-16, 1),
                    listOf(0u, 1u) to Rational(13, 8),
                    listOf(1u, 1u) to Rational(-12, 1),
                    listOf(2u, 1u) to Rational(16, 8),
                    listOf(0u, 2u) to Rational(10, 4),
                    listOf(1u, 2u) to Rational(4, 1),
                    listOf(2u, 2u) to Rational(-11, 3),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1, 4),
                    listOf(1u) to Rational(-17, 4),
                    listOf(2u) to Rational(-14, 8),
                    listOf(0u, 1u) to Rational(17, 9),
                    listOf(1u, 1u) to Rational(1, 3),
                    listOf(2u, 1u) to Rational(7, 6),
                    listOf(0u, 2u) to Rational(16, 3),
                    listOf(1u, 2u) to Rational(-17, 1),
                    listOf(2u, 2u) to Rational(-10, 8),
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(10, 2),
                    listOf(1u) to Rational(6, 7),
                    listOf(2u) to Rational(-16, 1),
                    listOf(0u, 1u) to Rational(13, 8),
                    listOf(1u, 1u) to Rational(-12, 1),
                    listOf(2u, 1u) to Rational(16, 8),
                    listOf(0u, 2u) to Rational(10, 4),
                    listOf(1u, 2u) to Rational(4, 1),
                    listOf(2u, 2u) to Rational(-11, 3),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1, 4),
                    listOf(1u) to Rational(-17, 4),
                    listOf(2u) to Rational(-14, 8),
                    listOf(0u, 1u) to Rational(17, 9),
                    listOf(1u, 1u) to Rational(1, 3),
                    listOf(2u, 1u) to Rational(7, 6),
                    listOf(0u, 2u) to Rational(16, 3),
                    listOf(1u, 2u) to Rational(-17, 1),
                    listOf(2u, 2u) to Rational(-10, 8),
                )
            ).substitute(RationalField, mapOf<Int, NumberedRationalFunction<Rational>>()),
            "test 6"
        )
        assertEquals(
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(10, 2),
                    listOf(1u) to Rational(6, 7),
                    listOf(2u) to Rational(-16, 1),
                    listOf(0u, 1u) to Rational(13, 8),
                    listOf(1u, 1u) to Rational(-12, 1),
                    listOf(2u, 1u) to Rational(16, 8),
                    listOf(0u, 2u) to Rational(10, 4),
                    listOf(1u, 2u) to Rational(4, 1),
                    listOf(2u, 2u) to Rational(-11, 3),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1, 4),
                    listOf(1u) to Rational(-17, 4),
                    listOf(2u) to Rational(-14, 8),
                    listOf(0u, 1u) to Rational(17, 9),
                    listOf(1u, 1u) to Rational(1, 3),
                    listOf(2u, 1u) to Rational(7, 6),
                    listOf(0u, 2u) to Rational(16, 3),
                    listOf(1u, 2u) to Rational(-17, 1),
                    listOf(2u, 2u) to Rational(-10, 8),
                )
            ),
            NumberedRationalFunction(
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(10, 2),
                    listOf(1u) to Rational(6, 7),
                    listOf(2u) to Rational(-16, 1),
                    listOf(0u, 1u) to Rational(13, 8),
                    listOf(1u, 1u) to Rational(-12, 1),
                    listOf(2u, 1u) to Rational(16, 8),
                    listOf(0u, 2u) to Rational(10, 4),
                    listOf(1u, 2u) to Rational(4, 1),
                    listOf(2u, 2u) to Rational(-11, 3),
                ),
                NumberedPolynomialAsIs(
                    listOf<UInt>() to Rational(1, 4),
                    listOf(1u) to Rational(-17, 4),
                    listOf(2u) to Rational(-14, 8),
                    listOf(0u, 1u) to Rational(17, 9),
                    listOf(1u, 1u) to Rational(1, 3),
                    listOf(2u, 1u) to Rational(7, 6),
                    listOf(0u, 2u) to Rational(16, 3),
                    listOf(1u, 2u) to Rational(-17, 1),
                    listOf(2u, 2u) to Rational(-10, 8),
                )
            ).substitute(RationalField, mapOf(
                5 to NumberedRationalFunction(
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(5, 8),
                        listOf(1u) to Rational(-12, 6),
                        listOf(2u) to Rational(7, 6),
                        listOf(0u, 1u) to Rational(-10, 4),
                        listOf(1u, 1u) to Rational(-7, 6),
                        listOf(2u, 1u) to Rational(8, 9),
                        listOf(0u, 2u) to Rational(16, 3),
                        listOf(1u, 2u) to Rational(-13, 4),
                        listOf(2u, 2u) to Rational(5, 1),
                    ),
                    NumberedPolynomialAsIs(
                        listOf<UInt>() to Rational(10, 6),
                        listOf(1u) to Rational(-18, 6),
                        listOf(2u) to Rational(5, 1),
                        listOf(0u, 1u) to Rational(17, 7),
                        listOf(1u, 1u) to Rational(8, 4),
                        listOf(2u, 1u) to Rational(-4, 9),
                        listOf(0u, 2u) to Rational(-6, 5),
                        listOf(1u, 2u) to Rational(-15, 8),
                        listOf(2u, 2u) to Rational(-18, 5),
                    )
                ),
            )),
            "test 6'"
        )
    }
    @Test
    @Ignore
    fun test_Polynomial_substitute_Double_Buffer() {
        // TODO
    }
    @Test
    @Ignore
    fun test_Polynomial_substitute_Constant_Buffer() {
        // TODO
    }
    @Test
    @Ignore
    fun test_Polynomial_substitute_Polynomial_Buffer() {
        // TODO
    }
    @Test
    @Ignore // FIXME: This tests work only for sane realisations of the substitutions. Currently, it is not.
            //  Sane algorithm for substitution p(q/r) (p, q, and r are polynomials) should return denominator r^deg(p),
            //  not r^(deg(p)(deg(p)+1)/2) as it is now.
    fun test_Polynomial_substitute_RationalFunction_Buffer() {
        // TODO
    }
    @Test
    @Ignore
    fun test_RationalFunction_substitute_Double_Buffer() {
        // TODO
    }
    @Test
    @Ignore
    fun test_RationalFunction_substitute_Constant_Buffer() {
        // TODO
    }
    @Test
    @Ignore
    fun test_RationalFunction_substitute_Polynomial_Buffer() {
        // TODO
    }
    @Test
    @Ignore // FIXME: This tests work only for sane realisations of the substitutions. Currently, it is not.
            //  Sane algorithm for substitution p(q/r) (p, q, and r are polynomials) should return denominator r^deg(p),
            //  not r^(deg(p)(deg(p)+1)/2) as it is now.
    fun test_RationalFunction_substitute_RationalFunction_Buffer() {
        // TODO
    }
    @Test
    @Ignore
    fun test_Polynomial_substituteFully_Double_Buffer() {
        // TODO
    }
    @Test
    @Ignore
    fun test_Polynomial_substituteFully_Constant_Buffer() {
        // TODO
    }
    @Test
    @Ignore
    fun test_RationalFunction_substituteFully_Double_Buffer() {
        // TODO
    }
    @Test
    @Ignore
    fun test_RationalFunction_substituteFully_Constant_Buffer() {
        // TODO
    }
    @Test
    @Ignore
    fun test_Polynomial_derivativeWithRespectTo_variable() {
        // TODO
    }
    @Test
    @Ignore
    fun test_Polynomial_nthDerivativeWithRespectTo_variable_order() {
        // TODO
    }
    @Test
    @Ignore
    fun test_Polynomial_nthDerivativeWithRespectTo_variablesAndOrders() {
        // TODO
    }
    @Test
    @Ignore
    fun test_Polynomial_antiderivativeWithRespectTo_variable() {
        // TODO
    }
    @Test
    @Ignore
    fun test_Polynomial_nthAntiderivativeWithRespectTo_variable_order() {
        // TODO
    }
    @Test
    @Ignore
    fun test_Polynomial_nthAntiderivativeWithRespectTo_variablesAndOrders() {
        // TODO
    }
}