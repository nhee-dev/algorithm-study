package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int pair = Integer.parseInt(br.readLine());
		
		boolean[] visited = new boolean[N+1];
		int[][] arr = new int[N+1][N+1];
		
		Queue<Integer> queue = new LinkedList<>();
	
		StringTokenizer st;
		for(int i=0;i<pair;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			arr[start][end] = arr[end][start] = 1;
		}
		
		visited[1]=true;
		queue.add(1);
		
		int answer=0;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for(int i=1;i<=N;i++) {
				if(arr[current][i]==1 && !visited[i]) {
					visited[i]=true;
					queue.add(i);
					answer++;
				}
			}
		}
		
		System.out.println(answer);
		
		
		
	}

}
