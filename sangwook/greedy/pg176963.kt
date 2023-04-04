package src.main.kotlin.greedy

class pg176963 {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        var answer = IntArray(photo.size)

        val hm = HashMap<String,Int>()

        for(i in name.indices){
            hm[name[i]] = yearning[i]
        }

        photo.forEachIndexed{idx, p ->
            var sum = 0

            p.forEach{ name ->
                sum += hm.getOrDefault(name,0)

            }
            answer[idx] = sum

        }

        return answer
    }
}