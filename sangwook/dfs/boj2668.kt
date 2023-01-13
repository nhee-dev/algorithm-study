package src.main.kotlin.dfs

class boj2668 {
    var N = 0
    lateinit var arr: IntArray
    val ansList = arrayListOf<Int>()
    lateinit var visit: BooleanArray
    lateinit var visited: BooleanArray
    fun sol() {
        N = readLine()!!.toInt()
        arr = IntArray(N + 1)
        visit = BooleanArray(N + 1)
        repeat(N) { idx ->
            arr[idx + 1] = readLine()!!.toInt()
        }

        for (i in 1..N) {
            visited = BooleanArray(N+1)
            if (!visit[i]) {
                val list = arrayListOf<Int>()
                visited[i] = true
                list.add(i)
                dfs(i, arr[i], list)
            }
        }

        println(ansList.size)
        println(ansList)

    }

    fun dfs(start: Int, cur: Int, list: ArrayList<Int>) {
        if (start == cur) {
            list.forEach {
                visit[it] = true
            }
            ansList.addAll(list)
            return
        }

        if (visited[cur]) {
            return
        }

        visited[cur] = true
        list.add(cur)
        dfs(start, arr[cur], list)
    }
}

fun main() {
    boj2668().sol()
}