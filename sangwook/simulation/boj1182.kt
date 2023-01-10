package src.main.kotlin.simulation

class boj1182 {
    var cnt = 0
    fun sol() {
        val (n, s) = readLine()!!.split(" ").map { it.toInt() }
        val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

        val visit = BooleanArray(n)

        getSubset(0, s, n, arr, visit)
        println(cnt)

    }

    private fun getSubset(cur: Int, total: Int, n: Int, arr: IntArray, visit: BooleanArray) {
        if (cur == n) {

            var sum = 0
            var flag = false
            for (i in visit.indices) {
                if (visit[i]) {
                    flag = true
                    sum += arr[i]
                }
            }
            if(!flag){
                return
            }

            if (sum == total) {

                cnt++
            }
            return
        }

        visit[cur] = true
        getSubset(cur + 1, total, n, arr, visit)
        visit[cur] = false
        getSubset(cur + 1, total, n, arr, visit)

    }
}

fun main() {
    boj1182().sol()
}