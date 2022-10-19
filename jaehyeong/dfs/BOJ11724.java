package com.al.dfs;

import java.util.Scanner;

public class BOJ11724 { // 연결요소의 개수   * 참고 할만 함
	   static int N,M,cnt;
	   static boolean[] visited; //정점 방문 여부 확인
	   static boolean[][] nodes; //간선 정보
	   
	public static void main(String[] args) {
		   Scanner scan = new Scanner(System.in);
		   
		   N = scan.nextInt();
	       M = scan.nextInt();
	       visited = new boolean[N+1];
	       nodes = new boolean[N+1][N+1];
	        
	       for(int i=0;i<M;i++) {
	           int from = scan.nextInt(), to = scan.nextInt();
	           nodes[from][to] = true;
	           nodes[to][from] = true;
	       }
	            
	        
	       for(int i=1;i<=N;i++) {
	           if(!visited[i]) {
	               dfs(i);
	               cnt++;
	           }
	       }
	       
	        System.out.println(cnt);
	}
	
    static void dfs(int st) {
    	visited[st] = true;
        for(int i=1;i<=N;i++) {
            if(nodes[st][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

}
