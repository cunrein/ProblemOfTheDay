package adventOfCode

import java.io.File
import java.math.BigInteger

fun freqAdjust(x: List<BigInteger>?): BigInteger {
    return if (!x.isNullOrEmpty()) {
        x.last() + freqAdjust(x.dropLast(1))
    } else {
        BigInteger.ZERO
    }
}

fun readFileAsLinesUsingBufferedReader(fileName: String): List<String> = File(fileName).bufferedReader().readLines()

fun loadDataFromFile(uri: String): List<BigInteger> {
    val data = readFileAsLinesUsingBufferedReader(uri)
    return data.map { v -> BigInteger(v) }
}