package src.main.kotlin.dp

class boj15486 {
    fun sol() {
        val N = readLine()!!.toInt()
        val timeArr = IntArray(N+1)
        val moneyArr = IntArray(N+1)
        val dp = IntArray(N+1)

        repeat(N) { i ->
            val (time, money) = readLine()!!.split(" ").map { it.toInt() }

            timeArr[i] = time
            moneyArr[i] = money

        }

        var max = -1

        for (i in 0..N) {

            max = maxOf(max, dp[i])

            val nextDay = i + timeArr[i]

            if (nextDay > N) {
                continue
            }

            dp[nextDay] = maxOf(dp[nextDay], max + moneyArr[i])

        }

        println(max)


    }
}

fun main() {
    boj15486().sol()
}