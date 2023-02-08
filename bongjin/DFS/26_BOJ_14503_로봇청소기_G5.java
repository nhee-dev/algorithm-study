import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 26_BOJ_14503_로봇청소기_G5 {
    static int N, M, result;
    static int arr[][], v[][];
    static int[] dx= {-1, 0, 1, 0};
    static int[] dy= {0, 1, 0, -1};

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        result = 0;

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        v= new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result++;
        dfs(r, c, d);

        System.out.println(result);
    }
    
    public static void dfs(int x, int y, int dir) {
        int nx, ny, w=0;

        v[x][y] = 1;
        for(int i = 0; i < 4; i++) {
            dir = dir - 1 < 0 ? 3 : dir - 1;
            nx = x + dx[dir];
            ny = y + dy[dir];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
            }else if(arr[nx][ny] == 0 && v[nx][ny] == 0) {
                dfs(nx, ny, dir);
                result++;
                break;
            }
            w++;
        }

        x = x - dx[dir];
        y = y - dy[dir];
        if(x < 0 || x >= N || y < 0 || y >= M) {
            return;
        }else if(w == 4 && arr[x][y] == 0) {
            dfs(x, y, dir);
        }
    }
}