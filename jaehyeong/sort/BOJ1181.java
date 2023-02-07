package com.al.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1181 { // 단어정렬 S5 1181 정렬
	static BufferedReader br;
	static StringBuilder sb;
	
	static class Elem implements Comparable<Elem> {
		String word;
		int length;

		@Override
		public int compareTo(Elem o) {
			if(this.length != o.length) return this.length - o.length;
			return this.word.compareTo(o.word);
		}
	}
	
	static int N;
	static Elem[] words;
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		words = new Elem[N];
		for(int i= 0; i < N; i ++) {
			String s = br.readLine();
			words[i] = new Elem();
			words[i].word = s;
			words[i].length = s.length();
		}
	}
	
	static void solve() {
		Arrays.sort(words);
		
		for(int i = 0; i < N; i ++) {
			if(i != 0) {
				if(words[i].word.equals(words[i-1].word)) {
					continue;
				}
			}
			sb.append(words[i].word).append("\n");
		}
		
		
	}
	

	public static void main(String[] args) throws IOException  {
		input();
		solve();
		System.out.println(sb.toString());
	}

}
