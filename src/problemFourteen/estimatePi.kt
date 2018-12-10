package problemFourteen

import kotlin.random.Random

fun estimatePi(iterations: Int): Double {

    var square = 0.0
    var circle = 0.0
    for (i in 1..iterations) {
        val x = Random.nextDouble()
        val y = Random.nextDouble()
        if (x * x + y * y <= 1) {
            circle += 1
        }
        square += 1
    }
    return 4 * (circle / square)
}