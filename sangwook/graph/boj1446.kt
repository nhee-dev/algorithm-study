package com.example.lib.kotlin.kakao.dijkstra

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class boj1446 {

    var N = 0
    var D = 0
    val shortCutPath = arrayListOf<ShortCut>()

    fun sol() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())

        N = st.nextToken().toInt()
        D = st.nextToken().toInt()

        for (i in 0 until N) {
            st = StringTokenizer(br.readLine())
            val start = st.nextToken().toInt()
            val end = st.nextToken().toInt()
            val dist = st.nextToken().toInt()

            if (end > D) {
                continue
            }

            if (end - start <= dist) {
                continue
            }
            shortCutPath.add(ShortCut(start, end, dist))

        }


        shortCutPath.sortWith(compareBy({ it.start }, { it.end }))

        println(shortCutPath)

        var move = 0
        val dist = IntArray(D + 1) { Int.MAX_VALUE }
        dist[0] = 0
        var idx = 0

        while (move < D) {
            if (idx < shortCutPath.size) {
                val sc = shortCutPath[idx]
                if (move == sc.start) {
                    dist[sc.end] = (dist[move] + sc.dist).coerceAtMost(dist[sc.end])
                    idx++
                } else {
                    dist[move + 1] = dist[move + 1].coerceAtMost(dist[move] + 1)
                    move++
                }
            } else {
                dist[move + 1] = dist[move + 1].coerceAtMost(dist[move] + 1)
                move++
            }
        }

        println(dist[D])

    }

}

data class ShortCut(var start: Int, var end: Int, var dist: Int)

fun main() {
    BOJ1446().sol()
}