import java.util.Scanner;

public class Main {
    static int T, n;
    static int[] A, B;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        
        for (int test_case = 0; test_case < T; test_case++) {
            n = sc.nextInt();
            A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            
            int sum = 0;
            B = new int[n+1];
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if(A[j] <= A[i]) {
                        B[i-1]++;
                    }
                }
                sum += B[i-1];
            }
            
            System.out.println(sum);
        }
    }
}
