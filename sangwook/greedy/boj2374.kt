package src.main.kotlin.greedy

import java.util.*

class boj2374 {
    fun sol() {
        val N = readLine()!!.toInt()
        var max = 0L
        var cnt = 0L

        val stk = Stack<Long>()
       for(i in 0 until N){
            val num = readLine()!!.toLong()

            max = maxOf(max,num)

            if(stk.isEmpty()){
                stk.push(num)
                continue
            }

           if(stk.peek() < num){
               cnt+= num - stk.peek()
               stk.pop()
               stk.push(num)
               continue
           }

           if(stk.peek() > num){
               stk.pop()
               stk.push(num)
           }


        }

        cnt+= max -stk.pop()

        println(cnt)

        }

}

fun main() {
    boj2374().sol()
}