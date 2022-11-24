import java.util.*;
import java.io.*;

public class BOJ_2470 {
	static int N;
	static int[] liquid;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		liquid = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(liquid);

		int s = 0;
		int e = N - 1;
		int minL = liquid[s];
		int minR = liquid[e];

		while (s < e) {
			if (abs(minL + minR) > abs(liquid[s] + liquid[e])) {
				minL = liquid[s];
				minR = liquid[e];
			}

			if (liquid[s] + liquid[e] < 0) {
				s++;
			} else {
				e--;
			}
		}

		System.out.println(String.format("%d %d", minL, minR));
	}

	static int abs(int n) {
		if (n < 0) {
			return -1 * n;
		} else {
			return n;
		}
	}
}
