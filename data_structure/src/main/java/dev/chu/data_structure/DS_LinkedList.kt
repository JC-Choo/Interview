package dev.chu.data_structure

import java.util.*

class DS_LinkedList {

    class Node(
            var data: Int? = null,
            var next: Node? = null
    )

    private lateinit var head: Node
    private var size = 0
    fun main() {
        val a = LinkedList<Int>()
        a.add(0)
        a.add(3)
        a.add(2)
        a.addLast(4)
        a.addFirst(1)
        a.forEach { print("$it ") }
        println()


        head = Node(null, null)
        addFront(head, 0)
        addFront(head, 1)
        addFront(head, 2)
        showAll()
    }

    private fun add(root: Node, data: Int) {
        val newNode = Node()
        newNode.data = data

        var count = 0
        while (true) {
            if (root.next != null) {
                count++
            } else {
                break
            }
        }
        size++
    }

    private fun addFront(root: Node, data: Int) {
        val node = Node()
        node.data = data
        node.next = root.next
        root.next = node
    }

    private fun removeFront(root: Node) {
        val front = root.next
        root.next = front?.next
    }

    private fun showAll() {
        println("showAll head.next = ${head.next}")
        while (head.next != null) {
            println("data = " + head.next?.data)
            head.next = head.next?.next
        }
    }
}