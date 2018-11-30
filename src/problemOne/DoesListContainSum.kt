package problemOne

import java.util.*


class DoesListContainSum {
    //Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
    //
    //For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

    // Used a set as the return to dedupe results.
    fun containSum(list: List<Int>, sum: Int): Set<Pair<Int, Int>> {
        return mutableSetOf<Pair<Int, Int>>().apply {
            for ((idx, i) in list.withIndex()) {
                for (v in list.slice(idx + 1 until list.size)) {
                    if (sum - i == v) {
                        add(Pair(i, v))
                    }
                }
            }
        }
    }

    fun setFindPairs(arr: List<Int>, sum: Int): Set<Pair<Int, Int>> {
        val s = HashSet<Int>()
        return mutableSetOf<Pair<Int, Int>>().apply {
            for (i in arr.indices) {
                val temp = sum - arr[i]

                // checking for condition
                if (temp >= 0 && s.contains(temp)) {
                    add(Pair(arr[i], temp))
                }
                s.add(arr[i])
            }
        }
    }
}