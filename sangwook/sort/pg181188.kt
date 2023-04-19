package src.main.kotlin.sort

class pg181188 {
    fun solution(targets: Array<IntArray>): Int {
        var answer: Int = 0

        targets.sortBy{it[1]}

        var curLast = 0

        for(i in targets.indices){
            if(curLast == 0){
                curLast = targets[i][1]
                continue
            }

            val start = targets[i][0]
            val end = targets[i][1]

            if(curLast > start){
                continue
            }

            curLast = end
            answer++
        }


        return answer + 1
    }
}