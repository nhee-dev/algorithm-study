package src.main.kotlin.number

class pg140107 {
    fun solution(k: Int, d: Int): Long {
        var answer: Long = 0

        for (i in 0..d / k) {
            val x = i * k.toLong()
            val powD = Math.pow(d.toDouble(), 2.0).toLong()
            val powX = Math.pow(x.toDouble(), 2.0).toLong()
            val y = Math.sqrt((powD - powX).toDouble()).toLong() / k
            answer += y + 1
        }

        return answer
    }
}