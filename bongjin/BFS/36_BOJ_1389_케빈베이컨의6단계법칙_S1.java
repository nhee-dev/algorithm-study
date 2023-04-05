package boj;
import java.util.*;

public class BOJ_1389_케빈베이컨의6단계법칙_S1 {
	static Queue<Integer> q;
	static int[][] arr;
	static boolean[] v;
	static int N, M, result, sum, total;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N + 1][N + 1];
		result = Integer.MAX_VALUE;
		
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		sum = Integer.MAX_VALUE;
		q = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++) {			
			v = new boolean[N + 1];
			total = 0;
			bfs(i);
			if(total < sum) {
				sum = total;
				result = i;
			}
		}

		System.out.println(result);
	}
	
	static void bfs(int s) {
		int cnt = 0;
		q.offer(s);
		v[s] = true;
		
		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (int l = 0; l < size; l++) {
				int n = q.poll();
				
				for (int j = 1; j < N + 1; j++) {
					if (arr[n][j] == 1 && !v[j]) {
						q.offer(j);
						v[j] = true;
						total += cnt;
					}
				}
			}
			
		}
	}

}
