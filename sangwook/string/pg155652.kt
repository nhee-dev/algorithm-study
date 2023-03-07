package src.main.kotlin.string

class pg155652 {
    fun solution(s: String, skip: String, index: Int): String {

        val visit = BooleanArray(26)

        for(al in skip){
            visit[al-'a'] = true
        }

        val sb = StringBuilder()

        s.forEach{
            var al = it

            var repeat = index

            while(repeat != 0){

                if(al == 'z'){
                    al = 'a'
                }else{
                    al++
                }

                if(visit[al-'a']){
                    continue
                }

                repeat--

            }

            sb.append(al)
        }

        return sb.toString()
    }
}