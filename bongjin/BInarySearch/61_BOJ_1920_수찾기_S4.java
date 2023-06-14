package boj;
import java.util.*;
import java.io.*;

public class BOJ_1920_수찾기_S4 {
	static int[] arr;
	static int  N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());			
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			sb.append(findBinary(Integer.parseInt(st.nextToken())) + "\n");
			
		}
		System.out.println(sb.toString());
	}
	
	static String findBinary(int num) {
		int l, r, c;
		l = 0; 
		r = N;
		c = N / 2;
		while(l != r) {
			if(arr[c] == num) return "1";
			if(r - l == 1) return "0";
			if(arr[c] > num) {
//				l = 0;
				r = c;
				c = r / 2;
			}else if(arr[c] < num) {
				l = c;
//				r = N;
				c = (r + l) / 2;
			}			
		}
		return "0";
	}
}
