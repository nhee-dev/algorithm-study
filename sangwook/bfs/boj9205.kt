package com.example.lib.java.dfs

import java.lang.StringBuilder
import java.util.LinkedList

class boj9205 {
    val sb = StringBuilder()
    fun sol() {
        var t = readLine()!!.toInt()

        while (t-- > 0) {

            val N = readLine()!!.toInt()
            val list = arrayListOf<IntArray>()
            val graph = arrayListOf<ArrayList<Int>>()
            repeat(N + 2) {
                list.add(readLine()!!.split(" ").map { it.toInt() }.toIntArray())
            }

            for (i in 0 until N + 2) {
                graph.add(arrayListOf<Int>())
            }

            for (i in 0 until N + 2) {
                for (j in i + 1 until N + 2) {
                    val dist = getDist(list[i], list[j])

                    if (dist <= 1000) {
                        graph[i].add(j)
                        graph[j].add(i)
                    }
                }
            }

            bfs(N, graph)
            sb.append('\n')
        }
        println(sb.toString())
    }

    private fun bfs(N: Int, graph: ArrayList<ArrayList<Int>>) {

        val q = LinkedList<Int>()
        q.offer(0)

        val visit = BooleanArray(N + 2)
        visit[0] = true

        while (q.isNotEmpty()) {
            val cur = q.poll()

            if (cur == N + 1) {
                sb.append("happy")
                return
            }

            for (next in graph[cur]) {
                if (visit[next]) continue
                visit[next] = true
                q.offer(next)
            }
        }

        sb.append("sad")
    }

    private fun getDist(p1: IntArray, p2: IntArray): Int {

        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1])
    }

}

fun main() {
    boj9205().sol()
}