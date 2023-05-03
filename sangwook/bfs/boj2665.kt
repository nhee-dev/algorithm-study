package com.example.lib.java.dfs

import java.util.*

class boj2665 {
    var N = 0
    lateinit var map: Array<IntArray>
    lateinit var visit: Array<BooleanArray>
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    fun sol() {
        N = readLine()!!.toInt()
        map = Array(N) { IntArray(N) }
        visit = Array(N) { BooleanArray(N) }

        repeat(N) { i ->
            val line = readLine()!!
            repeat(N) { j ->
                map[i][j] = line[j] - '0'
            }
        }

        bfs()

    }

    fun bfs() {

        val q = PriorityQueue<Node>()
        q.offer(Node(0, 0, 0))
        visit[0][0] = true

        while (q.isNotEmpty()) {
            val cur = q.poll()

            if (cur.x == N - 1 && cur.y == N - 1) {
                println(cur.cnt)
                return
            }

            for (i in 0 until 4) {
                val nx = cur.x + dx[i]
                val ny = cur.y + dy[i]

                if (!(nx in 0 until N && ny in 0 until N)) {
                    continue
                }

                if (visit[nx][ny]) {
                    continue
                }
                visit[nx][ny] = true

                if (map[nx][ny] == 0) {
                    q.offer(Node(nx, ny, cur.cnt+1))
                }else{
                    q.offer(Node(nx, ny, cur.cnt))
                }
            }
        }

    }

    data class Node(val x: Int, val y: Int, var cnt: Int) : Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return this.cnt - other.cnt
        }
    }
}

fun main() {
    boj2665().sol()
}