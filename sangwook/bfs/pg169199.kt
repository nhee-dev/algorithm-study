package com.example.lib.java.dfs
import java.util.*

class pg169199 {
    lateinit var map : Array<CharArray>
    lateinit var visit : Array<BooleanArray>

    var n = 0
    var m = 0

    val dx = intArrayOf(0,1,0,-1)
    val dy = intArrayOf(1,0,-1,0)

    fun solution(board: Array<String>): Int {
        var answer: Int = 0
        n = board.size
        m = board[0].length
        map = Array(n){CharArray(m)}
        visit = Array(n){BooleanArray(m)}

        var sx = 0
        var sy = 0
        for(i in 0 until n){
            for(j in 0 until m){
                map[i][j] = board[i][j]
                if(board[i][j] == 'R'){
                    sx = i
                    sy = j
                }
            }
        }

        return bfs(sx,sy)

    }

    fun bfs(sx : Int, sy : Int) : Int{

        val q = LinkedList<Point>()

        q.offer(Point(sx,sy,0))

        while(q.isNotEmpty()){

            val cur = q.poll()

            if(map[cur.x][cur.y] == 'G'){

                return cur.dist
            }

            visit[cur.x][cur.y] = true

            for(i in 0 until 4){
                var nx = cur.x
                var ny = cur.y

                while(true){

                    nx += dx[i]
                    ny += dy[i]

                    if(!(nx in 0 until n && ny in 0 until m) || map[nx][ny] == 'D'){

                        nx -= dx[i]
                        ny -= dy[i]
                        break

                    }


                }


                if(visit[nx][ny]){
                    continue
                }



                q.offer(Point(nx,ny,cur.dist+1))


            }

        }

        return -1
    }

    data class Point(val x : Int, val y : Int, var dist : Int = 0)
}