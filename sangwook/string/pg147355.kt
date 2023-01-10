package src.main.kotlin.string

class pg147355 {
    fun solution(t: String, p: String): Int {
        var answer: Int = 0

        var s = 0
        var e = p.length


        while(e < t.length+1){
            val num = t.substring(s,e)
            if(compareStr(num,p)){

                answer++
            }

            s++
            e++
        }

        return answer
    }

    fun compareStr(num : String, p : String) : Boolean{

        val length = p.length
        for(i in 0 until length){

            if(num[i] - '0' > p[i] - '0'){
                return false
            }

            if(num[i] - '0' < p[i] - '0'){
                return true
            }
        }
        return true
    }
}

fun main(){
    val ans = pg147355().solution("500220839878","7")
    println(ans)
}