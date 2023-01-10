package com.al.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10825S { // S4 국영수
	
	static StringBuilder sb;
	static BufferedReader br;
	static StringTokenizer st;
	
	static class Elem implements Comparable<Elem>{
		
		String name;
		int korean, english, math;
		
		@Override
		public int compareTo(Elem o) {
			
			// 국어 내림차순
			if(korean != o.korean) return o.korean - korean;
			// 영어 오름차순
			if(english != o.english) return english - o.english;
			// 수학 내림차순
			if(math != o.math) return o.math - math;
			// 이름 오름차순
			return name.compareTo(o.name);
		}
		
	}
	
	static int stuN;
	static Elem[] e;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		stuN = Integer.parseInt(br.readLine());
		e = new Elem[stuN];
		for(int i = 0; i < stuN; i++) {
			st = new StringTokenizer(br.readLine());
			e[i] = new Elem();
			e[i].name = st.nextToken();
			e[i].korean = Integer.parseInt(st.nextToken());
			e[i].english = Integer.parseInt(st.nextToken());
			e[i].math = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solve() {
		Arrays.sort(e);
		for(int i = 0; i < e.length; i++) {
			sb.append(e[i].name).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) throws IOException {
		
		input();
		solve();
	}

}
