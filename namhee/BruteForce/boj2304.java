import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] L;
    static int[] H;
    static int midL, leftL, rightL;
    static int answer;
    
    public static void main(String args[]) throws IOException {
        input();
        solve();
        output();
    }
    
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        L = new int[N];
        H = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L[i] = Integer.parseInt(st.nextToken());
            H[i] = Integer.parseInt(st.nextToken());
        }
    }
    
    static void solve() {
        sortDescendingByH();
        getArea();
    }
    
    static void sortDescendingByH() {
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (H[i] < H[j]) {
                    swapHL(i, j);
                }
            }
        }
    }
    
    static void swapHL(int i, int j) {
        int tmpH, tmpL;
        tmpH = H[i];
        H[i] = H[j];
        H[j] = tmpH;
        
        tmpL = L[i];        
        L[i] = L[j];
        L[j] = tmpL;
    }
    
    static void getArea() {
        getHighestArea();
        getLeftArea();
        getRightArea();
    }
    
    static void getHighestArea() {
        answer += H[0];
        midL = L[0];
    }
    
    static void getLeftArea() {
        leftL = midL;
        for (int i = 1; i < N; i++) {
            if (midL > L[i] && leftL > L[i]) {
                answer += ((leftL - L[i]) * H[i]);
                leftL = L[i];
            }
        }
    }
    
    static void getRightArea() {
        rightL = midL;
        for (int i = 1; i < N; i++) {
            if (midL < L[i] && rightL < L[i]) {
                answer += ((L[i] - rightL) * H[i]);
                rightL = L[i];
            }
        }
    }
    
    static void output() {
        System.out.println(answer);
    }
}
