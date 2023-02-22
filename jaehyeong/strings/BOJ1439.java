package com.al.string;

import java.io.*;
import java.util.*;

public class BOJ1439 { // 뒤집기 S5 문자열 ... 같은 난이도인데 이게 훨씬 쉽..
	
	static BufferedReader br;
	static String s;
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
	}
	
	static void solve() {
		//String을 0으로 나누면 몇개진지세고, 1로 나누면 몇개인지 센다. 적은 쪽을 뒤집는다.
		int zeroCase = new StringTokenizer(s, "1").countTokens();
		int oneCase = new StringTokenizer(s, "0").countTokens();
		
		int result = Math.min(zeroCase, oneCase);
		
		System.out.println(result);
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
