package src.main.kotlin.dfs

class boj16637 {
    val numList = arrayListOf<Int>()
    val opList = arrayListOf<String>()
    var max = Int.MIN_VALUE
    fun sol() {

        val N = readLine()!!.toInt()
        val line = readLine()!!.split("")

        line.forEach {
            if (it.toIntOrNull() != null) {
                numList.add(it.toInt())
            } else {
                if (it != "") opList.add(it)

            }
        }

        dfs(numList[0], 0)
        println(max)

    }

    fun dfs(res: Int, opIdx: Int) {

        if (opIdx == opList.size) {
            max = maxOf(res, max)
            return
        }

        dfs(calc(res, numList[opIdx + 1], opList[opIdx]), opIdx + 1)

        if (opIdx + 1 < opList.size) {
            val res2 = calc(numList[opIdx + 1], numList[opIdx + 2], opList[opIdx + 1])
            dfs(calc(res, res2, opList[opIdx]), opIdx + 2)
        }


    }

    fun calc(a: Int, b: Int, op: String): Int {
        when (op) {
            "+" -> {
                return a + b
            }

            "-" -> {
                return a - b
            }

            "*" -> {
                return a * b
            }

        }
        return -1
    }
}

fun main() {
    boj16637().sol()
}