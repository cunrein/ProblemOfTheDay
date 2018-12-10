package adventOfCode

import java.math.BigInteger

fun repeatedFreq(dat: List<BigInteger>): BigInteger {
    var sum = BigInteger.ZERO
    val seen: MutableSet<BigInteger> = mutableSetOf(BigInteger.ZERO)
    while (true) {
        for (i in dat) {
            sum += i
            if (seen.contains(sum)) {
                return sum
            }
            seen.add(sum)
        }
    }
}