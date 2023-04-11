package com.al.main;

import java.io.*;
import java.util.*;

public class BOJ1253 { // 좋다  / G4 / 투포인터

	static BufferedReader br;
	static StringTokenizer st;
	
	static int N, ans;
	static int[] nArr;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		nArr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i ++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		
	}
	
	static void solve () {
		 Arrays.sort(nArr);
		 
		 two_pointer();
		 
		 System.out.println(ans);
	}
	
	static void two_pointer() {
		for(int i = 0; i < N; i ++) {
			int left = 0;
			int right = N-1;
			
			while(true)	{
				if(left == i) left ++;
				if(right == i) right --;
				
				// 중복 불가
				if(left >= right) break;
				
				if(nArr[left] + nArr[right] > nArr[i]) right--;
				else if(nArr[left] + nArr[right] < nArr[i])	left++;
				else {
					ans++;
					break;
				}
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}

/*

1 <= N <= 2000
- 10억 <= 수 <= 10억

N개의 수가 주어진다.
수가 다른 수 두개의 합으로 나타낼 수 있으면 좋다.
좋은 수는 몇개인가?
수의 위치가 다르면 다른 수이다.

간단히 생각해서, 특정 원소를 하나 뽑는다. (모든 원소마다 반복) 2000
해당 원소를 제외한 다른 원소들 중 두개를 조합한다. (순서 O, 중복 X) 4000000--    ... 총 80억 시간 초과
더한 값이 같으면 +2, 아니면 0;

1. 정답의 최대치
	두 수의 합은 최대 20억 
	좋은 수의 갯 수는 2000
2. 개선된 접근
	타겟 수를 선택한다. (최대 2000)
	타겟수를 제외한 특정 수를 선택한다. (최대 2000)
	이분 탐색으로, 해당 수와 타겟수를 만들 수 있는 수 X를 찾는다. (log2000 = 11)
	2000 2000 11 = 44000000 ... 4천만 정도 될 듯? 
	
	투포인터로도 가능할 듯 하다.
	타겟 수를 선택한다.
	정렬된 수의 앞 뒤를 하나씩 선택해 더한다.
	X보다 크면 오른쪽 --
	X보다 작으면 왼쪽 --
	
	
3. 케이스
	3
	0 0 0
	3 
	-1 0 -1
	3
	0 10 -50
	3
	1000000000 -1000000000 1000000000


*/
