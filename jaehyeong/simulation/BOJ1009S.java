package com.al.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1009S { // B2 분산처리

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			
			st = new StringTokenizer(br.readLine()," ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int ans = 1;
			
			for(int i = 0; i < b; i++) {
				ans = (ans  * a) % 10;
			}
			
			// 단순화 참고할 표현 부분
			System.out.println(ans==0?10:ans);
		}

	}

}
