package src.main.kotlin.string


class pg70129 {
    fun solution(s: String): IntArray {

        var str = s
        var delCnt = 0
        var cnt = 0
        while (str.length != 1) {
            val zeroCnt = str.filter { it == '0' }.length
            delCnt += zeroCnt

            val len = str.length - zeroCnt

            str = Integer.toBinaryString(len)
            cnt++
        }

        return intArrayOf(cnt, delCnt)
    }
}
