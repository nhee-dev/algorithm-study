package com.al.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 { // 연산자 키워넣기 S1 백트레킹
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int numN;
	static int[] numArr;
	static int[] opArr; 

	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		numN = Integer.parseInt(br.readLine());
		numArr = new int[numN];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < numN; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		opArr = new int[4];
		for(int i = 0; i < 4; i ++) {
			opArr[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	static void solve() {
		int[] arr = opArr.clone();
		int[] choose = new int[numN-1];
		int depth = 0;
		permutation(arr, choose, depth);
		
		System.out.println(MAX);
		System.out.println(MIN);
	}
	
	static void permutation(int[] arr, int[] choose, int depth) {
		if(depth == numN-1) {
			cancul(choose);
			return; // 다 뽑으면 계산
		}
		for(int i = 0; i < 4; i ++) {
			if(arr[i] != 0) {
				choose[depth] = i;
				arr[i]--;
				permutation(arr, choose, depth+1);
				
				arr[i]++;
				choose[depth] = 0;
			}
		}
		
	}
	
	static void cancul(int[] choose) {
		int sum = numArr[0];
		for(int i = 0; i < choose.length; i++) {
			switch(choose[i]) {
				case 0 : sum += numArr[i+1];
					break;
				case 1 : sum -= numArr[i+1];
					break;
				case 2 : sum *= numArr[i+1];
					break;
				case 3 : sum /= numArr[i+1];
					break;
			}
		}
		if (sum > MAX) MAX = sum;
		if (sum < MIN) MIN = sum;
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
