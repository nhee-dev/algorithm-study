import java.util.*;
import java.io.*;

public class BOJ_13549 {
	static int N, K, min;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		v = new boolean[200001];
		bfs();
		System.out.println(min);
	}

	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(N, 0));
		v[N] = true;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (cur.n == K) {
				min = cur.depth;
				break;
			}
			if (cur.n * 2 <= 200000 && !v[cur.n * 2]) {
				if (cur.n * 1 == K) {
					min = cur.depth;
					break;
				}
				q.offer(new Node(cur.n * 2, cur.depth));
				v[cur.n * 2] = true;
			}
			if (cur.n - 1 >= 0 && !v[cur.n - 1]) {
				if (cur.n - 1 == K) {
					min = cur.depth + 1;
					break;
				}
				q.offer(new Node(cur.n - 1, cur.depth + 1));
				v[cur.n - 1] = true;
			}
			if (cur.n + 1 <= 200000 && !v[cur.n + 1]) {
				if (cur.n + 1 == K) {
					min = cur.depth + 1;
					break;
				}
				q.offer(new Node(cur.n + 1, cur.depth + 1));
				v[cur.n + 1] = true;
			}

		}
	}

	static class Node {
		int n, depth;

		public Node(int n, int depth) {
			this.n = n;
			this.depth = depth;
		}
	}

}
