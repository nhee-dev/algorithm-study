package com.al.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5014R {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int topF;
	static int goalF;
	static int upNum;
	static int downNum;
	
	static int[] floors;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		topF = Integer.parseInt(st.nextToken());
		int nowF = Integer.parseInt(st.nextToken());
		goalF = Integer.parseInt(st.nextToken());
		
		upNum = Integer.parseInt(st.nextToken());
		downNum = Integer.parseInt(st.nextToken());
		
		floors = new int[topF+1];
		floors[nowF] = 1;
		bfs(nowF);
		
	}
	
	static void bfs(int nowF) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(nowF);
		
		
		while(!q.isEmpty()) {
			int floor = q.poll();
			
			if(floor == goalF) {
				System.out.println(floors[floor]-1);
				return;
			}
			
			if(floor + upNum <= topF && floors[floor + upNum] == 0) {
				q.add(floor + upNum);
				floors[floor + upNum] = floors[floor] + 1;
			}
			if(floor - downNum > 0 && floors[floor - downNum] == 0) {
				q.add(floor - downNum);
				floors[floor - downNum] = floors[floor] + 1;
			}
			
		}
		
		System.out.println("use the stairs");
	
	}

}











