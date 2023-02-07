import java.util.Scanner;

public class Main {
	static int maxAnswer = 0;
	static int N;
	static int[] A, P;
	static boolean[] visited;

	public static void main(String[] args) {
		inputData();
		initData();
		perm(0);
		outputAnswer();
	}

	static void inputData() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		sc.close();
	}
	
	static void initData() {
		P = new int[N];
		visited = new boolean[N];
	}

	static void perm(int k) {
		if (k == N) {
			getAnswer();
		}
		else {
			for (int i = 0; i < N; i++) {
				if (visited[i]) continue;
				else {
					visited[i] = true;
					P[k] = A[i];
					perm(k + 1);
					visited[i] = false;
				}
			}
		}
	}
	
	static void getAnswer() {
		int sum = 0;
		for (int i = 0; i < N-1; i++) {
			sum += Math.abs(P[i] - P[i+1]);
		}
		
		maxAnswer = sum > maxAnswer ? sum : maxAnswer;
	}
	
	static void outputAnswer() {
	    System.out.print(maxAnswer);
	}
}

/* 설계
 * 시간, 메모리 제약 : 1초, 256MB
 * 제약 조건 : 3 <= N <= 8, -100 <= A[i] <= 100 (int)
 		-> N <= 8이며, 시간 제한 1초이므로. 순열로 풀 수 있다.
 * |A[k-2] - A[k-1]|의 최솟값 : 0, 최댓값 200 
		-> 비교할 최댓값의 최솟값 = 0
 * 필요한 변수 : N, A[N], visited[N], P[N](- 얻은 수열 결과를 저장)
 * 풀이 과정
	1-1. 입력을 받는다.
		(1) N 입력
		(2) int A[]에 N번만큼 입력
	1-2. 입력 받은 데이터를 기반으로 변수를 초기화 시켜준다.
		(1) visited를 크기 N으로 초기화
		(2) P(순열 결과 저장 배열)를 크기 N으로 초기화
		
	2. 모든 경우의 수를 순열로 찾는다. (N <= 8)
	(모든 수열을 찾으려면, 순열로 찾아야만.)
	if 순열 완성 = 식의 값 비교 후, 최댓값 갱신 결정
	else 미완성				
	  if visited continue
		else
		  visited 체크 후, 순열 배열에 넣기
		  다음 순열 함수 재귀
		  visited 미체크
 */
