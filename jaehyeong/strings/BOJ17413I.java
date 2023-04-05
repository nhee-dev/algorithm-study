package com.al.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ17413I { // 단어뒤집기 2 / S3 / 12
	
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	
	static String sentence;
	static char[] letters;
	static ArrayList<Character> temp;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		sentence = br.readLine();
		letters = new char[sentence.length()];
		
		for(int i = 0; i < sentence.length();i ++ ) {
			letters[i] = sentence.charAt(i);
		}
	}
	
	static void solve() {
		boolean isTag = false;
		temp = new ArrayList<Character>();
		
		for(int i = 0; i < sentence.length(); i++) {
			if(letters[i] == '<') {
				isTag = true;
				switch_letters(i-1);
			}
			if(letters[i] == '>') {
				isTag =false;
				continue;
			}
			if(isTag) continue;

			if(letters[i] == ' ') {
				switch_letters(i-1);
				continue;
			}
			
			temp.add(letters[i]);

			if(i == sentence.length()-1) {
				switch_letters(i);
			}
		}
		
		for(int i = 0; i < letters.length; i++ ) {
			sb.append(letters[i]);
		}
		System.out.println(sb);
	}
	
	static void switch_letters(int idx) {
		for(int k = 0; k < temp.size(); k++) {
			letters[idx-k] = temp.get(k);
		}
		temp = new ArrayList<Character>();
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}

/*

문자는 a0a 태그는 <fase>로 주어진다.
<fa>a0a a0a a0a<fa><fa> sa ;를 생각해보자.
태그의 구분은 < >로 가능하다.
문자열 구분은 " "를 만나거나 <를 만나거나 로 가능하다.
만약 마지막 위치가 공백이 아니면, " "도 <도 만나지 않고 문자가 끝난다.
	이 경우 마지막 인덱스의 도달할 때 >,  " " 가아닌 경우 문자로 간주한다.
따라서 " " < 마지막인덱스 일때 문자열을 바꿔줘야 한다.
	<인 경우 temp 만큼 이전 위치들을 바꿔준다. isTag true
	" " 인경우 마찬가지
	마지막 인덱스가 " " 인경우 마찬가지 





*/
