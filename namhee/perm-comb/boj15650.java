import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        arr = new int[M];
        visited = new boolean[N + 1];
        perm(1, 0);
    }
    
    static void perm(int start, int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            System.out.println(sb);
            return;
        }
        
        for (int i = start; i <= N; i++) {
            if (!visited[i]) {
                arr[depth] = i;
                visited[i] = true;
                perm(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}
