import problemFour.findLowestMissingPositiveInteger
import problemOne.DoesListContainSum
import problemThree.deserialize
import problemThree.node
import problemThree.serialize
import problemTwo.MultiplyArrayValues

fun main(args: Array<String>) {
    val doesListContainSum = DoesListContainSum()
    val multiplyArrayValues = MultiplyArrayValues()
    var list = listOf(10, 15, 3, 7, 2, 14)
    var out = doesListContainSum.containSum(list, 17)
    println("Values $out")
    out = doesListContainSum.setFindPairs(list, 17)
    println("Values $out")

    list = listOf(18, 12, 12, 5, 1, -1)
    out = doesListContainSum.containSum(list, 17)
    println("Values $out")
    out = doesListContainSum.setFindPairs(list, 17)
    println("Values $out")

    list = listOf(1, 2, 3, 4, 5)
    var output = multiplyArrayValues.multiply(list)
    println("Values $output")
    output = multiplyArrayValues.polygenelubricants(list)
    println("Values $output")

    list = listOf(3, 2, 1)
    output = multiplyArrayValues.multiply(list)
    println("Values $output")
    output = multiplyArrayValues.polygenelubricants(list)
    println("Values $output")

    var tree = buildTree()
    println(tree)
    val serial = serialize(tree)
    tree = deserialize(serial)
    println(tree)

    println(findLowestMissingPositiveInteger(intArrayOf(3, 4, -1, 1)))
    println(findLowestMissingPositiveInteger(intArrayOf(1, 2, 0)))
    println(findLowestMissingPositiveInteger(intArrayOf(4, 7, 0, -2, 3, 4, 1, 3, 6, 2)))
    println(findLowestMissingPositiveInteger(intArrayOf(10, 9, 9, 9, 9, 9, 0)))
}

fun buildTree(): node<String>? {
    val a = node("a", null, null)
    val b = node("b", null, null)
    val c = node("c", null, null)
    val d = node("d", null, null)
    val e = node("e", null, null)
    a.addNodes(b, c)
    c.addNodes(d, e)
    return a
}