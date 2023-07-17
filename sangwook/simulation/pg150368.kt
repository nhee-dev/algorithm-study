package src.main.kotlin.simulation

class pg150368 {
    var newClient = -1
    var sumPrice = -1
    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        var answer: IntArray = intArrayOf()

        val rate = intArrayOf(10,20,30,40)
        val output = IntArray(emoticons.size)

        dupPerm(0,users,emoticons,rate,output)

        return intArrayOf(newClient,sumPrice)
    }

    fun dupPerm(cur : Int,users : Array<IntArray>, emoticons: IntArray, rate : IntArray, output : IntArray){
        if(cur == emoticons.size){

            check(users,emoticons,output)

            return
        }

        for(i in 0 until 4){
            output[cur] = rate[i]
            dupPerm(cur+1,users,emoticons,rate,output)
        }
    }

    fun check(users : Array<IntArray>, emoticons: IntArray, output : IntArray){

        var client = 0
        var sum = 0

        users.forEach{ user ->

            var cost = 0
            val rate = user[0]
            val max = user[1]
            for(i in output.indices){
                if(rate <= output[i]){
                    cost += (emoticons[i] * (100 - output[i]) * 0.01).toInt()
                }
            }

            if(cost >= max){
                client++
            }else{
                sum += cost
            }

        }

        if(newClient < client){
            newClient = client
            sumPrice = sum
        }else if(newClient == client){
            sumPrice = maxOf(sumPrice,sum)
        }

    }
}