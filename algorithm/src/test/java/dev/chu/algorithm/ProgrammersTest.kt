package dev.chu.algorithm

import dev.chu.algorithm.programmers.Hash
import dev.chu.algorithm.programmers.HashKotlin
import org.junit.Test

class ProgrammersTest {

    @Test
    fun 위장() {
        val test00 = arrayOf(arrayOf("yellow_hat", "headgear"), arrayOf("blue_sunglasses", "eyewear"), arrayOf("green_turban", "headgear"))
        val test01 = arrayOf(arrayOf("crow_mask", "face"), arrayOf("blue_sunglasses", "face"), arrayOf("smoky_makeup", "face"))

        val hash = HashKotlin()
        println(hash.위장(test00))
        println(hash.위장(test01))
    }

    @Test
    fun 전화번호_목록() {
        val test00 = arrayOf("119", "97674223", "1195524421")
        val test01 = arrayOf("123", "456", "789")
        val test02 = arrayOf("12", "123", "1235", "567", "88")

        val hash = Hash()
        println(hash.전화번호_목록(test00))
        println(hash.전화번호_목록(test01))
        println(hash.전화번호_목록(test02))
    }
}