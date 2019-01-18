package dataStructures

data class DllNode<T>(var value:T, var next:DllNode<T>? = null, var previous:DllNode<T>? = null)

class DoubleLinkedList<T> {
    var head: DllNode<T>? = null
    var tail: DllNode<T>? = null
    var current: DllNode<T>? = null

    fun addHead(node: DllNode<T>): T {
        if(head == null) {
            current = node
            tail = node
            head = node
            return (head as DllNode<T>).value
        }

        node.next = head as DllNode<T>
        (head as DllNode<T>).previous = node
        head = node
        return (head as DllNode<T>).value
    }

    fun addTail(node: DllNode<T>): T {
        if(tail == null) {
            current = node
            tail = node
            head = node
            return (tail as DllNode<T>).value
        }

        node.previous = tail as DllNode<T>
        (tail as DllNode<T>).next = node
        tail = node
        return (tail as DllNode<T>).value
    }

    private fun addBefore(node: DllNode<T>, newNode: DllNode<T>) {
        newNode.next = node.next
        newNode.previous = node

        node.next = newNode
        newNode.next!!.previous = newNode
        current = newNode
    }

    private fun addAfter(node: DllNode<T>, newNode: DllNode<T>) {
        newNode.next = node
        newNode.previous = node.previous

        node.previous = newNode
        node.previous!!.next = newNode
        current = newNode
    }

    fun addBefore(node: DllNode<T>) {
        if (current != null && current!!.previous != null)
            addBefore(current!!, node)
        else
            addHead(node)
    }

    fun addAfter(node: DllNode<T>) {
        if (current != null)
            addAfter(current!!, node)
        else
            addTail(node)
    }

    fun hasNext(): Boolean {
        return current?.next != null
    }

    fun next(): T? {
        return if (current?.next != null) {
            current = current!!.next
            current!!.value
        } else
            null
    }

    fun hasPrev(): Boolean {
        return current?.previous != null
    }

    fun prev(): T? {
        return if (current?.previous != null) {
            current = current!!.previous
            current!!.value
        } else
            null
    }

    fun getCurrentValue(): T? {
        return current?.value
    }

    fun setCurrentToHead() {
        current = head
    }

    fun setCurrentToTail() {
        current = tail
    }

    fun copy(): DoubleLinkedList<T> {
        var start = head

        val out = DoubleLinkedList<T>()
        while (start != null) {
            out.addTail(DllNode(start.value))
            start = start.next
        }

        return out
    }

    override fun toString(): String {
        var start = head

        val sb = StringBuilder()
        while (start != null) {
            sb.append(start?.value)
            start = start.next
        }

        return sb.toString()
    }
}