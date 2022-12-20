package src.main.kotlin.number

class boj2581 {
    lateinit var primeArr: BooleanArray
    var M = 0
    var N = 0
    fun sol() {

        M = readLine()!!.toInt()
        N = readLine()!!.toInt()

        primeArr = BooleanArray(N + 1) { true }

        getPrime()
        var first = 0
        var sum = 0
        for (i in M..N) {
            if (i == 0 || i == 1) {
                continue
            }
            if (!primeArr[i]) {
                continue
            }

            if (first == 0) {
                first = i
            }

            sum += i

        }

        if (first == 0) {
            println(-1)
        } else {
            println(sum)
            println(first)
        }
    }

    fun getPrime() {

        val sqrt = Math.sqrt(N.toDouble()).toInt()

        for (i in 2..sqrt) {
            if (!primeArr[i]) {
                continue
            }
            var j = 2
            while (i * j <= N) {
                if (primeArr[i * j]) {
                    primeArr[i * j] = false

                }
                j++
            }
        }
    }
}

fun main() {
    boj2581().sol()
}