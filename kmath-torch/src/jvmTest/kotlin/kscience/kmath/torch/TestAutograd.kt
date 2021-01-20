package kscience.kmath.torch

import kotlin.test.Test


class TestAutograd {
    @Test
    fun testAutoGrad() = TorchTensorFloatAlgebra {
        withChecks {
            withCuda { device ->
                testingAutoGrad(device)
            }
        }
    }

    @Test
    fun testBatchedAutoGrad() = TorchTensorFloatAlgebra {
        withChecks {
            withCuda { device ->
                testingBatchedAutoGrad(device)
            }
        }
    }
}