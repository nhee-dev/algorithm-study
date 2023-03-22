package com.al.simul;

import java.io.*;
import java.util.*;

public class BOJ7682I {
	
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	
	static String map;
	static int XR, OR;
	
	static void input() throws IOException {
		br= new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			map = br.readLine();
			if(map.equals("end")) break;
			
			XR = 0;
			OR = 0;
			
			solve();
		}
	}
	
	static void solve() {
		int XN = 0; int ON = 0;
		
		// String의 X, O 갯수를체크한다.
		for(int i = 0; i < 9; i++) {
			if(map.charAt(i) == 'X') XN++;
			else if(map.charAt(i) == 'O') ON++;
		}
		
		// X, O 개수 조건을 확인한다.
		// X가 먼저 두지 않는 경우
		if(ON != XN && ON != XN-1) {
			print(false);
			return;
		}
		
		// O4 X5 이면 판완성 루트를 체크한다.
		// O가 완성상태면 실패, 아니면 성공
		if(ON == 4 && XN == 5) {
			check_map();
			if(OR >= 1) {
				print(false);
				return;
			} else {
				print(true);
				return;
			}
		}
		
		
		// 개수를 만족하고, 완전 상태가 아니면 라스트 체크를 한다.
		check_map();
		// 3개 완성된 경우가 아니면 개수만 맞으면 될 것이다. 위에서 체크 했다.
		// 3개 완성의 경우,완성이 여러 개면 안된다.
		if(OR+XR > 1) {
			print(false);
		} else if(OR+XR == 1){ // X가 완성일 경우(위), O가 완성일 경우 더 둘수 없도록 갯수체크를 한다.
			if(OR == 1) {
				if(XN == ON) print(true);
				else print(false);
			} else if(XR == 1) {
				if(ON == XN-1) print(true);
				else print(false);
			}
		} else {
			// 아직 두는 중인 경우 ... 완성상태가 아니면 다 채워야 한다. ////
			// 다 채운 경우는 위에서 체크했으므로 무조건 실패
			print(false);
		}
		
	}
	
	static void print(boolean state) {
		String result;
		
		if(state) result = "valid";
		else result = "invalid";
		
		sb.append(result).append("\n");
	}
	
	// 0 1 2
	// 3 4 5
	// 6 7 8 
	// 각 라인의 완성 여부를 확인한다.
	static void check_map() {
		check_line(0, 1, 2);
		check_line(3, 4, 5);
		check_line(6, 7, 8);

		check_line(0, 3, 6);
		check_line(1, 4, 7);
		check_line(2, 5, 8);

		check_line(0, 4, 8);
		check_line(2, 4, 6);

	}
	
	// 해당 라인이 완성 되었는지, X완성인지, Y완성인지 확인한다.
	static void check_line(int a, int b, int c) {
		if(map.charAt(a) == map.charAt(b) && map.charAt(b) == map.charAt(c)) {
			if(map.charAt(a) == 'X') {
				XR++; 
			} else if(map.charAt(a) == 'O') {
				OR++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		input();		
		System.out.println(sb);
	}

}

/*
 - 3 3 격자
 - 첫사람 X, 두번째 O
 - 가로, 세로, 대각선 3칸이면 끝남
 - 판 다차도 끝남
 
 - 판 상태가 최종 상태인가?
 
 - TC 여러개
 - 한 줄에 하나의 TC
 - 입력 마지막 end
 
 - 가능 valid, 불가능 invalid
 
현재 판 상태가 주어지고, 이것이 최종 상태인지를 구하는 문제이다.
최종 상태는 다음과 같다.
 - 마지막 사람이 3개를 연속시켰다.
 - 판이 다 찼다.
 
1. 접근
	DFS로 돌면서, 해당 판이 나올때 까지 돌려본다?
	몇가지가 가능할지 알 수 없다. 영원할 수도 ...
	
	각 상태에 따른 접근을 해보자.
	상태는, 선공과 후공, 순서대로, 3개 완성, 판완성, 종료
	
	상태에 따라 생각하자.
	 1. 선공과 후공
	 	항상 X가 먼저 두므로, O = X-1 or X 이어야 한다.
	 2. 3개 완성
	 	- 선공과 후공
	 		X가 3개 완성 : O = X-1
	 		O가 3개 완성 : X = O
	 	- 종료되어야 한다.
	 		아닐경우 3개 완성이 여러개 일 것
	 3. 판 완성
	 	- 항상 O 4 X 5 이다.
	 	- O는 완성될 수 없다.
	 	- X는 여러개 완성될 수 있다.
	 4. 특이 케이스
	 	3개 완성하고도 둔 경우 
	 	한사람이 여러번 둔 경우
	 	O가 먼저 둔 경우
	 	아무도 안둔 경우
	 
	 간단히 생각해보자. 판 상태가 String으로 주어진다.
	 0 1 2
	 3 4 5
	 6 7 8  형태라고 생각하자.
	 
	 갯수로 먼저 체크하자. 
	 	O = X-1, X 가 아니면 실패이다.
	 만일 O 4개, X 5개 인 경우
		완성된게 있는 지 확인한다.
	 	O가 완성되어 있으면 실패이다. else true
	 만일 판 완성이 아닌 경우
	 	3개 완성 상태이다.
	 		완성된게 있는지 확인한다.
	 		X가 완성된 경우 O = X-1;
	 		O가 완성된 경우 X=O;
	 		
	 		만일 완성이 여러개면 실패 (2개 이상은 완성상태만 가능) else true
	 		
	 
	 
	 
	 ---------------------------------------------------------------
	 
	 
	 
	완성 상태에 따라 생각하자.
	1. 마지막 사람이 3개 연속 완성한 경우
		X가 완성이면 : O는 2개 
	
	완성 상태는 다음과 같다.
	- 마지막 사람이 3개 연속 둔 경우
		X일 경우 O는 X-1 이어야 한다.
		O일 경우 X는 O이어야 한다.
		그렇지 않을 경우, 더 두거나 덜 둔 상태일 것이다.
	- 판이 다 찬 경우
		X가 5개, O가 4개 이다.(X일 경우 O는 X-1 이어야 한다.)
		X만 3개를 완성할 수 있다.

	판이 완성될 수 없는 상태는?
	- O가 X-1 or X가 아닌경우
	- 완성했는데도 더 둔 경우
		- 3개 완성이 여러개 나올 수 있다.
		- O보다 X가 클 수 있다. -> O가 완성되면 X == O여야 한다.
		- X가 완성된 경우 -> O == X-1 이어야 한다.





*/