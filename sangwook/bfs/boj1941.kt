package com.example.lib.java.dfs

import java.util.LinkedList

class boj1941 {

    val map = Array(5) { CharArray(5) }
    var ans = 0
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    val princessArr = IntArray(7)
    val pointVisit = BooleanArray(25)
    fun sol() {
        repeat(5) { i ->
            val line = readLine()!!.toCharArray()
            map[i] = line
        }

        comb(0, 0)

        println(ans)

    }

    fun comb(cur: Int, start: Int) {

        if (cur == 7) {

            if (!getYCount()) {
                return
            }

            if (!checkNear()) {
                return

            }
            ans++
            return
        }

        for (i in start until 25) {
            princessArr[cur] = i
            pointVisit[i] = true
            comb(cur + 1, i + 1)
            pointVisit[i] = false
        }


    }

    private fun checkNear(): Boolean {

        val q = LinkedList<Int>()
        q.offer(princessArr[0])
        val visit = BooleanArray(25)
        visit[princessArr[0]] = true

        var cnt = 1

        while (q.isNotEmpty()) {
            val cur = q.poll()

            val x = cur / 5
            val y = cur % 5

            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if (!(nx in 0..4 && ny in 0..4)) {
                    continue
                }

                if(!pointVisit[nx * 5 + ny]){
                    continue
                }
                if (visit[nx * 5 + ny]) {
                    continue
                }

                visit[nx * 5 + ny] = true
                q.offer(nx * 5 + ny)
                cnt++

            }
        }

        if(cnt == 7){
            return true
        }

        return false

    }

    private fun getYCount(): Boolean {
        var yCnt = 0
        princessArr.forEach {
            val x = it / 5
            val y = it % 5

            when (map[x][y]) {
                'Y' -> yCnt++
            }

            if (yCnt >= 4) {
                return false
            }
        }
        return true
    }

}

fun main() {
    boj1941().sol()
}