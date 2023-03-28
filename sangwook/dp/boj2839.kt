package src.main.kotlin.dp

class boj2839 {

    val type = intArrayOf(3,5)
    lateinit var dp: IntArray
    fun sol() {
        val  N = readLine()!!.toInt()

        dp = IntArray(N+1){ Int.MAX_VALUE }
        dp[0] = 0

        for(i in type.indices){
            for(j in type[i] until dp.size){
                if(dp[j-type[i]] != Int.MAX_VALUE){
                    dp[j] = minOf(dp[j],dp[j-type[i]]+1)
                }
            }
        }

        if(dp[N] != Int.MAX_VALUE){
            println(dp[N])
        }else{
            println(-1)
        }

    }
}

fun main() {
    boj2839().sol()
}