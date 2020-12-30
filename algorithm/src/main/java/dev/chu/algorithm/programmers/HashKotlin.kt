package dev.chu.algorithm.programmers

import android.os.Build
import androidx.annotation.RequiresApi
import kotlin.math.pow

class HashKotlin {
    @RequiresApi(Build.VERSION_CODES.N)
    fun 위장(clothes: Array<Array<String>>): Int {
        var answer = 1

        val map = HashMap<String, Int>()
        clothes.forEach {
            map[it[1]] = map.getOrDefault(it[1], 0)+1
        }

        for (value in map.values) {
            answer *= (value+1)
        }


        return answer-1
    }
}