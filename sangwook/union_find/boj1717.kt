package com.example.lib.kotlin.union_find

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

class boj1717 {

    var N = 0
    var M = 0
    lateinit var parent: IntArray

    fun sol() {

        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())

        val sb = StringBuilder()
        N = st.nextToken().toInt()
        M = st.nextToken().toInt()

        parent = IntArray(N + 1)
        for (i in 1 until parent.size) {
            parent[i] = i
        }

        for (i in 0 until M) {
            st = StringTokenizer(br.readLine())
            val flag = st.nextToken().toInt()
            val x = st.nextToken().toInt()
            val y = st.nextToken().toInt()

            if(flag == 0){
                union(x,y)
            }else{
                if(isSameParent(x,y)){
                   sb.append("YES\n")
                }else{
                    sb.append("NO\n")
                }
            }
        }

        println(sb.toString())
    }

    fun find(x: Int): Int {
        return if (x == parent[x]) {
            x
        } else {
            parent[x] = find(parent[x])
            return parent[x]
        }
    }

    fun union(a: Int, b: Int) {
        val x = find(a)
        val y = find(b)

        if (x != y) {
            if (x < y) {
                parent[y] = x
            } else {
                parent[x] = y
            }
        }
    }

    fun isSameParent(a: Int, b: Int): Boolean {
        val x = find(a)
        val y = find(b)

        return x == y
    }


}

fun main() {
    boj1717().sol()
}