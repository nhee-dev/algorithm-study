package com.example.lib.kotlin.combination
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


class boj6603 {

    fun main(){

        val br = BufferedReader(InputStreamReader(System.`in`))
        lateinit var st : StringTokenizer

        while(true){

            st = StringTokenizer(br.readLine())
            val n = st.nextToken().toInt()

            if(n == 0){
                break
            }

            val arr = IntArray(n)

            for(i in arr.indices){
                arr[i] = st.nextToken().toInt()
            }

            val visit = BooleanArray(n)
            comb(arr,visit,0,n,6)
            println()

        }

    }

    fun comb(arr : IntArray, visit : BooleanArray,start : Int, n : Int, r :Int ){

        if(r == 0){
            var str = ""
            for(i in visit.indices){
                if(visit[i]){
                    str+="${arr[i]} "
                }
            }
            println(str.trim())
        }

        for(i in start until n){
            if(!visit[i]){
                visit[i] = true
                comb(arr,visit,i+1,n,r-1)
                visit[i] = false
            }
        }


    }
}