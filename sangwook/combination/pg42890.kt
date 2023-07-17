package src.main.kotlin.comb

class pg42890 {
    val list = arrayListOf<String>()
    var ans = 0
    val hs = HashSet<String>()
    fun solution(relation: Array<Array<String>>): Int {

        val len = relation[0].size

        for(i in 1..len){
            val output = IntArray(i)
            comb(0,0,i,output,len,relation)
        }

        return hs.size
    }

    fun comb(cur : Int, start : Int, r : Int, output : IntArray, n : Int,relation: Array<Array<String>>){

        if(cur == r){
            val sb = StringBuilder()
            output.forEach{
                sb.append(it)
            }

            check(sb.toString(),relation)
            return
        }

        for(i in start until n){
            output[cur] = i
            comb(cur+1, i+1, r, output, n,relation)
        }

    }

    fun check(str : String,relation: Array<Array<String>>){

        for(s in hs){
            var flag = true
            for(ch in s){
                if(!str.contains(ch)){
                    flag = false
                    break
                }
            }
            if(flag){
                return
            }
        }

        val strArr = Array<String>(relation.size){""}
        for(i in str.indices){
            val idx = str[i] - '0'

            for(j in relation.indices){
                strArr[j] += relation[j][idx]

            }

        }

        val hs1 = HashSet<String>()
        var flag = true
        for(i in strArr.indices){
            if(!hs1.add(strArr[i])){
                flag = false
                break
            }
        }

        if(flag){
            hs.add(str)

        }
    }
}