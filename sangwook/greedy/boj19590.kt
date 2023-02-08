package src.main.kotlin.greedy

class boj19590{
    fun sol(){
        val N = readLine()!!.toInt()

        var sum = 0L
        val beads = IntArray(N)
        var max = -1
        repeat(N){ i ->
            val bead = readLine()!!.toInt()
            beads[i] = bead
            sum+=bead
            max = maxOf(max,bead)
        }
        if(N == 1){
            println(beads[0])
            return
        }

        if(max > sum-max){
            println(max-(sum-max))
        }else{
            if(sum % 2 == 0L){
                println(0)
            }else{
                println(1)
            }
        }


    }
}

fun main(){
    boj19590().sol()
}