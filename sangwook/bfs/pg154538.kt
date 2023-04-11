package com.example.lib.java.dfs

import java.util.*

class pg154538 {
    fun solution(x: Int, y: Int, n: Int): Int {
        var answer: Int = 0

        answer = bfs(x,y,n)

        return answer
    }

    fun bfs(x : Int, y : Int, n : Int) : Int{
        val q = LinkedList<Int>()
        val visited = BooleanArray(1000001)

        q.offer(x)
        var cnt = 0
        var flag = false
        while(q.isNotEmpty()){
            val size = q.size

            for(i in 0 until size){

                val cur = q.poll()

                if(visited[cur]){
                    continue
                }

                visited[cur] = true

                if(cur == y){
                    flag = true
                    return cnt;
                }

                if( cur + n <= y){
                    q.offer(cur+n)
                }

                if( cur * 2 <= y){
                    q.offer(cur*2)
                }

                if(cur * 3 <= y){
                    q.offer(cur*3)
                }

            }

            cnt++

        }



        return -1
    }
}