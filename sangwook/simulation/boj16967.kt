package src.main.kotlin.simulation

import java.lang.StringBuilder

class boj16967 {
    fun sol() {

        val (H, W, X, Y) = readLine()!!.split(" ").map { it.toInt() }
        val arr = Array(H + X) { IntArray(W + Y) }

        repeat(H + X) { i ->
            arr[i] = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
        }

        val ans = Array(H) { IntArray(W) }

        for(i in 0 until X){
            for(j in 0 until W){
                ans[i][j] = arr[i][j]
            }
        }

        for(i in 0 until Y){
            for(j in 0 until H){
                ans[j][i] = arr[j][i]
            }
        }

        for(i in X until H){
            for(j in Y until W){
                ans[i][j] = arr[i][j] - ans[i-X][j-Y]
            }
        }
        val sb = StringBuilder()
        for (i in ans.indices) {
            for (j in ans[i].indices) {
                sb.append(ans[i][j]).append(' ')
            }
            sb.append('\n')
        }

        println(sb.toString())
    }
}

fun main() {
    boj16967().sol()
}