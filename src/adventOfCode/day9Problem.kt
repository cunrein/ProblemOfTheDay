package adventOfCode

class MarbleGame(private val numPlayers: Int, private val marbles: Int) {
    private val players = HashMap<Int, Double>(numPlayers)

    init {
        for (i in 1 .. numPlayers) players[i] = 0.0
    }

    // return the score of winner.
    fun run(): Double {
        // optimization - init the circle to be the size of the number of marbles to prevent a resize.
        val circle = mutableListOf(0)
        var current = 0
        var player = 1
        var i = 1
        val oneHundredth = marbles/100
        while (i < marbles) {
            current = placeMarble(i, current, player, circle)
            if (player + 1 > numPlayers) {
                player = 0
            }
            player++
            i ++
            if(i % oneHundredth == 0) {print("#")}
        }
        println()
        return players.maxBy { it.value }!!.value
    }

    private fun placeMarble(marble: Int, idxCurrent: Int, player: Int, circle: MutableList<Int>): Int {
        if(marble % 23 == 0) {
            // score
            var score = players[player]!!.plus(marble)
            // take marble, move left 7 places
            val idx = findCounterClockwiseIndex(7, idxCurrent, circle)
            score += circle.removeAt(idx)
            players[player] = score
            return idx // this should now be the current marble
        } else {
            // place marble
            if(idxCurrent + 2 == circle.size) {
                // place at end
                circle.add(marble)
            } else if(idxCurrent + 2 > circle.size) {
                circle.add(1, marble)
                return 1
            } else {
                // place at index + 2
                // seems redundant not sure if this is required.
                circle.add(idxCurrent + 2, marble)
            }
        }
        return idxCurrent + 2
    }

    private fun findCounterClockwiseIndex(steps: Int, idx: Int, circle: MutableList<Int>): Int {
        return if (idx - steps >= 0) {idx - steps} else { circle.size + (idx - steps)}
    }
}
