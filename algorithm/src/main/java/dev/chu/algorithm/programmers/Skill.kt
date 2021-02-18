package dev.chu.algorithm.programmers

import kotlin.math.sqrt

object Skill {
    @JvmStatic
    fun main(args: Array<String>) {
//        println(스킬체크테스트_레벨_1_문제_1(118372))  // 873211
//        println(스킬체크테스트_레벨_1_문제_2(121)) // 144
//        println(스킬체크테스트_레벨_1_문제_2(-3))  // -1

//        println(스킬체크테스트_레벨_2_문제_1("1924", 2))   // 94
//        println(스킬체크테스트_레벨_2_문제_1("1231234", 2))    // 31234
//        println(스킬체크테스트_레벨_2_문제_1("1231234", 3))    // 3234
//        println(스킬체크테스트_레벨_2_문제_1("1231234", 4))    // 334
//        println(스킬체크테스트_레벨_2_문제_1("1231234", 5))    // 34
//        println(스킬체크테스트_레벨_2_문제_1("4177252841", 1)) // 477252841
//        println(스킬체크테스트_레벨_2_문제_1("4177252841", 2)) // 77252841
//        println(스킬체크테스트_레벨_2_문제_1("4177252841", 3)) // 7752841
//        println(스킬체크테스트_레벨_2_문제_1("4177252841", 4)) // 775841
//        println(스킬체크테스트_레벨_2_문제_1("4177252841", 5)) // 77841

//        println(스킬체크테스트_레벨_2_문제_2("110010101001").forEach { print("$it ") })  // 3, 8
//        println(스킬체크테스트_레벨_2_문제_2("01110").forEach { print("$it ") }) // 3, 3
//        println(스킬체크테스트_레벨_2_문제_2("1111111").forEach { print("$it ") })   // 4, 1

//        println(스킬테스트_레벨_2_조이스틱("JAZ"))     // 11
//        println(스킬테스트_레벨_2_조이스틱("JEROEN"))  // 56
//        println(스킬테스트_레벨_2_조이스틱("JAN"))  // 23

        println(스킬테스트_레벨_2_소수("17"))    // 3 -> 7 17 71
        println(스킬테스트_레벨_2_소수("011"))   // 2 -> 11 101
    }

    fun 스킬테스트_레벨_2_소수(numbers: String): Int {
        if (numbers.length == 1) {
            return if (numbers == "2" || numbers == "3" || numbers == "5" || numbers == "7") 1 else 0
        }

        var answer = 0
        val max = numbers.toCharArray().sortedArrayDescending().joinToString("").toInt()
        val sqrtOfMax = Math.sqrt(max.toDouble()).toInt()

        val list = mutableListOf(0, 0)
        for (i in 2 .. max) {
            list.add(i)
        }

        for (i in 2 .. sqrtOfMax) {
            if (list[i] == 0) continue

            var j = 2*i
            while (j <= max) {
                list[j] = 0
                j += i
            }
        }

        val filterList = list.filter { it != 0 }.map { it.toString() }.toMutableList()

        numbers.forEach { c ->
            filterList.forEachIndexed { index2, s ->
                if (s.contains(c)) {
                    filterList[index2] = s.replaceFirst(c.toString(), "0")
                }
            }
        }

        answer = filterList.filter { it.toInt() == 0 }.size

        return answer
    }

    fun 스킬테스트_레벨_2_조이스틱(name: String): Int {
        var answer = 0
        /**
         * 위로 : 다음 알파벳
         * 아래로 : 이전 알파벳(A -> Z)
         * 왼쪽 : 커서를 왼쪽으로 이동(첫번째 위치에서 왼쪽으로 이동하면 마지막에 커서)
         * 오른쪽 : 커서를 오른쪽으로 이동
         *
         * 풀이 방법 :
         * 1. 첫 번째는 무조건 up or down 해서 작은 수
         * 2. 두 번째 부터는 right or left 해서 작은 수 구한 다음, 다시 1번
         */
        val alphas = mutableListOf<String>()
        for (i in 65 .. 90) {
            alphas.add(i.toChar().toString())
        }

//        println("up = "+up(name[0].toString(), alphas))
//        println("down = "+down(name[name.length-1].toString(), alphas))
        val midCount = name.length/2
        var rightCount = 0
        var leftCount = 0
        name.forEachIndexed { index, c ->
            when {
                index == 0 -> {
                    val a = upOrDown(c.toString(), alphas)
                    answer += a
                    println("a = $a")
                }
                index <= midCount -> {
                    if (c == 'A') return@forEachIndexed
                    rightCount++
                    answer++
                    val a = upOrDown(c.toString(), alphas)
                    answer += a
                    println("rightCount = $rightCount. a = $a")
                }
                else -> {
                    if (c == 'A') return@forEachIndexed
                    leftCount++
                    answer++
                    val b = upOrDown(c.toString(), alphas)
                    answer += b
                    println("leftCount = $leftCount. b = $b")
                }
            }
        }

        return answer
    }

    private fun upOrDown(str: String, alphas: MutableList<String>): Int {
        val upCount = up(str, alphas)
        val downCount = down(str, alphas)

        return if (upCount >= downCount) downCount else upCount
    }
    private fun up(str: String, alphas: MutableList<String>): Int {
        var count = 0
        alphas.forEach {
            if (it == str) {
                return count
            }
            count ++
        }
        return count
    }
    private fun down(str: String, alphas: MutableList<String>): Int {
        var count = 0
        for (i in alphas.size-1 downTo 0) {
            count ++
            if (alphas[i] == str) {
                return count
            }
        }
        return count
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