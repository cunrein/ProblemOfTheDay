package problemOfTheDay.problemEight

import problemOfTheDay.problemThree.node


// A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
//
// Given the root to a binary tree, count the number of unival subtrees.
//
// For example, the following tree has 5 unival subtrees:
//
//   0
//  / \
// 1   0
//    / \
//   1   0
//  / \
// 1   1


// Original -- wrong
fun <T> node.Companion.universalTrees(n: node<T>?): Int {
    return if (n == null) {
        0
    } else if (n.rightNode == null && n.leftNode == null) {
        1
    } else if (n.leftNode != null && n.rightNode != null) {
        // test to see if universal
        val lnode = n.leftNode
        val rnode = n.rightNode
        return if (n.value == lnode?.value && n.value == rnode?.value) {
            1 + universalTrees(lnode) + universalTrees(rnode)
        } else {
            universalTrees(lnode) + universalTrees(rnode)
        }
    } else {
        0
    }
}

fun <T> node.Companion.countUniversalTrees(n: node<T>): Int {
    val cnt = Count(0)
    countUniversalTrees(n, cnt)
    return cnt.cnt
}

private data class Count(var cnt: Int)

private fun <T> node.Companion.countUniversalTrees(n: node<T>?, cnt: Count): Boolean {
    if (n == null)
        return true

    val ln = n.leftNode
    val rn = n.rightNode
    // Recursively count in left and right subtrees also
    val left = countUniversalTrees(ln, cnt)
    val right = countUniversalTrees(rn, cnt)

    // If any of the subtrees is not universal, then this
    // cannot be universal.
    if (!left || !right)
        return false

    // If left subtree is singly and non-empty, but data
    // doesn't match
    if (n.leftNode != null && n.value !== ln?.value)
        return false

    // Same for right subtree
    if (n.rightNode != null && n.value !== rn?.value)
        return false

    // If none of the above conditions is true, then
    // tree rooted under root is single valued, increment
    // count and return true.
    cnt.cnt++
    return true
}