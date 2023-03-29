package src.main.kotlin.simulation

class pg172928 {
    val dx = intArrayOf(-1,1,0,0)
    val dy = intArrayOf(0,0,-1,1)
    lateinit var map : Array<IntArray>
    var n = 0
    var m = 0
    var cx = 0
    var cy = 0

    fun solution(park: Array<String>, routes: Array<String>): IntArray {

        n = park.size
        m = park[0].length
        map = Array(n){IntArray(m)}

        park.forEachIndexed{ i, line ->
            line.forEachIndexed{ j, land ->
                if(land == 'S'){
                    cx = i
                    cy = j
                }else if(land == 'O'){
                    map[i][j] = 0
                }else{
                    map[i][j] = 1
                }
            }
        }
        for(i in routes.indices){
            val r = routes[i].split(" ")
            val dir = r[0]
            val step = r[1].toInt()

            checkDir(dir,step)

        }

        return intArrayOf(cx,cy)
    }

    fun checkDir(dir : String, step : Int) {
        var ox = cx
        var oy = cy

        var nx = 0
        var ny = 0
        var flag = true
        repeat(step){
            when(dir){

                "N" -> {
                    nx = ox + dx[0]
                    ny = oy + dy[0]
                }
                "S" -> {
                    nx = ox + dx[1]
                    ny = oy + dy[1]
                }
                "W" -> {
                    nx = ox + dx[2]
                    ny = oy + dy[2]
                }
                "E" -> {
                    nx = ox + dx[3]
                    ny = oy + dy[3]
                }
            }

            if(!(nx in 0 until n && ny in 0 until m)){
                flag = false
                return@repeat
            }

            if(map[nx][ny] == 1){
                flag = false
                return@repeat
            }

            ox = nx
            oy = ny
        }

        if(flag){
            cx = ox
            cy = oy
        }

    }
}