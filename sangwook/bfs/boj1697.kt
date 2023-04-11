package com.example.lib.java.dfs

import java.util.LinkedList

class boj1697 {
    fun sol() {
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }

        val visit = BooleanArray(100001)

        bfs(n, m, visit)

    }

    fun bfs(n: Int, m: Int, visit: BooleanArray) {

        val q = LinkedList<Int>()
        q.offer(n)

        var cnt = 0
        while (q.isNotEmpty()) {
            val size = q.size

            for (i in 0 until size) {

                val cur = q.poll()

                if(cur == m){
                    println(cnt)
                    return
                }

                if(visit[cur]){
                    continue
                }

                visit[cur] = true

                if(cur-1 >= 0){
                    q.offer(cur-1)
                }

                if(cur+1 <= 100000){
                    q.offer(cur+1)
                }

                if(cur*2 <= 100000){
                    q.offer(cur*2)
                }

            }
            cnt++
        }

    }
}

fun main() {
    boj1697().sol()
}