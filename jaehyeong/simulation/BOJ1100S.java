package com.al.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1100S { // B2 하안 칸

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int ans = 0;
        for (int i = 0; i < 8; i++) {
            String s = br.readLine();
            
            for (int j = 0; j < 8; j++) {
            	
            	// 단순화 참고
                if (s.charAt(j) == 'F' && (i + j) % 2 == 0) {
                	ans++;
                }
            }
        }
        
        System.out.print(ans);


	}

}
