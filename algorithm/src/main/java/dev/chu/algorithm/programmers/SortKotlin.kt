package dev.chu.algorithm.programmers

class SortKotlin {

    fun main() {
//        val arr = intArrayOf(1, 5, 2, 6, 3, 7, 4)
//        val arr2 = arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))
//        Level_1_K번째수(arr, arr2)


        val numbers00 = intArrayOf(6, 10, 2)
        val numbers01 = intArrayOf(3, 30, 34, 5, 9)
//        println(Level_2_가장_큰_수(numbers00))
        println(Level_2_가장_큰_수(numbers01))
    }

    private fun Level_2_가장_큰_수(numbers: IntArray): String {
        var answer = ""

        var list = mutableListOf<Int>()
        for (i in numbers.indices) {
            var sum = numbers[i].toString()
            for (j in numbers.indices) {
                if (i != j) {
                    println("1 i = $i j = $j sum = $sum")
                    sum += numbers[j].toString()
                }
            }
            println("1 result sum = $sum")
            list.add(sum.toInt())

            sum = numbers[i].toString()
            for (j in numbers.size-1 downTo 0) {
                if (i != j) {
                    sum += numbers[j].toString()
                }
            }
            println("2 result sum = $sum")
            list.add(sum.toInt())
        }

        list.forEach { print("$it ") }
        println("sorted")
        list.sortedDescending().forEach { print("$it ") }

        return answer
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
}