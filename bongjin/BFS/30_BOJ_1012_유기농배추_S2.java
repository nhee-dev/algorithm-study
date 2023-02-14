import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012 {
    static int N,M,K;
    static int arr[][];
    static boolean v[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            v = new boolean[N][M];

            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
            int result = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(arr[i][j] == 1 && !v[i][j]){
                        bfs(i,j);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }

    }

    private static void bfs(int row, int col) {
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{row,col});

        while(!q.isEmpty()){
            int node[] = q.poll();

            for(int d = 0; d < 4; d++){
                int nx = node[0] + dx[d];
                int ny = node[1] + dy[d];
                if(nx<0 || ny<0 || nx>=N || ny>=M || v[nx][ny] || arr[nx][ny] == 0) continue;
                q.offer(new int[]{nx,ny});
                v[nx][ny] = true;
            }
        }
    }
}