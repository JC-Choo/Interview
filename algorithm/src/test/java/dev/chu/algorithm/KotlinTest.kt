package dev.chu.algorithm

import org.junit.Test

class KotlinTest {
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