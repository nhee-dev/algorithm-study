import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] num;
    static int[] answer;
    static StringBuilder sb = new StringBuilder("");
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        
        Arrays.sort(num);
        
        answer = new int[M];
        perm(0, 0);
        
        System.out.println(sb);
    }
    
    static void perm(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(answer[i] + " ");
            }
            sb.append("\n");
            
            return;
        }
        
        for (int i = start; i < N; i++) {
            answer[depth] = num[i];
            perm(depth + 1, i);
        }
    }
}
