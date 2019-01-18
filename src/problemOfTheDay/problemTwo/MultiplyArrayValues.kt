package problemOfTheDay.problemTwo

class MultiplyArrayValues {
    //Given an array of integers, return a new array such that each element at index i
    // of the new array is the product of all the numbers in the original array except the one at i.
    //
    //For example, if our input was [1, 2, 3, 4, 5], the expected output would be
    // [120, 60, 40, 30, 24].
    // If our input was [3, 2, 1], the expected output would be [2, 3, 6].
    fun multiply(array: List<Int>): List<Int> {
        return mutableListOf<Int>().apply {
            for ((idx1, _) in array.withIndex()) {
                var tmp = 1
                for ((idx2, v) in array.withIndex()) {
                    if (idx1 == idx2) continue

                    tmp *= v
                }
                add(tmp)
            }
        }
    }

    // optimal solution.
    fun polygenelubricants(array: List<Int>): List<Int> {

        //var productBelow = MutableList(array.size) {1}
        var p = 1
        val productBelow = array.map {
            val tmp = p
            p *= it
            tmp
        }

        p = 1
        val productAbove = array.reversed().map {
            val tmp = p
            p *= it
            tmp
        }.reversed()

        return mutableListOf<Int>().apply {
            for (i in 0 until productAbove.size) {
                add(productAbove[i] * productBelow[i])
            }
        }
    }
}