package src.main.kotlin.dfs

class boj1012 {
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    fun sol() {
        val T = readLine()!!.toInt()
        val sb = StringBuilder()
        repeat(T) {
            var cnt = 0
            val (M, N, K) = readLine()!!.split(" ").map { it.toInt() }
            val map = Array(N) { IntArray(M) }
            val visit = Array(N) { BooleanArray(M) }
            repeat(K) {
                val (y, x) = readLine()!!.split(" ").map { it.toInt() }
                map[x][y] = 1
            }

            for (i in 0 until N) {
                for (j in 0 until M) {
                    if (!visit[i][j] && map[i][j] == 1) {
                        visit[i][j] = true
                        dfs(i, j, map, visit)
                        cnt++
                    }
                }
            }
            sb.append(cnt).append('\n')

        }
        println(sb.toString())
    }

    fun dfs(x: Int, y: Int, map: Array<IntArray>, visit: Array<BooleanArray>) {

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (!(nx in map.indices && ny in map[0].indices)) {
                continue
            }

            if(visit[nx][ny]){
                continue
            }

            if (map[nx][ny] == 0) {
                continue
            }

            visit[nx][ny] = true
            dfs(nx, ny, map, visit)
        }


    }
}

fun main() {
    boj1012().sol()
}