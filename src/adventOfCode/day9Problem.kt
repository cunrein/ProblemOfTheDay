package adventOfCode

import java.math.BigInteger

class MarbleGame(private val numPlayers: Int, private val marbles: BigInteger) {
    private val players = HashMap<Int, BigInteger>(numPlayers)

    init {
        for (i in 1 .. numPlayers) players[i] = BigInteger.ZERO
    }

    // return the score of winner.
    fun run(): BigInteger {
        val circle = mutableListOf(BigInteger.ZERO)
        var current = BigInteger.ZERO
        var player = 1
        var i = BigInteger.ONE
        val oneHundredth = marbles/100.toBigInteger()
        while (i < marbles) {
            current = placeMarble(i, current, player, circle)
            if (player + 1 > numPlayers) {
                player = 0
            }
            player++
            i ++
            if(i.mod(oneHundredth) == 0.toBigInteger()) {print("#")}
        }
        println()
        return players.maxBy { it.value }!!.value
    }

    private fun placeMarble(marble: BigInteger, current: BigInteger, player: Int, circle: MutableList<BigInteger>): BigInteger {
        val index = circle.indexOf(current).toBigInteger()
        if(marble.mod(BigInteger.ZERO.plus(23.toBigInteger())) == BigInteger.ZERO) {
            // score
            var score = players[player]!!.plus(marble)
            // take marble, move left 7 places
            val idx = findCounterClockwiseIndex(7.toBigInteger(), index, circle)
            score += circle.removeAt(idx.toInt())
            players[player] = score
            return circle[idx.toInt()] // this should now be the current marble
        } else {
            // place marble
            if(index.toInt() + 2 == circle.size) {
                // place at end
                circle.add(marble)
            } else if(index.toInt() + 2 > circle.size) {
                circle.add(1, marble)
            } else {
                // place at index + 1
                circle.add(index.toInt() + 2, marble)
            }
        }
        return marble
    }

    private fun findCounterClockwiseIndex(steps: BigInteger, idx: BigInteger, circle: MutableList<BigInteger>): BigInteger {
        return if (idx - steps >= 0.toBigInteger()) {idx - steps} else { circle.size.toBigInteger() + (idx - steps)}
    }
}