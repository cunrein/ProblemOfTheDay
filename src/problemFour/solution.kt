package problemFour

import kotlin.math.abs

//Given an array of integers, find the first missing positive integer in linear time
// and constant space. In other words, find the lowest positive integer that does not
// exist in the array. The array can contain duplicates and negative numbers as well.

fun findLowestMissingPositiveInteger(array: IntArray): Int {
    val positives = array.filter { it > 0 }.toIntArray()
    return findMissingPositiveInteger(positives)
}

fun findMissingPositiveInteger(array: IntArray): Int {
    for (i in array) {
        val pos = abs(i)
        if (pos - 1 < array.size && array[pos - 1] > 0) {
            array[pos - 1] = -array[pos - 1]
        }
    }

    for ((idx, i) in array.withIndex()) {
        if (i > 0) {
            return idx + 1
        }
    }
    return array.size + 1
}