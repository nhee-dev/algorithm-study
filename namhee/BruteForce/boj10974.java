import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static int N;
	static boolean[] visited;
	static int[] result;

	public static void main(String[] args) throws IOException {
		initData();
		perm(1);
	}

	static void initData() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		visited = new boolean[N + 1];
		result = new int[N + 1];
	}

	static void perm(int order) {
		if (order == N + 1) {
			outputResult();
		}
		else {
			for (int i = 1; i <= N; i++) {
				if (visited[i]) continue;
				else {
					visited[i] = true;
					result[order] = i;
					perm(order + 1);
					visited[i] = false;
				}
			}
		}
	}

	static void outputResult() {
		for (int i = 1; i <= N; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}
}

// 제약 조건 : 1초, 1 <= N <= 8
// 1부터 N까지의 수로 이루어진 순열을 사전순으로
// N <= 8 이므로, 제한 시간 내에 O(N!) 출력 가능
// 1-1. Data N 입력 받기
// 1-2. 1~N 사용했는지 체크하는 배열과, 결과 저장하는 배열 초기화
// 2. 1~N까지의 순열 사전순으로 받기
