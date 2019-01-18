package problemOfTheDay.problemThirtyFive

fun partition(arr: CharArray): CharArray {
    val r = arr.partition { it == 'R' }
    val g = r.second.partition { it == 'G' }
    return r.first.plus(g.first).plus(g.second).toCharArray()
}