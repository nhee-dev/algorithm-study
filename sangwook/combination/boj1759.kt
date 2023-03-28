package src.main.kotlin.comb

import java.lang.StringBuilder


class boj1759 {
    val need = arrayOf("a", "i", "o", "u", "e")

    fun sol() {
        val (r, n) = readLine()!!.split(" ").map { it.toInt() }
        val alphabet = readLine()!!.split(" ").toTypedArray()
        alphabet.sort()

        val output = Array(r) { "" }
        comb(0, 0, r, n, alphabet, output)
    }

    fun comb(cur: Int, start: Int, r: Int, n: Int, alphabet: Array<String>, output: Array<String>) {

        if (cur == r) {
            var a = 0
            var b = 0
            output.forEach {
                if(need.contains(it)){
                    a++
                }else{
                    b++
                }
            }

            if (a > 0 && b > 1) {
                val sb = StringBuilder()
                output.forEach {
                    sb.append(it)
                }
                println(sb.toString())
            }

            return
        }

        for (i in start until n) {
            output[cur] = alphabet[i]
            comb(cur + 1, i + 1, r, n, alphabet, output)
        }

    }
}

fun main() {
    boj1759().sol()
}