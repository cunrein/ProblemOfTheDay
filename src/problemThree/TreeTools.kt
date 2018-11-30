package problemThree

import problemThree.Constants.NULL_NODE
import problemThree.Constants.SEPERATOR
import java.util.*

object Constants {
    const val SEPERATOR = " "
    const val NULL_NODE = "#"
}

// deserialize from a string
fun deserialize(text: String): node<String>? {
    return if (text.isNotEmpty()) {
        parseString(StringTokenizer(text, SEPERATOR))
    } else {
        null
    }
}

fun serialize(node: node<String>?): String {
    return node!!.prefixTraversal(node)
}

private fun parseString(values: StringTokenizer): node<String>? {
    return if (!values.hasMoreTokens()) {
        null
    } else {
        val value = values.nextToken()
        if (value == NULL_NODE) {
            null
        } else {
            val node = node<String>(value, null, null)
            node.addLeft(parseString(values))
            node.addRight(parseString(values))
        }
    }
}