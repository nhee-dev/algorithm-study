package com.al.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15652 {
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		int numNum = Integer.parseInt(st.nextToken());
		int pickNum = Integer.parseInt(st.nextToken());
		
		int[] numArr = new int[numNum];
		for(int i = 0; i < numNum; i++) {
			numArr[i] = i + 1;
		}
		
		int[] pickArr = new int[pickNum];
		
		int depth = 0;
		
		permutation(numArr, pickArr, depth, numNum, pickNum);
		
		System.out.println(sb);
	}
	
	static void permutation(int[] numArr, int[] pickArr, int depth, int numNum, int pickNum) {
		if(depth == pickNum) {
			print(pickArr, pickNum);
			return;
		}
		
		for(int i = 0; i < numNum; i++) {
			pickArr[depth] = numArr[i];
			permutation(numArr, pickArr, depth+1, numNum, pickNum);
		}
	}
	
	static void print(int[] pickArr, int pickNum) {
		for(int i = 0; i < pickNum-1; i ++) {
			if(pickArr[i] > pickArr[i+1]) {
				return;
			}
		}
		for(int i = 0; i < pickNum; i ++) {
			sb.append(pickArr[i] + " ");
		}
		sb.append("\n");
	}

}
