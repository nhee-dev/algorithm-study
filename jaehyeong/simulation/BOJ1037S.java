package com.al.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1037S { //B1 약수

	static 	StringTokenizer st;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int max = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0 ; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            
            //단순화 참고
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        System.out.println(max * min);

	}

}