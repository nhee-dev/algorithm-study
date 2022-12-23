package src.main.kotlin.simulation

import java.util.*

class pg138476 {
    fun solution(k: Int, tangerine: IntArray): Int {

        val countArr = IntArray(10000001)

        tangerine.forEach{
            countArr[it]++
        }

        countArr.sortDescending()

        var rest = k
        var ans = 0
        for(i in countArr.indices){
            if(rest == 0){
                break
            }
            val quantity = countArr[i]

            if( quantity <= rest ){
                ans++
                rest -= quantity
            }else{
                ans++
                rest = 0
                break
            }

        }

        return ans

    }
}