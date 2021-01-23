package dev.chu.algorithm.sort

/**
 * 선택 정렬 (selection sort)
 * 제자리 정렬 알고리즘의 하나로, 다음과 같은 순서로 이루어진다.
 * 1. 주어진 리스트 중에 최소값을 찾는다.
 * 2. 그 값을 맨 앞에 위치한 값과 교체한다(패스(pass)).
 * 3. 맨 처음 위치를 뺀 나머지 리스트를 같은 방법으로 교체한다.
 *
 * 비교하는 것이 상수 시간에 이루어진다는 가정 아래, n개의 주어진 리스트를 이와 같은 방법으로 정렬하는 데에는
 * Θ(n2) 만큼의 시간이 걸린다.
 * 선택 정렬은 알고리즘이 단순하며 사용할 수 있는 메모리가 제한적인 경우에 사용시 성능 상의 이점이 있습니다.
 */
class SelectionSort {
    fun main(arr: IntArray) {
        for (i in 0 until arr.size-1) {
            var index = i
            var min = arr[i]

            for (j in i+1 until arr.size) {
                // min 이 i+1번째 arr 보다 크다면, 최소로 만들기 위해 min에 arr[j]의 값을 입력하고
                // 그렇다면, min 은 현재 비교 대상과의 "최소 값"이므로, 변경한 j의 값을 index에 넣어준다.
                if (min > arr[j]) {
                    min = arr[j]
                    index = j
                }
            }

            // 최소 값의 인덱스와 현재 인덱스를 스왑한다.
            val temp = arr[index]
            arr[index] = arr[i]
            arr[i] = temp
        }

        arr.forEach {
            print("$it ")
        }
        println()
    }
}