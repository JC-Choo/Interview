package dev.chu.algorithm.열혈자료구조

/**
 * 정렬된 데이터에서만 적용이 가능하다.
 * 반씩 나누어 target 이 midIndex 에 있다면 return midIndex, 없다면 target 이 midIndex 보다 큰지 작은지 판단해 첫 인덱스와 라스트 인덱스를 바꿔준다.
 * 즉, 반씩 누눠가며 타겟이 어디 영역에 있는지 찾아가는 알고리즘
 *
 * 시간 복잡도 : O(log n)
 */
object BinarySearch {
    @JvmStatic
    fun main(args: Array<String>) {
        val target = 23
        val array = intArrayOf(3, 2, 1, 7, 9, 12, 21, 23, 27, 20)
        val arr = array.sorted().toIntArray()
        println("target = $target -> " + BSearch(arr, arr.size, target))

        /**
         * O(log n)의 연산 횟수(9, 13, 16)는 O(n)의 연산 횟수(50, 500, 5000)보다 획기적으로 차이가 난다.
         * 그러므로, O(n)에서 O(log n) 알고리즘으로 변경하는 것은 약간의 성능 개선이 아닌 획기적인 개선이라 볼 수 있다.
         */
//        val arr50 = IntArray(50) { 0 }
//        val arr500 = IntArray(500) { 0 }
//        val arr5000 = IntArray(5000) { 0 }
//        result(BSearch(arr50, arr50.size, target))
//        result(BSearch(arr500, arr500.size, target))
//        result(BSearch(arr5000, arr5000.size, target))
    }

    private fun BSearch(arr: IntArray, len: Int, target: Int): Int {
        var first = 0       // 탐색 대상의 시작 인덱스 값
        var last = len - 1    // 탐색 대상의 마지막 인덱스 값
        var opCount = 0     // 비교 연산의 획수를 기록

        while (first <= last) {
            val mid = (first + last) / 2     // 탐색 대상의 중앙 값
            if (target == arr[mid]) {       // 중앙에 저장된 것이 타겟이라면
                println("opCount = $opCount")
                return mid                  // 탐색 완료
            } else {                        // 타겟이 아니라면 탐색 대상을 반으로 줄임
                if (target < arr[mid]) {
                    last = mid - 1
                } else {
                    first = mid + 1
                }
            }
            opCount++
        }

        println("opCount = $opCount")
        return -1
    }

    private fun result(idx: Int) {
        if (idx == -1) {
            println("탐색 실패")
        } else {
            println("타겟 저장 인텍스 = $idx")
        }
    }
}