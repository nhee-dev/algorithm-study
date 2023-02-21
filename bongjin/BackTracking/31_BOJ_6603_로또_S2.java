import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 31_BOJ_6603_로또_S2 {
    public static int[] arr;
    public static boolean[] v;
    public static int max = 6;

    public static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;

        sb = new StringBuilder();
        while(true) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            if(cnt == 0) break;
            arr = new int[cnt];
            v = new boolean[cnt];
            int idx = 0;
            while(idx < arr.length) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < arr.length; i++) {
                if(i + max > arr.length) continue;
                v[i] = true;
                backtracking(i, 1, arr[i] + " ");
                v[i] = false;
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void backtracking(int idx, int cnt, String str) {
        if(idx >= arr.length ||  idx + max - cnt > arr.length) return;
        if(cnt == max) {
            sb.append(str + "\n");
            return;
        }

        for(int i=idx+1; i < arr.length; i++) {
            if(v[i]) continue;
            v[i] = true;
            backtracking(i, cnt+1, str + arr[i] + " ");
            v[i] = false;
        }
    }
}
 
