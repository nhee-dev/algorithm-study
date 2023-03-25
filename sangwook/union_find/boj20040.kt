package src.main.kotlin.union_find

class boj20040 {
    lateinit var parent: IntArray
    fun sol() {
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }

        parent = IntArray(n) { it }
        repeat(m) { i ->
            val (s, e) = readLine()!!.split(" ").map { it.toInt() }
            if (find(s) != find(e)) {
                union(s, e)
            } else {
                println(i + 1)
                return
            }
        }

        println(0)

    }

    fun find(x: Int): Int {
        return if (x == parent[x]) {
            x
        } else {
            parent[x] = find(parent[x])
            parent[x]
        }
    }

    fun union(a: Int, b: Int) {

        val x = find(a)
        val y = find(b)

        if (x != y) {
            parent[y] = x
        }
    }

}

fun main() {
    boj20040().sol()
}