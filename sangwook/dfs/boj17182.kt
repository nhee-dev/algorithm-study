package src.main.kotlin.dfs

class boj17182 {
    lateinit var map: Array<IntArray>
    var min = Int.MAX_VALUE

    fun sol() {
        val (N, K) = readLine()!!.split(" ").map { it.toInt() }
        map = Array(N) { IntArray(N) { Int.MAX_VALUE } }

        for (i in map.indices) {
            map[i][i] = 0
        }

        repeat(N) { i ->
            val line = readLine()!!.split(" ").map { it.toInt() }
            repeat(N) { j ->
                map[i][j] = minOf(map[i][j], line[j])
            }
        }

        for (k in 0 until N) {
            for (i in 0 until N) {
                for (j in 0 until N) {
                    map[i][j] = minOf(map[i][j], map[i][k] + map[k][j])
                }
            }
        }

        val visit = BooleanArray(N)
        visit[K] = true
        dfs(K, N, 0, 0, visit)

        println(min)

    }

    private fun dfs(k: Int, n: Int, sum: Int, cnt: Int, visit: BooleanArray) {

        if (cnt == n - 1) {
            min = minOf(min, sum)
            return
        }

        for (i in 0 until n) {
            if (visit[i]) continue
            visit[i] = true
            dfs(i, n, sum + map[k][i], cnt + 1, visit)
            visit[i] = false
        }

    }
}

fun main() {
    boj17182().sol()
}