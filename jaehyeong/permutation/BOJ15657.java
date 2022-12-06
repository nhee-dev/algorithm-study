package com.al.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15657 {
	
	static int pickN;
	static int numN;
	static int[] numArr;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		numN = Integer.parseInt(st.nextToken());
		pickN = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
		
		numArr = new int[numN];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < numN; i ++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numArr);
		
		int[] pickArr = new int[pickN];
		
		int depth = 0;
	
		permutation(pickArr, depth);
		
		System.out.println(sb);
	}
	
	static void permutation(int [] pickArr, int depth) {
		if(depth == pickN) {
			print(pickArr);
			return;
		}
		
		for(int i = 0; i < numN; i++) {
			pickArr[depth] = numArr[i];
			permutation(pickArr, depth+1);
		}
	}
	
	static void print(int [] pickArr) {
		for(int i = 0; i < pickN-1; i ++) {
			if(pickArr[i] > pickArr[i+1]) {
				return;
			}
		}
		for(int i = 0; i < pickN; i ++) {
			sb.append(pickArr[i] + " ");
		}
		sb.append("\n");
	}

}
