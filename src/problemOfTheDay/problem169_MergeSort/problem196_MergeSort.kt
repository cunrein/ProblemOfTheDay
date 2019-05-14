package problemOfTheDay.problem169_MergeSort


data class Node<T : Comparable<T>>(val value: T, var next: Node<T>? = null)

class LinkedList<T : Comparable<T>>(var head: Node<T>?) {
    fun push(new_data: T) {
        /* allocate node */
        val newNode = Node<T>(new_data)

        /* link the old list off the new node */
        newNode.next = head

        /* move the head to point to the new node */
        head = newNode
    }

    // Utility function to print the linked list
    fun print() {
        println(toString())
    }

    override fun toString(): String {
        var headref = head
        var out = ""
        while (headref != null) {
            out += headref.value.toString() + " "
            headref = headref.next
        }
        return out
    }

}

private fun <T : Comparable<T>> sortedMerge(a: Node<T>?, b: Node<T>?): Node<T>? {
    val result: Node<T>?
    /* Base cases */
    if (a == null)
        return b
    if (b == null)
        return a

    /* Pick either a or b, and recur */
    if (a.value <= b.value) {
        result = a
        result.next = sortedMerge(a.next, b)
    } else {
        result = b
        result.next = sortedMerge(a, b.next)
    }
    return result
}

fun <T : Comparable<T>> mergeSort(h: Node<T>?): Node<T>? {

    if (h == null || h.next == null)
        return h

    // get the middle of the list
    val middle = getMiddle(h)
    val nextOfMiddle = middle?.next

    // set the next of middle node to null
    middle?.next = null

    // Apply mergeSort on left list
    val left = mergeSort(h)

    // Apply mergeSort on right list
    val right = mergeSort(nextOfMiddle)

    // Merge the left and right lists
    return sortedMerge(left, right)
}

fun <T : Comparable<T>> getMiddle(h: Node<T>?): Node<T>? {
    // Base case
    if (h == null)
        return h
    var fastptr = h.next
    var slowptr = h

    // Move fastptr by two and slow ptr by one
    // Finally slowptr will point to middle node
    while (fastptr != null) {
        fastptr = fastptr.next
        if (fastptr != null) {
            slowptr = slowptr?.next
            fastptr = fastptr.next
        }
    }
    return slowptr
}

fun main() {
    val node = Node(-2)
    val linkedList = LinkedList(node)

    linkedList.push(4)
    linkedList.push(0)
    linkedList.push(-1)
    linkedList.push(10)
    linkedList.push(12)
    linkedList.push(5)
    linkedList.print()

    val sorted = LinkedList(mergeSort(linkedList.head))
    sorted.print()
}