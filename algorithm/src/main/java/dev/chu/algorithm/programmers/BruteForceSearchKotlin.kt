package dev.chu.algorithm.programmers

/**
 * 완전 탐색(BP : Brute-Force Search or Exhaustive Search)
 */
object BruteForceSearchKotlin {
    @JvmStatic
    fun main(args: Array<String>) {
        Level_1_모의고사(intArrayOf(1, 2, 3, 4, 5))
        Level_1_모의고사(intArrayOf(1, 3, 2, 4, 2))
        Level_1_모의고사(intArrayOf(3, 2, 4, 2, 1, 5, 2, 4))
    }

    fun Level_1_모의고사(answers: IntArray): IntArray {
        var answer = intArrayOf()

        val test01 = arrayOf(1, 2, 3, 4, 5)
        val test02 = arrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val test03 = arrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

        // region [내가 푼 풀이]
//        val map = hashMapOf<Int, Int>()
//        answers.forEachIndexed { index, i ->
//            if (i == test01[index%5]) map[1] = map.getOrDefault(1, 0) + 1
//            if (i == test02[index%8]) map[2] = map.getOrDefault(2, 0) + 1
//            if (i == test03[index%10]) map[3] = map.getOrDefault(3, 0) + 1
//        }
//        var max = Int.MIN_VALUE
//        map.entries.forEach {
//            if (max < it.value) {
//                max = it.value
//            }
//        }
//        val result = mutableListOf<Int>()
//        map.entries.forEach {
//            if (it.value == max) {
//                result.add(it.key)
//            }
//        }
//
//        answer = result.toIntArray()
//        return answer
        // endregion

        // region [남이 푼 풀이]
        val map = mutableMapOf(Pair(1, 0), Pair(2, 0), Pair(3, 0))
        answers.forEachIndexed { index, i ->
            if (i == test01[index%5]) map[1] = map[1]!! + 1
            if (i == test02[index%8]) map[2] = map[2]!! + 1
            if (i == test03[index%10]) map[3] = map[3]!! + 1
        }

        val max = map.maxByOrNull { // 프로그래머스 답 사용 시 maxBy 이용
            it.value
        }?.value
        for (i in 1 .. map.size) {
            if (map[i] != max)
                map.remove(i)
        }
        answer = map.toList().sortedWith(compareBy {
            it.second
        }).toMap().keys.toIntArray()

        return answer
        // endregion
    }
}