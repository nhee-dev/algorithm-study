package com.example.lib.kotlin.kakao.dijkstra


class boj4386 {

    lateinit var points: Array<Point>
    val edgeList = arrayListOf<Edge>()
    lateinit var parent: IntArray
    fun sol() {

        val N = readLine()!!.toInt()
        points = Array(N) { Point(0, 0.0, 0.0) }
        parent = IntArray(N + 1) { it }
        repeat(N) { i ->
            val (x, y) = readLine()!!.split(" ").map { it.toDouble() }
            points[i] = Point(i, x, y)
        }

        for (i in points.indices) {
            val firstPoint = points[i]
            for (j in i + 1 until points.size) {
                val secondPoint = points[j]
                val weight = getWeight(firstPoint, secondPoint)
                edgeList.add(Edge(firstPoint.num, secondPoint.num, weight))
            }
        }

        edgeList.sort()

        var answer = 0.0
        edgeList.forEach {

            if (find(it.start) != find(it.end)) {
                answer += it.weight
                union(it.start, it.end)
            }
        }

        println(answer)

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
            if (a < b) {
                parent[b] = a
            } else {
                parent[a] = b
            }
        }


    }

    fun getWeight(firstPoint: Point, secondPoint: Point): Double {

        return Math.sqrt(Math.pow(secondPoint.x - firstPoint.x, 2.0) + Math.pow(secondPoint.y - firstPoint.y, 2.0))


    }
}

fun main() {

    boj4386().sol()

}

data class Point(val num: Int, val x: Double, val y: Double)
data class Edge(val start: Int, var end: Int, val weight: Double) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return if (this.weight < other.weight) -1 else 1
    }

}
