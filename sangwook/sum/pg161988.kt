package src.main.kotlin.sum

class pg161988 {
    fun solution(sequence: IntArray): Long {

        val sum = LongArray(sequence.size)

        var plusMinus = -1L
        sum[0] = sequence[0].toLong()
        for(i in 1 until sum.size){
            sum[i] = sum[i-1] + sequence[i] * plusMinus
            plusMinus *= -1L
        }

        var max = 0L
        var min = 0L

        for(i in sum.indices){
            max = maxOf(sum[i],max)
            min = minOf(sum[i],min)
        }


        return Math.abs(max-min)
    }
}