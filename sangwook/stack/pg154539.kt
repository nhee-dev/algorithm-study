package src.main.kotlin.stack

import java.util.*
class pg154539 {
    fun solution(numbers: IntArray): IntArray {
        var answer = IntArray(numbers.size)

        val stk = Stack<Int>()

        for(i in numbers.indices){

            if(stk.isEmpty()){
                stk.push(i)
                continue
            }

            if(numbers[i] <= numbers[i-1]){
                stk.push(i)
                continue
            }

            while(stk.isNotEmpty()){
                val idx = stk.peek()

                if(numbers[idx] < numbers[i]){
                    answer[idx] = numbers[i]
                    stk.pop()
                }else{
                    break
                }

            }
            stk.push(i)

        }

        while(stk.isNotEmpty()){
            answer[stk.pop()] = -1
        }

        return answer
    }
}