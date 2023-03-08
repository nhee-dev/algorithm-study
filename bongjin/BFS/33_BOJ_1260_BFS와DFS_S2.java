package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1260_BFS와DFS_S2 {
	static int N, M, V;
	static int[][] arr;
	static boolean[] v;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		N = Integer.parseInt(str.split(" ")[0]);
		M = Integer.parseInt(str.split(" ")[1]);
		V = Integer.parseInt(str.split(" ")[2]);
		
		arr = new int[N + 1][N + 1];
		q = new LinkedList<Integer>();
		v = new boolean[N + 1];
		
		for(int i = 0; i < M; i++) {
			str = br.readLine();
			int x = Integer.parseInt(str.split(" ")[0]);
			int y = Integer.parseInt(str.split(" ")[1]);
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		dfs(V);
		System.out.println("");
		v = new boolean[N + 1];
		bfs(V);
		
	}
	
	static void dfs(int x) {
		if(v[x]) {
			return;
		}
		v[x] = true;
		System.out.print(x + " ");
		for(int i = 1; i < N + 1; i++) {
			if(arr[x][i] == 1) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int x) {
		q.offer(x);
		v[x] = true;
		
		while(!q.isEmpty()) {
			int nx = q.poll();
			System.out.print(nx + " ");
			for(int i = 1; i < N + 1; i++) {
				if(!v[i] && arr[nx][i] == 1) {
					q.offer(i);
					v[i] = true;
				}
			}
		}
	}
	
}
