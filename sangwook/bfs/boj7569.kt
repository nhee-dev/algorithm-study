package com.example.lib.java.dfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class boj7569 {

    val dx = intArrayOf(0, 0, 1, 0, -1, 0)
    val dy = intArrayOf(0, 0, 0, 1, 0, -1)
    val dz = intArrayOf(-1, 1, 0, 0, 0, 0)
    fun sol() = with(BufferedReader(InputStreamReader(System.`in`))) {

        var st = StringTokenizer(readLine())
        val M = st.nextToken().toInt()
        val N = st.nextToken().toInt()
        val H = st.nextToken().toInt()
        val map = Array(H) { Array(N) { IntArray(M) } }

        val q = LinkedList<IntArray>()

        var originZeroCnt = 0
        repeat(H) { h ->
            repeat(N) { i ->
                st = StringTokenizer(readLine())
                repeat(M) { j ->
                    map[h][i][j] = st.nextToken().toInt()
                    if (map[h][i][j] == 1) {
                        q.offer(intArrayOf(h, i, j))
                    } else if (map[h][i][j] == 0) {
                        originZeroCnt++
                    }
                }
            }
        }

        if (originZeroCnt == 0) {
            println(0)
            return
        }

        var zeroCnt = 0
        var cnt = 0
        while (q.isNotEmpty()) {
            val size = q.size

            repeat(size) {

                val cur = q.poll()
                val cz = cur[0]
                val cx = cur[1]
                val cy = cur[2]

                for (i in 0 until 6) {
                    val nx = cx + dx[i]
                    val ny = cy + dy[i]
                    val nz = cz + dz[i]

                    if (!(nx in 0 until N && ny in 0 until M && nz in 0 until H)) continue
                    if (map[nz][nx][ny] != 0) continue

                    map[nz][nx][ny] = 1
                    zeroCnt++
                    q.offer(intArrayOf(nz, nx, ny))

                }
            }
            cnt++
        }

        if (originZeroCnt == zeroCnt) {
            println(cnt - 1)
        } else {
            println(-1)
        }

    }
}

fun main() {
    boj7569().sol()
}