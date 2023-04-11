package tree

import java.lang.StringBuilder

class boj15681 {
    fun sol() {
        val (N, R, Q) = readLine()!!.split(" ").map { it.toInt() }
        val vList = Array(N + 1) { arrayListOf<Int>() }
        val parent = IntArray(N + 1) { it }
        val size = IntArray(N + 1)
        repeat(N - 1) {
            val (u, v) = readLine()!!.split(" ").map { it.toInt() }
            vList[u].add(v)
            vList[v].add(u)

        }

        dfs(R, -1, size, parent, vList)

        val sb = StringBuilder()
        repeat(Q) {
            val U = readLine()!!.toInt()
            sb.append(size[U]).append(" ")
        }

        println(sb.toString())

    }

    fun dfs(cur: Int, pre: Int, size: IntArray, parent: IntArray, vList: Array<ArrayList<Int>>): Int {
        size[cur] = 1
        parent[cur] = pre
        for (next in vList[cur]) {
            if (next == pre) {
                continue
            }
            size[cur] += dfs(next, cur, size, parent, vList)


        }

        return size[cur]
    }

}

fun main() {
    boj15681().sol()
}