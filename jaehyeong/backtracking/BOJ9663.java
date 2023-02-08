package com.al.backtracking;
import java.io.*;
import java.util.*;

public class BOJ9663 { // N-Queen / G4 / 백트레킹
	
	static BufferedReader br;
	
	static int N;
	static int[] choose;
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 2차원 	배열 쓸 필요가 있나?
		// 한 줄에서 하나 씩 뽑는 경우의 수를 비교하는 것이다. 단, 위치는 유지하면서
		// 1차원 배열 1 2 4 5 0 이라고 생각해보자.
		// 1번 인덱스가 y값, 배열 값이 x값이 될 것이다. 
		// 1차원 쓰자.
		choose = new int[N+1];
	}
	
	static int result;
	static void solve() {
		result = 0;
		
		int[] arr = choose.clone();
		backtracking(arr, 1); // result를 계산할 것
		
		System.out.println(result);
	}
	
	// 줄마다 뽑은 위치 저장할 배열, depth 
	static void backtracking(int[] choose, int depth) { // 단계를 증가시키며 하나씩 뽑는다.
		if(depth == N+1) { // 도달할 경우 정상적으로 모든 위치에 퀸을 놓았으므로 +1
			result++;
			return;
		}
		
		//아직 뽑아야할 퀸이 남았을 경우
		for(int i = 1; i <= N; i++) { // 줄 수 만큼 반복
			
			boolean possible = true;
			
			//뽑은 퀸 배열을 확인하며 현재 위치가 놓을 수 있는 자리인지 확인
			for(int q = 1; q <= depth-1; q++) { // depth 전 까지만 확인
				
				// 현재 둘 x 좌표, y좌표, 확인할 이전 x좌표, y좌표
				if(attackable(i, depth, choose[q], q) ) { // 현재 위치에 놓았는지 확인 되면
					possible = false;
					break; // 못놓으면 break;
				}
			}
				
			// 놓을 수 있으면
			if(possible) {
				choose[depth] = i;
				backtracking(choose, depth+1); // 다음 깊이 확인
				choose[depth] = 0;
			}
			
			
		}
	}
	
	static boolean attackable(int dx, int dy, int cx, int cy) { // 공격 받는 자리면 true 
		// 같은 가로에는 있을리가 없음

		// 같은 세로에 있으면 탈락
		if(dx == cx) return true;
		
		if(Math.abs(dx-cx) == Math.abs(dy-cy)) return true;
		
		return false;

		// 이전에 뽑은 퀸의 위치 == 현재 자리 이면 true;
		// 대각선에 있으면 탈락 ... 대각선 자리 체크는 어떻게?
		// 1 1 1  
		// 1 1 1 
		// 1 1 1
		// 가운데 로부터 얼마나 멀리 있느냐를 기준으로 두면,
		// 1 2  2 1 은 같은 대각선
		// 1 2  2 3 은 같은 대각선
		// 1 3  2 2  3 1은 같은 대각선
		// 2 2  1 1  3 3은 같은 대각선
		// 대각선이면 무조건 1, 1 씩 증감 했을 것이다.
		 // 1 1 2 2 3 3
		 // 1 2 2 1 2 3
		// 따라서 x증가량과 y 증가량이 같고 커지면 대각선 우하
		// x 증가량과 y 증가량이 같고 작아지면 상좌
		// x 증가량과 y 증가량의 절댓값이 같고 반대인 대각 선 2개
		// 따라서 증가량의 절대 값이 같으면 대각선에 있을 것 ... 맞나? 
	}

	public static void main(String[] args) throws IOException { 
		input();
		solve();
	}

}

/*
 배열의 크기 N이 주어졌을 때, N * N 배열에 N 개의 퀸을 놓는 경우의 수를 구하는 문제이다.
 
 1. 계산의 최댓값
N이 최대 15이므로, 배열은 15이다. 
극단적으로 생각하여 모든 경우가 가능하다고 하면, 15^15 가지가 된다. 이는 매우 큰 수이므로 int로 해결할 수 없다.
그냥 long 써버릴까.
흠 ... 어떻게 확인할 방법이 없는데.
int로 두고 안되면 long으로 바꾸거나, 어차피 int 넘어갈 정도의 경우의 수 21억개 있다면 
일일히 확인해야하는 백트레킹으로는 해결할 수가 없을 거 같으니 일단 int를 써보자.

 2. 단순 구현
각 줄에 하나씩 밖에 둘 수 없다.
첫째 줄에 퀸을 하나씩 둘 때
다음 줄에도 하나씩 둬 보고, 이전 퀸의 범위와 겹치는치 제크한다.
이 경우 시간 복잡도는 N*N이므로 시간 초과. (15*15)

 3. 백트레킹은?
떠오르는 방법이 백트레킹 밖에 없으니 이걸로 풀테지만, 단순히 생각해보자.
맨위에 하나를 놓았을 때, 놓을 수 없는 두번째 위치의 경우의수가 2개 줄어든다. 2번째에도 놓으면 그 아래 놓을 수 있는 경우가 더 줄어든다.
15^15 보다는 훨 씬 적은 수가 될 것을 보인다.
가장 단순한 최대치를 잡아도 15 * 13 * 11 ...? 13만 * 15 ... 1억은 안되니 가능해 보이는데. 해보자.

- 입력
N : 맵 크기
- 출력
result

- 설계
1번 부터 15번 인덱스를 사용할 수 있도록 N+1 배열을 생성하자? 단, 시작을 1로 고정

첫줄 부터 마지막 줄 까지, 체크를 한다.
퀸을 놓는다. > 해당 위치가 가능한 위치인지 확인한다. > ture 면 다음 위치를 본다. / false면 다음 케이스로 break 한다.
종이가 없다 ... 일단 고 ...
*/
