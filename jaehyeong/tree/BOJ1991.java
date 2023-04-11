package com.al.tree;

import java.io.*;
import java.util.*;

public class BOJ1991 {// 트리 순회 // S1 // 트리
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static ArrayList<Character>[] arr;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			char x = st.nextToken().charAt(0);
			arr[x-'A'].add(st.nextToken().charAt(0));
			arr[x-'A'].add(st.nextToken().charAt(0));
		}
		
	}
	
	static void solve() {
				
		pre_order('A');
		sb.append("\n");
		
		in_order('A');
		sb.append("\n");
		
		post_order('A');
		
		System.out.println(sb);
	}
	
	
	static void pre_order(char x) {
		sb.append(x); // 본인 출력
		
		//좌, 끝나면 우 출력
		for(char i : arr[x-'A'] ) {
			if(i == '.') continue;
			pre_order(i);
		}
	}
	
	static void in_order(char x) {
		char left = arr[x-'A'].get(0);
		char right = arr[x-'A'].get(1);
		
		if(left != '.') in_order(left);
		
		sb.append(x);
		
		if(right != '.') in_order(right);
	}
	
	static void post_order(char x) {
		char left = arr[x-'A'].get(0);
		char right = arr[x-'A'].get(1);
		
		if(left != '.') post_order(left);
		
		if(right != '.') post_order(right);
		
		sb.append(x);

	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}

/*
1 <= N <= 26
이진 트리를 입력 받는다.
 - 전위 순회 출력 : 루트, 왼, 오
 - 중위 순회 출력
 - 후위 순회 출력
 
 - 알파벳 대문자
 - A가 루트 노드
 - 자식이 없으면 .
 
 - 전위 \n 중위 \n 후위  - 공백 없이 출력

1. 정답의 최대치
	고려 ㄴ
2. 간단한 접근
	트리를 어떻게 구현할까?
		ArrayList의 각 노드에 자신 노드들을 넣는다.
		각 노드를 순서대로 출력한다.
		
		Tree Node를 구현한다.
		본인, 좌, 우 노드를 입력한다.
		Tree[]에 담고 각 방식으로 순회한다.
3. 시간 복잡도
		노드의 수인 23 + 22*2 정도에 에 비례할 것?
*/