package src.main.kotlin.simulation

import java.util.*

class pg176962 {
    fun solution(plans: Array<Array<String>>): Array<String> {


        plans.sortBy { it[1] }
        val stk = Stack<Plan>()
        val list = arrayListOf<String>()

        plans.forEach {

            val name = it[0]
            val start = timeFormatter(it[1])
            val playTime = it[2].toInt()

            val cur = Plan(name,start,playTime)
            if(stk.isEmpty()){
                stk.push(cur)

            }else{

                val pre = stk.pop()

                if(pre.start + pre.playTime <= start){
                    list.add(pre.name)
                    var between = start - (pre.start + pre.playTime)
                    while(between > 0){
                        if(stk.isEmpty()){
                            break
                        }

                        val p = stk.pop()

                        if(p.playTime - between > 0){
                            p.playTime-=between
                            stk.push(p)
                            between = 0
                        }else{
                            list.add(p.name)
                            between -= p.playTime
                        }

                    }

                    stk.push(cur)
                }else{
                    val between = start - pre.start
                    pre.playTime -= between
                    stk.push(pre)
                    stk.push(cur)
                }

            }

        }

        while(stk.isNotEmpty()){
            val p = stk.pop()
            list.add(p.name)
        }


        return list.toTypedArray()
    }

    fun timeFormatter(t: String): Int {
        val time = t.split(":")
        val h = time[0].toInt()
        val m = time[1].toInt()

        return h * 60 + m

    }

    data class Plan(val name: String, val start: Int, var playTime: Int)
}

fun main() {
    pg176962().solution(
        arrayOf(
            arrayOf("science", "12:40", "50"),
            arrayOf("music", "12:20", "40"),
            arrayOf("history", "14:00", "30"),
            arrayOf("computer", "12:30", "100")

        )
    )
}