package src.main.kotlin.simulation

import java.util.LinkedList

class boj2002 {
    fun sol() {
        val N = readLine()!!.toInt()

        val enterQueue = LinkedList<String>()
        val exitQueue = LinkedList<String>()
        val map = HashMap<String,Int>()

        repeat(N) {
            val car = readLine()!!
            map[car] = 1
            enterQueue.offer(car)
        }
        repeat(N) {
            val car = readLine()!!
            exitQueue.offer(car)
        }
        var ans = 0

        while (enterQueue.isNotEmpty()) {
            val enterCar = enterQueue.poll()
            if(map[enterCar] == 0){
                continue
            }
            while (exitQueue.isNotEmpty()) {
                val exitCar = exitQueue.poll()
                map[exitCar] = 0
                if (enterCar == exitCar) {

                    break
                }
                ans++


            }
            if (exitQueue.isEmpty()) {
                break
            }
        }

        println(ans)

    }

}

fun main() {
    boj2002().sol()
}