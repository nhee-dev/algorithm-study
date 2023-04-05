import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] arr;
    
    static boolean[][] visited;
    static int[] queueX;
    static int[] queueY;
    static int[] stackX;
    static int[] stackY;
    
    static int[] diff = { 1, -1 };
    
    static int answer;

    public static void main(String args[]) throws IOException {
        input();
        solve();
        output();
    }
    
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        
        String str;
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
    }
    
    static void solve() {
        initData();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]){
                    //bfs(i, j);
                    //dfsR(i, j, arr[i][j]);
                    dfs(i, j);
                    answer++;
                }
            }
        }
    }
    
    static void initData() {
        visited = new boolean[N][M];
        queueX = new int[N * M];
        queueY = new int[N * M];
        stackX = new int[N * M * 2];
        stackY = new int[N * M * 2];
    }
    
    static void dfs(int y, int x) {
        int top = -1;
        stackX[++top] = x;
        stackY[top] = y;
        
        char boardType = arr[y][x];
        int nx = 0, ny = 0;
        while (top > -1) {
            x = stackX[top];
            y = stackY[top--];
            
            if (!visited[y][x]) {
                visited[y][x] = true;
            
                for (int i = 0; i < 2; i++) {
                    if (boardType == '-') {
                        nx = x + diff[i];
                        ny = y;
                    }
                    else if (boardType == '|') {
                        nx = x;
                        ny = y + diff[i];
                    }
    
                    if (!isWall(nx, ny) && arr[ny][nx] == boardType && !visited[ny][nx]) {
                        stackX[++top] = nx;
                        stackY[top] = ny;
                    }
                }
            }
        }
    }
    
    static void dfsR(int y, int x, char boardType) {
        visited[y][x] = true;
        int nx = 0, ny = 0;
        for (int i = 0; i < 2; i++) {
            if (boardType == '-') {
                nx = x + diff[i];
                ny = y;
            }
            else if (boardType == '|') {
                nx = x;
                ny = y + diff[i];
            }
            if (!isWall(nx, ny) && arr[ny][nx] == boardType && !visited[ny][nx]) {
                dfsR(ny, nx, boardType);
            }
        }
    }
    
    static void bfs(int y, int x) {
        int front = -1, rear = -1;
        queueX[++rear] = x;
        queueY[rear] = y;
        visited[y][x] = true;
        
        int nx = 0, ny = 0;
        char boardType = arr[y][x];
        while(front < rear) {
            x = queueX[++front];
            y = queueY[front];
            
            for (int i = 0; i < 2; i++) {
                if (boardType == '-') {
                    nx = x + diff[i];
                    ny = y;
                }
                else if (boardType == '|') {
                    nx = x;
                    ny = y + diff[i];
                }

                if (!isWall(nx, ny) && arr[ny][nx] == boardType && !visited[ny][nx]) {
                    queueX[++rear] = nx;
                    queueY[rear] = ny;
                    visited[ny][nx] = true;
                }
            }
            
        }
    }
    
    static boolean isWall(int x, int y) {
        return x < 0 || x >= M || y < 0 || y >= N;
    }
    
    static void output() {
        System.out.println(answer);
    }
}
