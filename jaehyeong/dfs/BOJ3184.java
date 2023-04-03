package com.al.dfs;

import java.io.*;
import java.util.*;

public class BOJ3184 { // 양 / S1 / DFS
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int R, C, ansSh, ansWf, sheeps, wolves;
	static String[] map;
	static boolean[][] visited;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new String[R];
		for(int i = 0; i < R; i ++) {
			map[i] = br.readLine();
		}
		visited = new boolean[R][C];
	}
	
	static void solve() {
		
		// 방문한 적 없고, 울타리가 아니면 dfs로 영역을 탐색한다.
		for(int i = 0 ; i < R; i ++ ) {
			for(int j = 0; j < C; j ++) {
								
				if(!visited[i][j] && map[i].charAt(j) != '#') {
					// 해당 영역을 탐색해 O와 V의 수를 구한다.
					dfs(i, j);
					
					// O와 V의 수에 따라 답에 더한다.
					if(sheeps > wolves) ansSh += sheeps;
					else ansWf += wolves;
					
					// 새로운 영역 탐색을 위해 초기화 한다.
					sheeps = 0;
					wolves = 0;
				}
			}
		}
		
		// 영역 탐색이 끝나면 출력
		System.out.println(ansSh + " " + ansWf);
	}
	
	static void dfs(int y, int x) {
		visited[y][x] = true;
		
		if(map[y].charAt(x) == 'o') sheeps++;
		else if(map[y].charAt(x) == 'v') wolves++;
		
		for(int i = 0; i < 4; i ++) {
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			
			if(validCheck(ny, nx) && !visited[ny][nx] && map[ny].charAt(nx) != '#') dfs(ny, nx);
		}
		
	}
	
	static boolean validCheck(int y, int x) {
		return y >= 0 && x >= 0 && y < R && x < C;
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}

/*
3 <= R, C <= 250
  - 양 > 늑대면 이긴다. // 같으면 진다.
  - 상하좌우로만 움직인다.
  - 모든 양, 늑대는 마당 안에 존재한다.
  - 살아남은 양과 늑대의 수를 출력하라.

 bfs로  영역마다 탐색을 시작한다.
 	.이고 방문하지 않았으면 이동한다.
 	O와 V의 수를 샌다.
 O > V면  O만 더하기, 아니면 V만 더하기

 1. 정답의 최대치
 	250
 2. 시간 복잡도
 	BFS 이므로, 시간 복잡도는 최대 250*250이다. 
 3. 케이스
	양과 늑대 일치
	
	양이 도망 (배제)
		
	늑대가 양보다 많음

	양이 없음
	
	늑대가 없음
	
	울타리가 없음
	
	전부 울타리임
*/


