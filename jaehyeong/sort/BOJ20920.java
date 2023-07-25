package com.al.sort;

import java.util.*;
import java.io.*;

public class BOJ20920 { // 영단어 암기는 괴로워 / S3 / 정렬
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static String[] words;
	static HashMap<String, Integer> map;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		N  = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		words = new String[N];
		for(int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
	}
	
	static void solve() {
		// HashMap에 단어를 넣는다.
		// 있으면 ++ // 없으면 1, 우선순위 큐에 new Elem
		map = new HashMap<>();
		ArrayList<Elem> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			if(words[i].length() < M) continue;
			if(map.containsKey(words[i])) {
				map.put(words[i], map.get(words[i])+1);
			} else {
				map.put(words[i], 1);
				list.add(new Elem(words[i]));
			}
		}
				
		Collections.sort(list);
		// 하나씩 출력한다.
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).word).append("\n");
		}
		System.out.println(sb);
	}
	

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	static class Elem implements Comparable<Elem> {
		String word;
		
		Elem(String w) {
			this.word = w;
		}
		
		public int compareTo(Elem e) {
			if(map.get(word) != map.get(e.word)) return map.get(e.word) - map.get(word);
			if(word.length() != e.word.length()) return e.word.length() - word.length();
			return word.compareTo(e.word);
		}
	}
}

/*
단어들이 주어진다.
많이 나온 단어, 긴 단어, 사전순 으로 정렬한다. ... 중복은 없다.
1. 접근
	단어를 입력 받을 때, HashMap에 넣어 카운팅 해둔다.
	우선순위큐에 넣고, 순서대로 뽑는다.
	HashMap에 넣는데 10만 + 최대 10만개 정렬 ...
2. 정답의 최대치 : 10만개
3. 구현
	class Elem를 만든다.
		영단어가 들어 있다.
	입력받은 단어를 돌며 HashMap을 확인한다.
		이미 있으면 Map + 1을 한다.
		없는 단어면 Map = 1, ArrayList에 넣는다.
	ArrayList를 정렬하여 출력한다.


*/