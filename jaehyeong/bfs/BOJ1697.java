package al.personal.dbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1697 { // 숨바꼭질

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int start = sc.nextInt(); // 시작 위치
		int end = sc.nextInt(); // 종료 위치
		
		int spend = bfs(start, end) -1; //
		
		System.out.println(spend);
	}
	
	static int bfs(int start, int end) {
		
		int visited[] = new int[100001];
		
		Queue<Integer> q = new LinkedList();
		
		q.offer(start);
		visited[start] = 1;
		while(!q.isEmpty()) {
						
			int nowP = q.poll();
			System.out.println(nowP + " nowP : visited " + visited[nowP]);
			
			if(nowP == end) {
				return visited[nowP];
			}
			
			if(nowP-1 >= 0 && visited[nowP-1] == 0) {
				q.offer(nowP-1);
				visited[nowP-1] = visited[nowP]+1;
			}
			if(nowP+1 <= 100000 && visited[nowP+1] == 0) {
				q.offer(nowP+1);
				visited[nowP+1] = visited[nowP]+1;
			}
			if(nowP*2 <= 100000 && visited[nowP * 2] == 0) {
				q.offer(nowP*2);
				visited[nowP*2] = visited[nowP]+1;
			}
			
		}

		return 1;
	}


}
