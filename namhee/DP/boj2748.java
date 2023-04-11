import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static long[] fibo = new long[91];
    static int n;
    
    public static void main(String args[]) throws IOException {
        dp();
        inputData();
        output();
    }
    
    static void dp() {
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= 90; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
    }
    
    static void inputData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }
    
    static void output() {
        System.out.println(fibo[n]);
    }
}
