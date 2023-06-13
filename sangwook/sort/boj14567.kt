package src.main.kotlin.sort

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

class boj14567 {
    fun sol() {
        val (N, M) = readLine()!!.split(" ").map { it.toInt() }
        val list = arrayListOf<ArrayList<Int>>()
        val degree = IntArray(N + 1)
        val ans = IntArray(N + 1)
        repeat(N + 1) {
            list.add(arrayListOf())
        }

        repeat(M) {
            val (a, b) = readLine()!!.split(" ").map { it.toInt() }
            list[a].add(b)
            degree[b]++
        }

        val q = LinkedList<Int>()

        for (i in 1..N) {
            if (degree[i] == 0) {
                q.offer(i)
            }
        }
        var cnt = 1
        while (q.isNotEmpty()) {
            val size = q.size
            for (i in 0 until size) {
                val cur = q.poll()
                ans[cur] = cnt

                for (next in list[cur]) {
                    degree[next]--
                    if (degree[next] == 0) {
                        q.offer(next)
                    }
                }

            }
            cnt++

        }

        val sb = StringBuilder()
        for(i in 1 until N+1){
            sb.append(ans[i]).append(' ')
        }
        println(sb.toString())

    }
}

fun main() {
    boj14567().sol()
}