package dev.chu.algorithm.programmers

import kotlin.math.sqrt

object Skill {
    @JvmStatic
    fun main(args: Array<String>) {
//        println(스킬체크테스트_레벨_1_문제_1(118372))  // 873211
//        println(스킬체크테스트_레벨_1_문제_2(121)) // 144
//        println(스킬체크테스트_레벨_1_문제_2(-3))  // -1

        println(스킬체크테스트_레벨_2_문제_1("1924", 2))   // 94
        println(스킬체크테스트_레벨_2_문제_1("1231234", 3))    // 3234
        println(스킬체크테스트_레벨_2_문제_1("4177252841", 4)) // 775841

//        println(스킬체크테스트_레벨_2_문제_2("110010101001").forEach { print("$it ") })  // 3, 8
//        println(스킬체크테스트_레벨_2_문제_2("01110").forEach { print("$it ") }) // 3, 3
//        println(스킬체크테스트_레벨_2_문제_2("1111111").forEach { print("$it ") })   // 4, 1
    }

    fun 스킬체크테스트_레벨_2_문제_2(s: String): IntArray {
        return 스킬체크테스트_레벨_2_문제_2_fun(s, intArrayOf(0, 0))
    }

    private fun 스킬체크테스트_레벨_2_문제_2_fun(s: String, count: IntArray): IntArray {
        val x = s.toCharArray().map {
            it.toString()
        }.filter {
            val isNotZero = it != "0"
            if (!isNotZero) {
                count[0] = count[0] + 1
            }
            isNotZero
        }


        val c = x.size
        val binary = c.toString(2)
        count[1] = count[1]+1
        if (binary != "1") {
            스킬체크테스트_레벨_2_문제_2_fun(binary, count)
        }

        return intArrayOf(count[1], count[0])
    }

    // number 의 개수 중 k개를 뺀 나머지 숫자 중 가장 큰거
    fun 스킬체크테스트_레벨_2_문제_1(number: String, k: Int): String {
        val arr = number.split("").filter { it.isNotEmpty() }.map {
            it.toInt()
        }.toIntArray()
        val visited = BooleanArray(arr.size)

        val result = mutableListOf<Int>()
        combination(arr, visited, 0, arr.size, arr.size-k, result)
        result.sortedDescending().forEach { print("$it ") }
        println()
        val answer = result.sortedDescending()[0]

        return answer.toString()
    }

    private fun combination(arr: IntArray, visited: BooleanArray, start: Int, size: Int, count: Int, result: MutableList<Int>) {
        if (count == 0) {
            var str = ""
            for (i in 0 until size) {
                if (visited[i]) {
                    str += arr[i]
                }
            }
            result.add(str.toInt())
            return
        }

        for (i in start until size) {
            visited[i] = true
            combination(arr, visited, i+1, size, count-1, result)
            visited[i] = false
        }
    }

    fun 스킬체크테스트_레벨_1_문제_2(n: Long): Long {
        val a = sqrt(n.toDouble()).toLong()
        return if (a * a == n) (a + 1) * (a + 1) else -1
    }

    fun 스킬체크테스트_레벨_1_문제_1(n: Long): Long {
        return n.toString().toCharArray().sortedDescending().joinToString("").toLong()
    }
}