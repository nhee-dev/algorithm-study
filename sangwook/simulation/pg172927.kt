package src.main.kotlin.simulation

class pg172927 {
    lateinit var mineralsArr : Array<String>
    var min = Int.MAX_VALUE
    var sum = 0
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        mineralsArr = minerals
        var cnt = 0
        val size = picks[0] + picks[1] + picks[2]
        var idx = 0
        val arr = IntArray(size)
        for(i in picks.indices){
            if(picks[i] != 0){
                repeat(picks[i]){
                    arr[idx] = i
                    idx++
                }

            }
        }
        val depth = minOf(Math.ceil(minerals.size.toDouble() / 5).toInt(), size)

        val visit = BooleanArray(size)

        dfs(0,depth,visit,arr)

        return min
    }

    fun dfs(cur : Int, depth : Int, visit: BooleanArray, arr : IntArray){

        if(sum >= min) return

        if(cur == depth){
            min = minOf(min,sum)
            return
        }

        for(i in 0 until arr.size){
            if(!visit[i]){
                visit[i] = true
                val tmp = getTired(arr[i], cur)
                sum+=tmp
                dfs(cur+1, depth, visit, arr)
                visit[i] = false
                sum-=tmp
            }
        }


    }


    fun getTired(pick : Int, idx : Int) : Int{

        val startIdx = idx*5
        val range = minOf(startIdx+5,mineralsArr.size)
        var sum = 0
        for(i in startIdx until range){
            val m = mineralsArr[i][0]

            when(pick){
                0 -> {
                    sum += 1
                }
                1 -> {
                    if(m == 'd'){
                        sum+=5
                    }else{
                        sum+= 1
                    }
                }
                2 -> {
                    if(m == 'd'){
                        sum+= 25
                    }else if (m == 'i'){
                        sum+= 5
                    }else{
                        sum+= 1
                    }
                }
            }
        }

        return sum
    }
}