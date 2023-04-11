package com.al.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15970 { // 화살표 그리기  S4
	
	static class Elem implements Comparable<Elem> {
		int x;
		int color;
		
		public int compareTo(Elem o) {
			if(color != o.color) return this.color - o.color;
			return x - o.x;
		}
	}
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int pN;
	static Elem[] eArr;
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		pN = Integer.parseInt(br.readLine());
		eArr = new Elem[pN];
		
		for(int i = 0; i < pN; i ++) {
			st = new StringTokenizer(br.readLine());
			eArr[i] = new Elem();
			eArr[i].x = Integer.parseInt(st.nextToken());
			eArr[i].color = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solve() {
		Arrays.sort(eArr);
		
		int sum = 0;
		for (int i = 0; i < pN; i ++) {
			if(i == 0) {
				sum += eArr[i+1].x - eArr[i].x;
				continue;
			}
			if(i == pN-1) {
				sum += eArr[i].x - eArr[i-1].x;
				continue;
			}
			if(eArr[i].color == eArr[i+1].color) {
				if(eArr[i].color == eArr[i-1].color) {
					if(eArr[i+1].x - eArr[i].x <= eArr[i].x - eArr[i-1].x) {
						sum += eArr[i+1].x - eArr[i].x;
						continue;
					} else {
						sum += eArr[i].x - eArr[i-1].x;
						continue;
					}
				} else {
					sum += eArr[i+1].x - eArr[i].x;
					continue;
				}
			}else {
				sum += eArr[i].x - eArr[i-1].x;
				continue;
			}
		}
		System.out.println(sum);
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
