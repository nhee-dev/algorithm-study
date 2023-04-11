package com.al.simul;

import java.io.*;
import java.util.*;

public class BOJ20207 { // 달력 // S1
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int N, ans;
	static int[] days;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ans = 0;
		
		days = new int[366];
		
		for(int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			for(int k = start; k <= end; k++) {
				days[k]++;
			}
		}
		
	}
	
	static void solve() {

		//0이 아닌 곳을 발견하면 start에 넣는다.높이를 체크한다.   
		//다시 0인 곳이 나올때까지 높이를 체크한다. 
		//0이 나오면 (또는 365이면) 이전 위치(또는 지금 위치)를 길이 마지막으로 입력하고 계산한다.
		//start와 end, 높이 를 초기화 하고 반복한다.
		
		// 0이 아닌 곳을 발견하면, 0이 나오거나 365번째 일 때 까지 높이를 체크하며 넘어간다.
		// 0이나 365가 나오면 계산한다.(단, start가 0이면 안한다.) / start 등을 초기화한다.
		int start = 0; int end = 0; int height = 0;
		for(int i = 1; i <= 365; i ++) {
			
			if(days[i] != 0) {
				// start가 0이면 - start에 입력한다. 
				if(start == 0) start = i;
				// start가 0이거나, 아니거나  높이를 비교하여 입력한다.
				height = Math.max(height, days[i]);
				
				if(i == 365) {
					// start가 0이면 - continue
					if(start == 0) continue;
					// start가 0이 아니면 - 계산하고 초기화 시킨다.
					end = 365;
					calcul(start, end, height);
					start = 0; end = 0; height = 0;
				}
			} else if(days[i] == 0) {
				// start가  0이면 - continue
				if(start == 0) continue;
				// start가  0이 아니면 - 계산하고 초기화 시킨다.
				end = i-1;
				calcul(start, end, height);
				start = 0; end = 0; height = 0;
			}
			
			
		}
	}
	
	static void calcul(int start, int end, int height) {
		ans += ((end-start+1) * height);
	}

	public static void main(String[] args) throws IOException {
		input();
		solve();
		System.out.println(ans);
	}

}

/*

1 <= 일정 N <= 1000

일정이 있는 곳에 코팅을 할ㄴ다.
 - 연속된 두 일자에 각각 일정이 1개 이상 있다면  일정이 연속됨
 - 연속된 일정은 하나의 직사각형에 포함
 - 연속된 일정을 모두 감싸는 크기로 코팅지 자름
 
 - 일정은 시작날짜, 종료날짜 포함
 - 시작일이 가장 이른 일정부터 채워짐
 - 시작일이 같으면 일정이 긴 것 부터 채워짐
 - 일정은 최상단 부터 배치
 
일정의 개수, 일정의 시작 날, 종료날이 주어질 때, 코팅지의 면적을 구하는 문제이다.

1. 정답의 최대치
	N이 1000일 때, 일정이 365일  동안 될 경우 면적은 365000 이다.
2. 간단한 접근
	일정을 정렬한다.
	날짜가 빠른 것을 앞으로 보낸다.
	종료일로부터 가장 가까운 다음 일정을 다음에 채운다. 더이상 없으면 다음 줄을 채운다.
		
	앞에서 부터 정렬되어 있다.
	노드를 만들고, 배열에 집어 넣는다. 
	이 노드와 겹치면 다음 배열에 넣는다.
	이 노드와 안겹치면 다음 위치에 넣는다.
	
	시작과 끝, 몇개가 겹치는 지를 알면 되는 문제이다.
	가장 빠른 날짜부터 종료일까지 체크한다. 
	다음 줄에서 해당 날짜 이내에 일정이 있는지 확인한다. (시작일)
		- 시작일이 날짜 이내이면, 종료일을 확인한다.
		- 종료일이 더 길면 갱신한다.
	
	연속된은 "시작일이 바로 다음 날 이거나(열로 이어짐), 겹치는 경우(행 추가)"
	정렬된 상태를 생각해 보자. 시작일로 정렬되어 있다.
	무조건 앞에서부터 순서대로 채운다.
	가령  1 3  2 5  5 7 인 경우를 보자.
	시작 : 1    종료 : 3  행 : 1
	다음 일정 2는 시작일이 이 범위에 겹치므로 (3보다 작거나 같으므로) 행을 추가한다. 종료일을 큰 것으로 갱신한다.
	시작 : 1    종료 : 5  행 : 2
	다음 일정 5는 시작일이 이 범위에 겹치므로 ... 이전 중 누구와 겹치지? (매번 새로운 일정 할 때마다, 이전 일정 중 몇개와 겹치는지 확인?)	
	
	중요한 것은, 몇개가 날짜가 겹치고, 연속되지 않는 날이 언제인지 확인하는 것이다.
	[365] 배열을 만들고
	날짜마다 1 씩 증가시킨다.
	처음부터 돌면서 비어있지 않은 구간의 최대 숫자가 높이 이며, 연속된 숫자의 갯수가 가로가 될 것이다.
	
	- 특이케이스
	1 ... 21
	1 21
	
	2 ... 6
	1 2
	2 3
	
	2 ... 4
	1 2
	355 356

*/