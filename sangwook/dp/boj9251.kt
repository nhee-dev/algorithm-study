package src.main.kotlin.dp

class boj9251 {

    fun sol() {
        val str1 = readLine()!!
        val str2 = readLine()!!

        val arr = Array(str1.length + 1) { IntArray(str2.length + 1) }

        for (i in 1..str1.length) {
            for (j in 1..str2.length) {
                if (str1[i - 1] == str2[j - 1]) {
                    arr[i][j] = arr[i - 1][j - 1] + 1
                    continue
                }

                arr[i][j] = maxOf(arr[i - 1][j], arr[i][j - 1])
            }
        }

        println(arr[str1.length][str2.length])

    }


}

fun main() {
    boj9251().sol()
}