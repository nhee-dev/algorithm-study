package src.main.kotlin.dfs

import java.util.*
import kotlin.collections.HashMap

class boj1339 {
    val wordList = arrayListOf<String>()
    var max = -1
    val map = HashMap<Char, Int>()
    fun sol() {
        val N = readLine()!!.toInt()
        val ts = HashSet<Char>()
        repeat(N) {
            val word = readLine()!!
            wordList.add(word)
            word.forEach { ch ->
                ts.add(ch)
            }
        }

        val arr = ts.toTypedArray()
        val output = IntArray(arr.size)
        val visit = BooleanArray(arr.size)
        perm(0, arr.size, arr, output, visit)
        println(max)

    }

    fun perm(cur: Int, r: Int, arr: Array<Char>, output: IntArray, visit: BooleanArray) {
        if (cur == r) {

            var totalSum = 0
            wordList.forEach { str ->
                var tmp = 0
                str.forEach { ch ->
                    tmp *= 10
                    tmp += map.getOrDefault(ch, -1)
                }

                totalSum += tmp

            }
            max = maxOf(totalSum, max)
            return

        }

        for (i in 9 downTo 10 - r) {
            if (!visit[9 - i]) {
                visit[9 - i] = true
                map[arr[cur]] = i
                perm(cur + 1, r, arr, output, visit)
                visit[9 - i] = false
            }
        }
    }
}

fun main() {
    boj1339().sol()
}