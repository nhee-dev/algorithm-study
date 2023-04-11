package com.example.lib.kotlin.kakao.dijkstra

class boj1774 {
    var N = 0
    var M = 0
    lateinit var gods: Array<God>
    val roadList = mutableListOf<Road>()
    lateinit var parent: IntArray

    fun sol() {

        val (n, m) = readLine()!!.split(" ").map { it.toInt() }
        N = n
        M = m
        gods = Array(N) { God(0, 0, 0) }

        repeat(N) { i ->
            val (x, y) = readLine()!!.split(" ").map { it.toInt() }
            gods[i] = God(i + 1, x, y)
        }

        for (i in gods.indices) {
            val first = gods[i]
            for (j in i + 1 until gods.size) {
                val second = gods[j]
                val weight = getDist(first, second)
                roadList.add(Road(first.num, second.num, weight))
            }

        }
        roadList.sort()

        parent = IntArray(N + 1) { it }

        repeat(M){
            val (a, b) = readLine()!!.split(" ").map { it.toInt() }

            union(a, b)
        }

        var res = 0.0
        roadList.forEach {
            val start = it.start
            val end = it.end
            val weight = it.weight

            if (find(start) != find(end)) {
                union(start, end)
                res += weight
            }
        }

        println(String.format("%.2f",res))

    }

    fun find(x: Int): Int {
        return if (x == parent[x]) {
            x
        } else {
            parent[x] = find(parent[x])
            parent[x]
        }
    }

    fun union(a: Int, b: Int) {
        val x = find(a)
        val y = find(b)

        if (x != y) {
            parent[y] = x
        }
    }

    fun getDist(first: God, second: God): Double {

        val dist =
            Math.sqrt(Math.pow((second.x - first.x.toDouble()), 2.0) + Math.pow((second.y - first.y).toDouble(), 2.0))

        return dist

    }

    data class God(val num: Int, val x: Int, val y: Int)
    data class Road(val start: Int, val end: Int, val weight: Double) : Comparable<Road> {
        override fun compareTo(other: Road): Int {
            return if (this.weight < other.weight) -1 else 1
        }
    }
}

fun main() {
    boj1774().sol()
}