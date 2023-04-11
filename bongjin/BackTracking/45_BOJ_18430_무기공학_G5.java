import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj18430_무기공학 {
    static int n, m;
    static int[][] arr;
    static boolean v[][];
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp[] = br.readLine().split(" ");

        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        arr = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(temp[j]);
        }

        v = new boolean[n + 1][m + 1];

        backtracking(0, 0);

        System.out.println(result);
    }

    public static void backtracking(int cnt, int sum) {
        if (cnt == n * m) {
            if (result < sum)
                result = sum;
            return;
        }

        int x = cnt / m;
        int y = cnt % m;

        if (!v[x][y]) {
            if (x + 1 < n && y + 1 < m && !v[x + 1][y] && !v[x][y + 1]) {
                v[x][y] = true;
                v[x + 1][y] = true;
                v[x][y + 1] = true;

                int tsum = sum + 2 * (arr[x][y]) + arr[x + 1][y] + arr[x][y + 1];
                backtracking(cnt + 1, tsum);

                v[x][y] = false;
                v[x + 1][y] = false;
                v[x][y + 1] = false;
            }

            if (x + 1 < n && y - 1 >= 0 && !v[x + 1][y] && !v[x][y - 1]) {
                v[x][y] = true;
                v[x + 1][y] = true;
                v[x][y - 1] = true;

                int tsum = sum + 2 * (arr[x][y]) + arr[x + 1][y] + arr[x][y - 1];
                backtracking(cnt + 1, tsum);

                v[x][y] = false;
                v[x + 1][y] = false;
                v[x][y - 1] = false;
            }

            if (x - 1 >= 0 && y - 1 >= 0 && !v[x - 1][y] && !v[x][y - 1]) {
                v[x][y] = true;
                v[x - 1][y] = true;
                v[x][y - 1] = true;

                int tsum = sum + 2 * (arr[x][y]) + arr[x - 1][y] + arr[x][y - 1];
                backtracking(cnt + 1, tsum);

                v[x][y] = false;
                v[x - 1][y] = false;
                v[x][y - 1] = false;
            }

            if (x - 1 >= 0 && y + 1 < m && !v[x - 1][y] && !v[x][y + 1]) {
                v[x][y] = true;
                v[x - 1][y] = true;
                v[x][y + 1] = true;

                int tsum = sum + 2 * (arr[x][y]) + arr[x - 1][y] + arr[x][y + 1];
                backtracking(cnt + 1, tsum);

                v[x][y] = false;
                v[x - 1][y] = false;
                v[x][y + 1] = false;
            }

        }
        backtracking(cnt+1, sum);
    }

}