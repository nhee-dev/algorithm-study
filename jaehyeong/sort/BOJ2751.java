package com.al.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2751 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int numNum = Integer.parseInt(br.readLine());
		int[] numArr = new int[numNum];
		for(int i = 0; i < numNum; i ++) {
			numArr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(numArr);
		
		for(int i = 0; i < numNum; i ++) {
			sb.append(numArr[i] + "\n");
		}
		System.out.println(sb);
		
	}

}
