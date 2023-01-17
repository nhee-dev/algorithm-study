package com.al.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11652 { //카드 S4
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;

	static int N; //카드 수
	static long[] cards; //카드 수 담길 배열
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		cards = new long[N];
		
		for(int i = 0; i < N; i++) {
			cards[i] = Long.parseLong(br.readLine());
		}
	}
	
	static void solve() {
		// 오름차순 정렬
		Arrays.sort(cards);
		// 배열 순회하며 최빈값 찾기
		int curCnt = 1;
		int maxCnt = 1;
		long solNum = cards[0];
		for(int i = 1; i < N; i ++) {
			if(cards[i]==cards[i-1]) {
				curCnt++;
			}
			if(cards[i]!=cards[i-1]) {
				curCnt=1;
			}
			if(curCnt > maxCnt) {
				solNum = cards[i];
				maxCnt = curCnt;
			}
		}
		System.out.println(solNum);
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
