package com.al.dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ2644 {
	
	static int pNums;
	static int p1;
	static int p2;
	static ArrayList<Integer>[] list;
	static int result = -1;
	static boolean[] visited;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		pNums = sc.nextInt();
		p1 = sc.nextInt();
		p2 = sc.nextInt();
		int wayNums = sc.nextInt();
		
		list = new ArrayList[pNums+1];
		for(int i=0; i <= pNums; i ++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < wayNums; i ++) {
			int parent = sc.nextInt();
			int child = sc.nextInt();
			list[parent].add(child);
			list[child].add(parent);
		}
		
		visited = new boolean[pNums+1];
		
		dfs(p1, 0);
		
		System.out.println(result);

	}
	
	static void dfs(int p, int dis) {
		
		visited[p] = true;
		int distance = dis;
		
		if(result != -1) {
			return;
		}
		
		for(int i : list[p]) {
			if(i == p2) {
				result = distance + 1;
				return;
			} else {
				if(result != -1) {
					return;
				} else if(visited[i]==true) {
					continue;
				}
				dfs(i, distance + 1);
	
			}
		}
		
	}


}

