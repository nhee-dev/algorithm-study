package src.main.kotlin.union_find

class boj14621 {
    var N = 0
    var M = 0
    val roadList = arrayListOf<Road>()
    lateinit var genderArr: Array<String>
    lateinit var parent: IntArray
    fun sol() {
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }
        N = n
        M = m

        genderArr = readLine()!!.split(" ").toTypedArray()
        parent = IntArray(N + 1) { it }
        repeat(M) {
            val (s, e, w) = readLine()!!.split(" ").map { it.toInt() }

            if (genderArr[s - 1] != genderArr[e - 1]) {
                roadList.add(Road(s, e, w))
            }

        }
        roadList.sort()
        var res = 0
        roadList.forEach {
            val s = it.start
            val e = it.end
            val w = it.weight

            if (find(s) != find(e)) {
                union(s, e)
                res += w
            }

        }

        var flag = true
        for (i in 1 until parent.size-1) {

            if (find(parent[i]) != find(parent[i+1])) {
                flag = false
                break
            }
        }

        if (!flag) res = -1

        println(res)

    }

    fun find(x: Int): Int {
        return if (x == parent[x]) {
            x
        } else {
            parent[x] = find(parent[x])
            return parent[x]
        }
    }

    fun union(x: Int, y: Int) {
        val a = find(x)
        val b = find(y)

        if (a != b) {
            parent[b] = a
        }
    }

    data class Road(val start: Int, val end: Int, val weight: Int) : Comparable<Road> {
        override fun compareTo(other: Road): Int {
            return this.weight - other.weight
        }
    }
}

fun main() {
    boj14621().sol()
}