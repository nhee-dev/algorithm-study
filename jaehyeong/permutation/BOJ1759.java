package com.al.permutationN;

import java.io.*;
import java.util.*;
	
public class BOJ1759 { // 암호만들기 / G5 / 완전탐색
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int L, C;
	static String[] letters;
	static String[] picked;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		letters = new String[C];
		picked = new String[L];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i ++) { 
			letters[i] = st.nextToken();
		}
	}
	
	static void rec_func(int depth, int start) {

		if(depth == L) {	
			if(checkValid()) print();
			return;
		}
		
		for(int i = start; i < C; i++) {
			picked[depth] = letters[i];
			
			// 현재 depth에 무엇을 담을지를 결정하게 된다.
			// 이번에 안 뽑는 경우는 다음 반복문 진행 시 depth 위치에 다른 것이 채워질 것
			rec_func(depth+1, i+1);
			picked[depth] = "1";
		}
	}
	
	static boolean checkValid() {
		int vowel = 0, cons = 0;
		for(String i : picked) {
			if(i.equals("a") || i.equals("e") || i.equals("i")
					|| i.equals("o") || i.equals("u")) {
				vowel++;
			} else {
				cons++;
			}
		}
		
		return vowel >= 1 && cons >= 2;
	}
	
	static void print() {
		for(int i = 0; i < L; i ++) {
			sb.append(picked[i]);
		}
		sb.append("\n");
	}
	
	static void solve() {
		Arrays.sort(letters);
		
		// 배열을 처음부터 순회하며 각 원소를 뽑을 지 정하고, L개 뽑으면 저장한다.
		rec_func(0, 0);
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
