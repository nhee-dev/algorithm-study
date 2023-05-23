package boj;

import java.util.*;
import java.io.*;

public class BOJ_11000_강의실배정_G5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		List<Class> list = new ArrayList();
		PriorityQueue<Integer> room = new PriorityQueue();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			list.add(new Class(s, t));
		}
		list.sort(Class::compareTo);		
		
		room.offer(list.get(0).t);
		for(int i = 1; i < list.size(); i++) {
			if(room.peek() <= list.get(i).s) {
				room.poll();
			}
			
			room.offer(list.get(i).t);
		}
		
		System.out.println(room.size());
		
	}
	
	static class Class implements Comparable<Class>{
		int s;
		int t;
		public Class(int s, int t) {
			super();
			this.s = s;
			this.t = t;
		}
		
		@Override
		public int compareTo(Class o) {
			if(this.s == o.s) return this.t - o.t;
			return this.s - o.s;
		}

		@Override
		public String toString() {
			return "Class [s=" + s + ", t=" + t + "]";
		}
		

	}
}
