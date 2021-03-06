package dev.chu.algorithm

object TmonTest {
    @JvmStatic
    fun main(args: Array<String>) {
        q01()
        q02()
    }

    /**
     * 앞에서부터 읽을 때나 뒤에서부터 읽을 때나 모양이 같은 수를 대칭수라고 부릅니다.
     * 두 자리 수를 곱해 만들 수 있는 대칭수 중 가장 큰 수는 9009=(91x99)입니다.
     * 세 자리 수를 곱해 만들 수 있는 가장 큰 대칭수는 얼마인가를 구하는 프로그램을 작성하고 답을 출력하세요.
     * (작성 개발 언어는 무관)
     */
    private fun q01() {
        val list = mutableListOf<String>()
        for (i in 100 until 1000) {
            for (j in 100 until 1000) {
                val value = i * j
                val str = value.toString()
                if (str.length == 6) {
                    if (str == str.reversed()) {
                        list.add(str)
                    }
                }
            }
        }
        val result = list.sortedDescending()[0]
        println("result = $result")
    }

    /**
     * 피보나치 수열의 각 숫자는 앞의 두 숫자를 더하여 만들어집니다. 1과 2로 시작하는 처음 10개의 숫자는 아래와 같습니다.
     * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
     * 500,000을 넘지 않는 피보나치 수 중 홀수의 합을 구하여 출력하는 프로그램을 작성하세요.
     * (개발 언어는 무관)
     */

    private fun q02() {
        val list = mutableListOf(1, 2)

        var index = 2
        var result = 0
        while (result < 500_000) {
            result = list[index - 1] + list[index - 2]
            list.add(result)
            index++
        }

        val sum = list.filter {
            it < 500_000
        }.filter {
            it%2 == 1
        }.sum()
        println("sum = $sum")
    }
}