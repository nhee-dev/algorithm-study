package src.main.kotlin.string

class pg142086 {
    fun solution(s: String): IntArray {
        val answer =  IntArray(s.length)

        val arr = IntArray(26){-1}

        for(i in s.indices){

            val ch = s[i]
            val position = ch-'a'
            if(arr[position] == -1){
                answer[i] = arr[position]

            }else{
                answer[i] = i - arr[position]

            }
            arr[position] = i

        }

        return answer
    }
}