package com.al.simul;

import java.io.*;
import java.util.*;

public class BOJ1205 { // 등수구하기 / S4
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int N, R, P, ans;
	static Integer[] ranks;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		ranks = new Integer[P+1];
		
		if(N != 0) st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= P; i ++) {
			if(i <= N) ranks[i] = Integer.parseInt(st.nextToken());
			else ranks[i] = -1;
		}
	}
	
	static void solve() {
		Arrays.sort(ranks, 1, P+1, Collections.reverseOrder());
		Arrays.toString(ranks);
		
		ans = -1; // R보다 큰 점수들만 있는 경ㅇ
		for(int i = 1; i <= P; i++) {
			if(ranks[i] < R) { // 더 낮은 점수를 찾은 경우
				ans = i;
				break;
			}
			if(ranks[i] == R) { // 같은 점수를 찾은 경우
				int now = i;
				while(i <= P && ranks[i] == R) {
					i++;
				}
				if(i == P +1) {
					ans = -1;
					break;
				} else {
					ans = now;
					break;
				}
				
			}
		}
		System.out.println(ans);
	}
	
	static void solve2() {
		Arrays.sort(ranks, 1, P+1, Collections.reverseOrder());
		
		ans = -1; // R보다 큰 점수들만 있는 경우
		for(int i = 1; i <= P; i++) {
			if(ranks[i] < R) { // 더 낮은 점수를 찾은 경우
				ans = i;
				break;
			}
			if(ranks[i] == R) { // 같은 점수를 찾은 경우
				int now = i;
				while(i <= P && ranks[i] == R) {
					i++;
				}
				ans = (i == P + 1) ? -1 : now;
				break;
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) throws IOException {
		input();
		solve2();
	}

}

/*
10 <= P <= 50
0 <= N <= P
0 <= 점수 <= 20억

 - 랭킹 리스트가 비 오름차순으로 주어진다. // 정렬
 - 점수가 큰 것부터 1등 ... 차례로 매겨진다.
 - 같으면 같은 등수를 유지하다가, 다음 등수가 매겨진다. // 2 2 2 1= 1등 3 4등 1
 - P : 랭킹리스트 수
 - N : 리스트에 있는 점수의 수
 - 랭킹리스트가 다 차있다면 새 점수가 이전 점수보다 좋을 때만 갱신 // 안차있으면 그냥
 - 점수가 랭킹에 못들면 -1
 
 새로운 점수(R)가 주어졌을 때, 몇등을 할 것인가? 

간단히 생각하면, 점수리스트를 역으로정렬해두고 R과 같거나 작은 수가 나올 때 까지 검색한다.
	검색할 때는 등수를 계산한다.
	가장 첫 점수는 1이며, 다음 점수일 때 마다 + 1을 한다. int rank; // 안해도 됨
R을 리스트 내에서 찾았을 경우
	같은 점수를 가장 처음 찾았을 것이다. 등수는 rank가 된다.index
	단, 같은 점수 끝까지 조회한 결과 index가 P이면-1을 리턴한다.
R을 리스트 내에서 못 찾았을 경우
	만약 P배열의 끝까지 못찾으면 -1을 리턴한다.
R보다 작은 수가 나왔을 경우
	만약 -1을 만나면, 해당 등수가 rank가 된다.
	해당 위치의 등수가 R의 등수가 될 것.

... 1부터 P까지 배열을 탐색할 것이므로, 각 위치에 있는 점수가 등수가 된다.

1. 정답의 최대치
	등수는 최대 50이고, 점수는 20억을 넘지 않는다.
2. 접근 
3. 시간복잡도
	배열은 최대 50이다.
4. 특이 케이스
	- 아무것도 없는 경우 ... 1등
	0 10 10
	- 못찾고 다찬경우
	10 1 10
	10 9 8 7 6 5 4 3 2 2
	- 찾앗지만 다찬경우
	10 1 10
	10 1 1 1 1 1 1 1 1 1
	- 마지막이 빈 경우
	2 1 10
	10 9 
	- 마지막이 빈 경우
	2 1 10
	10 1
	- 일반적
	3 1 10
	10 1 0
	
	reverse 부분정렬은 ..?
	기억으로 다 해결 된다는 건데~
*/