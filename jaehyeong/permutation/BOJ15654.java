package com.al.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15654 {
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		int numNum = Integer.parseInt(st.nextToken());
		int pickNum = Integer.parseInt(st.nextToken());
		
		int[] numArr = new int[numNum];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < numNum; i ++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numArr);
		
		int[] pickArr = new int[pickNum];
		boolean[] visited = new boolean[numNum];
		int depth = 0;
		
		permutation(numArr, pickArr, visited, depth, numNum, pickNum);
		
		System.out.println(sb);
	}
	
	static void permutation(int[] numArr, int[] pickArr, boolean[] visited, int depth, int numNum, int pickNum) {
		if(depth == pickNum) {
			print(pickArr, pickNum);
			return;
		}
		
		for(int i = 0; i < numNum; i ++) {
			if(visited[i] != true) {
				pickArr[depth] = numArr[i];
				visited[i] = true;
				permutation(numArr, pickArr, visited, depth+1, numNum, pickNum);
				visited[i] = false;
			}
		}
	}
	
	static void print(int[] pickArr, int pickNum) {
		for(int i = 0; i < pickNum; i ++) {
			sb.append(pickArr[i] + " ");
		}
		sb.append("\n");
	}

}
