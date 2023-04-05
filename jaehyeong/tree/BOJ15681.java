package com.al.tree;

import java.io.*;
import java.util.*;

public class BOJ15681 { // 트리와 쿼리 // G5 // 트리
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, R, Q;
	static ArrayList<Integer>[] nodes;
	static int[] nodeSum, querys;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		nodes = new ArrayList[N+1];
		for(int i = 1; i<=N; i ++) {
			nodes[i] = new ArrayList<>();
		}
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			nodes[a].add(b);
			nodes[b].add(a);
		}
		nodeSum = new int[N+1];
		querys = new int[Q+1];
		for(int i =1 ;i <= Q; i ++) {
			querys[i] = Integer.parseInt(br.readLine());
		}
		
	}
	
	static void solve() {
		
		// R 노드 시작해, 자손노드들을 탐색해, 각 노드를 루트로하는 총 노드 수를 저장한다.
		dfs(R, -1);
		
		for(int i = 1; i <= Q; i++) {
			sb.append(nodeSum[querys[i]]).append("\n");
		}
		System.out.println(sb);
		
	}
	
	static void dfs(int x, int par) {
		// 자손노드 탐색 후, 끝나면 자손노드수 합 을 해당 위치에 저장
		for(int y : nodes[x]) {
			if(y == par) continue; // 부모 노드는 제외
			
			dfs(y, x);
			nodeSum[x] += nodeSum[y];
		}
		
		// 자신 포함
		nodeSum[x] ++;
	}
	

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
