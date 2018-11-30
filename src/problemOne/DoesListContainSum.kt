package problemOne

import java.util.*


class DoesListContainSum {
    //Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
    //
    //For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

    // Used a set as the return to dedupe results.
    fun containSum(list: List<Int>, sum: Int): Set<Pair<Int, Int>> {
        val pairs = mutableSetOf<Pair<Int, Int>>()
        for ((idx, i) in list.withIndex()) {
            for (v in list.slice(idx + 1 until list.size)) {
                if (sum - i == v) {
                    pairs.add(Pair(i, v))
                }
            }
        }
        return pairs
    }

    fun setFindPairs(arr: List<Int>, sum: Int): Set<Pair<Int, Int>> {
        val s = HashSet<Int>()
        val pairs = mutableSetOf<Pair<Int, Int>>()
        for (i in arr.indices) {
            val temp = sum - arr[i]

            // checking for condition
            if (temp >= 0 && s.contains(temp)) {
                pairs.add(Pair(arr[i], temp))
            }
            s.add(arr[i])
        }
        return pairs
    }
}