package com.al.determination;

import java.io.*;
import java.util.*;

public class BOJ2512R { // 예산 // S3 // 이분탐색 - 매개변수 탐색

	static BufferedReader br;
	static StringTokenizer st;
	
	static int N, M, ans;
	static int[] nArr; // 지방 예산들
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nArr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		
		M= Integer.parseInt(br.readLine());
		
	}
	
	static void solve() {
		// 예산을 배정할 수 있는 최대 H를 구한다.
		int maxH = lower_bound();
		
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			ans = Math.max(ans, nArr[i]);
			if(ans >= maxH) {
				ans = maxH;
				break;
			}
		}
		
		System.out.println(ans);
	}
	
	static int lower_bound() {
		// result = 배정할 수 있는 H 최댓값
		int L = 1; int R = 100000; int result = 0;
		
		while(L <= R) {
			int mid = (L+R) / 2;
			// mid로 예산을 배정할 수 있을 경우
			if(determine(mid)) {
				L = mid + 1;
				result = mid;
			} else { // 예산 배정 못할 경우
				R = mid -1;
			}
		}
		
		return result;
	}
	
	// mid로 예산을 배정햇을 때, 총액 M을 이하인지 확인한다.
	static boolean determine(int H) {
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			if(sum > 1000000000) break;
			// H 넘거나 같으면 H
			sum += Math.min(H, nArr[i]);
		}
		return sum <= M;
	}
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}

/*
 3 <= 3 N 지방 수 <= 1만
 1 <= 예산 크기 <= 10만 // 10만이 최대 예산
 1 <= 총예산 M <= 10억
 - 총액 정해져 있음
 - 가능한한 최대의 총액 배정한다. > H 최대
 - 총액 내에서 모두 줄 수 있으면 준다.
 - 총액 내에서 모두 못 주면, 상한액을 기준으로한다.
 - 지방의 예산요청들, 총액이 주어질 때, 상한액을 구하라.
 - 출력은 배정된 예산 최댓값 정수 >> 예산 최댓값은 요구 예산 중 최대가 최대
 	상한액 이상이면 상한액을 배정한다.
 	상한액 이하이면 요청금액 그대로 배정한다.
> 상한액에 따라서 배정 예산의 총합이 달라진다. > 상한액이 커지면 배정되는 예산이 증가한다. 
> 총액 M이 주어졌을떄, 예산의 합이 최대가 되게 하는 H를 구하는 문제이다.
간단히 생각하면, 총예산 내에서 H를 정했을때, 각 지방에 얼마가 배분되는지 구해 합계를 구한다.
이 합계가 총예산을 넘지 않는 최대 H를 구한다.
H는 10억 범위고 예산크기가 10만이라 시간 초과이다.
10억을 줄이기 위해 알고리즘을 적용해 보자.
상한액 H에 따라서 결과가 바뀌며, H가 커지면 특정 시점부터 No가 나올 것이다.
매개변수 탐색을 위한 결정 문제로 ㅏ꿔보자.
H일 떄, 예산의 합이 M이하가 되는가? > H가 크면 No.
시간 복잡도는 log10억 * 1만으로 충분하다. - > (log10만)
1. 정답의 최대치
	지방수가 1만, 예산이 모두 10만일 때, H를 10만으로 잡으면 1만 * 10만의 합이 필요하다.
	그러나 총예산이 10억 이므로, 10억을 넘으면 리턴할 수 있다.
	
	매개변수 L, R 최대는 모두 10억 이므로 계산과정은 int로 충분하다.
2. 접근
	1~10만을 이분 탐색한다.
	mid를 구할 때 마다, 예산을 배분해 본다.
		예산 배분은 sum에 N개의 예산이 mid보다 크거나 같으면 mid, 아니면 예산을 더한다.
		sum이 10억을 넘어가면 break 한다.
		sum 한다.
	예산이 sum <= M 이면 현재 mid로는 예산 배분이 가능하니 오른쪽 탐색한다. L+1, result
	예산을 초과하면 현재 mid로는 예산 배분이 안되니 왼쪽 탐색한다. R-1
	출력 : 예산들중 최댓 값이 H 이상이면 H, 아니면 예산 중 최댓 값... 
	
	or 어차피 출력이 배정된 예산의 최대 이므로 ... 요구 예산 최댓 값을 R로 두어도 될 듯하다.
3. 엣지, 예외 케이스
	지방 3, 1, 총예산 1 ... 0
	3
	1 1 1
	1
	
*/