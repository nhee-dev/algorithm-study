package com.al.bfs;

import java.io.*;
import java.util.*;

public class BOJ5567 { // 결혼식 / S2 / BFS
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int N, M, ans;
	static ArrayList<Integer>[] ways;
	static int[] dist;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		ways = new ArrayList[N+1]; // 1부터
		for(int i = 1; i <= N; i++) {
			ways[i] = new ArrayList<>();
		}
		for(int i = 1; i<= M; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ways[a].add(b);
			ways[b].add(a);
		}
		
		dist = new int[N+1];
	}
	
	static void solve() throws IOException {
		
		//1번 노드의 연결부터 해  친구, 친구의 친구(1) 까지 탐색
		bfs();
		
		System.out.println(ans-1);
	}
	
	static void bfs() {
		Queue<Integer> Q = new LinkedList<>();
		
		Q.add(1);
		dist[1] = 1; // 1부터 시작
		
		
		// 1은 본인, 2는 친구, 3은 친구의 친구
		while(!Q.isEmpty()) {
			int now = Q.poll();
			
			ans++; // 본인 포함, 나중에 -1
			// 친구의 친구는 연결을 탐색하지 않는다.
			if(dist[now] == 3) continue;
			
			// 현재 사람의 친구들 중 방문하지 않은 곳
			for(int i : ways[now]) {
				// 방문한 곳 체크
				if(dist[i] != 0) continue;
				
				Q.add(i);
				dist[i] = dist[now]+1;
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}


/*
학교 친구들 관계들이 주어진다.
상근이의 친구의 친구까지 총 몇명인지 구하는 문제이다.
 - 상근이와 연결된 이들 중 친구에 친구까지 구한다. (depth 2)
 - 상근이는 1번이다.
간단히 생각하면, BFS에 1을 넣고, 1번의 연결된 사람들을 탐색해 수를 +1 한다.
연결된 사람들로 가서, 방문하지 않은 곳이 있으면 + 1 한다. 종료한다.
단 두번만 해야하므로, bfs while문이 돌 때 마다 depth를 1씩 증가 시키고, 2가 되면 더이상 않게 한다.
1. 정답의 최대치
	500명, 관계가 1만일 때, 1만 명까지 올 수 있다.
2. 시간 복잡도
	최대  500만 정도 일 것
3. 히든 케이스
	동기가 하나도 없는경우, 무조건 있음 M
	1명 뿐인 경우, 
	모든 동기가 2를 친구로 가진 경우
	동기가 서로가 서로를 친구로 가진 경우
	
*/