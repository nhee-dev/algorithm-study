package com.example.lib.recur

class boj2661 {

    fun sol() {
        val N = readLine()!!.toInt()

        go(N, 1, "1")

    }

    fun go(N: Int, depth: Int, cur: String) {

        if (depth != 1) {
            if (!checkGood(cur)) {
                return
            }
        }

        if (depth == N) {
            println(cur)
            System.exit(0)
        }
        go(N, depth + 1, cur + "1")
        go(N, depth + 1, cur + "2")
        go(N, depth + 1, cur + "3")

    }

    fun checkGood(str: String): Boolean {

        val len = str.length
        val m = str.length / 2

        for (i in 1..m) {
            val first = str.substring(len - 2 * i, len - 1 * i)
            val second = str.substring(len - 1 * i, len)
            if (first == second) {
                return false
            }
        }
        return true

    }

}

fun main() {
    boj2661().sol()
}