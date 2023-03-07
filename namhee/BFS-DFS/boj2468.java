import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int maxH;    
    static int[][] area;

    static int count;
    static boolean[][] visited;
    static boolean[][] isSafe;
    
    static int[] queueI = new int[100*100];
    static int[] queueJ = new int[100*100];
    static int[] di = { 0, 0, 1, -1 };
    static int[] dj = { 1, -1, 0, 0 };
    
    static int answer;
    
    public static void main(String args[]) throws IOException {
        input();
        solve();
        output();
    }
    
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                
                maxH = area[i][j] > maxH ? area[i][j] : maxH;
            }
        }
    }
    
    static void solve() {
        visited = new boolean[N][N];
        isSafe = new boolean[N][N];
        
        int rain = 0;
        while (rain < maxH) {
            initData(rain);
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (isSafe[i][j] && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            
            answer = count > answer ? count : answer;
            rain++;
        }
    }
    
    static void initData(int rain) {
        count = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;

                if (rain < area[i][j]) {
                    isSafe[i][j] = true;
                } else {
                    isSafe[i][j] = false;
                }
            }
        }
    }
    
    static void bfs(int i, int j) {
        int front = -1, rear = -1;
        
        queueI[++rear] = i;
        queueJ[rear] = j;
        visited[i][j] = true;
        
        int ni, nj;
        while(front < rear) {
            i = queueI[++front];
            j = queueJ[front];
            
            for (int n = 0; n < 4; n++) {
                ni = i + di[n];
                nj = j + dj[n];
                
                if (!isWall(ni, nj) && isSafe[ni][nj] && !visited[ni][nj]) {
                    queueI[++rear] = ni;
                    queueJ[rear] = nj;
                    visited[ni][nj] = true;
                }
            }
        }
    }
    
    static boolean isWall(int i, int j) {
        return i < 0 || i >= N || j < 0 || j >= N;
    }
    
    static void output() {
        System.out.println(answer);
    }
}
