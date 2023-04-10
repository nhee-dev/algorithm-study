package src.main.kotlin.simulation

class pg178871 {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        var answer = players.clone()

        val hm = HashMap<String,Int>()
        players.forEachIndexed{ idx, p ->
            hm[p] = idx
        }

        callings.forEach{ curPlayer ->

            val idx = hm.getOrDefault(curPlayer,-1)

            val frontPlayer = answer[idx-1]

            answer[idx-1] = curPlayer
            answer[idx] = frontPlayer
            hm[curPlayer] = idx-1
            hm[frontPlayer] = idx

        }

        return answer
    }
}
fun main(){

}