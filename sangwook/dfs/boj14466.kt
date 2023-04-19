package src.main.kotlin.dfs

class boj14466 {
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    var N = 0

    var flag = false
    fun sol() {
        val (n, K, R) = readLine()!!.split(" ").map { it.toInt() }
        N = n
        val road = Array(N + 1) { Array(N + 1) { Array(N + 1) { BooleanArray(N + 1) {true} } } }
        val cowList = arrayListOf<IntArray>()

        repeat(R) {
            val (r1, c1, r2, c2) = readLine()!!.split(" ").map { it.toInt() }
            road[r1][c1][r2][c2] = false
            road[r2][c2][r1][c1] = false
        }

        repeat(K) {
            val (x, y) = readLine()!!.split(" ").map { it.toInt() }
            cowList.add(intArrayOf(x, y))
        }

        var cnt = 0
        for (i in cowList.indices) {
            for (j in i + 1 until cowList.size) {
                val cow1 = cowList[i]
                val cow2 = cowList[j]
                val visit = Array(N+1) { BooleanArray(N+1) }
                dfs(cow1, cow2, road, visit)
                if (flag) {
                    cnt++
                    flag  = false
                }
            }
        }

        println((1 until K).sum()-cnt)

    }

    fun dfs(
        position: IntArray,
        target: IntArray,
        road: Array<Array<Array<BooleanArray>>>,
        visit: Array<BooleanArray>,
    ){

        val x = position[0]
        val y = position[1]
        visit[x][y] = true

        if (x == target[0] && y == target[1]) {
            flag = true
            return
        }

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (!(nx in 1 .. N && ny in 1 .. N)) {
                continue
            }

            if (visit[nx][ny]) {
                continue
            }

            if(!road[x][y][nx][ny]){
                continue
            }

            dfs(intArrayOf(nx, ny), target, road, visit)
        }


    }
}

fun main() {
    boj14466().sol()
}
