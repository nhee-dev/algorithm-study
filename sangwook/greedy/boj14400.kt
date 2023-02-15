package src.main.kotlin.greedy

class boj14400 {

    fun sol() {


        val N = readLine()!!.trim().toInt()
        val arr = Array(N) { IntArray(2) }

        repeat(N) { i ->
            val xy = readLine()!!.trim().split(" ").map { it.toInt() }.toIntArray()
            arr[i] = xy

        }

        arr.sortBy { it[0] }

        val x = arr[N / 2][0]

        arr.sortBy { it[1] }
        val y = arr[N / 2][1]

        var sum = 0L

        arr.forEach {

            sum += Math.abs(it[0] - x) + Math.abs(it[1] - y)
        }

        println(sum)

    }
}

fun main() {

    boj14400().sol()

}
