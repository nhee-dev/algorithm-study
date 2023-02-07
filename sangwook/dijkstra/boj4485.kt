package src.main.kotlin.dijkstra

import java.lang.StringBuilder
import java.util.PriorityQueue
import java.util.StringTokenizer

class boj4485 {
    var N = 0
    lateinit var map: Array<IntArray>
    lateinit var dist: Array<IntArray>
    lateinit var visited: Array<BooleanArray>
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)
    fun sol() {

        val answer = StringBuilder()
        var tc = 1

        while (true) {
            N = readLine()!!.toInt()
            if (N == 0) {
                println(answer.toString())
                break
            }
            map = Array(N) { IntArray(N) }
            dist = Array(N) { IntArray(N) { Int.MAX_VALUE } }
            visited = Array(N) { BooleanArray(N) }
            for (i in 0 until N) {
                val st = StringTokenizer(readLine())
                for (j in 0 until N) {
                    map[i][j] = st.nextToken().toInt()
                }
            }

            dist[0][0] = map[0][0]
            dijkstra(0, 0)
            answer.append("Problem $tc: ${dist[N - 1][N - 1]}").append("\n")
            tc++
        }


    }

    fun dijkstra(x: Int, y: Int) {

        val pq = PriorityQueue(Comparator<IntArray> { o1, o2 ->
            dist[o1[0]][o1[1]] - dist[o2[0]][o2[1]]
        })

        pq.offer(intArrayOf(x, y))

        while (pq.isNotEmpty()) {

            val cur = pq.poll()

            val cx = cur[0]
            val cy = cur[1]

            if (visited[cx][cy]) {
                continue
            }

            visited[cx][cy] = true

            for (i in 0 until 4) {
                val nx = cx + dx[i]
                val ny = cy + dy[i]

                if (nx in 0 until N && ny in 0 until N) {
                    if(!visited[nx][ny] && dist[nx][ny] > dist[cx][cy] + map[nx][ny]){
                        dist[nx][ny] = dist[cx][cy] + map[nx][ny]
                        pq.offer(intArrayOf(nx, ny))
                    }

                }
            }

        }
    }
}

fun main() {
    boj4485().sol()
}