package com.al.bfs;

import java.io.*;
import java.util.*;

public class BOJ18404R { // 현명한 나이트 / S1 /

	static BufferedReader br; 
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M, nightY, nightX;
	static int[][] mArr, map;
	static int[][] dir = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2,1}};
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		nightY = Integer.parseInt(st.nextToken());
		nightX = Integer.parseInt(st.nextToken());
		
		mArr = new int[M][2];
		for(int i = 0; i < M; i ++) {
			st = new StringTokenizer(br.readLine());
			mArr[i][0] = Integer.parseInt(st.nextToken());
			mArr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		map = new int[N+1][N+1];
	}
	
	// map은 1~N
	static void solve() {
		//bfs로 시작위치부터, 각 위치를 방문한다.
		bfs(nightY, nightX);
		
		//Marr의 각 좌표의 Map 값을 출력한다. -> mArr, map
		for(int i = 0; i < M; i ++) {
			sb.append(map[mArr[i][0]][mArr[i][1]]-1).append(" ");
		}
		System.out.println(sb);
	}
	
	static void bfs(int startY, int startX) {
		// Q를 만든다.
		Queue<Integer> Q = new LinkedList<>();
		// 시작 Y, X를 넣는다.
		Q.add(startY); Q.add(startX);
		// 방문 처리를 한다.
		map[startY][startX] = 1;
		
		// Q가 비어있지 않는 동안
		while(!Q.isEmpty()) {
			// Q를 뽑는다.
			int y = Q.poll();
			int x = Q.poll();
			
			// 8방향을 탐색한다. -> map
			for(int i = 0; i < 8; i ++) {
				int ny = y + dir[i][0];
				int nx = x + dir[i][1];
				// valid, !visited(map!=0) 이면 방문
				if(!validCheck(ny, nx)) continue;
				if(map[ny][nx] != 0) continue;
				// Q에 넣는다.
				Q.add(ny); Q.add(nx);
				// 방문 처리 한다.
				map[ny][nx] = map[y][x] + 1;
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
1. 접근
	특정 M개의 칸에 도달하는 최소 이동 수를 구한다.
	2차원 배열로 BFS를 사용해 보자.
	최대 N 500, M 1000일 때,
	공간복잡도 = 250000, 시간 복잡도 = 250000*8 = 200만
	시작위치는 하나 이므로, 시작 위치에서 각 칸에 도달하는 시간을 구하면 된다.(1부터 시작)
2. 정답의 최대치 : 250000
3. 구현
	시작위치로 부터, BFS를 한다.
		8방향을 탐색한다.
		범위내, 방문X, 이면 방문한다.
			방문은 Map에 표시할 것이다. (1~ 1+...)
	M개의 위치에 도달하는데 필요한 map을 출력한다.

*/
