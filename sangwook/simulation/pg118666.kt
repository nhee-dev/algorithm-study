class Solution {
    lateinit var surveyResult : Array<IntArray>

    fun solution(survey: Array<String>, choices: IntArray): String {

        surveyResult = Array(4){IntArray(2)}

        for(i in survey.indices){

            when(choices[i]){
                in 1 .. 3 -> {
                    val key = survey[i][0]
                    val v = choices[i]
                    inputResult(key,4-v)
                }
                in 5 .. 7 ->{
                    val key = survey[i][1]
                    val v = choices[i]
                    inputResult(key,v-4)
                }

            }

        }

        val result = StringBuilder()

        for(i in surveyResult.indices){

            var firstChar = ""
            var secondChar = ""
            when(i){
                0 -> {
                    firstChar = "R"
                    secondChar = "T"
                }
                1 -> {
                    firstChar = "C"
                    secondChar = "F"
                }
                2 -> {
                    firstChar = "J"
                    secondChar = "M"
                }
                3 -> {
                    firstChar = "A"
                    secondChar = "N"
                }

            }
            val first = surveyResult[i][0]
            val second = surveyResult[i][1]

            if(first > second){
                result.append(firstChar)
            }else if( first < second ){
                result.append(secondChar)
            }else{
                if(firstChar < secondChar){
                    result.append(firstChar)
                }else{
                    result.append(secondChar)
                }
            }

        }

        return result.toString()
    }

    fun inputResult(category : Char, point : Int){
        when(category){
            'R'->{
                surveyResult[0][0] += point
            }
            'T'->{
                surveyResult[0][1] += point

            }
            'C'->{
                surveyResult[1][0] += point

            }
            'F'->{
                surveyResult[1][1] += point

            }
            'J'->{
                surveyResult[2][0] += point

            }
            'M'->{
                surveyResult[2][1] += point

            }
            'A'->{
                surveyResult[3][0] += point

            }
            'N'->{
                surveyResult[3][1] += point

            }
        }
    }
}