package com.al.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1260 { // dfs/bfs
	
	static ArrayList<Integer>[] wayList;
	static boolean[] visited;
	static ArrayList<Integer> resultD;
	static int nodeNums;
	static Queue<Integer> q;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		nodeNums = sc.nextInt();
		int wayNums = sc.nextInt();
		int startNode = sc.nextInt();
		
		//간선 정보 담을 배열 생성
		wayList = new ArrayList[nodeNums+1];
		for(int i = 0; i < nodeNums+1; i++) {
			wayList[i] = new ArrayList<>();
		}
		
		//간선 정보를 배열에 입력 
		for(int i = 0; i < wayNums; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			// 양방향 등록
			wayList[a].add(b);
			wayList[b].add(a);
						
		}
		
		//낮은 수부터 방문하기 위해 정렬
		for(ArrayList i : wayList) {
			Collections.sort(i);
		}
		
		//방문 중복 방지 위한 배열
		visited = new boolean[nodeNums+1];
		//방문 결과 담을 배열
		resultD = new ArrayList<>();
		
		dfs(startNode);
		for(int i = 0; i < resultD.size(); i++) {
			if(i == resultD.size()-1) {
				System.out.println(resultD.get(i));
			} else {
				System.out.print(resultD.get(i) + " ");
			}
		}
		
		
		//DFS를 위한 Queue 생성
		q = new LinkedList();

		visited = new boolean[nodeNums+1];
		resultD = new ArrayList<>();
		bfs(startNode);
		
		for(int i = 0; i < resultD.size(); i++) {
			if(i == resultD.size()-1) {
				System.out.println(resultD.get(i));
			} else {
				System.out.print(resultD.get(i) + " ");
			}
		}
	}
	
	
	static void dfs(int node) {
		visited[node] = true; // 정점 방문 처리
		resultD.add(node); // 방문 한 순서 기록
		
		for(int i : wayList[node]) {
			if(visited[i] == false) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int node) {
		visited[node] = true; 
		resultD.add(node);
		
		for(int i : wayList[node]) {
			q.offer(i);
			visited[i] = true;
			resultD.add(i);
		}
		
		while(!q.isEmpty()) {
			int n = q.poll();
			
			for(int i : wayList[n]) {
				if(visited[i] == false) {
					q.offer(i);
					visited[i] = true;
					resultD.add(i);
				}
			}

		}
				
	}

}
