            package dev.chu.data_structure

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun test() {
        val dsLinkedlist = DS_LinkedList()
        dsLinkedlist.main()
    }

    @Test
    fun addition_isCorrect() {
        val arr = intArrayOf(0, 1, 0, 3, 12)
        for (i in 0 until arr.size-1) {
            for (j in i+1 until arr.size) {
                if(arr[i] == 0) {
                    if (arr[i] < arr[j]) {
                        val temp = arr[j]
                        arr[j] = arr[i]
                        arr[i] = temp
                    }
                }
            }
        }
        arr.forEach {
            print("$it ")
        }
    }
}