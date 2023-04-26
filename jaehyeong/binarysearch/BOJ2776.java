package com.al.main;

import java.util.*;
import java.io.*;

public class BOJ2776 { // 경쟁적 전염

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int T, N, M;
	static String[] arr1, arr2;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr1 = br.readLine().split(" ");
			
			M = Integer.parseInt(br.readLine());
			arr2 = br.readLine().split(" ");
			
			solve();
		}

	}
	
	static void solve () {
		//arr2의 각 원소에 대해 이분 탐색으로 있는지 확인한다.
		Arrays.sort(arr1);
		
		for(String s : arr2) {
			if(binary_search(s)) sb.append("1").append("\n");
			else sb.append("0").append("\n");
		}
	}
	
	static boolean binary_search(String X) {
		boolean result = false;
		
		int L = 0; int R = N-1;
		while(L <= R) {
			int mid = (L+R)/2;
						
			if(arr1[mid].equals(X)) {
				result = true;
				break;
			} else if(arr1[mid].compareTo(X) > 0) {
				R = mid-1;
			} else {
				L = mid + 1;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		input();
		System.out.println(sb.toString());
	}

}
