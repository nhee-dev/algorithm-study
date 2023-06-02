package com.example.lib.kotlin.kakao.dijkstra

import java.lang.StringBuilder

class boj16918 {

    fun sol() {
        val (R, C, N) = readLine()!!.split(" ").map { it.toInt() }

        val arr = Array(R) { CharArray(C) { ' ' } }

        val timeArr = Array(R) { IntArray(C) { -1 } }

        repeat(R) { r ->
            val input = readLine()!!
            repeat(C) { c ->
                arr[r][c] = input[c]
                if (arr[r][c] == 'O') {
                    timeArr[r][c] = 0
                }
            }

        }

        var t = 1

        while (t < N) {
            t++
            if (t % 2 == 0) {
                makeBomb(arr, timeArr, t)
            } else {
                val visit = Array(R) { BooleanArray(C) }
                for (i in timeArr.indices) {
                    for (j in timeArr[i].indices) {
                        if (t - timeArr[i][j] >= 3) {
                           visit[i][j] = true
                        }
                    }
                }

                for( i in visit.indices){
                    for(j in visit[i].indices){
                        if(visit[i][j]){
                            explodeBomb(i,j,arr,timeArr)
                        }
                    }
                }

            }

        }
        val sb = StringBuilder()
        arr.forEach {
            sb.append(it).append('\n')
        }

        println(sb.toString())

    }


    private fun explodeBomb(x: Int, y: Int, arr: Array<CharArray>, timeArr: Array<IntArray>) {
        arr[x][y] = '.'
        timeArr[x][y] = -1
        val dx = intArrayOf(1, 0, -1, 0)
        val dy = intArrayOf(0, 1, 0, -1)

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (!(nx >= 0 && nx < arr.size && ny >= 0 && ny < arr[0].size)) {
                continue
            }

            arr[nx][ny] = '.'
            timeArr[nx][ny] = -1
        }


    }

    private fun makeBomb(arr: Array<CharArray>, timeArr: Array<IntArray>, time: Int) {


        for (i in arr.indices) {
            for (j in arr[i].indices) {
                if (arr[i][j] == '.') {
                    arr[i][j] = 'O'
                    timeArr[i][j] = time
                }
            }
        }
    }
}

fun main() {
    boj16918().sol()
}