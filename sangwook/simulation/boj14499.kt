package src.main.kotlin.simulation

import java.util.*

class boj14499 {

    var n = 0
    var m = 0
    var x = 0
    var y = 0
    var num = 0
    lateinit var map: Array<IntArray>

    var top = 0
    var bottom = 0
    var left = 0
    var right = 0
    var front = 0
    var back = 0

    lateinit var movingArr: IntArray

    fun sol() {
        val (N, M, X, Y, K) = readLine()!!.split(" ").map { it.toInt() }

        n = N
        m = M
        x = X
        y = Y
        num = K

        movingArr = IntArray(num)

        map = Array(n) { IntArray(m) }

        for (i in 0 until n) {
            val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
            map[i] = arr

        }

        movingArr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

        movingArr.forEach {
            if (rollDice(it)) {
                println(top)
            }

        }
    }

    fun rollDice(dir: Int): Boolean {

        when (dir) {
            1 -> return rollEast()
            2 -> return rollWest()
            3 -> return rollNorth()
            4 -> return rollSouth()

        }
        return true
    }

    private fun rollEast(): Boolean {
        if (y + 1 < m) {
            y++
            val tmp = bottom

            if (map[x][y] != 0) {
                bottom = map[x][y]
                map[x][y] = 0
            } else {
                bottom = right
                map[x][y] = bottom

            }
            right = top
            top = left
            left = tmp
            return true

        } else {
            return false
        }

    }

    private fun rollWest(): Boolean {
        if (y - 1 >= 0) {
            y--
            val tmp = bottom

            if (map[x][y] != 0) {
                bottom = map[x][y]
                map[x][y] = 0
            } else {
                bottom = left
                map[x][y] = bottom

            }
            left = top
            top = right
            right = tmp
            return true
        } else {
            return false
        }
    }

    private fun rollNorth(): Boolean {
        if (x - 1 >= 0) {
            x--
            val tmp = bottom

            if (map[x][y] != 0) {
                bottom = map[x][y]
                map[x][y] = 0
            } else {
                bottom = back
                map[x][y] = bottom

            }
            back = top
            top = front
            front = tmp
            return true

        } else {
            return false
        }
    }

    private fun rollSouth(): Boolean {
        if (x + 1 < n) {
            x++
            val tmp = bottom

            if (map[x][y] != 0) {
                bottom = map[x][y]
                map[x][y] = 0
            } else {
                bottom = front
                map[x][y] = bottom

            }
            front = top
            top = back
            back = tmp
            return true

        } else {
            return false
        }
    }

}


fun main() {
    boj14499().sol()

}

