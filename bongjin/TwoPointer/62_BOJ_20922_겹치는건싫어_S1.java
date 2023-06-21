package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20922_겹치는건싫어_S1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int[] v = new int[100001];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());			
		}
		
		int l = 0, r = 0, sum = 0;
		while(l <= r){
			if(v[arr[r]] < K || r == N) {
				v[arr[r++]]++;				
				
			}else if(v[arr[r]] == K) {
				v[arr[l++]]--;				
			}
			sum = Math.max(sum, r - l);
			
			if(r == N) break;			
		}
		System.out.println(sum);
	}
}
