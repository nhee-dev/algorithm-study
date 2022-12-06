import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 15_BOJ_18429_실버3 {

    static int N, K, result;
    static int[] kit;
    static int[] day;
    static int[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();
        N = Integer.parseInt(s.split(" ")[0]);
        K = Integer.parseInt(s.split(" ")[1]);
        kit = new int[N];
        day = new int[N];
        v = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            kit[i]= Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(result);
    }

    static void dfs(int cnt) {
        if(cnt == N) {
            boolean result = check();
            if(result)
                result++;
            return;
        }
        for(int i = 0; i < N; i++) {
            if(v[i] == 1)
                continue;
            v[i] = 1;
            day[cnt] = i;
            dfs(cnt + 1);
            v[i] = 0;
        }

    }
    static boolean check() {
        int nowW = 500;
        for(int i = 0; i < N; i++) {
            int idx = day[i];

            nowW += kit[idx];
            nowW -= K;
            if(nowW < 500)
                return false;
        }
        return true;
    }

}