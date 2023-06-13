package src.main.kotlin.dp

class boj1932 {
    fun sol() {
        val N = readLine()!!.toInt()
        val map = Array(N) { IntArray(N) }

        repeat(N) { i ->
            val line = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
            map[i] = line
        }

        val dp = Array(N) { IntArray(N) }
        dp[0][0] = map[0][0]

        for (i in 0 until N - 1) {
            for (j in 0 until map[i].size) {
                dp[i + 1][j] = maxOf(dp[i + 1][j], dp[i][j] + map[i + 1][j])
                dp[i + 1][j + 1] = maxOf(dp[i + 1][j + 1], dp[i][j] + map[i + 1][j + 1])
            }
        }

        println(dp[N - 1].max())

    }
}

fun main() {
    boj1932().sol()
}