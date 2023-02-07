import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 24_BOJ_2178_미로탐색_S1 {

    static int n;
    static int m;    
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][] arr;
    static boolean[][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        v = new boolean[n][m];
        v[0][0] = true;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(arr[n - 1][m - 1]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] { x, y });

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = xy[0] + dx[i];
                int ny = xy[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || v[nx][ny] || arr[nx][ny] == 0) {
                    continue;
                }
                q.add(new int[] { nx, ny });
                v[nx][ny] = true;
                arr[nx][ny] = arr[xy[0]][xy[1]] + 1;
            }
        }
    }
}