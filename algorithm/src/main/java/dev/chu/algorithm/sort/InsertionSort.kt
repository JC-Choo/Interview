package dev.chu.algorithm.sort

/**
 * 삽입 정렬 (InsertionSort)
 * 자료 배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교하여,
 * 자신의 위치를 찾아 삽입함으로써 정렬을 완성하는 알고리즘
 *
 * 장점
 * 구현이 간단하다.
 *
 * 단점
 * 배열의 길이가 길어질수록 효율이 떨이진다.
 */
class InsertionSort {

    fun main00(arr: IntArray) {
        for (i in 1 until arr.size) {
            val temp = arr[i]
            var aux = i-1
            while ((aux >= 0) && (arr[aux] > temp)) {
                arr[aux+1] = arr[aux]
                aux--
            }
            arr[aux+1] = temp
        }

        arr.forEach {
            print("$it ")
        }
        println()
    }

    private lateinit var arr: IntArray

    fun main01(array: IntArray) {
        this.arr = array
        for (i in 1 until arr.size) {
            for (j in i downTo 1) {
                if (arr[j-1] > arr[j]) {
                    swap(j, j-1)
                }
            }
        }

        arr.forEach {
            print("$it ")
        }
        println()
    }

    private fun swap(num1: Int, num2: Int) {
        val temp = arr[num1]
        arr[num1] = arr[num2]
        arr[num2] = temp
    }
}