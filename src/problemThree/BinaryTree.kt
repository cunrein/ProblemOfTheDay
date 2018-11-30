package problemThree

import problemThree.Constants.NULL_NODE
import problemThree.Constants.SEPARATOR

data class node<T>(
    var value: T?,
    var leftNode: node<T>?,
    var rightNode: node<T>?
) {

    //Given the root to a binary tree, implement serialize(root), which serializes the tree into a string,
    // and deserialize(s), which deserializes the string back into the tree.
    constructor(node: node<T>) : this(node.value, node.leftNode, node.rightNode)

    fun addNodes(left: node<T>?, right: node<T>?) = this.apply { addLeft(left).addRight(right) }
    fun addLeft(left: node<T>?) = this.apply { leftNode = left }
    fun addRight(right: node<T>?) = this.apply { rightNode = right }

    override fun toString(): String {
        return prefixTraversal(this)
    }

    fun infixTraversal(node: node<T>?): String {
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

    fun prefixTraversal(node: node<T>?): String {
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

    fun postfixTraversal(node: node<T>?): String {
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