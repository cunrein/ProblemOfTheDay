package adventOfCode

data class PowerGrid(val x: Int, val y: Int, val sn: Int) {
    val grid = Array(x) { Array(y) { 0 } }

    init {
        for (i in 0 until x) {
            for (j in 0 until y) {
                val rackId = i + 10
                grid[i][j] = getHundredthPlace(((rackId * j) + sn) * rackId) - 5
            }
        }
    }

    private fun getHundredthPlace(input: Int): Int {
        val s = input.toString()
        return if (s.length >= 3) s[2].toInt() else 0
    }

//    fun getGridValue(x: Int, y: Int): Int {
//        return if(x > this.x || y > this.y)
//            -6 // Error outside of grid.
//        else
//            grid[x][y]
//    }
}

fun getMostPowerful3x3Grid(powerGrid: PowerGrid): Pair<Int, Int> {
    var map = mutableMapOf<Pair<Int, Int>, Int>()
    for (i in 0 until powerGrid.x - 2) {
        for (j in 0 until powerGrid.y - 2) {
            val key = Pair(i, j)
            var sum = 0
            for (x in 0..2) {
                for (y in 0..2) {
                    sum += powerGrid.grid[i + x][j + y]
                }
            }
            map[key] = sum
        }
    }
    return map.maxBy { it.value }!!.key
}

fun main(args: Array<String>) {
    println(getMostPowerful3x3Grid(PowerGrid(300, 300, 18)))
}