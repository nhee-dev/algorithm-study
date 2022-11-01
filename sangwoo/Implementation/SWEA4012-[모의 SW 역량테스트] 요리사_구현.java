import java.util.*;
import java.io.*;

// SWEA 4012 [모의 SW 역량테스트] 요리사
public class Solution{
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int sum = 0, min = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			sum = 0;
			min = Integer.MAX_VALUE;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 조합으로 N/2 뽑기
			visited = new boolean[N];
			combi(0, 0, N, N / 2);

			bw.write(String.format("#%d %d\n", test_case, min));
		}
		bw.flush();
		bw.close();
	}

	public static void combi(int depth, int start, int n, int r) {
		if (depth == r) {
			int idx1 = 0, idx2 = 0;
			int[] arr1 = new int[r];
			int[] arr2 = new int[r];
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					arr1[idx1++] = i + 1;
				}
				if (!visited[i]) {
					arr2[idx2++] = i + 1;
				}
			}

			int[] out1 = new int[2];
			int[] out2 = new int[2];
			boolean[] v1 = new boolean[r];
			boolean[] v2 = new boolean[r];
			sum = 0;
			per(arr1, out1, v1, 0, r, 2);
			int prev = sum;
			sum = 0;
			per(arr2, out2, v2, 0, r, 2);
			int value = prev - sum;
			if (value < 0) {
				value *= -1;
			}

			if (min > value) {
				min = value;
			}

			return;
		}
		for (int i = start; i < n; i++) {
			if (depth == 0 && i != 0) {
				continue;
			}
			visited[i] = true;
			combi(depth + 1, i + 1, n, r);
			visited[i] = false;
		}
	}

	public static void per(int[] arr, int[] out, boolean[] v, int depth, int n, int r) {
		if (depth == r) {
			sum += map[out[0] - 1][out[1] - 1];
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!v[i]) {
				v[i] = true;
				out[depth] = arr[i];
				per(arr, out, v, depth + 1, n, r);
				v[i] = false;
			}
		}
	}
}
