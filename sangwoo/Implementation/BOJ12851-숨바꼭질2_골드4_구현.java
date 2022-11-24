import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851 {
	static int N, K, time, num;
	static int[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if (K == N) {
			System.out.println(0);
			System.out.println(1);
			return;
		}
		
		time = 0;
		num = 0;
		visited = new int[100001];
		Arrays.fill(visited,  Integer.MAX_VALUE);

		bfs();
		
		System.out.println(time);
		System.out.println(num);
	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		visited[N] = 0;
		boolean isFind = false;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				if(cur == K) {
					num++;
					isFind = true;
					continue;
				}				
				find(cur + 1, q);
				find(cur - 1, q);
				find(cur * 2, q);
			}
			if(isFind) {
				break;
			}	
			time++;
		}
	}
	
	public static void find(int cur, Queue<Integer> q) {
		if(!outOfRange(cur) && time <= visited[cur]) {
			q.offer(cur);
			if(cur != K) {
				visited[cur] = time;
			}
		}		
	}

	public static boolean outOfRange(int n) {
		return (n < 0 || n > 100000);
	}
}
