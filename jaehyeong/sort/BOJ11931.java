package com.al.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ11931 { // 버블 정렬 복습

	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
				
		int numNums = Integer.parseInt(reader.readLine());
		Integer[] numList2 = new Integer[numNums];
//		ArrayList<Integer> numList = new ArrayList();
		
		for(int i = 0; i < numNums; i ++) {
//			numList.add(Integer.parseInt(reader.readLine()));
			numList2[i] = Integer.parseInt(reader.readLine());
		}
		
				
		Arrays.sort(numList2, Collections.reverseOrder());
//		bubbleSort(numList);
		for(int i : numList2) {
			writer.write(i+"\n");
		}
		writer.flush();
		
	

	}
	
	static ArrayList<Integer> bubbleSort(ArrayList<Integer> numlist) {
		for(int count = 0; count < numlist.size()-1; count ++) { // 최대 size-1 번 반복
			boolean isSwaped = false;
			for(int index = 0; index < numlist.size()-1-count; index ++) { // 주행 한 번 할 때 마다 1 씩 감소
				if(numlist.get(index) < numlist.get(index+1)) { // 앞 인덱스 값이 뒤 인덱스 값 보다 작으면 스왑
					Collections.swap(numlist, index, index+1);
					isSwaped = true;
				}
			}
			if(!isSwaped) { // 한 번도 정렬이 바뀌지 않으면 완료된 것으로 보고 종료
				break;
			}
		}
		return numlist;
	}

}
