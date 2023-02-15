import java.io.*;
import java.util.*;

class 29_BOJ_1926_그림_S1{

    static int n, m, result = 0, tmp = 0;
    static int[][] arr;
    static int[][] v;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        v = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {

                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(v[i][j] == 0 && arr[i][j] == 1) {
                    v[i][j] = 1;
                    tmp = 1;
                    dfs(i,j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(result);

    }

    public static void dfs(int idx, int jdx) {
        if(result < tmp){
            result = tmp;
        }
        for(int i = 0; i < 4; i++) {
            int nx = idx + dx[i];
            int ny = jdx + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny] == 1 || arr[nx][ny] == 0){
                continue;
            }
            tmp++;
            v[nx][ny] = 1;
            dfs(nx, ny);
        }
    }
}
