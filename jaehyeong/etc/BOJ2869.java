package com.al.etc;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ2869 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nums = br.readLine();
		br.close();
		
		StringTokenizer st = new StringTokenizer(nums);

		int up = Integer.parseInt(st.nextToken());	
		int down = Integer.parseInt(st.nextToken());	
		int height = Integer.parseInt(st.nextToken());	

		int day = (height - down) / (up - down);
        
		if ((height - down) % (up - down) != 0) {
			day++;
		}
		
		System.out.println(day);

		
	}

}
