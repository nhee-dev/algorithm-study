package com.al.bfs;

import java.io.*;
import java.net.StandardSocketOptions;
import java.util.*;

public class BOJ7562 { // 나이트의 이동 / S1 / 
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int TC, N;
	static int[][] sites;
	static int[][] map;
	static int[][] dir = {{-1, -2},{-2, -1},{-2, 1},{-1, 2},
			{1, 2},{2, 1},{2, -1},{1, -2}};
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		TC = Integer.parseInt(br.readLine());
		sites = new int[2][2];
		
		for(int i = 1; i<= TC; i++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int k = 0; k < 2; k++) {
				st = new StringTokenizer(br.readLine());
				sites[k][0] = Integer.parseInt(st.nextToken());
				sites[k][1] = Integer.parseInt(st.nextToken());
			}
			
			solve();
		}
	}
	
	static void solve() {
		bfs(sites[0][0], sites[0][1]);
		
		if(map[sites[1][0]][sites[1][1]] == 0) 
			map[sites[1][0]][sites[1][1]] = 1;

		sb.append(map[sites[1][0]][sites[1][1]]-1).append("\n");
	}
	
	static void bfs(int starty, int startx) {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(starty);
		Q.add(startx);
		map[starty][startx] = 1;
		
		while(!Q.isEmpty()) {
			int y = Q.poll();
			int x = Q.poll();
			
			if(y == sites[1][0] && x == sites[1][1]) break;
			
			for(int k = 0; k < 8; k++) {
				int ny = y + dir[k][0];
				int nx = x + dir[k][1];
				
				if(!validCheck(ny, nx)) continue;
				if(map[ny][nx] != 0) continue;
				
				Q.add(ny);
				Q.add(nx);
				map[ny][nx] = map[y][x] + 1;
			}
		}
	}
	
	static boolean validCheck(int y, int x) {
		return y >= 0 && x >= 0 && y < N && x < N;
	}
	
	public static void main(String[] args) throws IOException {
		input();
		System.out.println(sb);

	}

}

/*
3 <= N <= 300

나이트는 8방향으로 이동이 가능하다.
격자형 그래프와, 목표지점 이 주어질때, 최소 몇번 만에 이 칸으로 갈 수 있는가?
 - 입력 : TC부터
 - 격자 : N N // 0 <= i <= N-1
 - TC : 체스판 길이 N, 현재 칸, 이동하려는 칸
 
 
가중치 없는 그래프에서 최단시간 구하는 문제이다. BFS를 해보자.
그래프는 0 ... N-1 까지의 배열로 구성된다.
1. 정답의 최대치
	N 300 일때, 9만
2. 접근
	현재 위치를 Que에 넣는다. map에 현재 위치를 1로 방문 체크 한다.(1칸) 나중에 -1;
	8방위 를 탐색한다. 1. 배열 범위   2. 방문   ... 목표지점 도달하면 큐에 넣고, poll 시 종료
	넣을 대마다 dist 한다.
3. 특이 케이스
	한번도 이동할 수 없으면 0리턴 하는가?
	도달할 수 없는 경우는? -> 어떻게 되는지 모르겠는데, 가능성없는 거 같기도, 0으로 해두자.
	
	1
	2
	11
	00
	

*/