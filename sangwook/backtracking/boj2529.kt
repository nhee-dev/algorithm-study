package com.example.lib.recur

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var k = 0
var n = 0
lateinit var buho: IntArray
lateinit var arr: IntArray

var max = -1L
var min = 10000000000L

var maxStr = ""
var minStr = ""

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    k = br.readLine().toInt()
    n = k + 1
    buho = IntArray(k)

    val st = StringTokenizer(br.readLine())

    for (i in buho.indices) {
        if (st.nextToken()[0] == '<') {
            buho[i] = 1
        } else {
            buho[i] = 0
        }

    }


    arr = IntArray(n)
    val visit = BooleanArray(10)

    recur11(0, visit)

    println(maxStr)
    println(minStr)

}

fun recur11(a: Int, visit: BooleanArray) {
    if (a == n) {

        if (checkBuho()) {
            var res = ""
            for (i in arr.indices) {
                res += arr[i]
            }
            val num = res.toLong()

            if(min > num){
                min = num
                minStr = res
            }

            if(max < num){
                max = num
                maxStr = res
            }

        }
        return
    }

    for (i in 0 until 10) {
        if (visit[i]) {
            continue
        }

        arr[a] = i
        visit[i] = true
        recur11(a + 1, visit)
        visit[i] = false
    }
}

fun checkBuho(): Boolean {

    for (i in buho.indices) {
        val b = buho[i]
        if (b == 1) {
            if (arr[i] > arr[i + 1]) {
                return false
            }
        }

        if (b == 0) {
            if (arr[i] < arr[i + 1]) {
                return false
            }
        }

    }
    return true
}


