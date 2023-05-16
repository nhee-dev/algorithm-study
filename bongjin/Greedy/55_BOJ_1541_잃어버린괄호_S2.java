package boj;

import java.util.*;
import java.io.*;

public class BOJ_1541_잃어버린괄호_S2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine(); 
		String[] str = input.split("\\-");
		int[] arr = new int[str.length];
		for(int i = 0; i < str.length; i++) {
			String[] tmp = str[i].split("\\+");
			int sum = 0;
			for(String s: tmp) {
				sum += Integer.parseInt(s);
			}
			arr[i] = sum;
		}
		
		int result = arr[0];
		for(int i = 1; i < arr.length; i++) {
			result -= arr[i];
		}
		System.out.println(result);
	}
}
