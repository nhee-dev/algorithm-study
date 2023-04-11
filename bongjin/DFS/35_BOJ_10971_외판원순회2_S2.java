import java.util.*;

public class 35_BOJ_10971_외판원순회2_S2 {

    static int N;
    static int[][] array;
    static boolean visited[];
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        array = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        for(int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i, 0, 0);
            visited[i] = false;
        }

        System.out.println(result);
    }

    public static void dfs(int start, int now, int sum, int cnt) {
        if(cnt == N - 1) {
            if(array[now][start] != 0) {
                sum += array[now][start];
                if(sum < result) result = sum;
            }
            return;
        }

        for(int i = 1;i <= N; i++) {
            if(visited[i] == false && array[now][i] != 0) {
                visited[i] = true;
                dfs(start, i, sum + array[now][i], cnt + 1);
                visited[i] = false;
            }
        }
    }

}