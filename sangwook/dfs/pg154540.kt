package src.main.kotlin.dfs

class pg154540 {
    lateinit var visited : Array<BooleanArray>
    lateinit var map : Array<IntArray>
    val dx = intArrayOf(1,0,-1,0)
    val dy = intArrayOf(0,1,0,-1)

    fun solution(maps: Array<String>): IntArray {
        var answer = arrayListOf<Int>()
        map = Array(maps.size){IntArray(maps[0].length)}
        visited = Array(maps.size){BooleanArray(maps[0].length)}
        for(i in maps.indices){
            for(j in maps[0].indices){
                if(maps[i][j] == 'X'){
                    map[i][j] = -1
                }else{
                    map[i][j] = maps[i][j] - '0'
                }
            }
        }

        for(i in map.indices){
            for(j in map[0].indices){
                if(!visited[i][j] && map[i][j] != -1){
                    val size = dfs(i,j)
                    answer.add(size)
                }
            }
        }

        return if(answer.isEmpty()) intArrayOf(-1) else answer.sorted().toIntArray()
    }

    fun dfs(x : Int, y : Int) : Int{

        visited[x][y] = true
        var cnt = map[x][y]

        val cx = x
        val cy = y
        for(i in 0 until 4){
            val nx = cx + dx[i]
            val ny = cy + dy[i]

            if(!(nx in 0 until map.size && ny in 0 until map[0].size)){
                continue
            }

            if(visited[nx][ny]){
                continue
            }

            if(map[nx][ny] == -1){
                continue
            }

            cnt += dfs(nx,ny)

        }
        return cnt
    }
}