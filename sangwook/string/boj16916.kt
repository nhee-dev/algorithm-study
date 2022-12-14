package src.main.kotlin.two_pointer

class boj16916 {
    lateinit var pi: IntArray
    var ans = 0
    fun sol() {
        val origin = readLine()!!
        val target = readLine()!!

        pi = IntArray(target.length)

        getPi(target)
        kmp(origin, target)
        println(ans)

    }

    fun kmp(origin: String, target: String) {

        var j = 0
        for (i in origin.indices) {
            while (j > 0 && origin[i] != target[j]) {
                j = pi[j - 1]
            }
            if (origin[i] == target[j]) {
                if (j == target.length - 1) {
                    ans = 1
                    break
                } else {
                    j++
                }
            }
        }
    }

    fun getPi(target: String) {

        var j = 0

        for (i in 1 until target.length) {
            while (j > 0 && target[i] != target[j]) {
                j = pi[j - 1]
            }
            if (target[i] == target[j]) {
                j++
                pi[i] = j
            }

        }

    }
}

fun main() {
    boj16916().sol()
}