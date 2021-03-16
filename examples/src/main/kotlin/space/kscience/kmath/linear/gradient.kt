package space.kscience.kmath.linear

import space.kscience.kmath.real.*
import space.kscience.kmath.structures.RealBuffer

fun main() {
    val x0 = Point(0.0, 0.0, 0.0)
    val sigma = Point(1.0, 1.0, 1.0)

    val gaussian: (Point<Double>) -> Double = { x ->
        require(x.size == x0.size)
        kotlin.math.exp(-((x - x0) / sigma).square().sum())
    }

    fun ((Point<Double>) -> Double).grad(x: Point<Double>): Point<Double> {
        require(x.size == x0.size)
        return RealBuffer(x.size) { i ->
            val h = sigma[i] / 5
            val dVector = RealBuffer(x.size) { if (it == i) h else 0.0 }
            val f1 = invoke(x + dVector / 2)
            val f0 = invoke(x - dVector / 2)
            (f1 - f0) / h
        }
    }

    println(gaussian.grad(x0))

}