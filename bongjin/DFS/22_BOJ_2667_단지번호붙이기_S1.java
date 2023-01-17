import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2667 {
    static int arr[][];
    static boolean v[][];
    static int N;
    static int count = 1;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split("");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        v = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] == 1 && !v[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count-1);
        int result[] = new int[count];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] != 0)
                    result[arr[i][j]]++;
            }
        }

        Arrays.sort(result);
        for(int i=1; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static void dfs(int i, int j) {
        arr[i][j] = count;
        v[i][j] = true;
        for(int d = 0; d < dx.length; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if(arr[nx][ny] == 1 && !v[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}