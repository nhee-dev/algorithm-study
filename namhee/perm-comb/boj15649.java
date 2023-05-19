import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder("");
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        arr = new int[M];
        visited = new boolean[N + 1];
        perm(0);
        System.out.print(sb);
    }
    
    static void perm(int depth) {
		if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
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
