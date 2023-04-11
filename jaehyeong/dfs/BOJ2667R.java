package com.al.dfs;

import java.io.*;
import java.util.*;

public class BOJ2667R { // 단지번호 붙이기 / S1 / dfs // 다시풀기
	// 이번에는 String을 이용해 map을 사용하였다.
	// 

	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	
	static int N, cnt;
	static String[] map;
	static ArrayList<Integer> areas;
	static boolean[][] visited;
	static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new String[N];
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine();
		}
		visited = new boolean[N][N];
	}
	
	static void dfs(int y, int x) {
		
		visited[y][x] = true;
		cnt++;
		
		for(int k = 0; k < 4; k++) {
			int ny = y + dir[k][0];
			int nx = x + dir[k][1];
			
			if(!checkValid(ny, nx)) continue;
			if(visited[ny][nx]) continue;
			if(map[ny].charAt(nx)=='0') continue;
			
			dfs(ny, nx);
		}
	}
	
	static boolean checkValid(int ny, int nx) {
		return ny >= 0 && nx >= 0 && ny < N && nx < N;
	}
	
	static void solve() {
		areas = new ArrayList<>();

		for(int i = 0; i < N; i ++) {
			for(int j = 0; j < N; j ++) {
				
				if(visited[i][j] == true || map[i].charAt(j) == '0') continue;
				
				cnt = 0;
				dfs(i, j);
				areas.add(cnt);
			}
		}
		
		Collections.sort(areas);
		
		sb.append(areas.size()).append('\n');
		for(int i : areas) {
			sb.append(i).append('\n');	
		}
		
		
		
		System.out.print(sb);
		
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
