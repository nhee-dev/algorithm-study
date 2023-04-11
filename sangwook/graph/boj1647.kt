package com.example.lib.kotlin.kakao.dijkstra

class boj1647 {
    var N = 0
    var M = 0
    val edgeList = mutableListOf<Edge>()
    lateinit var parent: IntArray

    fun sol() {
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }
        N = n
        M = m
        parent = IntArray(N + 1) { it }
        repeat(M) {
            val (s, e, w) = readLine()!!.split(" ").map { it.toInt() }
            edgeList.add(Edge(s, e, w))
        }

        edgeList.sort()
        val weightList = arrayListOf<Int>()

        edgeList.forEach {
            val x = it.start
            val y = it.end
            val w = it.weight

            if (find(x) != find(y)) {
                union(x, y)
                weightList.add(w)
            }
        }

        val sum = weightList.sum() - weightList.last()
        println(sum)

    }

    fun find(x: Int): Int {
        return if (x == parent[x]) {
            x
        } else {
            parent[x] = find(parent[x])
            parent[x]
        }

    }

    fun union(x: Int, y: Int) {
        val a = find(x)
        val b = find(y)

        if (a != b) {
            parent[b] = a
        }
    }


    data class Edge(val start: Int, val end: Int, val weight: Int) : Comparable<Edge> {
        override fun compareTo(other: Edge): Int {
            return this.weight - other.weight
        }
    }
}


fun main() {
    boj1647().sol()
}
