package com.al.backtracking;

import java.io.*;
import java.util.*;

public class BOJ9081 { // 단어맞추기 / S1 / 백트레킹?
	
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	
	static int TC, lastFlag;
	static String targetS, lastString;
	static char[] letters, choose;
	static boolean[] visited;
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		TC = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= TC; t++) {
			targetS = br.readLine();
			letters = targetS.toCharArray();
			choose = new char[targetS.length()];
			visited = new boolean[targetS.length()];
			
			// TC 마다 초기화한다.
			lastString = ""; lastFlag = 0;
			
			solve();
			
		}
	}
	
	static void solve() {
		Arrays.sort(letters);
		
		// 단어를 조합하여 타겟과 같거나 다음 단어를 lastString에 입력한다.
		rec_func(0);
		
		sb.append(lastString).append("\n");
	}
	
	static void rec_func(int depth) {
		// flag가 2 이면 return 한다.
		if(depth == targetS.length()) {
			//flag가 0일 때, 타겟과 같으면 타겟 입력하고 flag 1 return;
			if(lastFlag == 0) {
				String now = new String(choose);
				
				if(now.equals(targetS)) {
					lastString = now;
					lastFlag = 1;
				}
				return;
			}
			
			//flag가 1이 면, 해당 단어 입력하고 flag 2 return;
			if(lastFlag == 1) { // 이미 타겟만들고 다음에 옴
				lastString = new String(choose);
				lastFlag = 2;
			}
			return;
		}
		
		// length만큼 뽑는다.
		char last = 'a';
		int start = 0;
		if(choose[depth] == '\u0000') {
			for(int i = 0; i < letters.length; i++) {
				if(letters[i] == targetS.charAt(depth)) {
					start = i;
					break;
				}
			}
		}
		for(int i = start; i < letters.length; i++ ) {
			if(visited[i]) continue;
			if(letters[i] == last) continue; // 같은 문자를 중복해서 뽑지 않음
			choose[depth] = letters[i];
			last = letters[i];

			visited[i] = true;			
			rec_func(depth+1);
			visited[i] = false;
			
			if(lastFlag == 2) return;
		}
	}
	
	public static void main(String[] args) throws IOException {
		input();
		System.out.println(sb);
	}

}


/*

1 <= T <= 10
0 <= 단어 길이 leng <= 100

알파벳으로 만들 수 있는 단어를 사전순으로 생각하자.
BEER 다음에는 BERE가 온다.

주어진 단어 다음에 오는 단어를 출력하자.

- TC
- 알파벳 대문자, 공백없음
- 주어진 단어가 마지막이면 주어진 단어 출력

TC만큼 반복한다.
매번  lastFlag, leng, String을 갱신한다.

간단히 생각하면, 주어진 알파벳을 모두 사용해서 조합하는 문제이다.
 순서는 의미있지만, 중복은 허용하지 않는다.
 같은 단어를 여러번 만들지도 않는다.
 
 시간복잡도는 단어 길이가 100일 때, 
100 개 중 100개를 순서있게 뽑되, 중복은 허용 않는다.
100! ... 아니 시간 초과인데?
백트레킹? 
생각해보자. 뽑고자하는 단어를 만들고, 그 다음을 생각해야 하므로 ..
BCA가 주어진 경우, 가장 처음에 ABC를 뽑을 때 까진 continue를 한다.
BCA를 뽑은 후 다음 조합을 계산한다. 즉 ...
rec_func을 한다고 치면
letters[i] == targetS.charAt[depth]
일 때 부터 start를 시작한다.
이러면 처음에는 A 넘기고 B뽑은 후 dfs,
AB 넘기고 C 뽑은 후 dfs,
A 뽑은 후 완성 flag 1이 될 것이고,
이 이후 다음 것을 사용할 것이다.
시간 복잡도는 100+100+100 * 10 정도 아닌가 ... 
찾는 원소가 전부 마지막에 있어도 ... 



rec_func으로 주어진 문자를 순회하며, 하나씩 해당 위치에 뽑는다.
 방문한 적이 있는 문자는 방문하지 않는다.
 이전에 선택한 적 있는 문자는 건너 뛴다.
leng 만큼 뽑았으면, 해당 문자가 주어진 단어와 일치하는지 확인한다.
 	if(lastFlag = 2 return;)
 lastFlag = 0 인경우
 	주어진 단어와 일치하면 lastFlag = 1로 만든다.
 	lastStirng = 현재 단어
 만약 isLast == 1 이면
 lastString을 업데이트 하고, lastFlag = 2; (단 한번만) 모든 문장을 리턴한다.

문자가 ""인 경우
한글자인 경우 A
두글자인 경우 AB

*/