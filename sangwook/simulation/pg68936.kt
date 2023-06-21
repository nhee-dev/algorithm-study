package src.main.kotlin.simulation

class pg68936 {
    fun solution(arr: Array<IntArray>): IntArray {
        var answer = IntArray(2)

        recur(0,0,arr,arr.size,answer)


        return answer
    }

    fun recur(x : Int, y : Int, arr : Array<IntArray>, size : Int, answer : IntArray){

        if(check(x,y,arr,size)){
            answer[arr[x][y]]++
            return
        }

        recur(x, y, arr, size / 2, answer)
        recur(x + size / 2 , y, arr, size / 2, answer)
        recur(x, y + size / 2, arr, size / 2, answer)
        recur(x + size / 2, y + size / 2, arr, size / 2, answer)

    }

    fun check(x : Int, y : Int, arr : Array<IntArray>, size : Int) : Boolean{
        val num = arr[x][y]
        for(i in x until x + size){
            for(j in y until y + size){
                if(num != arr[i][j]){
                    return false
                }
            }
        }

        return true
    }
}