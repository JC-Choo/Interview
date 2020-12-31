package dev.chu.algorithm

import dev.chu.algorithm.programmers.SortKotlin
import dev.chu.algorithm.sort.BubbleSort
import dev.chu.algorithm.sort.InsertionSort
import dev.chu.algorithm.sort.SelectionSort
import org.junit.Test

class SortKotlinTest {

    @Test
    fun 프로그래머스_sort() {
        val sort = SortKotlin()
        sort.main()
    }

    @Test
    fun 버블정렬() {
        val testArray = intArrayOf(31, 25, 12, 22, 11)
        val sort = BubbleSort()
        sort.main(testArray)
    }

    @Test
    fun 선택정렬() {
        val testArray = intArrayOf(31, 25, 12, 22, 11)
        val sort = SelectionSort()
        sort.main(testArray)
    }

    @Test
    fun 삽입정렬() {
        val testArray = intArrayOf(31, 25, 12, 22, 11)
        val sort = InsertionSort()
        sort.main00(testArray)
        sort.main01(testArray)
    }
}