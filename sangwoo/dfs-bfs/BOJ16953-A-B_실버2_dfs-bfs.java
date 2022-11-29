import java.util.*;
import java.io.*;

public class BOJ_16953 {
	static long A, B, min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		min = Long.MAX_VALUE;

		bfs();

		if (min == Long.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	static void bfs() {
		Queue<Long> q = new LinkedList<>();
		q.offer(A);

		int level = 0;
		boolean isFind = false;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				long cur = q.poll();
				if (cur == B) {
					isFind = true;
					break;
				}
				if (cur * 2 <= B) {
					q.offer(cur * 2);
				}
				if ((cur * 10) + 1 <= B) {
					q.offer((cur * 10) + 1);
				}
			}

			level++;
			if (isFind) {
				break;
			}
		}
		if (isFind) {
			min = level;
		}
	}
}
