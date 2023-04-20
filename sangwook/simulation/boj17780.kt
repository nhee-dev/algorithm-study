package src.main.kotlin.simulation

class boj17780 {
    var N = 0
    var K = 0

    lateinit var map: Array<IntArray>
    lateinit var board: Array<Array<PointList>>
    val pointList = arrayListOf<Point>()

    val dx = intArrayOf(0, 0, -1, 1)
    val dy = intArrayOf(1, -1, 0, 0)
    fun sol() {

        val (n, k) = readLine()!!.split(" ").map { it.toInt() }
        N = n
        K = k

        map = Array(N) { IntArray(N) }
        board = Array(N) { Array(N) { PointList() } }

        for (i in 0 until N) {
            val mapInfo = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
            map[i] = mapInfo
        }

        repeat(K) { num ->
            val (x, y, d) = readLine()!!.split(" ").map { it.toInt() }

            pointList.add(Point(x - 1, y - 1, d-1, num))
            board[x - 1][y - 1].list.add(Point(x - 1, y - 1, d-1, num))
        }

        repeat(1000) { cnt ->
            for (i in pointList.indices) {
                val p = pointList[i]

                if (board[p.x][p.y].list[0].num != i) {
                    continue
                }

                var dir = p.dir

                var nx = p.x + dx[dir]
                var ny = p.y + dy[dir]

                if (!(nx in 0 until N && ny in 0 until N) || map[nx][ny] == 2) {

                    dir = 1-dir
                    if (dir < 0) {
                        dir += 4
                    }
                    p.dir = dir
                    board[p.x][p.y].list[0].dir = p.dir
                    nx += dx[dir] * 2
                    ny += dy[dir] * 2

                    if (!(nx in 0 until N && ny in 0 until N) || map[nx][ny] == 2) {
                        continue
                    }

                }

                board[p.x][p.y].list.forEach {
                    it.x = nx
                    it.y = ny


                }

                if (map[nx][ny] == 0) {
                    board[nx][ny].list.addAll(board[p.x][p.y].list)

                } else {
                    board[nx][ny].list.addAll(board[p.x][p.y].list.reversed())
                }


                board[p.x][p.y].list.clear()
                board[nx][ny].list.forEach {
                    pointList[it.num].x = nx
                    pointList[it.num].y = ny
                }


                if (board[nx][ny].list.count() >= 4) {
                    println(cnt + 1)
                    return
                }

            }

        }

        println(-1)

    }

    data class PointList(val list: ArrayList<Point> = arrayListOf())
    data class Point(var x: Int, var y: Int, var dir: Int, val num: Int)
}

fun main() {
    boj17780().sol()
}