package src.main.kotlin.greedy

class pg132267 {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer: Int = 0
        var N = n

        while(N >= a){
            val coke = N / a
            val give = coke * a
            val take = coke * b
            answer+=take

            N = N - give + take

        }

        return answer
    }
}