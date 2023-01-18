package src.main.kotlin.simulation

import java.util.*
class pg133502 {
    fun solution(ingredient: IntArray): Int {
        var answer: Int = 0
        val stk1 = Stack<Int>()
        val stk2 = Stack<Int>()

        for(i in ingredient.indices){
            if(ingredient[i] == 1 && stk1.size >= 3){

                if(stk1.peek() != 3){
                    stk1.push(ingredient[i])
                    continue
                }

                val a = stk1.pop()
                stk2.push(a)

                if(stk1.peek() != 2){
                    val b = stk2.pop()
                    stk1.push(b)
                    stk1.push(ingredient[i])
                    continue
                }

                val c = stk1.pop()
                stk2.push(c)

                if(stk1.peek() != 1){
                    val d = stk2.pop()
                    stk1.push(d)

                    val e = stk2.pop()
                    stk1.push(e)
                    stk1.push(ingredient[i])
                    continue
                }
                stk1.pop()
                stk2.pop()
                stk2.pop()

                answer++

            }else{
                stk1.push(ingredient[i])
            }

        }

        return answer
    }
}