import java.util.;

class Solution {
    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int answer = bfs(maps, visited);
        return answer;
    }
    
    public int bfs(int[][] maps, boolean[][] visited) {
        QueuePoint q = new LinkedListPoint();
        q.offer(new Point(0,0,1));
        visited[0][0] = true;
        
        int res = 0;
        boolean goal = false;
        
        while(!q.isEmpty()) {
            Point cur = q.poll();
             
             목표지점 도착
            if(cur.x == maps.length -1 && cur.y == maps[0].length -1) {
                res = cur.depth;
                goal = true;
                break;
            }
            
            for(int i = 0; i4; i++) {
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                
                if(x  0  y  0  x  maps.length-1  y  maps[0].length-1)
                    continue;
                
                if(maps[x][y] == 1 && !visited[x][y]) {
                    q.offer(new Point(x, y, cur.depth + 1));
                    visited[x][y] = true;
                    res = cur.depth + 1;
                }
            }
        }       
        
        if(goal) {
            return res;
        } else {
            return -1;
        }
    }
}

class Point {
    int x, y, depth;
    public Point(int x, int y, int depth) {
        this.x = x; this.y = y; this.depth = depth;
    }
}