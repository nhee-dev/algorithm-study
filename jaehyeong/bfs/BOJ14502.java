package com.al.bfs;

import java.io.*;
import java.util.*;

public class BOJ14502 {

	static BufferedReader br;
	static StringTokenizer st;
	
	static int N, M, max, zeroes;
	static int[][] map;
	static int[][] points;
	static boolean[][] visited;
	static int[][] dir = {{-1, 0},{1, 0},{0, -1},{0, 1}};
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		max = 0;
	
		map = new int[N+1][M+1];
		for(int i = 1; i <= N; i ++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		points = new int[N*M + 1][2];
		visited = new boolean[N+1][M+1];
	}
	
	static void bfs() {
		Queue<Integer> Q = new LinkedList<>();
				
		for(int i = 1; i <= N; i ++) {
			for(int j = 1; j <= M; j ++) {
				visited[i][j] = false;
				
				if(map[i][j] == 2) {
					Q.add(i);
					Q.add(j);
					visited[i][j] = true;
				}
			}
		}
		
		while(!Q.isEmpty()) {
			int y = Q.poll();
			int x = Q.poll();
						
			for(int k = 0; k < 4; k++) {
				int ny = y + dir[k][0];
				int nx = x + dir[k][1];
				
				if(ny < 1 || nx < 1 || ny > N || nx > M) continue;
				if(visited[ny][nx] == true) continue;
				if(map[ny][nx] != 0) continue;
				
				// 벽 또는 바이러스로 채워져 있음
				visited[ny][nx] = true;
				Q.add(ny);
				Q.add(nx);
			}
		}
		

		
		int result = 0;
		for(int i = 1; i <= N; i ++) {
			for(int j = 1; j <= M; j++) {
				if(map[i][j] == 0  && visited[i][j] == false) {
					result++;
				}
			}
		}
		max = Math.max(max, result);
	}
	
	static void rec_func(int idx , int depth) {
		if(depth == 3) {
			bfs();
			return;
		}
		if(idx > zeroes) return;
		
		map[points[idx][0]][points[idx][1]] = 1;
		rec_func(idx+1, depth+1);
		
		// map에서 선택 안함, 벽 선택 초기화!
		map[points[idx][0]][points[idx][1]] = 0;
		rec_func(idx+1, depth);
	}
	
	static void solve() {
		
		// 조합할 포인트 배열값 입력
		zeroes = 0;
		for(int i = 1; i <= N; i ++) {
			for(int j = 1; j <= M; j++) {
				if(map[i][j] == 0) {
					zeroes++;
					points[zeroes][0] = i;
					points[zeroes][1] = j;
				}
			}
		}
		// 3 개를 조합하고, 안전영역을 갱신한다.
		rec_func(1, 0);
		
		// 안전 영역 최대치를 출력한다.
		System.out.println(max);
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
