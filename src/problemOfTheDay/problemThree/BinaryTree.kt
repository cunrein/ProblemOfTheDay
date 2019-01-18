package problemOfTheDay.problemThree

import problemOfTheDay.problemThree.Constants.NULL_NODE
import problemOfTheDay.problemThree.Constants.SEPARATOR

data class node<T>(
    var value: T?,
    var leftNode: node<T>?,
    var rightNode: node<T>?
) {
    fun addNodes(left: node<T>?, right: node<T>?) = this.apply { addLeft(left).addRight(right) }
    fun addLeft(left: node<T>?) = this.apply { leftNode = left }
    fun addRight(right: node<T>?) = this.apply { rightNode = right }

    override fun toString(): String {
        return prefixTraversal(this)
    }

    companion object {
        @JvmStatic
        fun <T> infixTraversal(node: node<T>?): String {
            return StringBuilder().apply {
                if (node != null) {
                    append(infixTraversal(node.leftNode))
                    append(node.value)
                    append(SEPARATOR)
                    append(infixTraversal(node.rightNode))
                } else {
                    append(NULL_NODE)
                    append(SEPARATOR)
                }
            }.toString()
        }

        @JvmStatic
        fun <T> prefixTraversal(node: node<T>?): String {
            return StringBuilder().apply {
                if (node != null) {
                    append(node.value)
                    append(SEPARATOR)
                    append(prefixTraversal(node.leftNode))
                    append(prefixTraversal(node.rightNode))
                } else {
                    append(NULL_NODE)
                    append(SEPARATOR)
                }
            }.toString()
        }

        @JvmStatic
        fun <T> postfixTraversal(node: node<T>?): String {
            return StringBuilder().apply {
                if (node != null) {
                    append(postfixTraversal(node.leftNode))
                    append(postfixTraversal(node.rightNode))
                    append(node.value)
                    append(SEPARATOR)
                } else {
                    append(NULL_NODE)
                    append(SEPARATOR)
                }
            }.toString()
        }
    }
}