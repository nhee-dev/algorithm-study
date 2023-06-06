package com.example.lib.java.dfs

import java.util.*

class boj6087 {
    var min = Int.MAX_VALUE
    lateinit var dist: Array<IntArray>
    fun sol() {

        val (m, n) = readLine()!!.split(" ").map { it.toInt() }
        val map = Array(n) { CharArray(m) { ' ' } }
        dist = Array(n) { IntArray(m) { -1 } }
        val targetPosition = arrayListOf<IntArray>()
        repeat(n) { i ->
            val line = readLine()!!
            repeat(m) { j ->
                map[i][j] = line[j]
                if (map[i][j] == 'C') {
                    targetPosition.add(intArrayOf(i, j))
                }
            }
        }

        bfs(map, targetPosition)
        println(dist[targetPosition[1][0]][targetPosition[1][1]] - 1)

    }

    private fun bfs(map: Array<CharArray>, targetPosition: ArrayList<IntArray>) {
        val dx = intArrayOf(1, 0, -1, 0)
        val dy = intArrayOf(0, 1, 0, -1)
        val q = LinkedList<Pair<Int, Int>>()
        q.offer(Pair(targetPosition[0][0], targetPosition[0][1]))
        val N = map.size
        val M = map[0].size
        dist[targetPosition[0][0]][targetPosition[0][1]] = 0

        while (q.isNotEmpty()) {

            val cur = q.poll()
            val cx = cur.first
            val cy = cur.second

            for (i in 0 until 4) {
                var nx = cx + dx[i]
                var ny = cy + dy[i]

                while (nx in 0 until N && ny in 0 until M) {
                    if (map[nx][ny] == '*') break
                    if (dist[nx][ny] == -1) {
                        dist[nx][ny] = dist[cx][cy] + 1
                        q.offer(Pair(nx, ny))
                    }
                    nx += dx[i]
                    ny += dy[i]
                }
            }
        }
    }
}


fun main() {
    boj6087().sol()
}