package dev.chu.data_structure

import org.junit.Test

class ArrayTest {
    private val arr = arrayOf(1, 3, 5, 2, 4, 7, 0, 5, 2, 3, 1)

    @Test
    fun 최소값찾기() {
        var min = Int.MAX_VALUE
        for (i in arr.indices) {
            if (min > arr[i]) {
                min = arr[i]
            }
        }
        println("min = $min")
    }

    @Test
    fun 포문으로_두번째_작은_요소_찾기() {
        var min = Int.MAX_VALUE
        var minIndex = arr.size
        for (i in arr.indices) {
            if (min > arr[i]) {
                min = arr[i]
                minIndex = i
            }
        }
        println("fist min = $min")
        min = Int.MAX_VALUE
        for (i in arr.indices) {
            if (minIndex != i) {
                if (min > arr[i]) {
                    min = arr[i]
                }
            }
        }
        println("second min = $min")
    }

    @Test
    fun 버블정렬로_두번째_작은_요소_찾기() {
        for (i in 0 until arr.size-1) {
            for (j in i+1 until arr.size) {
                if (arr[i] > arr[j]) {
                    val temp = arr[j]
                    arr[j] = arr[i]
                    arr[i] = temp
                }
            }
        }
        arr.forEach { print("$it ") }
        println()
        println("arr[1] = ${arr[1]}")
    }

    @Test
    fun 배열의_첫번째_반복하지_않는_정수() {
        for (i in 0 until arr.size-1) {
            var count = i

            for (j in i+1 until arr.size) {
                if (arr[i] == arr[j]) {
                    count = j
                    break
                }
            }

            if (count == i) {
                println("result = ${arr[i]}")
                break
            }
        }
    }

    @Test
    fun 두개의_정렬된_배열_병합() {
        val arr0 = intArrayOf(0, 1, 2, 3, 4)
        val arr1 = intArrayOf(3, 4, 5, 6, 7)
        val result = arrayOfNulls<Int>(arr0.size+arr1.size)
        arr0.forEachIndexed { index, i ->
            result[index] = i
        }
        arr1.forEachIndexed { index, i ->
            result[arr0.size+index] = i
        }
        result.forEach { print("$it ") }
    }

    @Test
    fun 양수_음수_재정렬() {
        val arr0 = intArrayOf(3, -2, 1, 0, -4, 5)

    }
}