import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int N;
    static char[][] arr;
    
    static boolean[][] visited;
    static int[] queueX;
    static int[] queueY;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    
    static int weaknessArea, noWeaknessArea;
    
    public static void main(String args[]) throws IOException {
        input();
        solve();
        output();
    }
    
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        arr = new char[N][N];
        String line;
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
    }
    
    static void solve() {
        initData();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfsR(i, j, arr[i][j], false);
                    //bfs(i, j, false);
                    noWeaknessArea++;
                }
            }
        }
        
        resetVisited();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfsR(i, j, arr[i][j], true);
                    //bfs(i, j, true);
                    weaknessArea++;
                }
            }
        }
    }
    
    static void initData() {
        visited = new boolean[N][N];
        queueX = new int[N * N];
        queueY = new int[N * N];
    }
    
    static void resetVisited() {
        visited = new boolean[N][N];
    }
    
    static void dfsR(int y, int x, char color, boolean haveWeakness) {
        visited[y][x] = true;
        
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
                
            if (!isWall(nx, ny) && !visited[ny][nx]) {
                if (haveWeakness) {
                    if (color == 'B' && arr[ny][nx] == 'B') {
                        dfsR(ny, nx, color, haveWeakness);                          
                    }
                    else if (color != 'B' && arr[ny][nx] != 'B') {
                        dfsR(ny, nx, color, haveWeakness);                          
                    }
                }
                else {
                    if (color == arr[ny][nx]) {
                        dfsR(ny, nx, color, haveWeakness);
                    }
                }
            }
        }
    }
    
    static void bfs(int y, int x, boolean haveWeakness) {
        char color = arr[y][x];
        
        int front = -1, rear = -1;
        queueX[++rear] = x;
        queueY[rear] = y;
        visited[y][x] = true;
        
        int nx, ny;
        while (front < rear) {
            x = queueX[++front];
            y = queueY[front];

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                
                if (!isWall(nx, ny) && !visited[ny][nx]) {
                    if (haveWeakness) {
                        if (color == 'B' && arr[ny][nx] == 'B') {
                            queueX[++rear] = nx;
                            queueY[rear] = ny;
                            visited[ny][nx] = true;                            
                        }
                        else if (color != 'B' && arr[ny][nx] != 'B') {
                            queueX[++rear] = nx;
                            queueY[rear] = ny;
                            visited[ny][nx] = true;                            
                        }
                    }
                    else {
                        if (color == arr[ny][nx]) {
                            queueX[++rear] = nx;
                            queueY[rear] = ny;
                            visited[ny][nx] = true;
                        }
                    }
                }
            }
        }
    }
    
    static boolean isWall(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }
    
    static void output() {
        System.out.println(noWeaknessArea + " " + weaknessArea);
    }

}

/* 문제 조건
    목표 : R /= G인 사람과 R == G인 사람이 보는 그림은 각각 몇개의 구역으로 나눠 보이는지 순서대로 출력
        char N * N (N <=100) table, 4방탐색. -> bfs가 유리할 것이라 판단. -> 실제로도 그러했음.
        1초, 128MB. -> 반복문 내 계속 호출하는 함수 내부에 변수를 초기화하지 않도록 주의할 것.
 */
