package com.al.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ1427 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String numS = br.readLine();
		int[] numArr = new int[numS.length()];
		for(int i = 0; i < numS.length(); i ++) {
			numArr[i] = numS.charAt(i) - '0';
		}
		
		Arrays.sort(numArr);
		
		for(int i = numArr.length-1; i >= 0; i --) {
			sb.append(numArr[i]);
		}
		
		System.out.println(sb);
	}

}
