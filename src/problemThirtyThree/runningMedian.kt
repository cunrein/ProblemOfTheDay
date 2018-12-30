package problemThirtyThree

fun runingMedian(intStream: List<Int>): List<Double> {

    val container = mutableListOf<Int>()
    return intStream.map {
        container.add(it)
        container.sort()
        if(container.size % 2 == 0)
            (container[container.size/2] + container[container.size/2 - 1])/2.0
        else
        container[container.size/2].toDouble()
    }

}


fun main(args: Array<String>) {
    val data = listOf(2, 1, 5, 7, 2, 0, 5)
    println(runingMedian(data))
}