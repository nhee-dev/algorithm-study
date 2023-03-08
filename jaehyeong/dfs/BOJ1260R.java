package com.al.dfs;

import java.io.*;
import java.util.*;

public class BOJ1260R { // DFS와 BFS // S2 // DFS
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int N, M, V;
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	static StringBuilder sb;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		for(int i = 1; i <= N; i ++) {
			adj[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < M; i++) {
			st= new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			adj[x].add(y);
			adj[y].add(x);
		}
		for(int i = 1; i <= N; i ++) {
			Collections.sort(adj[i]);
		}
		
		visited = new boolean[N+1];
		
	}

	static void dfs(int x) {
		visited[x] = true;
		sb.append(x).append(" ");
		
		for(int y : adj[x]) {
			if(visited[y] == true) continue;
			dfs(y);
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.add(start);
		visited[start] = true;
		
		while(!que.isEmpty()) {
			int x = que.poll();
			
			sb.append(x).append(" ");
			
			for(int y : adj[x]) {
				if(visited[y]) continue;
				
				que.add(y);
				visited[y] = true;
			}
		}
	}
	
	
	static void solve() {
		dfs(V); // dfs 결과를 sb에 담는다.
		
		sb.append("\n");
		
		// dfs에서 사용했던 것 공유하면 초기화
		for(int i = 1; i <= N; i ++) {
			visited[i] = false;
		}
		
		bfs(V); // bfs 결과를 sd에 담는다.
		
		System.out.print(sb);
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
