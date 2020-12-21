package dev.chu.algorithm

class BinarySearch {
    fun main(arr: IntArray, x: Int): Int {
        var low = 0
        var high = arr.size-1

        while (low <= high) {
            val mid = (low+high)/2
            if(arr[mid] == x)
                return mid

            if(arr[mid] > x) high = mid - 1
            else low = mid + 1
        }

        return -1
    }
}