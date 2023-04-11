import java.io.*;
import java.util.*;

public class BOJ_1182_부분수열의합_S2{

    static int N, S;
    static int arr[], result[];
    static int cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        if(S == 0) {
            System.out.println(cnt-1);
        }else {
            System.out.println(cnt);
        }
    }

    private static void dfs(int idx, int sum) {
        if(idx == N) {
            if(sum == S) {
                cnt++;
            }
            return;
        }
        dfs(idx+1, sum+arr[idx]);
        dfs(idx+1, sum);
    }
}