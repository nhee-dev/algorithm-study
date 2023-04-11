package src.main.kotlin.sum

class boj1644 {
    val arr = arrayListOf<Int>()
    var ans = 0
    fun sol() {
        val N = readLine()!!.toInt()
        if (N == 1) {
            println(0)
            return
        }

        repeat(N + 1) { i ->
            val num = i + 1
            if (checkPrime(num)) {
                arr.add(num)
            }
        }

        var s = 0
        var e = 0
        var sum = arr[s]

        val m = arr.size
        while (true) {

            if (sum < N) {
                e++
                if(e == m){
                    break
                }
                sum += arr[e]
            } else if (sum > N) {
                sum -= arr[s]
                s++
            } else {
                ans++
                sum-=arr[s]
                s++
                e++
                if(e == m){
                    break
                }
                sum+=arr[e]
            }
        }

        println(ans)

    }

    fun checkPrime(num: Int): Boolean {

        if (num == 2) {
            return true
        }

        if (num == 1 || num % 2 == 0) {
            return false
        }

        val sqrt = Math.sqrt(num.toDouble()).toInt()

        for (i in 3..sqrt step 2) {

            if (num % i == 0) {
                return false
            }
        }
        return true

    }
}

fun main() {
    boj1644().sol()
}