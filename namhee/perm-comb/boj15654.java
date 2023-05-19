import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] num;
    static boolean[] visited;
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
        
        sort();
        
        answer = new int[M];
        visited = new boolean[N];
        perm(0);
        
        System.out.print(sb);
    }
    
    static void perm(int depth) {
        if (M == depth) {
            for (int i = 0; i < M; i++) {
                sb.append(answer[i] + " ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                answer[depth] = num[i];
                visited[i] = true;
                perm(depth + 1);
                visited[i] = false;                
            }
        }
    }
    
    static void sort() {
        int tmp;
        for (int i = 0; i < N-1; i++) {
            for (int j = i; j < N; j++) {
                if (num[i] > num[j]) {
                    tmp = num[i];
                    num[i] = num[j];
                    num[j] = tmp;
                }
            }
        }
    }
}
