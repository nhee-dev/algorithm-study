package src.main.kotlin.tree

import java.util.StringTokenizer

class boj1949 {

    var N = 0
    lateinit var peopleArr: IntArray
    lateinit var list: Array<ArrayList<Int>>
    lateinit var dp: Array<IntArray>

    fun sol() {

        N = readLine()!!.toInt()
        peopleArr = IntArray(N + 1)
        list = Array(N + 1) { arrayListOf() }
        dp = Array(N + 1) { IntArray(2) }

        var st = StringTokenizer(readLine()!!)
        for (i in 1..N) {
            peopleArr[i] = st.nextToken().toInt()
        }

        repeat(N - 1) {
            st = StringTokenizer(readLine()!!)
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()
            list[a].add(b)
            list[b].add(a)
        }

        dfs(1, -1)
        println(maxOf(dp[1][0], dp[1][1]))

    }

    fun dfs(cur: Int, parent: Int) {

        for (next in list[cur]) {
            if (next == parent) {
                continue
            }

            dfs(next, cur)
            dp[cur][0] += maxOf(dp[next][0], dp[next][1])
            dp[cur][1] += dp[next][0]

        }
        dp[cur][1] += peopleArr[cur]

    }

}

fun main() {
    boj1949().sol()
}