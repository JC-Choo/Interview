package dev.chu.algorithm.programmers

class SortKotlin {

    fun main() {
//        val arr = intArrayOf(1, 5, 2, 6, 3, 7, 4)
//        val arr2 = arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))
//        Level_1_K번째수(arr, arr2)

//        val numbers00 = intArrayOf(6, 10, 2)
//        val numbers01 = intArrayOf(3, 30, 34, 5, 9)
//        val numbers02 = intArrayOf(121, 12)
//        val numbers03 = intArrayOf(0, 0, 0, 0)
//        println(Level_2_가장_큰_수(numbers00))
//        println(Level_2_가장_큰_수(numbers01))
//        println(Level_2_가장_큰_수(numbers02))
//        println(Level_2_가장_큰_수(numbers03))

        val citations00 = intArrayOf(3, 0, 6, 1, 5)
        val citations01 = intArrayOf(10, 8, 5, 4, 3)
        val citations02 = intArrayOf(4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6)
        val citations03 = intArrayOf(10, 50, 100)
        val citations04 = intArrayOf(2, 2, 2)
        val citations05 = intArrayOf(10, 100)
        println("3 = "+Level2_H_index(citations00))
        println("4 = "+Level2_H_index(citations01))
        println("6 = "+Level2_H_index(citations02))
        println("3 = "+Level2_H_index(citations03))
        println("2 = "+Level2_H_index(citations04))
        println("2 = "+Level2_H_index(citations05))
    }

    private fun Level2_H_index(citations: IntArray): Int {
        citations.sortedDescending().forEachIndexed { index, i ->
            if (index >= i) {
                return index
            }
        }

        return citations.size
    }

    private fun Level_2_가장_큰_수(numbers: IntArray): String {
        var answer = ""

        numbers.map {
            it.toString()
        }.sortedWith(Comparator<String> { a, b ->
            (b + a).compareTo(a + b)
        }).forEachIndexed { index, s ->
            if (index == 0 && s == "0") {
                return "0"
            }
            answer+=s
        }

        return answer
    }

    private fun Level_1_K번째수(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf()

        // 풀이 1
        val list = mutableListOf<Int>()
        commands.forEach { intArr ->
            val i = intArr[0]
            val j = intArr[1]
            val k = intArr[2]

            val arr = array.copyOfRange(i-1, j)
            arr.sort()
            list.add(arr[k-1])
        }
        answer = list.toIntArray()

        // 풀이 2
        answer = commands.map { intArr ->
            array.sliceArray(IntRange(intArr[0]-1, intArr[1]-1)).sortedArray()[intArr[2]-1]
        }.toIntArray()

        return answer
    }
}