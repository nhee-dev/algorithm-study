import java.util.*
class pg138477 {
    var e = 0
    fun solution(k: Int, score: IntArray): IntArray {
        var answer = IntArray(score.size)

        var s = 1
        val e = score.size
        val pq = PriorityQueue<Int>()

        while(s < e+1){
            if( s <= k ){
                pq.offer(score[s-1])
                answer[s-1] = pq.peek()
                s++
                continue
            }

            val cur = pq.peek()
            val next = score[s-1]

            if(next > cur){
                pq.poll()
                pq.offer(next)
                answer[s-1] = pq.peek()
            }else{
                answer[s-1] = pq.peek()
            }
            s++
        }

        return answer
    }
}