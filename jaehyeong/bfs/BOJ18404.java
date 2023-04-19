package com.al.main;

import java.io.*;
import java.util.*;

public class BOJ18404 { // 현명한 나이트 / S1 / DFS BFS
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M, kY, kX;
	static int[][] targets;
	static int[][] dist;
	static int[][] dir = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		kY = Integer.parseInt(st.nextToken());
		kX = Integer.parseInt(st.nextToken());
		
		targets = new int[M][2];
		for(int i = 0; i < M; i ++) {
			st = new StringTokenizer(br.readLine());
			targets[i][0] = Integer.parseInt(st.nextToken());
			targets[i][1] = Integer.parseInt(st.nextToken());
		}
		dist = new int[N+1][N+1];

	}
	
	static void solve() {

		bfs();
		
		for(int i = 0; i < targets.length; i ++) {
			sb.append(dist[targets[i][0]][targets[i][1]]-1).append(" ");
		}

		
		System.out.println(sb.toString());
	}
	
	static void bfs() {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(kY); Q.add(kX);
		dist[kY][kX] = 1; // 1부터 시작
		
		while(!Q.isEmpty()) {
			int y = Q.poll();
			int x = Q.poll();
			
			for(int i = 0; i < 8; i ++) {
				int ny = y + dir[i][0];
				int nx = x + dir[i][1];
				
				if(!validCheck(ny, nx) || dist[ny][nx] != 0) continue;
				
				Q.add(ny); Q.add(nx);
				dist[ny][nx] = dist[y][x] + 1;
			}
		}
		
	}
	
	static boolean validCheck(int y, int x) {
		return y >= 1 && x >= 1 && y <= N && x <= N;
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}

/*

 - 나이트는 8가지 위치로 이동한다.

 - 나이트 위치와 잡아야할 말들의 위치가 주어지고, 순서대로 최소 몇번의 이동으로 잡을 수 있는지의 문제이다.
 
 - 중복 없이, 잡을 수 있는 위치로만 주어진다.
 
 1. 정답의 최대치
 	맵의 크기는 500 * 1000 이다.
 2. 간단한 접근
	최소 횟수를 구하며 분기가 발생하므로 BFS를 사용하자.
		Q에 나이트의 위치를 넣는다. visit은 0
		8방향을 체크한다.
			맵 범위 안이고, 방문하지 않았으면 방문한다.
			방문 시 이전 횟수 + 1 을 한다. 
			Q에 ny, nx를 넣는다.
		poll 할 때 ny nx가 원하는 위치면 정답에 입력한다. (sb)
		
*/
