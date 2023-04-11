package com.al.tree;

import java.io.*;
import java.util.*;

public class BOJ11725 {
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static ArrayList<Integer>[] nodeArr;
	static int[] parent;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nodeArr = new ArrayList[N+1];
		for(int i = 1; i <= N; i ++) {
			nodeArr[i] = new ArrayList<Integer>();
		}
		for(int i = 1; i <= N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			nodeArr[a].add(b);
			nodeArr[b].add(a);
		}
		parent = new int[N+1];
		
	}
	
	static void solve() {
		
		// 1번 노드부터 자식노드들의 부모를 parent[자식]에 입력한다.
		dfs(1, -1);
		
		for(int i = 2; i <= N; i ++) {
			sb.append(parent[i]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int x, int par) {
		for(int y : nodeArr[x]) {
			if(y == par) continue;
			
			parent[y] = x;
			dfs(y, x);
		}
		
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
