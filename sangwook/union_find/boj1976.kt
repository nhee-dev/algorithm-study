package com.example.lib.kotlin.union_find

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

class boj1976 {

    var N = 0
    var M = 0
    lateinit var map: Array<IntArray>
    lateinit var target: IntArray
    lateinit var visit: BooleanArray

    val roads = ArrayList<ArrayList<Int>>()

    fun sol() {

        val br = BufferedReader(InputStreamReader(System.`in`))

        N = br.readLine().toInt()
        M = br.readLine().toInt()

        map = Array(N) { IntArray(N) }

        visit = BooleanArray(N)

        for (i in 0 until N) {
            val st = StringTokenizer(br.readLine())
            for (j in 0 until N) {
                map[i][j] = st.nextToken().toInt()
            }
        }
        target = IntArray(M)
        val st = StringTokenizer(br.readLine())
        for (i in 0 until M) {
            target[i] = st.nextToken().toInt() - 1
        }

        for (i in 0 until N) {
            if (!visit[i]) {
                val list = ArrayList<Int>()
                val tmp = makeRoad(i, list)

                roads.add(tmp)

            }
        }

        if (checkRoads()) {
            println("YES")
        } else {
            println("NO")
        }

    }

    private fun checkRoads(): Boolean {

        loop@for (i in roads.indices) {
            val roadTmp = roads[i]
            for (j in target.indices) {
                if (!roadTmp.contains(target[j])) {
                    continue@loop
                }

            }
            return true
        }
        return false
    }

    private fun makeRoad(index: Int, list: ArrayList<Int>): ArrayList<Int> {

        list.add(index)
        visit[index] = true

        for (i in 0 until N) {
            if (map[index][i] == 1 && !visit[i]) {
                makeRoad(i, list)
            }
        }

        return list
    }
}

fun main() {
    boj1976().sol()
}