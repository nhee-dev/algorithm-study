package src.main.kotlin.greedy


class pg161989 {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0

        var cur = 0

        for(i in section.indices){
            val num = section[i]
            if(num >= cur){
                answer++
                cur = num + m
            }
        }

        return answer
    }
}