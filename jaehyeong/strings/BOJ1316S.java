package com.al.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BOJ1316S {

	static int wNums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		wNums = Integer.parseInt(br.readLine());
		
		int answer = 0;
		
		for(int i = 0; i < wNums; i ++) {
			String word = br.readLine();
			int[] checkChar = new int[26];
			boolean isCheckWord = true;
			
			checkChar[word.charAt(0) - 'a'] ++;
			
			for(int j = 1; j < word.length(); j ++) {
				if(checkChar[word.charAt(j) - 'a'] != 0 && word.charAt(j) != word.charAt(j-1)) {
					isCheckWord = false;
					break;
				} 
				checkChar[word.charAt(j) - 'a']++;
			}
			if(isCheckWord) {
				answer ++;
			}
		}
		
		System.out.println(answer);
		
	}

}
