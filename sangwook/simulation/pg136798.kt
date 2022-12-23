package src.main.kotlin.simulation

class pg136798 {
    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer: Int = 0

        for(i in 1..number){
            val num = getDivideNum(i)

            if(num > limit){
                answer += power
            }else{
                answer += num
            }

        }
        return answer
    }
    fun getDivideNum(num : Int) : Int{

        var cnt = 0
        val sqrt = Math.sqrt(num.toDouble()).toInt()
        for(i in 1..sqrt){
            if(num % i == 0){
                cnt++
            }
        }

        cnt*=2

        if(sqrt*sqrt == num){
            cnt--
        }

        return cnt

    }
}