package dev.chu.algorithm.programmers

import java.nio.file.Files.size
import kotlin.math.sqrt

/**
 * 완전 탐색(BP : Brute-Force Search or Exhaustive Search)
 */
object BruteForceSearchKotlin {
    @JvmStatic
    fun main(args: Array<String>) {
        Level_1_모의고사(intArrayOf(1, 2, 3, 4, 5))
        Level_1_모의고사(intArrayOf(1, 3, 2, 4, 2))
        Level_1_모의고사(intArrayOf(3, 2, 4, 2, 1, 5, 2, 4))

        println("8 = " + solution("8"))
        println("17 = " + solution("31"))
        println("011 = " + solution("011"))

        Level_2_카펫(10, 2).forEach { print("$it ") }
        println()
        Level_2_카펫(8, 1).forEach { print("$it ") }
        println()
        Level_2_카펫(24, 24).forEach { print("$it ") }
        println()
        Level_2_카펫(14, 4).forEach { print("$it ") }
        println()
        Level_2_카펫(18, 6).forEach { print("$it ") }
        println()
    }

    fun Level_2_카펫(brown: Int, yellow: Int): IntArray {
        val sum = brown + yellow
        val half = sqrt(sum.toFloat()).toInt()
        val divisors = mutableListOf<Int>()
        for (i in 1..half) {
            if (sum % i == 0) {
                divisors.add(i)
                divisors.add(sum / i)
            }
        }

        return setResult2(divisors.sorted().toSet(), yellow)
    }

    fun setResult2(set: Set<Int>, yellow: Int): IntArray {
        val mid = set.size / 2
        if (set.size % 2 == 0) {
            var index = mid
            for (i in mid until set.size) {
                index -= 1
                if ((set.elementAt(i) - 2) * (set.elementAt(index) - 2) == yellow) {
                    return intArrayOf(set.elementAt(i), set.elementAt(index))
                }
            }
        } else {
            return intArrayOf(set.elementAt(mid), set.elementAt(mid)).sortedArrayDescending()
        }
        return intArrayOf()
    }

    // region 누군가 푼 거
    fun setResult(brown: Int, yellow: Int): IntArray {
        return (1..yellow).filter {
            yellow % it == 0
        }.first {
            brown == (yellow / it * 2) + (it * 2) + 4
        }.let {
            intArrayOf(yellow / it + 2, it + 2)
        }
    }
    // endregion

    fun Level_2_소수찾기(numbers: String): Int {
        if (numbers.length == 1) {
            return if (numbers == "2" || numbers == "3" || numbers == "5" || numbers == "7") 1 else 0
        }

        val maxValue = numbers.toCharArray().sortedArrayDescending().joinToString("").toInt()
        val sqrtOfMax = sqrt(maxValue.toFloat()).toInt()

        var answer = 0

        val list = mutableListOf(0, 0)
        for (i in 2..maxValue) {
            list.add(i)
        }

        for (i in 2..sqrtOfMax) {
            if (list[i] == 0) continue

            var j = 2 * i
            while (j <= maxValue) {
                list[j] = 0
                j += i
            }
        }

        val filterList = list.filter { it != 0 }.map { it.toString() }.toMutableList()

        numbers.toCharArray().forEach { ch ->
            filterList.forEachIndexed { index2, i ->
                if (i.contains(ch)) {
                    filterList[index2] = i.replaceFirst(ch.toString(), "0")
                }
            }
        }

        filterList.forEach {
            if (it.toInt() == 0) {
                answer++
            }
        }

        return answer
    }

    // region [소수찾기 남의 풀이]
    lateinit var combNumbers: MutableList<Int>
    fun solution(numbers: String): Int {
        var answer = 0
        combNumbers = mutableListOf()

        temp(numbers, "")

        combNumbers.distinct().forEach {
            if (isPrime(it)) {
                answer++
            }
        }
        return answer
    }

    fun temp(numbers: String, result: String) {
        if (result.isNotEmpty()) {
            combNumbers.add(result.toInt())
        }

        if (numbers.isEmpty()) {
            return
        }
        numbers.forEachIndexed { index, c ->
            temp((numbers.removeRange(index..index)), result + c)
        }
    }

    fun isPrime(num: Int): Boolean {

        if (num == 1 || num == 0) {
            return false
        }
        for (i in 2..num / 2) {
            if (num % i == 0) {
                return false
            }
        }
        return true
    }
    // endregion

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
            if (i == test01[index % 5]) map[1] = map[1]!! + 1
            if (i == test02[index % 8]) map[2] = map[2]!! + 1
            if (i == test03[index % 10]) map[3] = map[3]!! + 1
        }

        val max = map.maxByOrNull { // 프로그래머스 답 사용 시 maxBy 이용
            it.value
        }?.value
        for (i in 1..map.size) {
            if (map[i] != max) map.remove(i)
        }
        answer = map.toList().sortedWith(compareBy {
            it.second
        }).toMap().keys.toIntArray()

        return answer
        // endregion
    }
}