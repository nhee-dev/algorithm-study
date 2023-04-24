package src.main.kotlin.greedy

class pg132265 {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0

        val N = topping.size

        val leftCnt = IntArray(N)
        val rightCnt = IntArray(N)

        var visit = BooleanArray(10001)

        var cnt = 0

        for(i in topping.indices){
            if(visit[topping[i]]){
                leftCnt[i] = cnt
                continue
            }

            visit[topping[i]] = true
            cnt++
            leftCnt[i] = cnt
        }

        visit = BooleanArray(10001)
        cnt = 0
        for(i in N-1 downTo 0){
            if(visit[topping[i]]){
                rightCnt[i] = cnt
                continue
            }

            visit[topping[i]] = true
            cnt++
            rightCnt[i] = cnt
        }

        for(i in 0 until N-1){
            if(leftCnt[i] == rightCnt[i+1]){
                answer++
            }
        }

        return answer
    }
}