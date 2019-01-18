package problemOfTheDay.ProblemFiftyThree

import java.util.*

class Queue<T> {

    private val stack1 = ArrayDeque<T>()
    private val stack2 = ArrayDeque<T>()

    fun enqueue(value: T) {
        stack1.push(value)
        stack2.clear()
        stack1.forEach { elm -> stack2.push(elm) }

    }

    fun dequeue() : T {
        val o = stack2.pop()
        stack1.clear()
        stack2.forEach { elm -> stack1.push(elm) }
        return o
    }

    fun isEmpty(): Boolean = stack1.isEmpty() && stack2.isEmpty()

}

fun main(args: Array<String>) {
    val q = Queue<Int>()

    for (i in 1 .. 20)
        q.enqueue(i)

    while (!q.isEmpty())
        println(q.dequeue())
}