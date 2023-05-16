package src.main.kotlin.simulation

class boj10830 {

    var N = 0
    fun sol() {

        var (n, b) = readLine()!!.split(" ").map { it.toLong() }
        N = n.toInt()

        var originMatrix = Array(N) { IntArray(N) }
        var outputMatrix = Array(N) { IntArray(N) }

        repeat(N) { i ->
            originMatrix[i] = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
            outputMatrix[i][i] = 1
        }

        while (b > 0) {

            if (b % 2 == 1L) {
                outputMatrix = mul(outputMatrix, originMatrix)
            }
            originMatrix = mul(originMatrix, originMatrix)

            b /= 2

        }

        for (i in 0 until N) {
            for (j in 0 until N) {
                print("${outputMatrix[i][j]} ")
            }
            println()
        }

    }

    fun mul(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {

        val result = Array(N) { IntArray(N) }

        repeat(N) { i ->
            repeat(N) { j ->
                repeat(N) { k ->
                    result[i][j] += A[i][k] * B[k][j]
                    result[i][j] %= 1000
                }
            }
        }

        return result
    }
}

fun main() {
    boj10830().sol()
}