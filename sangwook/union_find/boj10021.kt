package src.main.kotlin.union_find

import java.util.PriorityQueue

class boj10021 {
    var N = 0
    var C = 0
    lateinit var parent: IntArray
    fun sol() {

        val arr = arrayListOf<IntArray>()
        val (n, c) = readLine()!!.split(" ").map { it.toInt() }
        N = n
        C = c
        parent = IntArray(N) { it }
        repeat(N) {
            val (x, y) = readLine()!!.split(" ").map { it.toInt() }
            arr.add(intArrayOf(x, y))
        }

        val pq = PriorityQueue<Triple<Int,Int,Int>>(compareBy { it.third })

        for (i in 0 until arr.size) {
            val first = arr[i]
            for (j in i until arr.size) {
                val second = arr[j]
                val dist = getDist(first, second)

                if (dist >= C) pq.offer(Triple(i, j, dist))
            }
        }
        var ans = 0
        var count = 0
        while (pq.isNotEmpty()) {
            val cur = pq.poll()
            if (find(cur.first) != find(cur.second)) {
                union(cur.first, cur.second)
                ans += cur.third
                count++

            }
        }
        if (count < N - 1) println(-1)
        else println(ans)

    }

    private fun getDist(first: IntArray, second: IntArray): Int {

        return (Math.pow((first[0] - second[0]).toDouble(), 2.0) + Math.pow((first[1] - second[1]).toDouble(), 2.0)).toInt()
    }

    fun find(a: Int): Int {
        if (parent[a] == a) return a
        parent[a] = find(parent[a])
        return parent[a]
    }

    fun union(a: Int, b: Int) {
        val x = find(a)
        val y = find(b)
        if (x < y) parent[y] = x
        else parent[x] = y
    }


}

fun main() {
    boj10021().sol()
}

