package dev.chu.algorithm.열혈자료구조

/**
 * 순차적으로 진행해 값을 구하는 알고리즘
 *
 * 시간 복잡도 : O(n)
 */
object LinearSearch {
    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(3, 5, 2, 4, 9)
        var idx = LSearch(arr, arr.size, 4)
        result(idx)

        idx = LSearch(arr, arr.size, 7)
        result(idx)
    }

    // 순차 탐색 알고리즘 적용된 함수
    private fun LSearch(arr: IntArray, len: Int, target: Int): Int {
        arr.indices.forEachIndexed { i, _ ->
            if (arr[i] == target) {
                return i    // 찾은 대상의 인덱스 값 반환
            }
        }
        return -1       // 찾지 못했음을 의미하는 값 반환
    }

    private fun result(idx: Int) {
        if (idx == -1) {
            println("탐색 실패")
        } else {
            println("타겟 저장 인텍스 = $idx")
        }
    }
}