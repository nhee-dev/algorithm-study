package src.main.kotlin.two_pointer

class boj20366 {
    fun sol() {

        val N = readLine()!!.toInt()
        val heights = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
        heights.sort()
        var min = Int.MAX_VALUE
        for (i in heights.indices) {
            for (j in i + 1 until heights.size) {

                val elsaSnowMan = heights[i] + heights[j]

                var annaTop = 0
                var annaBottom = N-1

                while (annaTop < annaBottom) {

                    if (annaTop == i || annaTop == j){
                        annaTop++
                        continue
                    }
                    if (annaBottom == i || annaBottom == j){
                        annaBottom--
                        continue
                    }

                    val annaSnowMan = heights[annaTop] + heights[annaBottom]
                    min = minOf(min, Math.abs(elsaSnowMan - annaSnowMan))

                    if (annaSnowMan < elsaSnowMan) {
                        annaTop++
                    } else if (annaSnowMan > elsaSnowMan) {
                        annaBottom--
                    } else {
                        break
                    }

                }

            }
        }

        println(min)
    }
}

fun main() {
    boj20366().sol()
}