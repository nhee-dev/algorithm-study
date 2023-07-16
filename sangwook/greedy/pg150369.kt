package src.main.kotlin.greedy

class pg150369 {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var answer: Long = -1

        var lastIdx = n-1
        var dist = 0L

        while(lastIdx != -1){
            var give = 0
            var take = 0
            if(deliveries[lastIdx] != 0 || pickups[lastIdx] != 0){
                dist += (lastIdx+1)*2

                for(i in lastIdx downTo 0){
                    give += deliveries[i]

                    if(give >= cap){
                        deliveries[i] = give-cap
                        break
                    }

                    deliveries[i] = 0
                }

                for(i in lastIdx downTo 0){
                    take += pickups[i]

                    if(take >= cap){
                        pickups[i] = take-cap
                        break
                    }

                    pickups[i] = 0
                }

            }else{
                lastIdx--
            }

        }

        return dist
    }
}