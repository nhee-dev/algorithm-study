package com.al.tree;

import java.io.*;
import java.util.*;

public class BOJ1068 { // 트리 / G5 / 트리
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int N, R, root;
	static ArrayList<Integer>[] child;
	static int[] leaf;

	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		child = new ArrayList[N];
		for(int i = 0; i < N; i ++) {
			child[i] = new ArrayList<>();
		}
		
		leaf = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i ++) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent == -1) {
				root = i;
				continue;
			}
			child[parent].add(i);
		}
		
		R = Integer.parseInt(br.readLine());
	}
	
	static void solve() {
		// R 노드를 지운다.
		for(ArrayList<Integer> i : child) {
			if(i.contains(R)) {
				i.remove(i.indexOf(R));
			}
		}
	
		// root 부터 자식들을 돌며 leaf[x]를 구한다.
		// root이 지워지면 0이다.
		if(root != R) dfs(root);

		System.out.println(leaf[root]);
	}
	
	static void dfs(int x) {

		if(child[x].size() == 0) {
			leaf[x] = 1;
			return;
		}
		
		for(int y : child[x]) {
			dfs(y);
			leaf[x] += leaf[y];
		}
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
