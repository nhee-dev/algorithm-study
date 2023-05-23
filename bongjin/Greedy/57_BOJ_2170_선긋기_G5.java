package boj;

import java.util.*;
import java.io.*;

public class BOJ_2170_선긋기_G5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		List<Point> list = new ArrayList<Point>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.add(new Point(s, e));
		}
		
		list.sort(Point::compareTo);		
		
		Point p = list.get(0);
		int result = p.e - p.s;
		
		for(int i = 1; i < N; i++) {
			Point np = list.get(i);
			
			if(p.s <= np.s && np.e <= p.e) {
				continue;
			}else if(np.s < p.e) {
				result += np.e - p.e;
			}else {
				result += np.e - np.s;
			}
			p = np;
			
		}		
		System.out.println(result);
	}
	
	static class Point implements Comparable<Point>{
		int s;
		int e;
		public Point(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}
		
		@Override
		public int compareTo(Point o) {
			if(this.s == o.s) {
				return this.e - o.e;
			}
			return this.s - o.s;
		}

		@Override
		public String toString() {
			return "Point [s=" + s + ", e=" + e + "]";
		}
		
		
	}
}
