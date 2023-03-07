package src.main.kotlin.dfs

class boj1967 {
    var max = 0
    var dist = 0
    fun sol() {

        val N = readLine()!!.toInt()
        val list = Array(N+1) { arrayListOf<Point>() }
        repeat(N - 1) {
            val (s, e, w) = readLine()!!.split(" ").map { it.toInt() }
            list[s].add(Point(e, w))
            list[e].add(Point(s, w))

        }

        for (i in 1 ..N) {
            val visit = BooleanArray(N+1)
            dist = 0
            dfs(list, visit, i, N)
        }

        println(max)
    }

    fun dfs(list: Array<ArrayList<Point>>,visit : BooleanArray, cur: Int, N: Int){

        for (i in list[cur].indices) {
            val next = list[cur][i].e
            if(visit[next]){
                continue
            }

            dist += list[cur][i].weight
            max = maxOf(dist,max)
            visit[cur] = true
            dfs(list,visit, next, N)
            dist-=list[cur][i].weight

        }

        return

    }
}

data class Point(val e: Int, val weight: Int)

fun main() {
    boj1967().sol()
}