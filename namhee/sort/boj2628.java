package com.algo.practice.boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj2628 {
	
	static int[] wLine = new int[100];
	static int[] hLine = new int[100];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int N = sc.nextInt();
		int wLineCount = 0;
		int hLineCount = 0;
		for (int i = 0; i < N; i++) {
			int val = sc.nextInt();
			if (val == 0) {
				wLine[++wLineCount] = sc.nextInt();
			}
			else if (val == 1) {
				hLine[++hLineCount] = sc.nextInt();
			}
		}

		Arrays.sort(wLine, 0, wLineCount+1);
		Arrays.sort(hLine, 0, hLineCount+1);
		
		int wMax = 0;
		for (int i = 0; i < hLineCount; i++) {
			wMax = Math.max(wMax, hLine[i+1] - hLine[i]);
		}
		wMax = Math.max(wMax, w - hLine[hLineCount]);
		
		int hMax = 0;
		for (int i = 0; i < wLineCount; i++) {
			hMax = Math.max(hMax, wLine[i+1] - wLine[i]);
		}
		hMax = Math.max(hMax, h - wLine[wLineCount]);
		
		int maxArea = wMax * hMax;
		System.out.printf("%d", maxArea);
	}
}
