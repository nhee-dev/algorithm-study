package com.al.bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14716S { // 현수막
	static int H;
	static int W;
	static int[][] map;
	static boolean[][] visited;
	static int[] dh = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dw = {-1, -1, 0, 1, 1, 1, 0, -1};
	static Queue<Point> q;

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
		
		q = new LinkedList<Point>();
		
		int answer = 0;
		for(int i = 0; i < H; i ++) {
			for(int j = 0; j < W; j ++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					q.add(new Point(i,j));
					bfs();
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
	
	static void bfs() {
		
		while(!q.isEmpty()) {
			Point point = q.poll();
			int h = point.x;
			int w = point.y;
					
			for(int d = 0; d < 8; d++) {
				int newH = h + dh[d];
				int newW = w + dw[d];
				
				if(!validCheck(newH, newW)) continue;
				
				if(!visited[newH][newW] && map[newH][newW] == 1) {
					q.add(new Point(newH, newW));
					visited[newH][newW] = true;
				}
				
			}
		}
	}
	
	static boolean validCheck(int h, int w) {
		return h >= 0 && w >= 0 && h < H && w < W;
	}

}





