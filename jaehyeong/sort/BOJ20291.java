package com.al.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ20291 {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int N;
	static String[] files;
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		files = new String[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), ".");
			st.nextToken();
			files[i] = st.nextToken();
		}
	}
	
	static void solve() {
		Arrays.sort(files);
		String curF = files[0];
		
		int count = 0;
		for(int i = 0; i < N; i ++) {
			if(files[i].equals(curF)) {
				count++;
			} else {
				sb.append(curF).append(" ").append(count).append("\n");

				curF = files[i];
				count = 1;
			}
			if(i == N-1) {
				sb.append(curF).append(" ").append(count).append("\n");
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
		System.out.println(sb.toString());
	}

}
