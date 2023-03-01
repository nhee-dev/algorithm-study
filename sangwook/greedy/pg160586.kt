package src.main.kotlin.greedy

class pg160586 {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        var answer = IntArray(targets.size)

        val minCnt = IntArray(26){101}

        keymap.forEach{
            val keys = it

            for(i in keys.indices){
                val alpha = keys[i]
                val cnt = i+1

                if(minCnt[alpha-'A'] > cnt){
                    minCnt[alpha-'A'] = cnt
                }
            }
        }

        for(i in targets.indices){
            val target = targets[i]
            var cnt = 0
            for(j in target.indices){
                val alpha = target[j]
                val min = minCnt[alpha-'A']
                if( min == 101 ){
                    cnt = -1
                    break
                }

                cnt += min
            }
            answer[i] = cnt

        }

        return answer
    }
}