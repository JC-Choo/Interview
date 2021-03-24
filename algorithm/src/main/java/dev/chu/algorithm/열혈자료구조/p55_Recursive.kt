package dev.chu.algorithm.열혈자료구조

object Recursive {
    @JvmStatic
    fun main(args: Array<String>) {
//        println("result = ${factorial(5)}")

//        val arr = intArrayOf(1, 3, 5, 7, 9)
//        val result = binarySearchRecursive(arr, 0, arr.size-1, 7)
//        println("result = $result")

        hanoiTowerMove(3, "A", "B", "C")
        hanoiTowerMove(3, "B", "C", "D")

//        println("result = ${fibonacciSequence00(5)}")
//        println("result = ${fibonacciSequence01(5)}")
    }

    private fun factorial(num: Int): Int {
        println("factorial num = $num")
        return if (num == 0) {
            1
        } else {
            val result = num * factorial(num-1)
            println("factorial result = $result")
            result
        }
    }

    private fun binarySearchRecursive(arr: IntArray, first: Int, last: Int, target: Int): Int {
        println("binarySearchRecursive first = $first, last = $last")
        if (first > last) return -1
        val mid = (first + last) / 2
        println("binarySearchRecursive mid = $mid")

        return when {
            arr[mid] == target -> {
                val result = mid
                println("binarySearchRecursive 0 result = $result")
                result
            }
            arr[mid] < target -> {  // target이 더 크므로, first가 mid보다 +1 되어야만 mid 이상의 수에서 target을 찾는다.
                val result = binarySearchRecursive(arr, mid+1, last, target)
                println("binarySearchRecursive 1 result = $result")
                result
            }
            else -> {
                val result = binarySearchRecursive(arr, first, mid-1, target)
                println("binarySearchRecursive 2 result = $result")
                result
            }
        }
    }

    private fun hanoiTowerMove(num: Int, from: String, by: String, to: String) {
        /**
         * A, B, C 막대에서 원반 n개를 옮길 시 순서
         * 1. n-1개를 A에서 B로 옮긴다.
         * 2. n번째 원반을 A에서 C로 옮긴다.
         * 3. B에 있는 n-1개의 원반을 B에서 C로 옮긴다.
         *
         * 코딩 넘나 어렵다..
         */
        if (num == 1) {
            println("if 원반 1을 ${from}에서 ${to}로 옮긴다.")
        } else {
            hanoiTowerMove(num-1, from, to, by)
            println("원반 ${num}을 ${from}에서 ${to}로 옮긴다.")
            hanoiTowerMove(num-1, by, from, to)
        }
    }

    // 피보나치 수열 -> 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...
    private fun fibonacciSequence00(n: Int): Int {
        println("fibonacciSequence00 n = $n")
        return when (n) {
            1 -> {
                0
            }
            2 -> {
                1
            }
            else -> {
                val result = fibonacciSequence00(n-1) + fibonacciSequence00(n-2)
                println("fibonacciSequence00 result = $result")
                result
            }
        }
    }

    private fun fibonacciSequence01(n: Int): Int {
        val list = mutableListOf(0, 1)

        var index = 2
        while (index < n) {
            val result = list[index-1] + list[index-2]
            list.add(result)
            index++
        }
        list.forEach { print("$it ") }
        println()

        return list[list.size-1]
    }
}