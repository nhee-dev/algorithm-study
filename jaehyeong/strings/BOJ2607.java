package com.al.string;

import java.io.*;
import java.util.*;

public class BOJ2607 { // 비슷한 단어 / S3 / 문자열
	
	static BufferedReader br;
	static int N, ans;
	static String w1, w2;
	static int[] w1Arr, w2Arr; 
	
	static void solve() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		if(N == 0) return;
		
		w1Arr = new int[26];
		w2Arr = new int[26];
		
		w1 = br.readLine();
		for(int i = 0; i < w1.length(); i++) {
			w1Arr[w1.charAt(i) - 'A']++;
		}

		for(int i = 1; i < N; i++) {
			w2 = br.readLine();  
			if(Math.abs(w1.length()-w2.length()) >= 2) continue;
			
			for(int k = 0; k < w2.length(); k++) {
				w2Arr[w2.charAt(k) - 'A']++;
			}
			
			int dif = 0;
			for(int m = 0; m < 26; m++) {
				dif += Math.abs(w1Arr[m] - w2Arr[m]);
				w2Arr[m] = 0;
			}
			

			if(dif <= 1) {
				ans++;
			}
			if(dif == 2) {
				if(w1.length() == w2.length()) ans++;
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		solve();
		System.out.println(ans);
	}

}

/*
 - 모두 영문 알파벳 대문자
 - W <= 100 // 0? 1?
 - W.length <= 10 // 0? 
  
 간단히 생각해서 첫번째 W의 문자가 각 위치에 몇개 있는지 확인한다.
 good =  1 2 1   
 g111 =  1 0 0 3  god = 1 1 1   goood = 1 3 1 lsm 000 111
 첫문자와 비교할 다음 문자의 위치를 비교한다.
  |W[i] - W다음[i]|  0 2 1 3 = 6  0 1 0 = 1  0 1 0  121111 = 7
   의 값을 다 더했을 때, 1이하가 나와야 한다. (1 or 0)
 = W = 0
 	 워드가 없으므로, 1글자가 나오면 출력이 될 것이다.
 	 W가 0개이면, 0이 출력될 것
 = 글자 수가 다른 경우 
 	갯수 비교는 잘 된다.
 = 굴자가 일부 같고 일부 다른 경우
 	같은 부분은 -1 되어, 다른 문자의 수가 나타날 것이다.
 = 글자가 모두 다른 경우
 	두 문자의 모든 글자 수의 합이 된다.
 1. 정답의 최대 치 :  100
 2. 시간 복잡도 : 100 * 10
 3. 그 외 케이스
 
  		

*/