package dev.chu.algorithm.programmers

class SortKotlin {

    fun main() {
//        val arr = intArrayOf(1, 5, 2, 6, 3, 7, 4)
//        val arr2 = arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))
//        Level_1_K번째수(arr, arr2)


        val numbers00 = intArrayOf(6, 10, 2)
        val numbers01 = intArrayOf(3, 30, 34, 5, 9)
        println(Level_2_가장_큰_수(numbers00))
        println(Level_2_가장_큰_수(numbers01))
    }

    private fun Level_1_K번째수(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf()

        // 풀이 1
//        val list = mutableListOf<Int>()
//        commands.forEach { intArr ->
//            val i = intArr[0]
//            val j = intArr[1]
//            val k = intArr[2]
//
//            val arr = array.copyOfRange(i-1, j)
//            arr.sort()
//            list.add(arr[k-1])
//        }
//        answer = list.toIntArray()

        // 풀이 2
        answer = commands.map { intArr ->
            array.sliceArray(IntRange(intArr[0]-1, intArr[1]-1)).sortedArray()[intArr[2]-1]
        }.toIntArray()

        return answer
    }

    private fun Level_2_가장_큰_수(numbers: IntArray): String {
        var answer = ""

        val list = mutableListOf<String>()
        numbers.forEachIndexed { index, i ->
            if (i == 0) return@forEachIndexed
            var str = i.toString()
            numbers.forEachIndexed { index2, j ->
                if (index != index2) {
                    println("str 1 = $str")
                    str += j.toString()
                    list.add(str)
                    println("str 2 = $str")
                    str = i.toString()
                }
            }
        }
        list.forEach { print("$it ") }
        println()
        list.sortedDescending().forEach { print("$it ") }
        println()
        answer = list.sortedDescending()[0]

        return answer
    }
}