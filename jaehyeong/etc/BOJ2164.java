package com.al.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numS = br.readLine();
		br.close();

		int num = Integer.parseInt(numS);
				
		Queue q = new LinkedList<Integer>();
		
		for(int i = 1; i <= num; i ++) {
			q.add(i);
		}
		
		while(q.size() > 1) {
			q.poll();			
			q.add(q.poll());
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(q.poll() + "");
		bw.close();
	
	}

}
