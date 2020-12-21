package dev.chu.algorithm

import org.junit.Test

class TreeTest {
    @Test
    fun 이진트리() {
        val tree = BinaryTree()
        tree.insertNode(5)
        tree.insertNode(7)
        tree.insertNode(8)
        tree.insertNode(3)
        tree.insertNode(2)
        tree.insertNode(6)
//        tree.insertNode(4)

        println()
        if (tree.removeNode(3)) {
            println("노드 삭제")
        }
        println()

        tree.inorderTree(tree.rootNode, 0);
//        tree.postorderTree(tree.rootNode, 0)
//        tree.preorderTree(tree.rootNode, 0)
    }
}