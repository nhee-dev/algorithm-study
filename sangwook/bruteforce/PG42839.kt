package com.example.lib.kotlin.bruteforce

class PG42839 {
    fun solution(numbers: String): Int {
        var answer = 0

        val arr = IntArray(numbers.length)
        for (i in numbers.indices) {
            arr[i] = numbers[i] - '0'
        }

        println(arr.contentToString())
        val output = IntArray(numbers.length)
        val visited = BooleanArray(numbers.length)

        val hs = HashSet<Int>()
        for (i in 0..numbers.length) {
            perm(arr, output, visited, 0, i + 1, hs)
        }

        return hs.size
    }

    fun perm(
        arr: IntArray,
        output: IntArray,
        visited: BooleanArray,
        depth: Int,
        target: Int,
        hs: HashSet<Int>
    ) {

        if (depth == target) {

            var stringNum = "";
            for (i in 0 until target) {
                stringNum += output[i];
            }


            val num = stringNum.toInt()
            if (isPrime(num)) {
                hs.add(num);
            }

            return;

        }

        for (i in arr.indices) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, target, hs);
                visited[i] = false;
            }

        }

    }

    fun isPrime(num: Int): Boolean {

        var i = 0
        val sqrt = Math.sqrt(num.toDouble()).toInt()
        println(sqrt)

        if (num == 2)
            return true;

        if (num % 2 == 0 || num == 1)
            return false;


        for (i in 3..sqrt step 2) {
            if (num % i == 0)
                return false
        }

        return true

    }
}