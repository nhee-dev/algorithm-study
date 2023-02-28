package src.main.kotlin.greedy

import kotlin.math.abs

class boj1107 {
    fun sol() {

        val N = readLine()!!.toInt()
        val M = readLine()!!.toInt()
        val brokenNum =
            if (M != 0) readLine()!!.split(" ").map { it.toInt() }.toIntArray() else intArrayOf()
        val isBroken = BooleanArray(10)

        if (N == 100) {
            println(0)
            return
        }

        if (brokenNum.isNotEmpty()) {
            brokenNum.forEach {
                isBroken[it] = true
            }
        }


        var ans = abs(N - 100)

        for (i in 0..1000000) {
            val num = i.toString()

            var flag = true

            for (j in num.indices) {
                val char = num[j]
                if (isBroken[char - '0']) {
                    flag = false
                    break
                }
            }

            if (flag) {
                val cnt = num.length + abs(i - N)
                ans = minOf(ans, cnt)
            }
        }


        println(ans)
    }
}

fun main() {
    boj1107().sol()
}