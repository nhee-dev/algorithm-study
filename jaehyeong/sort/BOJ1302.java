package com.al.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1302 { // 베스트셀러 / S4 / 정렬
	
	static BufferedReader br;
	static int N;
	static String[] wArr;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		wArr = new String[N];
		for(int i = 0; i < N; i++) {
			wArr[i] = br.readLine();
		}
	}
	
	static String lastWord = "";
	static int count;
	static String manyWord;
	static int maxCount = 0;
	
	static void solve() {
		Arrays.sort(wArr);
		
		for(int i = 0; i < N; i++) {
			if(!lastWord.equals(wArr[i])) {
				count = 1;
			} else {
				count++;
			}
			if(count > maxCount) {
				maxCount = count;
				manyWord = wArr[i];
			}
			lastWord = wArr[i];
		}
		System.out.println(manyWord);
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
