import java.util.*
class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {

        val size = queue1.size
        val queue = IntArray(size*2)

        for(i in queue1.indices){
            queue[i] = queue1[i]
        }

        for(i in queue2.indices){
            queue[i+size] = queue2[i]
        }

        var q1Sum = queue1.sum().toLong()
        var q2Sum = queue2.sum().toLong()
        var cnt = 0
        var q1Idx = 0
        var q2Idx = size

        while(q1Sum != q2Sum){


            if(cnt > size * 4){
                cnt = -1
                break
            }


            if(q1Sum > q2Sum){
                q1Sum-=queue[q1Idx]
                q2Sum+=queue[q1Idx]

                q1Idx++
                if(q1Idx == size*2){
                    q1Idx = 0
                }
            }else{
                q1Sum+=queue[q2Idx]
                q2Sum-=queue[q2Idx]

                q2Idx++
                if(q2Idx == size*2){
                    q2Idx = 0
                }
            }

            cnt++
        }

        return cnt
    }
}