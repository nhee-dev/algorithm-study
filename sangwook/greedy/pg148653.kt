package src.main.kotlin.greedy

class pg148653 {
    var answer: Int = 0
    fun solution(storey: Int): Int {

        val storeyArr = storey.toString().toCharArray().map{it-'0'}.toIntArray()

        for(i in storeyArr.size-1 downTo 0){

            if(storeyArr[i] <= 4){
                answer+=storeyArr[i]
                continue
            }

            if(storeyArr[i] >= 6){
                answer+= (10-storeyArr[i])
                if(i - 1 < 0){
                    answer+=1
                    continue
                }
                storeyArr[i-1]++
                continue
            }

            if(storeyArr[i] == 5){
                if( i-1 < 0){
                    answer+=5
                    continue
                }

                if(storeyArr[i-1] <= 4){
                    answer+=storeyArr[i]
                }else{
                    answer+=storeyArr[i]
                    storeyArr[i-1]+=1
                }
            }
        }
        return answer

    }
}