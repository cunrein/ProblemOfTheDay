package problemOfTheDay.problemFourtyThree

import java.util.*

data class Stack<T : Comparable<T>>(val el: T? = null) {
    private val list = LinkedList<T>()

    init {
        if (el != null)
            list.addFirst(el)
    }

    fun push(el: T) {
        list.addFirst(el)
    }

    fun pop(): T {
        return list.first ?: throw RuntimeException("The list is empty")
    }

    fun max(): T {
        return list.max() ?: throw RuntimeException("The list is empty")
    }
}