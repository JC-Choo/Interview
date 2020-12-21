package dev.chu.algorithm

import dev.chu.algorithm.sort.BubbleSort
import org.junit.Test

class SearchTest {

    @Test
    fun 이진검색() {
        val search = BinarySearch()
        val sort = BubbleSort()

        // 정렬되어있을 경우
        val arr = intArrayOf(17, 28, 43, 67, 88, 92, 100)
        val result = search.main(arr, 92)
        println("result = $result")

        // 정렬되어있지 않을 경우(arr 결과)
        val arr2 = intArrayOf(6, 4, 1, 8, 9, 2, 7, 5, 3)
        val result2 = search.main(arr2, 5)
        println("result2 = $result2")

        // 정렬되어있지 않을 경우(정렬 후 x 대한 sort arr 결과)
        val result3 = search.main(sort.main(arr2), 5)
        println("result3 = $result3")
    }
}