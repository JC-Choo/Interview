package dev.chu.data_structure.tree

class Node(var value: Int) {
    var leftChild: Node? = null
    var rightChild: Node? = null
}

class BinaryTree {
    var rootNode: Node? = null

    /**
     * 새로운 노드 삽입
     */
    fun insertNode(element: Int) {
        if (rootNode == null) {
            rootNode = Node(element)
            return
        }

        println()
        println("element = $element")
        println("rootNode = ${rootNode?.value}")
        var head = rootNode
        println("head = ${head?.value}")
        println("-----------while")
        var currentNode: Node?
        while (true) {
            currentNode = head
            println("currentNode = ${currentNode?.value}, head = ${head?.value}")

            if (head != null) {
                println("head.value > element = ${head.value > element}")
                // 현재의 루트보다 작은 경우, 왼쪽부터 탐색
                if (head.value > element) {
                    head = head.leftChild
                    println("head = $head")

                    if (head == null) {
                        /*
                        왼쪽 자식 노드가 비어있는 경우, 해당 위치에 추가할 노드를 삽입한다.
                        현재 currenNode head를 가리키고 있다.
                        */
                        currentNode?.leftChild = Node(element)
                        println("currentNode.leftChild = ${currentNode?.leftChild?.value}")
                        break
                    }
                } else {
                    // 현재의 루트보다 큰 경우, 오른쪽으로 탐색을 한다.
                    head = head.rightChild
                    println("head = $head")

                    if (head == null) {
                        currentNode?.rightChild = Node(element)
                        println("currentNode.rightChild = ${currentNode?.rightChild?.value}")
                        break
                    }
                }
            }
        }
    }

    /**
     * 특정 노트 삭제
     */
    fun removeNode(element: Int): Boolean {
        var removeNode = rootNode
        var parentOfRemoveNode: Node? = null
        if (removeNode != null) {
            while (removeNode!!.value != element) {
                parentOfRemoveNode = removeNode

                // 삭제할 값이 현재 노드보다 작으면 왼쪽을 탐색한다.
                removeNode = if (removeNode.value > element) {
                    removeNode.leftChild
                } else {
                    removeNode.rightChild
                }

                if (removeNode == null) {
                    return false
                }
            }

            println("removeNode.leftChild = ${removeNode.leftChild}, removeNode.rightChild = ${removeNode.rightChild}")
            println("removeNode = ${removeNode.value}, rootNode = ${rootNode?.value}, parentOfRemoveNode = ${parentOfRemoveNode?.value}")
            // 자식 노드가 모두 없을 때
            if (removeNode.leftChild == null && removeNode.rightChild == null) {
                // 삭제 대상이 트리의 루트일 때
                when (removeNode) {
                    rootNode -> {
                        rootNode = null
                    }
                    parentOfRemoveNode?.rightChild -> {
                        parentOfRemoveNode.rightChild = null
                    }
                    else -> {
                        parentOfRemoveNode?.leftChild = null
                    }
                }
            }

            // 오른쪽 자식 노드만 존재하는 경우
            else if (removeNode.leftChild == null) {
                when (removeNode) {
                    rootNode -> {
                        rootNode = removeNode.rightChild
                    }
                    parentOfRemoveNode?.rightChild -> {
                        // 삭제 대상의 오른쪽 자식 노드를 삭제 대상 위치에 둔다.
                        parentOfRemoveNode.rightChild = removeNode.rightChild
                    }
                    else -> {
                        parentOfRemoveNode?.leftChild = removeNode.rightChild
                    }
                }
            }

            // 왼쪽 자식 노드만 존재하는 경우
            else if (removeNode.rightChild == null) {
                when (removeNode) {
                    rootNode -> {
                        rootNode = removeNode.leftChild
                    }
                    parentOfRemoveNode?.rightChild -> {
                        parentOfRemoveNode.rightChild = removeNode.leftChild
                    }
                    else -> {
                        parentOfRemoveNode?.leftChild = removeNode.leftChild
                    }
                }
            }

            /*
             두 개의 자식 노드가 존재하는 경우
             삭제할 노드의 왼쪽 서브 트리에 있는 가장 큰 값 노드를 올리거나
             오른쪽 서브 트리에 있는 가장 작은 값 노드를 올리면 된다.
             구현 코드는 2번째 방법을 사용
             */
            else {
                // 삭제 대상 노드의 자식 노드 중에서 대체될 노드(replaceNode)를 찾는다.
                var parentOfReplaceNode = removeNode
                // 삭제 대상의 오른쪽 서브 트리 탐색 지정
                var replaceNode = parentOfReplaceNode.rightChild

                while (replaceNode?.leftChild != null) {
                    // 가장 작은 값을 찾기 위해 왼쪽 자식 노드를 탐색한다.
                    parentOfReplaceNode = replaceNode
                    replaceNode = replaceNode.leftChild
                }

                if (replaceNode != removeNode.rightChild) {
                    // 가장 작은 값을 선택하기 때문에 대체 노드의 왼쪽 자식은 빈 노드가 된다.
                    parentOfReplaceNode?.leftChild = replaceNode?.rightChild

                    // 대체할 노드의 오른쪽 자식 노드를 삭제할 노드의 오른쪽으로 지정한다.
                    replaceNode?.rightChild = removeNode.rightChild
                }

                // 삭제할 노드가 루트 노드인 경우 대체할 노드로 바꾼다.
                when (removeNode) {
                    rootNode -> {
                        rootNode = replaceNode
                    }
                    parentOfRemoveNode?.rightChild -> {
                        parentOfRemoveNode.rightChild = replaceNode
                    }
                    else -> {
                        parentOfRemoveNode?.leftChild = replaceNode
                    }
                }

                // 삭제 대상의 노드의 왼쪽 자식을 잇는다.
                replaceNode?.leftChild = removeNode.leftChild
            }
        }

        return true
    }

    /**
     * 중위 순회
     */
    fun inorderTree(root: Node?, depth: Int) {
        if (root != null) {
            inorderTree(root.leftChild, depth + 1)
            for (i in 0 until depth) {
                print("ㄴ")
            }
            println(root.value)
            inorderTree(root.rightChild, depth + 1)
        }
    }

    /**
     * 후위 순회
     */
    fun postorderTree(root: Node?, depth: Int) {
        if (root != null) {
            postorderTree(root.leftChild, depth+1)
            postorderTree(root.rightChild, depth+1)
            for (i in 0 until depth) {
                print("ㄴ")
            }
            println(root.value)
        }
    }

    /**
     * 전위 순회
     */
    fun preorderTree(root: Node?, depth: Int) {
        if (root != null) {
            for (i in 0 until depth) {
                print("ㄴ")
            }
            println(root.value)
            preorderTree(root.leftChild, depth+1)
            preorderTree(root.rightChild, depth+1)
        }
    }
}