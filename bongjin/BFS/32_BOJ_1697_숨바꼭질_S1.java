package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 32_BOJ_1697_숨바꼭질_S1 {
	
	static int N, K;
	static int[] arr;
	static Queue<Integer> q;
	static int[] v;
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		N = Integer.parseInt(str.split(" ")[0]);
		K = Integer.parseInt(str.split(" ")[1]);
		
		arr = new int[100001];
		v = new int[100001];
		q = new LinkedList<Integer>();
		result = 0;
		bfs(N);
		System.out.println(result);
		
	}
	
	static void bfs(int s) {
		q.offer(s);
		v[s] = 1;
		
		while(!q.isEmpty()) {
			int x = q.poll();			
			if(x == K) {
				result = v[x] - 1;
				return;
			}
			
			if(x > 0 && v[x - 1] == 0) {
				v[x - 1] = v[x] + 1;
				q.offer(x - 1);
			}
			if(x < 100000 && v[x + 1] == 0) {
				v[x + 1] = v[x] + 1;
				q.offer(x + 1);
			}
			if(2 * x < 100001 && v[2 * x] == 0) {
				v[x * 2] = v[x] + 1;
				q.offer(x * 2); 
			}
			
		}
	}
}
