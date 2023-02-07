package src.main.kotlin.string

class pg133499 {
    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0

        for(i in babbling.indices){
            val word = babbling[i]

            if(word.contains("ayaaya") || word.contains("yeye") || word.contains("woowoo") || word.contains("mama")){
                continue
            }

            val newWord = word.replace("aya",".").replace("ye",".").replace("woo",".").replace("ma",".")
            var flag = true
            for(j in newWord.indices){

                if(newWord[j] != '.'){
                    flag = false
                    break
                }
            }

            if(flag){
                answer++
            }

        }
        return answer
    }
}

fun main(){
    val answer = pg133499().solution(arrayOf("aya", "yee", "u", "maa"))
    println(answer)
}