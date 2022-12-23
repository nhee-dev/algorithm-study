package com.example.lib.java.dfs

import java.util.*

class boj9470 {

    fun sol() {
        val t = readLine()!!.toInt()
        repeat(t) {

            val (k, m, p) = readLine()!!.split(" ").map { it.toInt() }

            val toList = Array(m + 1) { arrayListOf<Int>() }
            val fromList = Array(m + 1) { arrayListOf<Int>() }
            val nodeList = Array(m + 1) { Node(1) }

            repeat(p) {
                val (s, e) = readLine()!!.split(" ").map { it.toInt() }

                toList[s].add(e)
                fromList[e].add(s)
            }

            val ans = bfs(toList, fromList, nodeList)

            println("$k $ans")
        }

    }

    fun bfs(
        toList: Array<ArrayList<Int>>,
        fromList: Array<ArrayList<Int>>,
        nodeList: Array<Node>
    ): Int {

        var strahler = -1
        val q = LinkedList<Int>()

        for (i in fromList.indices) {
            if (fromList[i].isEmpty()) {
                q.offer(i)
            }
        }

        while (q.isNotEmpty()) {

            val cur = q.poll()

            for (next in toList[cur]) {

                var max = -1
                var cnt = 0

                for (pre in fromList[next]) {
                    if (nodeList[pre].order < max) {
                        continue
                    }
                    if (nodeList[pre].order == max) {
                        cnt++
                        continue
                    }
                    cnt = 1
                    max = nodeList[pre].order

                }
                if (cnt >= 2) {
                    nodeList[next].order = max + 1

                } else {
                    nodeList[next].order = max
                }

                strahler = maxOf(strahler, nodeList[next].order)
                q.offer(next)
            }

        }
        return strahler
    }

    data class Node(var order: Int)
}

fun main() {
    boj9470().sol()
}