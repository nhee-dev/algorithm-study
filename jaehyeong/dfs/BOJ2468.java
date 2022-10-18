package com.al.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2468 { // 안전 영역
	static int n;
	static int map[][];
	static boolean visited[][];
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		map = new int[n][n];
		visited = new boolean [n][n];
		
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < n; j ++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int safeNums = 0;
		int caseStart = 0;

		for(int k = 1; k <= 100; k ++) {
			int resultNums = 0;
			visited = new boolean [n][n];			
			for(int i = 0; i < n; i ++) {
				for(int j = 0; j < n; j ++) {
					
					if(map[i][j] > caseStart && visited[i][j] == false) {
						resultNums++;
						dfs(i, j, caseStart);
					}
				}
			}
			caseStart++;
			if(safeNums < resultNums ) {
				safeNums = resultNums;
			}
		}
		System.out.println(safeNums);
	}
	
	static void dfs(int y, int x, int caseHigh) {
		visited[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int newY = y + dy[i];
			int newX = x + dx[i];
			if(validcheck(newY, newX) && map[newY][newX] > caseHigh && visited[newY][newX] == false) {
				dfs(newY, newX, caseHigh);
			}
		}
		
	}

	static boolean validcheck(int y, int x) {
		if(y < 0 || x < 0 || y >= n || x >= n) {
			return false;
		}
		return true;
	}
}
