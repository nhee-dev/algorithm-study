import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class 19_BOJ_17086_아기상어2_S2 {
    static int N, M, result;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int tmp = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 1){
                    continue;
                }
                tmp = bfs(i, j);
                result = tmp > result ? tmp : result;
            }
        }
        System.out.println(result);
    }


    static int bfs(int x, int y) {
        boolean v[][] = new boolean[N][M];
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] {x, y, 0});
        v[x][y] = true;
        while(!q.isEmpty()) {
            int p[] = q.poll();

            for(int i = 0; i < 8; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                int val = p[2];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M){
                    continue;
                }
                if(v[nx][ny] == true){
                    continue;
                }
                if(arr[nx][ny] == 1){
                    return val + 1;
                }       
                v[nx][ny] = true;
                q.add(new int[] {nx, ny, val + 1});
            }
        }
        return 0;
    }
}