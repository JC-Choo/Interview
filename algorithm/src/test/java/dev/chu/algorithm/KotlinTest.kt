package dev.chu.algorithm

import org.junit.Test

class KotlinTest {
    @Test
    fun testPalindrome() {
        println("Hello".isPalindrome()) // print false
        println("LoL".isPalindrome()) // print true
    }

    fun String.isPalindrome() = this == reversed()

    @Test
    fun test() {
        val test00 = arrayOf("cc", "aaaa", "bbb")
        println(test00.sortedWith(Comparator<String> { a, b ->
            print("a = $a, b = $b, ")
            val c = a.length.compareTo(b.length)
            print("c = $c\n")
            c
        }))
    }
}