package boj;

import java.io.*;
import java.util.*;

public class BOJ_1744_수묶기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue();
		List<Integer> pl = new ArrayList();
		List<Integer> nl = new ArrayList();
		
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num > 0) pl.add(num);
			else nl.add(num);
			
		}
		
		Collections.sort(pl, Collections.reverseOrder());
		Collections.sort(nl);
		int sum = 0;
		for(int i = 0; i < pl.size(); i++) {
			if(i < pl.size() - 1 && pl.get(i) != 1 && pl.get(i + 1) != 1) {
				sum += pl.get(i++) * pl.get(i);
			}else {
				sum += pl.get(i);
			}
		}
		
		for(int i = 0; i < nl.size(); i++) {
			if(i < nl.size() - 1 && nl.get(i) < -1) {
				sum += nl.get(i++) * nl.get(i);
			}else if(i < nl.size() - 1 && nl.get(nl.size() - 1) == 0) {
				if(nl.get(i) == 1) sum += -1;
				else sum += nl.get(i++) * nl.get(i);
			}else {
				sum += nl.get(i);
			}
		}
		
		System.out.println(sum);
		
	}
}