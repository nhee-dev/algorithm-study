class Solution {
    public int solution(int[][] maps) {                
        // 0. init data  
        int n = maps.length;
        int m = maps[0].length; 
        
        int[] queueX = new int[n * m];
        int[] queueY = new int[n * m];
        int front = -1, rear = -1;
        int[][] dist = new int[n][m];

        // 1. push first point
        int x = 0, y = 0;
        queueX[++rear] = x;
        queueY[rear] = y;
        dist[y][x] = 1;
        
        // 2. bfs
        int answer = -1;
        int nx, ny;
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };
        while (rear > front) {
            x = queueX[++front];
            y = queueY[front];
            if (x == m - 1 && y == n - 1) {
                answer = dist[y][x];
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (!isOutBound(nx, ny, n, m) && maps[ny][nx] == 1 && dist[ny][nx] == 0) {
                    queueX[++rear] = nx;
                    queueY[rear] = ny;
                    dist[ny][nx] = dist[y][x] + 1;
                }
            }
        }
        
        return answer;
    }
    
    boolean isOutBound(int x, int y, int n, int m) {
        return y < 0 || y >= n || x < 0 || x >= m;
    }
}
