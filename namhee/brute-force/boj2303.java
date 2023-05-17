import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static int maxNum, answer;
    static int[] card = new int[5];

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            inputCardNum();
            solve(i);
        }
        output();
    }
    
    static void inputCardNum() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
    }
    
    static void solve(int index) {
        int maxRemainder = 0;
        int remainder;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 5; j++) {
                remainder = getRemainder(i, j);
                maxRemainder = remainder > maxRemainder ? remainder : maxRemainder;
            }
        }
        
        if (maxNum <= maxRemainder) {
            maxNum = maxRemainder;
            answer = index;
        }
    }
    
    static int getRemainder(int i, int j) {
        int sum = 0;
        for (int k = 0; k < 5; k++) {
            if (k != i && k != j) {
                sum += card[k];
            }
        }
        return sum % 10;
    }
    
    static void output() {
        System.out.println(answer);
    }
}

// N, 5*4=20*1000 = 2*10^3
