package src.main.kotlin.number

import kotlin.math.*

class pg181187 {
    fun solution(r1: Int, r2: Int): Long {
        var answer: Long = 0

        for(i in 0 until r2){
            answer += if(i == 0){
                (r2-r1 + 1)
            }else if(i < r1){
                getY(i,r2,0) - getY(i,r1,1)
            }else{
                getY(i,r2,0)
            }
        }

        return answer * 4
    }
    fun getY(a : Int, r : Int, flag : Int) : Int {


        val rr = r.toLong() * r
        val aa = a.toLong() * a

        val cnt = sqrt(rr.toDouble()-aa.toDouble())


        if(flag == 1 && cnt % 1 == 0.0){
            return floor(cnt).toInt() - 1
        }

        return floor(cnt).toInt()

    }
}