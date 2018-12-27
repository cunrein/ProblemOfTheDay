package problemThirtyOne

fun editDistance(str1: String, str2: String): Int {
    val len1 = str1.length
    val len2 = str2.length
    val diff = Math.max(len1, len2) - Math.min(len1, len2)
    val len = Math.min(str1.length, str2.length)
    val compareStr1 = str1.substring(0 until len)
    val compareStr2 = str2.substring(0 until len)
    return compareStr1.mapIndexed { i, c ->
        if (c == compareStr2[i])
            0
        else
            1
    }.sum() + diff
}

fun main(args: Array<String>) {
    //problemOftheDay()
    println(editDistance("kitten", "sitting"))
}