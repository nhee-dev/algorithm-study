package com.al.main;

import java.io.*;
import java.util.*;

public class BOJ4963 { // 섬의 개수 / S2 / DFS
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int W, H, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			if(W == 0 && H == 0) break;
			
			ans = 0;
			map = new int[H+1][W+1];
			visited = new boolean[H+1][W+1];
			for(int i = 1; i <= H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			solve();
			sb.append(ans).append("\n");
		}
	}
	
	public static void solve() {

		for(int i = 1; i <= H; i++) {
			for(int j = 1; j <= W; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					dfs(i, j);
					ans ++;
				}
			}
		}
	}
	
	static void dfs(int y, int x) {
		visited[y][x] = true;
		
		for(int i = 0; i < 8; i++) {
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			
			if(!validCheck(ny, nx) || visited[ny][nx] || map[ny][nx] != 1) continue;
			
			
			dfs(ny, nx);
		}
	}
	
	static boolean validCheck(int y, int x) {
		return y >= 1 && x >= 1 && y <= H && x <= W; 
	}

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(sb);
	}

}

/*

1 <= x, y <= 50
 섬과 바다가 주어질 때, 섬의 갯수는?
 - 가로, 세로, 대각선으로 이동 가능한 섬
 - 지도는 바다로 둘러쌓임
 - 1 : 땅, 0 : 바다
 
 - TC 여러개, 처음 : x, 다음 : y
 - 마지막 줄 0 두개
 
 간단히 생각해서, map을 순회하면서 방문하지 않은 1을 만날 때 마다 cnt++ 해주고, dfs로 방문 처리를 한다.
  dfs의 탐색은 8방향 이다.
 
1. 정답의 최대치 : 최대 2500
2. 접근
	for(i)
		for(j)
			if map ij == 1 && !visited ij
 				dfs(i,j);
 	
 	dfs() 
 		i, j 방문처리
 			8방향 탐색
 			(범위 체크 && 방문체크)
 				dfs()


*/
