package com.example.lib.java.dfs

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

class boj15591 {

    lateinit var uMap: Array<ArrayList<LongArray>>
    lateinit var visit: Array<BooleanArray>
    fun sol() {
        val (n, q) = readLine()!!.split(" ").map { it.toInt() }


        uMap = Array(n + 1) { arrayListOf(longArrayOf(0, 0)) }
        visit = Array(n + 1) { BooleanArray(n + 1) }
        repeat(n - 1) {
            val (a, b, c) = readLine()!!.split(" ").map { it.toLong() }

            uMap[a.toInt()].add(longArrayOf(b, c))
            uMap[b.toInt()].add(longArrayOf(a, c))

        }

        val sb = StringBuilder()

        repeat(q) {
            val (K, V) = readLine()!!.split(" ").map { it.toLong() }
            val visit = BooleanArray(n + 1)
            visit[V.toInt()] = true
            val queue = LinkedList<Int>()
            queue.add(V.toInt())
            var cnt = 0

            while (queue.isNotEmpty()) {
                val cur = queue.poll()

                for (arr in uMap[cur]) {

                    if (visit[arr[0].toInt()]) continue

                    if (arr[1] < K) continue
                    queue.offer(arr[0].toInt())
                    visit[arr[0].toInt()] = true
                    cnt++

                }
            }

            sb.append(cnt).append('\n')
        }

        println(sb.toString())

    }

}

fun main() {
    boj15591().sol()
}