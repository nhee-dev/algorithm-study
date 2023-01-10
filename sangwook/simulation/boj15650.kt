package src.main.kotlin.simulation

import java.lang.StringBuilder

class boj15650 {

    fun sol() {
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }
        val arr = IntArray(m)
        comb(0, 0, n, m, arr)
    }

    fun comb(cur: Int, start: Int, n: Int, m: Int, arr: IntArray) {

        if (cur == m) {
            val sb = StringBuilder()
            arr.forEach { sb.append(it).append(' ') }
            println(sb.toString())
            return
        }

        for (i in start until n) {
            arr[cur] = i + 1
            comb(cur + 1, i + 1, n, m, arr)
        }

    }
}

fun main() {
    boj15650().sol()
}