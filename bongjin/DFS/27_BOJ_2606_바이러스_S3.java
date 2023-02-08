import java.io.*;
import java.util.StringTokenizer;

public class 27_BOJ_2606_바이러스_S3 {
    static int C;
    static int N;
    static boolean[][] arr;
    static boolean[] v;
    static int result;    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        arr = new boolean[C + 1][C + 1];
        v = new boolean[C + 1];
        for(int i = 0; i < N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            arr[n1][n2] = true;
            arr[n2][n1] = true;
        }
        result =0;
        dfs(1);
        System.out.println(result-1);
    }

    static void dfs(int n){
        result++;
        v[n] = true;
        for(int i = 1; i <= C; i++){
            if(!v[i] && arr[n][i]){
                dfs(i);
            }
        }
    }
}