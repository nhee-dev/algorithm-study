package com.al.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class BOJ2178 { // 다시 풀기
	
	static int n;
	static int m;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		int[][] maze = new int[n][m]; // 맵 생성
		for(int i = 0; i < n; i ++) { // 맵 세팅
			String s = sc.nextLine();
			char[] c = s.toCharArray();
			for(int j = 0; j < m; j++) {
				maze[i][j] = c[j] - '0';
			}
		}
		
		Queue<Pair> q = new LinkedList<Pair>();
		int[][] dist = new int[n][m];
		
		q.offer(new Pair(0,0));
		dist[0][0] = 1;
		
		int[] dy = {-1, 1, 0, 0};
		int[] dx = {0, 0, -1, 1};
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			int y = p.y;
			int x = p.x;
			for(int i = 0; i < 4; i ++) {
				y = p.y + dy[i];
				x = p.x + dx[i];
				
				if(checkValid(y, x)) {
					if(maze[y][x] == 1 && dist[y][x] == 0) {
						q.offer(new Pair(y, x));
						dist[y][x] = dist[p.y][p.x] + 1;
					}
				}else {
					continue;
				}
				
			}			
			
		}
		
		System.out.println(dist[n-1][m-1]);

		
		
		
	}
	
	static boolean checkValid(int h, int w) {
		if(h < 0 || w < 0 || h >= n || w >= m) {
			
			return false;
		}

		return true;
	}
	
	static class Pair {
		int y;
		int x;
		
		Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
