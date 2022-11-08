package com.al.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1245S {
	static int H;
	static int W;
	static int[][] map;
	static boolean [][] visited;
	static boolean isTop;
	static int[] dx = {-1, -1, 0 , +1, +1, +1, 0, -1}; // 좌 좌상 상 우상 우 우하 하 우좌
	static int[] dy = {0, 1 , 1 , 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new int[H][W];
			visited = new boolean[H][W];
			
			for(int i = 0; i < H; i ++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j ++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			for(int i = 0; i < H; i ++) {
				for(int j = 0; j < W; j ++) {
					if(!visited[i][j]) {
						isTop = true;
						dfs(i, j);
						if(isTop) answer ++;
					}
					
				}
			}
			System.out.println(answer);
		
	}
	
	
	static void dfs(int h, int w) {
		visited[h][w] = true;
		
		for(int a = 0; a < 8; a ++) {
			int newH = h + dy[a];
			int newW = w + dx[a];
			
			// valid 하나로 묶어도 됨
			if(validCheck(newH, newW) && map[h][w] < map[newH][newW]) {
				isTop = false;
			}
			if(validCheck(newH, newW) && map[newH][newW] == map[h][w] && !visited[newH][newW]) {
				dfs(newH, newW);
			}
		}
		
	}
	
	static boolean validCheck(int h, int w) {
		if(h <0 || h >= H || w < 0 || w >= W) {
			return false;
		}
		return true;
	}

}
