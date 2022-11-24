import java.util.*;
import java.io.*;

public class BOJ_2606 {
	static int N, K, count;
	static List<Integer> computers[];
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		computers = new List[N];
		visited = new boolean[N];
		count = 0;
		for(int i = 0; i < N; i++) {
			computers[i] = new ArrayList<>();
		}
		
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			computers[from].add(to);
			computers[to].add(from);
		}
		
		visited[0] = true;
		dfs(0);
		System.out.println(count);
	}
	
	static void dfs(int node) {
		int size = computers[node].size();
		for(int i = 0; i < size; i++) {
			int cur = computers[node].get(i);
			
			if(visited[cur]) {
				continue;
			}
			visited[cur] = true;
			count++;
			dfs(cur);
		}
	}

}
