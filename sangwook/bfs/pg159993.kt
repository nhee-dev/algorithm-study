package com.example.lib.java.dfs

import java.util.*
class pg159993 {
    val dx = intArrayOf(1,0,-1,0)
    val dy = intArrayOf(0,1,0,-1)

    lateinit var map : Array<CharArray>

    var N = 0
    var M = 0
    var answer: Int = 0
    fun solution(maps: Array<String>): Int {
        N = maps.size
        M = maps[0].length

        map = Array(N){CharArray(M){' '}}
        var startX = 0
        var startY = 0
        var endX = 0
        var endY = 0
        var leverX = 0
        var leverY = 0
        for(i in 0 until N){
            for(j in 0 until M){
                if(maps[i][j] == 'S'){
                    startX = i
                    startY = j
                }

                if(maps[i][j] == 'E'){
                    endX = i
                    endY = j
                }

                if(maps[i][j] == 'L'){
                    leverX = i
                    leverY = j
                }
                map[i][j] = maps[i][j]
            }
        }

        if(!bfs(startX,startY,leverX,leverY)) {
            return -1
        }
        if(!bfs(leverX,leverY,endX,endY)){
            return -1
        }

        return answer
    }
    fun bfs(x : Int, y : Int, targetX : Int, targetY : Int) : Boolean{

        val visit = Array(N){BooleanArray(M)}
        val q = LinkedList<IntArray>()
        q.offer(intArrayOf(x,y))
        var cnt = 0
        while(q.isNotEmpty()){
            val size = q.size
            for(i in 0 until size){

                val cur = q.poll()
                val curX = cur[0]
                val curY = cur[1]

                if(curX == targetX && curY == targetY){
                    answer += cnt
                    return true
                }

                for(j in 0 until 4){
                    val nx = curX + dx[j]
                    val ny = curY + dy[j]

                    if(!(nx in 0 until N && ny in 0 until M)){
                        continue
                    }
                    if(visit[nx][ny]){
                        continue
                    }
                    if(map[nx][ny] == 'X'){
                        continue
                    }

                    visit[nx][ny] = true
                    q.offer(intArrayOf(nx,ny))
                }

            }
            cnt++

        }
        return false
    }



}