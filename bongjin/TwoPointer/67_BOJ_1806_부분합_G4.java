package boj;
		
import java.io.*;
import java.util.*;

public class 67_BOJ_1806_부분합_G4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int a[] = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		int l = 0;
		int r = 0;
		int result = Integer.MAX_VALUE;
		int len = 0;
		while(r <= n) {
			if(sum >= s) {
				sum -= a[l++];
				len = r - l + 1;
				if(result > len) result = len;
			}else if(sum < s) {
				sum += a[r++];
			}
		}
		
		System.out.println((result) == Integer.MAX_VALUE ? 0 : result);

	}

}