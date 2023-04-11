package com.al.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7795 { // 먹을 것인가 먹힐 것인가 / S3 / 이분 탐색
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int M;
	static int[] A;
	static int[] B;
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc ++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			A = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			B = new int[M+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			solve();	
		}
	}
	
	static void solve() {
		Arrays.sort(B, 1, M+1); // 0번 index는 사용하지 않을 것이므로 제외
		
		int result = 0;
		for(int i = 1; i <= N; i++) {
			
			//... 1을 더하기 위해 +1 했으므로 그냥 M 넣으면 됨 인생
			result += binary(B, 1, M, A[i]); // 이분 탐색 결과를 result에 더한다.
		}
		
		System.out.println(result);
	}
	
	
	// 정형화하려면 인자로 받는게 좋을 것? static으로해서 그냥 써도 되는데
	// 탐색 배열, 탐색 시작 index, 탐색 종료 index, 타겟
	static int binary(int[] B, int L, int R, int X) {
		
		int ans = 0; // L 최댓 값이 곧 작은 수들의 최대 index(개수) 
		while(L <= R) {
			int mid = (L+R)/2; // index 값 1 4 / 2 = 2
			
			if(B[mid] < X) { // 타겟보다 작다면 더 큰 지점 찾아야 함, 오른쪽 부터 탐색 시작하도록 L값 조정
				ans = mid; // 현재 값이 적절한 마지막 값일 수 있으므로 저장
				L = mid+1;
			} else if(B[mid] >= X) { // 타멧보다 크다면 더 작은 지점 찾아야 함, 왼쪽까지 탐색 하도록 R값 조정
				R = mid-1;
			}
		}
		
		// 답이 하나도 없는 경우, 즉 B배열의  0 리턴하게 하려면 그냥 1부터 시작하는게 편할듯
		// 만일 답이 0개라면 0 리턴할 것
		// 만일 답이 index 1뿐이라면 1을 리턴할 것. 
		// 만일 답이 index 1, 2, 3 이라면 3을 리턴할 것. 

		
		return ans;
	}

	public static void main(String[] args) throws IOException {
		input();
	}

}


/*

A 배열이 주어지고 B 배열이 주어질 떄, A의 각 원소보다 작은 B 원소의 수를 구하는 문제이다.

1. 계산 최댓값
배열 A의 크기가 최대 20000, B의 크기가 최대 20000이다.
A의 모든 원소가 B보다 크다고하면, 예를들어 A가 2로 구성된 배열이고, B가 1로 구성된 배열이면 항상 A 원소가 클 것이다.
이 경우 20000 * 20000 = 400000000으로 정답의 최대치는 4억이 된다. 
이는 int로 충분하므로 int를 변수로 사용한다.

2. 단순 풀이
단순하게 생각하면 A의 모든 원소를 돌 때마다, B배열을 탐색해 A보다 작은 원소가 몇 개 있는지 세보면 된다.
이 경우 시간 복잡도는 N(A의 배열 크기) * M(B의 배열크기) 이므로 4억이다.
시간 제한이 1초이므로 잘하면 통과, 빠듯하게 1억을 1초로 잡으면 4초로 실패할 것이다. 

3. 다른 방법
크기 비교 문제이므로 이분 탐색을 사용해 볼 수 있다.
이분 탐색을 구현하기 위해서는 정렬된 배열이 필요하므로, B배열을 정렬하는데 퀵소트로 MlogM의 시간이 들 것이다.
정렬된 배열을 이분 탐색하는데 걸리는 시간은 logM이다. 이를 N 원소의 수 만큼 반복하므로 시간 복잡도는 NlogM이다.
즉, 이분 탐색으로 걸리는 시간은  (M+N)logM = 40000log20000 = 40000 * 14 = 5만 정도 ...
충분히 풀만한 시간이다. 

4. 입력, 출력 확인
- 입력
첫 줄 테스트 케이스 T
테스트 케이스 마다 [N M] [A 배열 숫자] [B 배열 숫자]
- 출력
A > B인 원소의 수 출력

5. 구현
입력받은 B 배열을 정렬한다.

정렬한 B배열을 A의 크기만큼 이분 탐색을 한다.

이분탐색 결과 얻은 A의 원소 하나에 대한 결과 값을 최종 답에 더한다.


결과
보통 설계 부터 하고 들어가는데 귀찮아서 안하고 들어갔다가
1 더하는 부분에서 실패함.
인덱스 범위 ... 확인
*/
