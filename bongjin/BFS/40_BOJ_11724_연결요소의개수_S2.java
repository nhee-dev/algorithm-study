package boj;

import java.util.*;

public class BOJ_11724_연결요소의개수_S2 {
	
	static int[][] arr;
	static boolean[] v;
	static Queue<Integer> q;
	static int result, N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N + 1][N + 1];
		v = new boolean[N + 1];
		q = new LinkedList<Integer>();
		result = 0;
		
		for(int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			arr[x][y] = 1;
			arr[y][x] = 1;			
		}
		
		for(int i = 1; i <= N; i++) {
			if(!v[i]) {
				bfs(i);
				result++;	
			}
		}
		
		System.out.println(result);
		
	}
	
	static void bfs(int s) {
		q.offer(s);
		v[s] = true;
		
		while(!q.isEmpty()) {
			int ns = q.poll();			
			for(int i = 1; i <= N; i++) {
				if(!v[i] && arr[ns][i] == 1) {
					v[i] = true;
					q.offer(i);				
				}
			}
		}
	}
}
