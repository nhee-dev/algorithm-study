package com.al.bfs;

import java.io.*;
import java.util.*;

public class BOJ11403 { // 경로찾기 / S1 / BFS
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int[][] map, visited;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

	}
	
	static void solve() {
		for(int i = 0; i < N; i++) {
			bfs(i);
		}
		
		for(int i = 0; i < N; i ++) {
			for(int j = 0; j < N; j++) {
				sb.append(visited[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int start) {
		Queue<Integer> Q = new LinkedList<>();
		
		for(int i = 0; i < N; i ++) {
			if(map[start][i] == 1) {
				Q.add(i);
				visited[start][i] = 1;
			}
		}
		
		while(!Q.isEmpty()) {
			int x = Q.poll();
			
			for(int i = 0; i < N; i++) {
				if(visited[start][i] != 0) continue;
				if(map[x][i] == 1) {
					Q.add(i);
					visited[start][i] = 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}

/*
1 <= N <= 100;
각 정점이 다른 정점들로 갈 수 있는지를 출력하는 문제이다.
그래프가 인접행렬로 주어진다.
map은 0부터 N-1까지로 한다.

방문가능한지 체크할 배열을 visited[i][]로 만든다.
노드 0 ~ N까지 i를 돌면서, bfs로 방문 가능한 곳을 방문한다. 방문할 때 마다, vistied[i][방문]을 1로 한다.


N이 1인 경우 0


*/