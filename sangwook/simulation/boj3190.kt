package com.example.lib.kotlin.simulation

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class boj3190 {

    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st: StringTokenizer

    var n = 0
    lateinit var map: Array<IntArray>

    val APPLE = 10

    val dirList = arrayListOf<List<String>>()

    var time = 0

    var head = arrayOf(1, 1)
    val body = LinkedList<IntArray>()

    var dirIdx = 0
    var dx = arrayOf(0, 1, 0, -1)
    var dy = arrayOf(1, 0, -1, 0)

    fun main() {

        n = br.readLine().toInt()
        map = Array(n + 1) { IntArray(n + 1) }

        var appleCnt = br.readLine().toInt()
        //사과 위치 저장
        initApple(appleCnt)

        var changeCnt = br.readLine().toInt()
        //방향 전환 리스트 넣기
        for (i in 0 until changeCnt) {
            val directionChange = br.readLine()
            dirList.add(directionChange.split(" "))

        }

        body.offer(intArrayOf(head[0], head[1]))

        while (true) {
            if (!move()) {
                break
            }
        }

        println(time)

    }

    fun move(): Boolean {

        time++

        head[0] += dx[dirIdx]
        head[1] += dy[dirIdx]

        // 머리가 맵 벗어났을 때 false 반환
        if (!(head[0] in 1..n && head[1] in 1..n)) {
            return false
        }

        // 머리가 몸통 부딪혔을 때 false 반환
        if (checkBody(head[0], head[1])) {
            return false
        }

        //body에 머리 추가
        body.offer(intArrayOf(head[0], head[1]))

        // 머리가 사과일 경우 그 자리 사과 없애고 꼬리 안따라옴
        if (map[head[0]][head[1]] == APPLE) {
            map[head[0]][head[1]] = 0
        } else {
            //그 외 꼬리 한 칸 따라옴
            body.poll()

        }

        if (dirList.isNotEmpty()) {

            if (dirList[0][0].toInt() == time) {

                if (dirList[0][1] == "D") {
                    dirIdx++
                    if (dirIdx == 4) {
                        dirIdx = 0
                    }
                } else {
                    dirIdx--
                    if (dirIdx == -1) {
                        dirIdx = 3
                    }
                }

                dirList.removeAt(0)

            }

        }


        return true
    }

    fun checkBody(x: Int, y: Int): Boolean {

        //큐 속에 iter돌려서 x,y 포함 되있으면 true반환
        val iter = body.iterator()

        while (iter.hasNext()) {
            val next = iter.next()
            if (x == next[0] && y == next[1]) {
                return true
            }
        }

        return false

    }

    fun initApple(appleCnt: Int) {

        for (i in 0 until appleCnt) {
            st = StringTokenizer(br.readLine())
            map[st.nextToken().toInt()][st.nextToken().toInt()] = APPLE
        }
    }
}

fun main(){
    boj3190().main()
}

