package src.main.kotlin.string

class pg150370 {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {

        var answerList = arrayListOf<Int>()
        val typeArr = IntArray(26)

        val d = today.split(".")
        val newToday = "${d[0]}${d[1]}${d[2]}".toInt()

        terms.forEach{
            val term = it.split(" ")
            val type = term[0][0]
            val expire = term[1].toInt()

            typeArr[type-'A'] = expire

        }

        privacies.forEachIndexed{ index, it ->

            val info = it.split(" ")
            val date = info[0].split(".")
            val type = info[1]

            var year = date[0].toInt()
            var month = date[1].toInt()
            var day = date[2].toInt()

            month+=typeArr[type[0]-'A']

            if(month > 12){
                year += (month / 12)
                month %= 12
                if(month== 0) {
                    month = 12
                    year--
                }
            }

            day--
            if(day == 0){
                month--
                if(month == 0){
                    month = 12
                    year--
                }
                day = 28
            }

            val monthStr = if(month<10) "0$month" else "$month"
            val dayStr = if( day < 10) "0$day" else "$day"

            val privacy = "$year$monthStr$dayStr".toInt()

            if(newToday - privacy > 0){
                answerList.add(index+1)
            }

        }

        return answerList.toIntArray()
    }
}