package com.al.main;

import java.util.*;
import java.io.*;

public class BOJ17070 { // 파이프 옮기기 1 / G5 / 
	
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] map;
	static int N, cnt;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solve() {
		
		cnt = 0;
		
		// dfs 로 모든 경우의 수를 탐방해 본다.
		dfs(1, 2, 1);
		
		// 결과를 출력한다.
		System.out.println(cnt);
	}
	
	// 1 : 가로, 2 : 세로, 3: 대각선
	static void dfs(int y, int x, int state) {
		if(y == N && x == N) cnt++;
		
		if(state == 1) {
			if(checkHor(y, x)) dfs(y, x+1, 1);
			if(checkCro(y, x)) dfs(y+1, x+1, 3);
		} else if(state == 2) {
			if(checkVer(y, x)) dfs(y+1, x, 2);
			if(checkCro(y, x)) dfs(y+1, x+1, 3);
		} else if(state == 3) {
			if(checkHor(y, x)) dfs(y, x+1, 1);
			if(checkVer(y, x)) dfs(y+1, x, 2);
			if(checkCro(y, x)) dfs(y+1, x+1, 3);	
		}
		
	}
	
	static boolean checkHor(int y, int x) {
		// 오른쪽이 범위 내인지 확인 && 오른쪽이 빈 칸인지 확인
		return checkValid(y, x+1) && map[y][x+1] == 0;
	}
	
	static boolean checkVer(int y, int x) {
		// 아래쪽이 범위 내인지 확인 && 아래쪽이 빈 칸인지 확인
		return checkValid(y+1, x) && map[y+1][x] == 0;
	}
	
	static boolean checkCro(int y, int x) {
		// 오른쪽이 범위 내인지 확인 && 오른쪽이 빈 칸인지 확인
		return checkValid(y, x+1) && checkValid(y+1, x) && checkValid(y+1, x+1)
				&& map[y][x+1] == 0 && map[y+1][x] == 0 && map[y+1][x+1] == 0;
	}
	
	static boolean checkValid(int y, int x) {
		return y <= N && x <= N;
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}


/*
 - R C 행 열
 - 1 부터 시작
 - 벽 또는 빈칸
 - 파이프는 2칸을 차지하며 가로로 연결
 - 가로, 세로, 대각선으로 회전 가능
 - 파이프는 항상 빈칸만 차지하며, 밀어서 이동 시킴
 - 밀 방향은 세가지 우, 우하, 하
 - 밀면서 회전 가능 - 45도
 - 가로 : 오른쪽, 대각선 오른쪽 아래
 - 세로 : 아래, 대각선 오른쪽 아래
 - 대각 선 : 가로 오른쪽 아래, 세로 오른쪽 아래, 오른쪽 아래 대각선
 - 처음 파이프는 1,1  1,2 가로를 차지 한다. 파이프의 한쪽 끝을 N, N으로 이동시키는 방법의 수는?

1. 정답의 최대치 : 100만 이하
2. 간단한 접근
	dfs를 이용해 파이프를 매번 7가지 경우의 수 중 가능한 방법으로 밀어 이동 시킨다.
	파이프의 위치가 N,N에 도달하면 cnt++을 한다.
	이동 시킬 때, (1,2)의 좌표만 신경 쓰면 될 것 같다. (어차피 좌와 상은 고려하지 않으며, 이동한 위치로만 이동할 것이기 때문이다.) 
3. 구현
	항상 파이프는 가 : 오, 세 : 아, 대 : 오-아 를 기준으로 한다. 
		(상태 값에 따라 경우의 수를 나눈다.)
		파이프가 가로이면 오른쪽 / 오, 아, 대 가 비어있어야 한다.
		파이프가 세로이면 아래 / 오, 아, 대가 비어있어야 한다.
		파이프가 대각이면 오른쪽/ 아래, 오, 아, 대 가 비어있어야 한다.
		
		이동이 가능하면, 해당위치로 이동 시킨다. (매번 상태 값을 가지고 이동한다. 회전 시켰으면 상태값을 변경 시킬 것이다.)
		N,N에 도달하면 리턴 시킨다.
*/
