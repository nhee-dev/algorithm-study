package src.main.kotlin.sort

import java.util.LinkedList
import java.util.StringTokenizer

class boj2252 {

    var n = 0
    var m = 0
    lateinit var indegree: IntArray
    val list = arrayListOf<ArrayList<Int>>()
    fun sol() {

        var st = StringTokenizer(readLine()!!)
        n = st.nextToken().toInt()
        m = st.nextToken().toInt()

        indegree = IntArray(n + 1)
        repeat(n + 1) {
            list.add(arrayListOf())
        }

        repeat(m) {
            st = StringTokenizer(readLine()!!)
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()
            list[a].add(b)
            indegree[b]++
        }

        topologicalSort()

    }

    fun topologicalSort() {

        val q = LinkedList<Int>()
        val res = LinkedList<Int>()

        for (i in 1..n) {
            if (indegree[i] == 0) {
                q.offer(i)
            }
        }

        while (q.isNotEmpty()) {
            val cur = q.poll()
            res.offer(cur)

            for (next in list[cur]) {
                indegree[next]--

                if (indegree[next] == 0) {
                    q.offer(next)
                }

            }
        }

        println(res)

    }
}

fun main() {
    boj2252().sol()
}