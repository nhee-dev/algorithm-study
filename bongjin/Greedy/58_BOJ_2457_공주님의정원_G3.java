package boj;

import java.io.*;
import java.util.*;

public class BOJ_2457_공주님의정원_G4 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Days> list = new ArrayList();
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			int start = Integer.parseInt(s.split(" ")[0]) * 100 + Integer.parseInt(s.split(" ")[1]);
			int end = Integer.parseInt(s.split(" ")[2]) * 100 + Integer.parseInt(s.split(" ")[3]);
			if(start < 1131 && end > 300) {
				list.add(new Days(start, end));
			}
		}
		
		list.sort(Days::compareTo);
//		System.out.println(list);
		
		int sum = 1;
		Days d = list.get(0);
		
		int sIdx = 0;		
		while(sIdx < list.size() && list.get(sIdx).s <= 301){
			Days td = list.get(sIdx);
			if(td.e > d.e && td.s <= d.e){				
				d = list.get(sIdx);
			}
			sIdx++;
		}
		if(sIdx == 0 ) {
			System.out.println(0);
			return;
		}
		sIdx--;

		while(d.e < 1131) {			
			Days nd = list.get(sIdx);			
			boolean flag = false;			
			for(int i = sIdx + 1; i < list.size(); i++) {				
				Days td = list.get(i);
				if(td.s <= d.e) {					
					if(nd.e <= td.e) {
						nd = td;					
						flag = true;
						sIdx = i;
					}
				}else {
					break;
				}				
			}
			if(flag) {
				d = nd;
				sum++;
				if(d.e > 1130) break;
			}
			else {
				System.out.println(0);
				return;
			}
		}
		System.out.println(sum);

	}
		
	static class Days implements Comparable<Days>{
		int s;
		int e;
		public Days(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}
		
		@Override
		public int compareTo(Days o) {
			if(this.s == o.s) return this.e - o.e;
			return this.s - o.s;
		}

		@Override
		public String toString() {
			return "Days [s=" + s + ", e=" + e + "]";
		}
		
	}
}
