package al.personal.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int totalNum = Integer.parseInt(st.nextToken());
		int pickNum = Integer.parseInt(st.nextToken());
		int depth = 0;
		
		boolean[] visited = new boolean[totalNum];
		int[] numArr = new int[totalNum];
		int[] pickArr = new int[pickNum];
		
		for(int i = 0; i < totalNum; i ++) {
			numArr[i] = i+1;
		}
				
		permutation(numArr, pickArr, visited, depth, totalNum, pickNum);
		
		
	}
	
	static void permutation(
			int[] numArr, int[] pickArr, boolean[] visited, int depth, int totalNum, int pickNum
	) {
		if(depth == pickNum) {
			print(pickArr, pickNum);
			return;
		}
		
		for(int i = 0; i < totalNum; i ++) {
			if(visited[i] != true) {
				pickArr[depth] = numArr[i];
				visited[i] = true;
				permutation(numArr, pickArr, visited, depth+1, totalNum, pickNum);
				visited[i] = false;
			}
		}
		
	}
	
	static void print(int[] pickArr, int pickNum) {
		for(int i = 0; i < pickNum; i ++) {
			System.out.print(pickArr[i] + " ");	
		}
		System.out.println();
	}

}
