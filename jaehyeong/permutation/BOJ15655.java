package com.al.permutation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15655 { // N과M 6
	
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	
	static int numNum;
	static int pickNum;
	
	public static void main(String[] args) throws IOException {
	
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		numNum = Integer.parseInt(st.nextToken());
		pickNum = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] numArr = new int[numNum];
		for(int i = 0; i < numNum; i ++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numArr);
		
		int[] pickArr = new int[pickNum];
		int depth = 0;
		
		boolean[] visited = new boolean[numNum];
		
		permutation(numArr, pickArr, visited, depth);
		
		System.out.println(sb);
	}

	static void permutation(int[] numArr, int[] pickArr, boolean[] visited, int depth) {
		if(depth == pickNum) {
			print(pickArr);
			return;
		}
		
		for(int i = 0; i < numNum; i++) {
			if(visited[i] != true) {
				visited[i] = true;
				pickArr[depth] = numArr[i];
				permutation(numArr, pickArr, visited, depth+1);
				visited[i] = false;
			}
		}
		
	}
	
	static void print(int[] pickArr) {
		for(int i = 0; i < pickNum-1; i ++) {
			if(pickArr[i] > pickArr[i+1]) {
				return;
			}
		}
		for(int i = 0; i < pickNum; i++) {
			sb.append(pickArr[i] + " ");
		}
		sb.append("\n");
	}
}











