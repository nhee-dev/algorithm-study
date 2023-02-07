package src.main.kotlin.greedy

import java.util.StringTokenizer

class boj14247 {

    fun sol() {

        val N = readLine()!!.toInt()

        val treeList = mutableListOf<Tree>()
        val nowArr = IntArray(N)
        val growthArr = IntArray(N)

        var st = StringTokenizer(readLine()!!)
        repeat(N){i ->
            nowArr[i] = st.nextToken().toInt()
        }

        st = StringTokenizer(readLine()!!)
        repeat(N){i ->
            growthArr[i] = st.nextToken().toInt()
        }

        for (i in 0 until N) {
            treeList.add(Tree(nowArr[i], growthArr[i]))
        }

        treeList.sortWith(compareBy({ it.growLen }, { it.length }))

        var ans = 0L
        for (i in treeList.indices) {
            ans += treeList[i].length + treeList[i].growLen * i
        }

        println(ans)

    }

    data class Tree(val length: Int, val growLen: Int)
}

fun main() {
    boj14247().sol()
}