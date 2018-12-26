package problemTwentyNine

import com.google.common.base.Splitter

// Run-length encoding is a fast and simple method of encoding strings.
// The basic idea is to represent repeated successive characters as a
// single count and character. For example, the string "AAAABBBCCDAA"
// would be encoded as "4A3B2C1D2A".

fun encode(str: String): String {
    var i = 0
    var c = str[i]
    val sb = StringBuilder()
    var j = 1
    while (i < str.length - 1) {
        i++
        if (c == str[i]) {
            j++
        } else {
            sb.append("$j$c")
            c = str[i]
            j = 1
        }
    }
    // capture the last characters.
    sb.append("$j$c")
    return sb.toString()
}

fun decode(str: String): String {
    //bad string
    if (str.length % 2 != 0)
        return ""
    val pieces = Splitter.fixedLength(2).split(str)
    val sb = StringBuilder()
    for (p in pieces) {
        val cnt = p[0].toString().toInt()
        sb.append(p[1].toString().repeat(cnt))
    }
    return sb.toString()
}

fun main(args: Array<String>) {
    val en = encode(testDataDay29)
    println(en == "4A3B2C1D2A")
    println(decode(en) == testDataDay29)
}

val testDataDay29 = "AAAABBBCCDAA"