package src.main.kotlin.sum

class pg155651 {
    fun solution(book_time: Array<Array<String>>): Int {
        var answer: Int = -1

        // book_time.sortBy{it[0]}

        val timeArr = IntArray(1450)

        book_time.forEach{
            val start = it[0]
            val end = it[1]

            timeArr[timeFormat(start)]+=1
            timeArr[timeFormat(end)+10]-=1
        }

        for(i in 1 until timeArr.size){
            timeArr[i]+=timeArr[i-1]
            answer = maxOf(answer,timeArr[i])
        }



        return answer
    }
    fun timeFormat(time : String):Int{
        val timeSplit = time.split(":")
        val hour = timeSplit[0].toInt()
        val minute = timeSplit[1].toInt()
        return hour*60 + minute



    }
}