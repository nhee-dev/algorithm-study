package com.example.lib.kotlin.simulation
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class boj15683 {

    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st: StringTokenizer

    var n = 0
    var m = 0
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    lateinit var map: Array<IntArray>
    lateinit var copyMap: Array<IntArray>
    lateinit var output: IntArray
    val cctvList = arrayListOf<CCTV>()
    var answer = Integer.MAX_VALUE


    fun sol() {

        init()
        output = IntArray(cctvList.size)
        perm(0, cctvList.size)

        println(answer)

    }

    private fun perm(depth: Int, r: Int) {

        if (depth == r) {
            copyMap = Array(n) { IntArray(m)}

            for (i in 0 until n) {
                System.arraycopy(map[i], 0, copyMap[i], 0, map[i].size)
            }

            for (i in cctvList.indices) {
                direction(cctvList[i], output[i])
            }

            getBlind()

            return
        }

        for (i in 0 until 4) {
            output[depth] = i
            perm(depth + 1, r)
        }

    }

    private fun direction(cctv: CCTV, d: Int) {

        when (cctv.num) {
            1 -> when (d) {
                0 -> watch(cctv, 0)
                1 -> watch(cctv, 1)
                2 -> watch(cctv, 2)
                3 -> watch(cctv, 3)
            }
            2 -> when (d) {
                0 or 2 -> {
                    watch(cctv, 0)
                    watch(cctv, 2)
                }
                else -> {
                    watch(cctv, 1)
                    watch(cctv, 3)
                }
            }
            3 -> when (d) {
                0 -> {
                    watch(cctv, 0)
                    watch(cctv, 1)
                }
                1 -> {
                    watch(cctv, 1)
                    watch(cctv, 2)
                }
                2 -> {
                    watch(cctv, 2)
                    watch(cctv, 3)
                }
                3 -> {
                    watch(cctv, 0)
                    watch(cctv, 3)
                }
            }
            4 -> when (d) {
                0 -> {
                    watch(cctv, 0)
                    watch(cctv, 1)
                    watch(cctv, 3)
                }
                1 -> {
                    watch(cctv, 0)
                    watch(cctv, 1)
                    watch(cctv, 2)
                }
                2 -> {
                    watch(cctv, 1)
                    watch(cctv, 2)
                    watch(cctv, 3)
                }
                3 -> {
                    watch(cctv, 0)
                    watch(cctv, 2)
                    watch(cctv, 3)
                }
            }
            5 -> {
                watch(cctv, 0)
                watch(cctv, 1)
                watch(cctv, 2)
                watch(cctv, 3)

            }

        }
    }

    private fun watch(cctv: CCTV, d : Int){
        val q = LinkedList<CCTV>()
        val visit = Array(n){BooleanArray(m)}

        q.add(cctv)

        visit[cctv.x][cctv.y] = true

        while (q.isNotEmpty()){
            val tmp = q.poll()!!

            val nx = tmp.x + dx[d]
            val ny = tmp.y + dy[d]

            if(!(nx in 0 until n && ny in 0 until m) || copyMap[nx][ny] == 6){
                break
            }
            if(copyMap[nx][ny] == 0){
                copyMap[nx][ny] = -1
                q.add(CCTV(cctv.num,nx,ny))
            }else{
                q.add(CCTV(cctv.num,nx,ny))
            }
        }
    }

    private fun getBlind(){
        var cnt = 0
        for(i in 0 until n){
            for(j in 0 until m){
                if(copyMap[i][j] == 0){
                    cnt++
                }
            }
        }
        answer = Math.min(answer,cnt)
    }


    private fun init() {

        st = StringTokenizer(br.readLine())
        n = st.nextToken().toInt()
        m = st.nextToken().toInt()

        map = Array(n) { IntArray(m) }

        repeat(n) { i ->
            st = StringTokenizer(br.readLine())
            repeat(m) { j ->
                map[i][j] = st.nextToken().toInt()
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvList.add(CCTV(map[i][j], i, j))
                }
            }
        }

    }

    data class CCTV(var num: Int = 0, var x: Int = 0, var y: Int = 0)

}

fun main(){
    boj15683().sol()
}