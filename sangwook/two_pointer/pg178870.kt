package src.main.kotlin.two_pointer

class pg178870 {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer = IntArray(2)

        val n = sequence.size
        var s = 0
        var e = 0
        var sum = sequence[0]

        var minLen = 1000001

        while(e < n) {

            if(sum < k){
                e++
                if(e == n){
                    break
                }
                sum+=sequence[e]
            }else if(sum > k){
                sum-=sequence[s]
                s++
            }else{
                if(e-s < minLen){

                    minLen = e-s
                    answer[0] = s
                    answer[1] = e
                }

                e++
                if(e == n){
                    break
                }
                sum+=sequence[e]
            }

        }

        return answer
    }
}
fun main(){

}