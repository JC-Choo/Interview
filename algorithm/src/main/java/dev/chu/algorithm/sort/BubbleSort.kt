package dev.chu.algorithm.sort

/**
 * 버블 정렬 (Bubble sort)
 * 인접한 두 원소를 검사해 정렬하는 알고리즘으로, 서로 인접한 두 원소의 크기가
 * 순서대로 되어 있지 않다면 서로 교환한다.
 *
 * 장점
 * 구현이 매우 간단
 *
 * 단점
 * 순서에 맞지 않는 요소를 인접한 요소와 교환한다.
 * 가장 왼쪽에서 가장 오른쪽으로 이동 시 모든 배열을 교환한다.
 *
 * 쓸데없는 과정이 많아, 잘 사용되지 않는다.
 */
class BubbleSort {
    fun main(arr: IntArray): IntArray {
        for (i in 0 until arr.size-1) {
            for (j in i+1 until arr.size) {
                if (arr[i] > arr[j]) {
                    val temp = arr[j]
                    arr[j] = arr[i]
                    arr[i] = temp
                }
            }
        }

        return arr
    }
}