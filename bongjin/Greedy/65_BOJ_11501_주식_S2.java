package boj;

import java.io.*;
import java.util.*;

public class BOJ_11501_주식_S2{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		
		
		for(int t = 0; t < T; t++) 
		{
			
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Num> list = new ArrayList();
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				list.add(new Num(arr[i], i));
			}
			list.sort(Num :: compareTo);
			
			Long result = 0L;
			for(int i = 0; i < N; i++) {
				Num n = list.get(i);
				int idx = n.idx;
				
				if(idx == 0){
					arr[idx] = -1;
					continue;
				}
				for(int d = idx - 1; d >= 0; d--) {
					if(arr[d] == -1L) break;
					if(arr[d] >= n.n) break;
					result += n.n - arr[d];
					arr[d] = -1;
				}
			}
			System.out.println(result);
		}
	}
	
	static class Num implements Comparable<Num>{
		int n;
		int idx;		
		
		public Num(int n, int idx) {
			super();
			this.n = n;
			this.idx = idx;
		}

		@Override
		public int compareTo(Num o) {
			return o.n - this.n;			
		}

		@Override
		public String toString() {
			return "Num [n=" + n + ", idx=" + idx + "]";
		}

	}
}
