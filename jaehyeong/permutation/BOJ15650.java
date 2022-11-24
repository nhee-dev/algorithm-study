package al.personal.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15650 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int totalNum = Integer.parseInt(st.nextToken());
		int pickNum = Integer.parseInt(st.nextToken());
		
		int[] numArr = new int[totalNum];
		int[] pickArr = new int[pickNum];
		boolean[] visited = new boolean[totalNum];
		
		for(int i = 0; i < totalNum; i ++) {
			numArr[i] = i+1;
		}
		
		int depth = 0;
		
		permutation(numArr, pickArr, visited, totalNum, pickNum, depth);

	}
	
	static void permutation(int[] numArr, int[] pickArr, boolean[] visited, int totalNum, int pickNum, int depth) {
		if(depth == pickNum) {
			print(pickArr, pickNum);
			return;
		}
		
		for(int i = 0; i < totalNum; i ++) {
			if(visited[i] == false) {
				pickArr[depth] = numArr[i];
				visited[i] = true;
				permutation(numArr, pickArr, visited, totalNum, pickNum, depth+1);
				visited[i] = false;
			}
		}
		
	}
	
	static void print(int[] pickArr, int pickNum) {
		
		for(int i = 0; i < pickArr.length - 1; i ++) {
			if(pickArr[i] > pickArr[i+1]) {
				return;
			}
		}
		

		for(int i = 0; i < pickArr.length; i ++) {
			System.out.print(pickArr[i] + " ");
		}
		
		System.out.println();
	}

}
