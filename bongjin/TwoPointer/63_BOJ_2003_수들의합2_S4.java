package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003_수들의합2_S4 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine()); 
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int l = 0, r = 0, sum = 0;
		int result = 0;
		while(l < N) {
			if(sum > M || r == N) {
				sum -= arr[l++];
			}else {
				sum += arr[r++];
			}
			if(sum == M)result++;
			
		}
		System.out.println(result);
	}
}
