package com.al.dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ2606 { // Virus
	static boolean[] visited;
	static int virusComs;
	static ArrayList<Integer>[] coms;
 
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int comNums = sc.nextInt();
		int wayNums = sc.nextInt();
		
		visited = new boolean[comNums+1];
		
		coms = new ArrayList[comNums+1];
		
		for(int i = 0; i < comNums+1; i++) {
			coms[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < wayNums; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			coms[a].add(b);
			coms[b].add(a);
		}
		
		dfs(1);
		System.out.println(virusComs);
		
	}
	
	static void dfs(int node) {
		visited[node] = true;
		
		for(int i = 0; i < coms[node].size(); i++) {
			if(visited[coms[node].get(i)] != true) {
				virusComs++;
				dfs(coms[node].get(i));
			}
		}
		
	}

}
