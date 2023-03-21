import java.util.*;

public class BOJ_10026_적록색약_G5 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int N;
    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new char[N][N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.next().toCharArray();

        int[] result = {0, 0};
        boolean[][][] v = new boolean[2][N][N];

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!v[k][i][j]) {
                        dfs(i, j, v[k], arr[i][j]);
                        result[k]++;
                    }
                    if (arr[i][j] == 'G')
                        arr[i][j] = 'R';
                }
            }
        }
        System.out.println(result[0] + " " + result[1]);

    }

    static void dfs(int y, int x, boolean[][] v, char ch) {
        v[y][x] = true;
        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if (ny < 0 || nx < 0 || ny >= N || nx >= N || v[ny][nx] || arr[ny][nx] != ch)
                continue;
            dfs(ny, nx, v, ch);
        }
    }

}