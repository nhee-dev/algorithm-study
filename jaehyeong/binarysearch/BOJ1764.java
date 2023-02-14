package com.al.binarysearch;

import java.util.*;
import java.io.*;

public class BOJ1764 { // 듣보잡 S4 이분탐색

	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	
	static int N;
	static int M;
	static String[] A;
	static String[] B;
	static ArrayList<String> sameN;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new String[N+1];
		for(int i = 1; i <= N; i ++) {
			A[i] = br.readLine();
		}
		
		B = new String [M+1];
		for(int i = 1; i <= M; i ++) {
			B[i] = br.readLine();
		}
		
		sameN = new ArrayList<String>();
	}
	
	static void solve() {
		Arrays.sort(B, 1, M+1);
		
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			int index = binary(B, 1, M, A[i]); // 찾으면 index를, 없으면 0을 돌려줌
			
			if(index == 0) continue;
			
			sameN.add(B[index]);
			ans++;
		}
		
		Collections.sort(sameN);
		sb.append(ans).append("\n");
		for(int i = 0; i < ans; i++) {
			sb.append(sameN.get(i)).append("\n");
		}
		
		System.out.print(sb);
		
	}
	
	static int binary(String[] B, int L, int R, String X) {
		int result = 0;
		while(L <= R) {
			int mid = (L + R)/2;
			if(B[mid].equals(X)) {
				result = mid;
				break;
			}
			if(B[mid].compareTo(X) > 0) {
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
