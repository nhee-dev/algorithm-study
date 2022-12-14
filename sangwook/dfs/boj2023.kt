package src.main.kotlin.dfs

import java.lang.StringBuilder
import kotlin.math.sqrt

class boj2023 {
    var N = 0
    val list = arrayListOf<Int>()
    fun sol() {
        N = readLine()!!.toInt()

        for (i in 1..9) {
            if (isPrime(i)) {
                dfs(i * 10, 1)
            }
        }

        val sb = StringBuilder()
        for (primeNum in list) {
            sb.append(primeNum).append("\n")
        }
        println(sb.toString())
    }

    fun dfs(num: Int, size: Int) {

        if (size == N) {
            list.add(num / 10)
            return
        }

        for (i in 1..9) {
            val nNum = num + i
            if (isPrime(nNum)) {
                dfs(nNum * 10, size + 1)
            }
        }

    }

    fun isPrime(num: Int): Boolean {

        if (num == 2) {
            return true
        }

        if (num == 1 || num % 2 == 0) {
            return false
        }

        val sqrt = sqrt(num.toDouble()).toInt()

        for (i in 3..sqrt) {
            if (num % i == 0) {
                return false
            }
        }

        return true
    }
}

fun main() {
    boj2023().sol()
}