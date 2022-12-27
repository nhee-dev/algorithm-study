package src.main.kotlin.simulation

import java.util.*

class pg142085 {
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        var answer: Int = 0

        val pq = PriorityQueue<Int>(reverseOrder())
        var sum = 0
        var muJeok = k
        for(i in enemy.indices){

            val e = enemy[i]
            sum+=e
            pq.offer(e)


            if(muJeok == 0 && sum > n){
                return i
            }

            if(sum > n){
                muJeok--
                sum -= pq.poll()
            }

        }

        return enemy.size
    }
}