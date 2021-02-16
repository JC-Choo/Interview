package dev.chu.algorithm.programmers

import kotlin.math.sqrt

object Skill {
    @JvmStatic
    fun main(args: Array<String>) {
        println(스킬체크테스트_레벨_1_문제_1(118372))  // 873211
        println(스킬체크테스트_레벨_1_문제_2(121)) // 144
        println(스킬체크테스트_레벨_1_문제_2(-3))  // -1
    }

    fun 스킬체크테스트_레벨_1_문제_2(n: Long): Long {
        val a = sqrt(n.toDouble()).toLong()
        return if (a * a == n) (a + 1) * (a + 1) else -1
    }

    fun 스킬체크테스트_레벨_1_문제_1(n: Long): Long {
        return n.toString().toCharArray().sortedDescending().joinToString("").toLong()
    }
}