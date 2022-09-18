package com.al.dfs;


import java.util.Arrays;
import java.util.Scanner;

public class BOJ2667 {
	
	static boolean[][] visited;
	static int[][] map;
	static int N;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int areaNum = 0;
	static int[] areaSize;

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N][N];
		visited = new boolean[N][N];
		areaSize = new int [N*N];
		
		sc.nextLine();
		
		for(int i = 0; i < N; i ++) {
			String s = sc.nextLine();
			for(int j = 0; j < N; j ++) {
				map[i][j] = s.charAt(j) -'0';
			}
		}
		
		
		
		
		
		for(int i = 0; i < N; i ++) {
			for(int j= 0; j < N; j++) {
				if(map[i][j] == 1 && visited[i][j]==false) {
					areaNum++;
					dfs(i,j);
				}
			}
		}
		
		Arrays.sort(areaSize);
		
		System.out.println(areaNum);
		
		for(int i = 0; i < areaSize.length; i++) {
			if(areaSize[i]==0) {
				continue;
			}
			System.out.println(areaSize[i]);
		}
		
		

	}
	
	
	
	
	static void dfs(int i, int j) {
		visited[i][j] = true;
		areaSize[areaNum]++;
		
		for(int z = 0; z < 4; z ++) {
			int x = j + dx[z];
			int y = i + dy[z];
			
			if(check(y,x) && map[y][x] == 1 && visited[y][x] == false) {
				dfs(y, x);
			}
			
		}
			
	}
	
	
	
	
	static boolean check(int i, int j) {
		boolean isIn = false;
		
		if(i >= 0 && i < N && j >= 0 && j < N) {
			isIn = true;
		} 
		
		return isIn;
	}

}