package com.example.lib.java.dfs

import java.util.LinkedList

class boj2206 {
    lateinit var map: Array<IntArray>
    lateinit var visit: Array<Array<BooleanArray>>
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    fun sol() {
        val (N, M) = readLine()!!.split(" ").map { it.toInt() }
        map = Array(N) { IntArray(M) }
        visit = Array(N) { Array(M) { BooleanArray(2) } }
        repeat(N) { i ->
            val line = readLine()!!
            repeat(M) { j ->
                map[i][j] = line[j] - '0'

            }
        }

        val dist = bfs(N, M)

        println(dist)
    }

    fun bfs(N: Int, M: Int): Int {

        val q = LinkedList<Position>()
        q.offer(Position(0,0,0))
        var cnt = 1
        while (q.isNotEmpty()) {
            val size = q.size

            for (i in 0 until size) {
                val cur = q.poll()
                val cx = cur.x
                val cy = cur.y
                val broken = cur.broken

                if (cx == N - 1 && cy == M - 1) {
                    return cnt
                }

                for (j in 0 until 4) {
                    val nx = cx + dx[j]
                    val ny = cy + dy[j]

                    if (!(nx in 0 until N && ny in 0 until M)) {
                        continue
                    }

                    if(map[nx][ny] == 0){
                        if(visit[nx][ny][broken]){
                            continue
                        }

                        visit[nx][ny][broken] = true
                        q.offer(Position(nx,ny,broken))

                    }else{
                        if(broken == 1){
                            continue
                        }
                        if(visit[nx][ny][1]){
                            continue
                        }
                        visit[nx][ny][1] = true

                        q.offer(Position(nx,ny,1))

                    }

                }
            }
            cnt++

        }

        return -1

    }
    data class Position(val x : Int, val y : Int,val broken : Int)
}

fun main() {
    boj2206().sol()
}