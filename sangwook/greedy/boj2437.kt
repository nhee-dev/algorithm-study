package src.main.kotlin.greedy

class boj2437 {

    fun sol() {
        val N = readLine()!!.toInt()

        val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray().sorted()

        var sum = 0

        for (i in arr.indices) {
            if (sum + 1 < arr[i]) {
                println(sum + 1)
                return
            }

            sum += arr[i]
        }

        println(sum+1)

    }
}

fun main() {
    boj2437().sol()
}
