package problemThree

import problemThree.Constants.NULL_NODE
import problemThree.Constants.SEPARATOR
import java.util.*

object Constants {
    const val SEPARATOR = " "
    const val NULL_NODE = "#"
}

// deserialize from a string
fun deserialize(text: String): node<String>? {
    return if (text.isNotEmpty()) {
        parseString(StringTokenizer(text, SEPARATOR))
    } else {
        null
    }
}

fun serialize(n: node<String>?): String {
    return node.prefixTraversal(n)
}

private fun parseString(values: StringTokenizer): node<String>? {
    return if (!values.hasMoreTokens()) {
        null
    } else {
        val value = values.nextToken()
        if (value == NULL_NODE) {
            null
        } else {
            val node = node(value, null, null)
            node.addLeft(parseString(values))
            node.addRight(parseString(values))
        }
    }
}