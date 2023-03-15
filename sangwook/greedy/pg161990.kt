package src.main.kotlin.greedy

class pg161990 {
    fun solution(wallpaper: Array<String>): IntArray {

        var minX = -1
        var minY = -1
        var maxX = -1
        var maxY = -1

        for(i in wallpaper.indices){
            val files = wallpaper[i]

            for(j in files.indices){
                val f = files[j]
                if(f == '#'){

                    if(minX == -1){
                        minX = i
                        minY = j
                        maxX = i
                        maxY = j
                    }else{
                        minX = minOf(i,minX)
                        minY = minOf(j,minY)
                        maxX = maxOf(i,maxX)
                        maxY = maxOf(j,maxY)
                    }

                }
            }
        }


        return intArrayOf(minX,minY,maxX+1,maxY+1)
    }
}