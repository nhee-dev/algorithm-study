import java.util.*;
import java.io.*;

public class BOJ_21318 {
	static int N, Q;
	static int[] piano, mistake;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		piano = new int[N + 1];
		mistake = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			piano[i] = Integer.parseInt(st.nextToken());
		}

		recordMistake();
		
		Q = Integer.parseInt(br.readLine());
		for (int question = 0; question < Q; question++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			bw.write(String.valueOf(findMistake(x, y)));
			bw.write('\n');
		}
		
		bw.close();
	}

	static void recordMistake() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (piano[i] > piano[i + 1]) {
				sum++;
			}
			mistake[i] = sum;
		}
		mistake[N] = sum;
	}

	static int findMistake(int x, int y) {
		if (x == y) {
			return 0;
		}

		return mistake[y - 1] - mistake[x - 1];
	}
}
