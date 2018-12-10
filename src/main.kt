import adventOfCode.createDataDayThree
import adventOfCode.findNonOverlapingClaim
import problemEight.countUniversalTrees
import problemFive.car
import problemFive.cdr
import problemFive.cons
import problemFour.findLowestMissingPositiveInteger
import problemOne.DoesListContainSum
import problemSeven.countNumberDecodings
import problemThree.deserialize
import problemThree.node
import problemThree.serialize
import problemTwo.MultiplyArrayValues
import java.math.BigInteger

fun main(args: Array<String>) {
    //problemOftheDay()
    advent()
}

fun advent() {
//    println(freqAdjust(loadDataFromFile("./adventOfCode/day1data.dat")))
//    println(repeatedFreq(loadDataFromFile("./adventOfCode/day1data.dat")))
//    //println(repeatedFreq(createList()))
//    val map = mapOf<>()
//    println(stringDiff("bqlpzruexkszyahnamgjdctvfs",
//    "bqlporuexkwyyahnbmgjdctvfb"))
//    println(findMissing())
//    val claim = createClaim("#1 @ 108,350: 22x29")
//    println("${claim.name}, ${claim.xStart}, ${claim.yStart}, ${claim.xEnd}, ${claim.yEnd}")
//    println(findOverlap(createDataDayThree()))
    println(findNonOverlapingClaim(createDataDayThree()))
}

fun createList(): List<BigInteger> {
    return listOf<BigInteger>(
        BigInteger.valueOf(1),
        BigInteger.valueOf(-2),
        BigInteger.valueOf(3),
        BigInteger.valueOf(1),
        BigInteger.valueOf(3)
    )
}

fun problemOftheDay() {
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

    println(car(cons(3, 4)))
    println(cdr(cons(3, 4)))

    var message = "111"
    println(countNumberDecodings(message.toCharArray(), message.length))
    message = "129"
    println(countNumberDecodings(message.toCharArray(), message.length))

    var intTree = buildTree2()
    println(intTree)
    println(node.countUniversalTrees(intTree))
    intTree = buildTree3()
    println(intTree)
    println(node.countUniversalTrees(intTree))
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

fun buildTree2(): node<Int> {
    return node(
        0, node(1, null, null),
        node(
            0,
            node(
                1,
                node(1, null, null),
                node(1, null, null)
            ),
            node(0, null, null)
        )
    )
}

fun buildTree3(): node<Int> {
    return node(
        1, node(1, null, null),
        node(
            1,
            node(
                1,
                node(1, null, null),
                node(1, null, null)
            ),
            node(1, null, null)
        )
    )
}