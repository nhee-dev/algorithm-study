package src.main.kotlin.number

class pg135807 {
    val divideList = arrayListOf<Int>()


    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        var answer: Int = 0

        arrayA.sort()
        arrayB.sort()

        getDivideNum(arrayA[0])
        getDivideNum(arrayB[0])


        val divArr = divideList.sortedDescending().toIntArray()

        for(i in divArr.indices){

            var checkFirst = false
            var checkSecond = false

            if(arrayA[0] % divArr[i] == 0){
                checkFirst = checkArr(divArr[i],arrayA,0)
                checkSecond = checkArr(divArr[i],arrayB,1)
            }else{
                checkFirst = checkArr(divArr[i],arrayB,0)
                checkSecond = checkArr(divArr[i],arrayA,1)
            }

            if(checkFirst && checkSecond){
                answer = divArr[i]
                break
            }

        }

        return answer
    }

    fun checkArr(num : Int, arr : IntArray, flag : Int) : Boolean{

        when(flag){
            0 -> {
                arr.forEach{
                    if(it % num != 0){
                        return false
                    }
                }

            }

            1 -> {
                arr.forEach{
                    if(it % num == 0){
                        return false
                    }
                }
            }
        }

        return true

    }



    fun getDivideNum(min : Int){

        val sqrt = Math.sqrt(min.toDouble()).toInt()

        for(i in 1..sqrt){

            if(min %i == 0){
                if(divideList.contains(i)){
                    divideList.remove(i)
                }else{
                    divideList.add(i)
                }


                if(min / i != i){
                    if(divideList.contains(min / i)){
                        divideList.remove(min / i)
                    }else{
                        divideList.add(min / i)
                    }
                }

            }


        }

    }
}
