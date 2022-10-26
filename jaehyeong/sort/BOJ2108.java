package com.al.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class BOJ2108 { // 통계학 ////

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numCnt = sc.nextInt();
		int[] numArr = new int[numCnt];
		
		for(int i = 0; i < numCnt; i ++) {
			numArr[i] = sc.nextInt();
		}
		
		// 산술평균
		int sum = 0;
		for(int num : numArr) {
			sum += num;
		}
		System.out.println(Math.round(sum / numCnt));
		
		// 중앙값
		Arrays.sort(numArr);
		System.out.println(numArr[(numCnt/2)]);
		
		// 최빈값
		int[] numCntArr = new int[8005];
		for(int i : numArr) {
			numCntArr[i+4000]++;
		}	
		int nowMax = 0;
		int result = 0;
		ArrayList sameArr = new ArrayList<>();
		for(int i = 0; i < 8002; i++) {
			if(numCntArr[i] > nowMax) {
				nowMax = numCntArr[i];
				result = i - 4000;
				sameArr.clear();
				sameArr.add(result);
			} else if(numCntArr[i] == nowMax) {
				sameArr.add(i - 4000);
			}
		}
		Collections.sort(sameArr);
		
		if(sameArr.size() > 2) {
			System.out.println(sameArr.get(1));
		} else {
			System.out.println(sameArr.get(0));
		}
		
		//범위
		int maxNum = 0;
		int minNum = 5000;
		for(int i : numArr) {
			maxNum = Math.max(i, maxNum);
			minNum = Math.min(i, minNum);
		}
		if(minNum > 0) {
			System.out.println(maxNum - minNum);
		} else {
			System.out.println(maxNum + minNum);
		}
		
	}

}
