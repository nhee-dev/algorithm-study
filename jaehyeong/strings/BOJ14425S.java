package com.al.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ14425S {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int setNums = Integer.parseInt(st.nextToken());
		int checkNums = Integer.parseInt(st.nextToken());
		
		HashSet stringSet = new HashSet<String>();
		for(int i = 0; i < setNums; i++) {
			stringSet.add(br.readLine());
		}
		
		int answer = 0;
		for(int i = 0; i< checkNums; i ++) {
			if(stringSet.contains(br.readLine())) {
				answer ++;
			}
		}
		
		System.out.println(answer);
	}

}
