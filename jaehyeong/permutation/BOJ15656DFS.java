package com.al.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15656DFS {

	static BufferedReader br;
	static StringTokenizer st;
	static int numN;
	static int pickN;
	static StringBuilder sb;
	static int[] numArr;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
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
		dfs(pickArr, 0);
		
		System.out.println(sb);
	}
	
	static void dfs(int[] pickArr, int depth) {
		if(depth == pickN) {
			print(pickArr, depth);
			return;
		}
		
		for(int i = 0; i < numN; i ++) {
			pickArr[depth] = numArr[i];
			dfs(pickArr, depth+1);
		}
	}
	
	static void print(int[] pickArr, int depth) {
		for(int i = 0; i < depth; i ++) {
			sb.append(pickArr[i] + " ");
		}
		sb.append("\n");
	}

}
