package src.main.kotlin.greedy

class pg152996 {
    fun solution(weights: IntArray): Long {
        var answer: Long = 0

        val hm = HashMap<Int,Int>()
        val hs = HashSet<Int>()

        weights.forEach{ weight->

            hm[weight] = hm.getOrDefault(weight,0) + 1
            hs.add(weight)
        }

        for(w in hs){



            val wNum = hm[w]!!.toLong()
            if(wNum > 1){
                answer += (wNum* (wNum-1)) / 2
            }

            var otherWeight = 0
            otherWeight = w * 4 / 2
            if(hm.contains(otherWeight)){
                answer += wNum * hm[otherWeight]!!
            }

            otherWeight = w * 2 / 4
            if(w * 2 % 4 == 0){
                if(hm.contains(otherWeight)){
                    answer += wNum * hm[otherWeight]!!
                }
            }


            otherWeight = w * 3 / 4
            if(w * 3 % 4 ==0){
                if(hm.contains(otherWeight)){
                    answer += wNum * hm[otherWeight]!!
                }
            }


            otherWeight = w * 4 / 3
            if(w * 4 % 3 ==0){
                if(hm.contains(otherWeight)){
                    answer += wNum * hm[otherWeight]!!
                }
            }

            otherWeight = w * 3 / 2 + w * 3 % 2
            if(w * 3 % 2 ==0){
                if(hm.contains(otherWeight)){
                    answer += wNum * hm[otherWeight]!!
                }
            }

            otherWeight = w * 2 / 3
            if(w * 2 % 3 ==0){
                if(hm.contains(otherWeight)){
                    answer += wNum * hm[otherWeight]!!
                }
            }

            hm.remove(w)
        }

        return answer
    }
}