package com.example.lib.java.dfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class boj1987 {

    var n = 0
    var m = 0
    val visit = BooleanArray(26)
    var ans = -1
    lateinit var map: Array<CharArray>

    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    fun sol() {

        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())

        n = st.nextToken().toInt()
        m = st.nextToken().toInt()

        map = Array(n) { CharArray(m) }

        for (i in 0 until n) {
           val input = br.readLine()
            for (j in 0 until m) {
                map[i][j] = input[j]
            }
        }

        dfs(0, 0,1)

        println(ans)

    }

    private fun dfs(x: Int, y: Int, cnt : Int) {

        ans = cnt.coerceAtLeast(ans)

        visit[map[x][y] - 'A'] = true

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx in 0 until n && ny in 0 until m) {
                if(!visit[map[nx][ny]-'A']){
                    dfs(nx,ny,cnt+1)

                }
            }

        }

        visit[map[x][y] - 'A'] = false

    }

}

fun main() {
    Boj1987().sol()
}
