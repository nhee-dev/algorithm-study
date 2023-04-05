package com.al.main;

import java.io.*;
import java.util.*;

public class BOJ1107 { // 리모컨 / G5 / 시뮬 완탐
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int N, M, difX, temp;
	static int[] buttons, selected; // 1은 고장
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		buttons = new int[10];
		selected = new int[6];
		
		// 후보 1 ... M이 없어서?
		if(M != 0) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i ++) {
				int num = Integer.parseInt(st.nextToken());
				buttons[num] = 1;
			}
		}
	}
	
	static void solve() {
		
		// 100과 목표와의 차이를 구한다.
		int dif100 = Math.abs(100-N);
		
		// 50미만에서 숫자를 조합해, 가장 가까운 수와의 차를 구한다.
		// 버튼이 전부 고장나지 않으면, 고장나지 않은 버튼으로 조합하여 가까운 값 찾기
		difX = 500001;
		if(M != 10) {
			rec_func(0, false);
		}
		
//		System.out.println(dif100 + " dif100 : difX : last " + difX + " " + temp);
		System.out.println(dif100 < difX ? dif100 : difX);
		
	}
	
	static void rec_func(int depth, boolean isStart) {
		if(depth == 6) {
			// 하나도 버튼을 누르지 않은 경우
			if(!isStart) return;
			
			// 선택한 수를 int로 만든다.

			int now = getSelectedNum();
			int leng = (now + "").length();
			// 50만 이상의 수면 넘긴다.
			if(now > 1000000) return;
			
			// 선택한 수와 목표의 차이를 구한다.
			int difNow = Math.abs(N-now) + leng;
			
			// 이전 차이보다 작으면 갱신하고, 아니면 그대로 둔다.
			// difX = difNow < difX ? difNow : difX;
			if(difNow < difX) {
				difX = difNow;
				temp = now;		
			}
			return;
		}
		
		if(!isStart) {
			selected[depth] = 0;
			rec_func(depth+1, false);
		}
		for(int i = 0; i < 10; i ++) {
			// 망가진 버튼은 선택하지 않는다.
			if(buttons[i]==1) continue;
			
			// 하나를 선택하고 다음 것을 선택한다.
			selected[depth] = i;
			rec_func(depth+1, true);
		}
	}
	
	static int getSelectedNum() {
		int result = 0;
		
		sb = new StringBuilder();
		for(int i = 0; i < 6; i++) {
			sb.append(selected[i]);
		}
		result = Integer.parseInt(sb.toString());
		
		return result;
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}

/*
0 <= N <= 50만
0 <= M <= 10

숫자 버튼 몇개가 고장이 났다. M
0 ~ 9가 있다.
 - + : +1
 - - : -1
 - 0에서 줄어들지 않는다.
 - 채널은 무한대
 - 현재 채널은 100
 
고장난 버튼들이 주어진다.
N에 도달 하려면 버튼을 최소 몇 번 눌러야 하는가?

--- 방법 1 ... 좀 복잡함---
먼저 100에서  X를 향해 +, -로 이동가능한 횟수를 구한다.

다음 숫자 키를 이용해 이동을 해본다.
	X의 첫 자리와 가장 가까운 큰 수를 구한다.(선택 불가면 자리수를 높여 가장 낮은 수)
		나머지를 가능한 작은 수로 채운다.
	X의 첫 자리와 가장 가까운 작은 수를 구한다(선택 불가면 자리수를 낮혀 가장 높은 수)
		나머지를 가능한 큰 수로 채운다.
	X의 첫 자리와 같은 수를 이동한다.
		그 다음 자리를 최대한 가까운 수로 채운다, 그 다음 자리도 최대한 가까운 수로 채운다.

이 네 가지 경우에 걸리는 횟수 중 가장 적은 수를 구한다.
--- 방법 2 ... 
먼저 숫자 버튼으로 가능한 모든 숫자를 만들어 본다.
해당 숫자와 목표 숫자 X를 비교해 절댓값을 얻는다.
절댓값이 작으면 해당 숫자를 선택한다.

선택한 수와 X와의 차이, 100과 X와의 차이를 구한다.
둘 중 작은 쪽을 선택한다.

1. 정답의 최대치 : 최대 50만
2. 시간 복잡도
	조합하는데 9^6 ... 100만 안됨
	충분히 가능할 듯
3. 구현
4. 케이스
	0
	0
	
	275
	10
	0 1 2 3 4 5 6 7 8 9
	
	5
	9
	0 1 2 3 4 6 7 8 9
	
	500000
	10
	0 1 2 3 4 5 6 7 8 9
	
	500000
	0
	
	500000
	6
	0 1 2 3 4 5
	
	500000
	4
	0 1 2 3
	
	101
	0
	
	101
	10
	0 1 2 3 4 5 6 7 8 9
	
	101
	3
	0 1 2
	
	0
	9
	0 1 2 3 4 5 6 7 8 
	
	0
	1
	0
	
	

*/
