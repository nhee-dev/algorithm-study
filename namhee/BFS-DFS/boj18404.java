import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int X, Y;
    static int[][] board;
    static int[] minDist;
    
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
        
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken()) - 1;
        Y = Integer.parseInt(st.nextToken()) - 1;

        int A, B;
        board = new int[N][N];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken()) - 1;
            B = Integer.parseInt(st.nextToken()) - 1;
            board[A][B] = i;
        }
    }
    
    static void solve() {
        minDist = new int[M + 1];
        bfs();
    }
    
    static void bfs() {
        int[] queue = new int[N * N * 2];
        int front = -1, rear = -1;
        int[][] dist = new int[N][N];
        
        dist[X][Y] = 1;
        queue[++rear] = X;
        queue[++rear] = Y;
        
        int[] dx = { -2, -2, -1, -1, 1, 1, 2, 2 };
        int[] dy = { -1, 1, -2, 2, -2, 2, -1, 1 };
        int nx, ny, x, y;
        while (rear > front) {
            x = queue[++front];
            y = queue[++front];
            
            for (int i = 0; i < 8; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                
                if (!isOutBound(nx, ny) && dist[nx][ny] == 0) {
                    dist[nx][ny] = dist[x][y] + 1;
                    if (board[nx][ny] != 0) {
                        minDist[board[nx][ny]] = dist[nx][ny] - 1;
                    }
                    queue[++rear] = nx;
                    queue[++rear] = ny; 
                }
            }
        }
    }
    
    static boolean isOutBound(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= N;
    }
    
    static void output() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= M; i++) {
            sb.append(minDist[i]).append(' ');
        }
        System.out.println(sb);
    }
}
