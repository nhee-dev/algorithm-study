package boj;

import java.util.*;
public class BOJ_11399_ATM_S4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int result = arr[0];
		int[] d = new int[N];
		d[0] = result;
		
		for(int i = 1; i < N; i++) {
			d[i] += d[i - 1] + arr[i];
			result += d[i];
		}
		System.out.println(result);
	}
}
