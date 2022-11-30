package com.al.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 { // 토마토 2차원
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	
	static int M;
	static int N;
	static int[][] box;
	
	static Queue<Point> q;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int [N][M];
		for(int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M; j ++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		q = new LinkedList();
		int rawTomato = 0;
		for(int i = 0; i < N; i ++) {
			for(int j = 0; j < M; j++) {
				if(box[i][j]==1) {
					q.add(new Point(i, j));
				}
				if(box[i][j]== 1) {
					rawTomato++;
				}
			}
		}
		
		if(q.isEmpty()) {
			System.out.println(-1);
			return;
		}
		if(!q.isEmpty() && rawTomato == 0 ) {
			System.out.println(0);
			return;
		}
		bfs();
		
		int day = 0;
		for(int i = 0; i < N; i ++) {
			for(int j = 0; j < M; j ++) {
				if(box[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				day = Math.max(day, box[i][j]);
			}
		}
		System.out.println(day-1);
				
	}
	
	static void bfs( ) {
		while(!q.isEmpty()) {
			Point now = q.poll();
			int y = now.y;
			int x = now.x;
			for(int i = 0; i < 4; i ++) {
				int newY = y + dy[i];
				int newX = x + dx[i];
				
				if(validCheck(newY, newX) && box[newY][newX] == 0) {
					box[newY][newX] = box[y][x] + 1;
					q.add(new Point(newY, newX));
				}
			}
		}
	}
	
	static boolean validCheck(int y, int x) {
		
		if(y >= 0 && y < N && x >= 0 && x < M) {
			return true;
		}
		
		return false;
	}
	

}

class Point {
	int y;
	int x;
	
	Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
