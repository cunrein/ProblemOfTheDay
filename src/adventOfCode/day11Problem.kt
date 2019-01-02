package adventOfCode

data class PowerGrid(val xMax: Int, val yMax: Int, val sn: Int) {
    val grid = Array(xMax) { Array(yMax) { 0 } }

    init {
        for (x in 0 until xMax) {
            for (y in 0 until yMax) {
                grid[x][y] = powerLevel(sn, x, y)
            }
        }
    }

    private fun powerLevel(sn: Int, x: Int, y: Int): Int {
        val rackId = x + 10
        var powerLevel = rackId * y
        powerLevel += sn
        powerLevel *= rackId
        val out = getHundredthPlace(powerLevel) - 5
        return out
    }

    private fun getHundredthPlace(input: Int): Int {
        val s = input.toString()
        return if (s.length >= 3) s[s.length - 3].toString().toInt() else 0
    }
}

fun gridSum(grid: PowerGrid, topLeftX: Int, topLeftY: Int, size: Int): Int {
    var result = 0

    for (y in topLeftY + size - 1 downTo topLeftY) {
        for (x in topLeftX + size - 1 downTo topLeftX) {
            result += grid.grid[x][y]
        }
    }

    return result
}

data class Quad(val x: Int, val y: Int, val power: Int, val size: Int) {
    override fun toString(): String {
        return "($x, $y, $size, $power)"
    }
}

fun getMostPowerful3x3Grid(powerGrid: PowerGrid): Quad {
    var maxSum = Integer.MIN_VALUE
    var cornerX = 0
    var cornerY = 0
    var sqSize = 0
    //val size = 3
    for (size in 1..300) {
        for (y in 0 until powerGrid.yMax - size) {
            for (x in 0 until powerGrid.xMax - size) {
                val sum = gridSum(powerGrid, x, y, size)
                if (sum > maxSum) {
                    maxSum = sum
                    cornerX = x
                    cornerY = y
                    sqSize = size
                }
            }
        }
    }
    return Quad(cornerX, cornerY, maxSum, sqSize)
}

fun main(args: Array<String>) {
    println(getMostPowerful3x3Grid(PowerGrid(300, 300, 8772)))
}