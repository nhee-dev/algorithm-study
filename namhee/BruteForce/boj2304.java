import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr = new int[1001];
    static int start = 1001;
    static int end = 0;
    static int midL, maxH = 0;
    static int answer;

    public static void main(String args[]) throws IOException {
        input();
        solve();
        output();
    }
    
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        int L, H;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            arr[L] = H;
            
            initPointLocation(L, H);
        }
    }
    
    static void initPointLocation(int L, int H) {
        start = L < start ? L : start;
        end = L > end ? L : end;
        
        if (maxH < H) {
            maxH = H;
            midL = L;
        }
    }
    
    static void solve() {
        getLeftArea();
        getRightArea();
    }
    
    static void getLeftArea() {
        int h = 0;
        for (int i = start; i <= midL; i++) {
            if (h < arr[i]) {
                h = arr[i];
            }
            answer += h;
        }
    }

    static void getRightArea() {
        int h = 0;
        for (int i = end; i > midL; i--) {
            if (h < arr[i]) {
                h = arr[i];
            }
            answer += h;
        }
    }

    static void output() {
        System.out.println(answer);
    }
}
