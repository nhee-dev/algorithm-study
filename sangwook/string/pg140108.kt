package src.main.kotlin.string

class pg140108 {
    fun solution(s: String): Int {

        var answer: Int = 0

        var x = s[0]
        var xCnt = 1
        var otherCnt = 0

        if(s.length == 1){
            return 1
        }

        for(i in 1 until s.length){

            if(i == s.length-1){
                answer++
                break
            }

            if(xCnt == 0){
                x = s[i]
                xCnt++

                continue
            }

            if(s[i] == x){
                xCnt++
            }else{
                otherCnt++
            }

            if(xCnt == otherCnt){
                answer++
                xCnt = 0
                otherCnt = 0
            }


        }

        return answer
    }
}