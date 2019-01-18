package problemOfTheDay.problemThirtyEight

class NQueens (private val n: Int) {
    var count = 0
    private var c = IntArray(n + 1)
    private var f = ""

    fun nQueens(row: Int) {
        outer@ for (x in 1..n) {
            for (y in 1 until row) {
                if (c[y] == x) continue@outer
                if (row - y == Math.abs(x - c[y])) continue@outer
            }
            c[row] = x
            if (row < n) nQueens(row + 1)
            else if (++count == 1) f = c.drop(1).map { it - 1 }.toString()
        }
    }
}
fun main(args: Array<String>) {
    for (n in 1..14) {
        val nQueens = NQueens(n)
        nQueens.nQueens(1)
        println("For a $n x $n board:")
        println("\tSolutions = ${nQueens.count}")
        println()
    }
}