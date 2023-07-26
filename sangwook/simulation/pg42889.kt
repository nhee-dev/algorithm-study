package src.main.kotlin.simulation

class pg42889

fun solution(N: Int, stages: IntArray): IntArray {
    val answer = IntArray(N)
    val failure = Array(N){DoubleArray(2)}

    repeat(N){ i ->

        val num = i + 1

        var total = 0
        var cnt = 0
        for(j in stages.indices){
            if(num > stages[j]){
                continue
            }

            total++

            if(num == stages[j]){
                cnt++
            }

        }

        failure[i] = doubleArrayOf(num.toDouble(), cnt / total.toDouble())

    }


    failure.sortWith(compareBy({ -it[1] }, { it[0] }))

    for(i in failure.indices){
        answer[i] = failure[i][0].toInt()
    }

    return answer
}
