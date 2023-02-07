package src.main.kotlin.simulation

import java.util.*

class boj2504 {

    fun sol() {

        var answer = 0
        var tmp = 1

        val input = readLine()!!
        val stk = Stack<Char>()

        for (i in input.indices) {

            when (input[i]) {
                '(' -> {
                    tmp *= 2
                    stk.push(input[i])
                }

                ')' -> {
                    if(stk.isEmpty()||stk.peek() != '('){
                        answer = 0
                        break
                    }else if(input[i-1] =='('){
                        answer += tmp
                    }

                    tmp/=2
                    stk.pop()
                }

                '[' -> {
                    tmp *= 3
                    stk.push(input[i])
                }

                ']' -> {
                    if(stk.isEmpty()||stk.peek() != '['){
                        answer = 0
                        break
                    }else if(input[i-1] =='['){
                        answer += tmp
                    }

                    tmp/=3
                    stk.pop()
                }

            }
        }

        if(stk.isNotEmpty()){
            println(0)
        }else{
            println(answer)
        }


    }
}

fun main() {
    boj2504().sol()
}