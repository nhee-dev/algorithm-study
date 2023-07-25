package com.al.sort;

import java.util.*;
import java.io.*;

public class BOJ10816 { // 숫자카드 2 / S4
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static int[] nArr, mArr;
	static HashMap<Integer, Integer> map;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		nArr = new int[N];
		for(int i = 0; i < N; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		
		st= new StringTokenizer(br.readLine());
		mArr = new int[M];
		for(int i = 0; i < M; i++) {
			mArr[i] = Integer.parseInt(st.nextToken());
		}
		
}
	
	static void solve() {
		// HashMap에 값을 넣는다.
		initMap();
		
		// mArr를 돌며 nArr에 몇개 있는지 HahMap에서 확인한다.
		for(int i = 0; i < M; i++) {
			// 값을 sb에 추가한다.
			sb.append(map.getOrDefault(mArr[i], 0)).append(" ");
		}
		System.out.println(sb);
	}
	
	static void initMap() {
		map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			// 이미 있으면
			if(map.containsKey(nArr[i])) {
				map.put(nArr[i], map.get(nArr[i]) + 1);
			} else {
				map.put(nArr[i], 1);
			}
		}
	}


	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}

/*
mArr의 각 원소가, nArr에 몇개 있는가?
1. 간단한 접근
	m 원소 하나 마다, nArr 확인하고 같으면 ++ 한다.
		확인은 어떻게 하나?
			이분 탐색 : 50만 * long50만
			HashMap : 같음 ... 
			카운팅 X
				nArr를 counting 해 둔다. 50만
				mArr 돌며 접근한다. 50만
				-> 공간 복잡도가 1천만 ... 
2. 정답 최대치 : 50만
*/
