package two_pointer

import java.util.StringTokenizer

class boj1806 {

    fun sol() {
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }
        val arr = IntArray(n)

        val st = StringTokenizer(readLine())
        for (i in 0 until n) {
            arr[i] = st.nextToken().toInt()
        }

        var s = 0
        var e = 0
        var sum = arr[s]
        var size = 1
        var min = 100010

        while (e < n) {

            if (sum >= m) {
                min = minOf(min, size)
            }
            if (sum <= m) {
                e++
                if (e == n) {
                    break
                }

                sum += arr[e]
                size++
            } else {
                sum -= arr[s]
                s++
                size--
            }
        }

        if (min == 100010) {
            min = 0
        }
        println(min)
    }

}

fun main() {
    boj1806().sol()
}