package src.main.kotlin.binary_search

class boj2110 {
    var N = 0
    var M = 0
    lateinit var arr: LongArray
    fun sol() {

        val (n, m) = readLine()!!.split(" ").map { it.toInt() }
        N = n
        M = m
        arr = LongArray(N)
        repeat(N) { i ->
            val num = readLine()!!.toLong()
            arr[i] = num
        }

        arr.sort()

        var s = 1L
        var e = arr[N - 1] - arr[0]
        var ans = -1L
        while (s <= e) {
            val mid = (s + e) / 2

            val cnt = getCnt(mid)

            if (cnt < M) {
                e = mid - 1
            } else {
                ans = maxOf(ans,mid)
                s = mid + 1
            }
        }
        println(ans)


    }

    private fun getCnt(len: Long): Int {

        var cnt = 1
        var curPosition = arr[0]
        for (i in 1 until arr.size) {
            if (arr[i] - curPosition >= len) {
                cnt++
                curPosition = arr[i]
            }


        }
        return cnt
    }
}

fun main() {
    boj2110().sol()
}