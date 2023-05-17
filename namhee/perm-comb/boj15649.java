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
        perm(0);
    }
    
    static void perm(int depth) { // worst : 8^8 = 16,777,216
        if (depth == M) {
            StringBuilder sb = new StringBuilder(""); // String 쓸 때보다 메모리 45MB 절약 가능
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            System.out.println(sb);
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                arr[depth] = i;
                visited[i] = true;
                perm(depth + 1);
                visited[i] = false;
            }
        }
    }
}
