package src.main.kotlin.sum

class boj2015 {

    fun sol() {
        val input = readLine()!!.split(" ")
        val N = input[0].toInt()
        val K = input[1].toLong()

        val sumArr = LongArray(N + 1)
        var ans = 0L
        val arr = readLine()!!.split(" ").map { it.toInt() }

        for (i in 1..N) {
            sumArr[i] = sumArr[i - 1] + arr[i - 1]

        }

        val hm = HashMap<Long, Int>()

        for (i in 1..N) {
            if (sumArr[i] == K) {
                ans++
            }
            ans += hm.getOrDefault(sumArr[i] - K, 0)
            hm[sumArr[i]] = hm.getOrDefault(sumArr[i], 0) + 1
        }

        println(ans)

    }
}

fun main() {
    boj2015().sol()
}