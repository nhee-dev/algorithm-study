package com.al.determination;

import java.io.*;
import java.util.*;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class BOJ1654 { // 랜선 자르기 / S2 / 이분탐색 - 매개변수 탐색

	static BufferedReader br;
	static StringTokenizer st;
	
	static int K, N;
	static long maxH = Integer.MAX_VALUE;
	static int[] kArr;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		kArr = new int[K+1];
		for(int i = 1; i <= K; i++) {
			kArr[i] = Integer.parseInt(br.readLine());
		}
	}
	
	static void solve() {
		// 이분 탐색, 1~21억을 탐색, 매번 H로 자르면 N개 이상 얻을 지 확인 후 Hn최댓값 반환
		long ans = lower_bound(1L, maxH);
		
		System.out.println(ans);
	}
	
	// L~R 탐색 할 때 마다, N개 이상을 얻을 수 있는지 확인
	static long lower_bound(long L, long R) {
		L = 1;
		R = Integer.MAX_VALUE;
		
		long result = L-1; 

		while(L<=R) {
			long mid = (L+R)/2;
			// mid를 H로 잘랐을 때, N개 이상을 얻을 수 있다.
			if(determine(mid)) {
				// 얻을 수 없을 때 까지 H를 키워야 한다.
				L = mid+1;
				// 얻을 수 있는 H에 포함되므로 result에 입력
				result =  mid;

			}else {
				System.out.println(R);
				// 얻을 수 없으므로 H를 줄인다.
				R = mid-1;
			}
		}
		
		return result;
	}
	
	// K 배열을 돌며 h로 나눈 몫을 lineCnt에 더한다.
	// lineCnt가 목표 N보다 크거나 같으면 true 리턴한다.
	static boolean determine(long h) {
		long lineCnt = 0;
		
		for(int k= 1; k <= K; k++) {
			lineCnt += kArr[k]/h;
		}
		return lineCnt >= N;
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}

/*
	K개의 랜선을 잘라 N개 이상을 얻을 수 있는 H의 최댓값을 구하는 문제이다.
	
	1. 정답의 최대치
		K 최대 1만, N 최대 100만, H 최대 21억
		1만개가 21억의 길이이고, 1단위로 자르면 21억개 가나온다. int로 가능하다.
		
	2. 간단한 접근 : K개의 랜선을 길이 21억개로 잘라서 매번, N개가 나오는지 더해 본다.
		1만 * 21억 = fail
	
	3. 개선된 접근 : 21억은 너무 크다. 이분탐색? 최댓값을 구하는 문제이고, H에 따라 N개를 얻을 수 있는지 비례한다.
		결정문제 : H로 잘랐을 때, N개 이상의 랜선을 얻을 수 있는가?
				H가 커질 수록 N이 작아진다. 따라서 H의 최댓값이 N을 얻을 수 있는 가장 큰 H이가 될 것이다.
	(그림 그려보기)
	4. 시간 복잡도 : 이분 탐색으로 H 탐색에 log21억, 매번 잘라 더하는데 1만으로 충분하다.
	
	5. 구현
		int K, N, MAXH
		int[] K개 랜선 담을 배열 1~K
		

*/