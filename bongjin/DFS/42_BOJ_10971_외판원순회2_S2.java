import java.util.*;

public class BOJ_10971_외판원순회2_S2 {

    static int N;
    static int[][] arr;
    static boolean v[];
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N+1][N+1];
        v = new boolean[N+1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 1; i <= N; i++) {
            v[i] = true;
            dfs(i,i,0,0);
            v[i] = false;
        }

        System.out.println(answer);
    }

    public static void dfs(int start, int now, int sum, int cnt) {
        if(cnt == N - 1) {
            if(arr[now][start] != 0) {
                sum += arr[now][start];
                if(sum < answer) answer = sum;
            }
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(v[i] == false && arr[now][i] != 0) {
                v[i] = true;
                dfs(start, i, sum + arr[now][i], cnt + 1);
                v[i] = false;
            }
        }
    }

}