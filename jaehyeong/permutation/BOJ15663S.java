package com.al.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ15663S {
	
	static int numN;
	static int pickN;
	static int[] numArr;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		numN = Integer.parseInt(st.nextToken());
		pickN = Integer.parseInt(st.nextToken());
		
		numArr = new int[numN];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < numN; i ++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numArr);
				
		int[] pickArr = new int[pickN];
		int depth = 0;
		
		boolean[] visited = new boolean[numN];
		HashSet<Integer> set = new HashSet();
		dfs(pickArr, depth, visited, set);
		System.out.println(sb);
	}
	
	static void dfs(int[] pickArr, int depth, boolean[] visited, HashSet<Integer> set) {
		if(depth == pickN) {
				print(pickArr);

			return;
		}
		
		int check = -1;
		for(int i = 0; i < numN; i++) {
			if(visited[i] != true && check != numArr[i]) {
				check = numArr[i];
				pickArr[depth] = numArr[i];
				visited[i] = true;
				dfs(pickArr, depth+1, visited, set);
				visited[i] = false;
			}
		}
	}
	
	static void print(int[] pickArr) {
		for(int i = 0; i < pickN; i ++) {
			sb.append(pickArr[i] + " ");
		}
		sb.append("\n");
	}

}
