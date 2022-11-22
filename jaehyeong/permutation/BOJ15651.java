package al.personal.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ15651 {

	static BufferedWriter bw;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw  = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int numCnt = Integer.parseInt(st.nextToken());
		int pickCnt = Integer.parseInt(st.nextToken());
		
		int[] numArr = new int[numCnt];
		int[] pickArr = new int[pickCnt];
		int depth = 0;
		
		for(int i = 0; i < numCnt; i ++) {
			numArr[i] = i + 1;
		}
		
		permutation(numArr, pickArr, depth, numCnt, pickCnt);
		bw.flush();
	}
	
	static void permutation(int[] numArr, int[] pickArr, int depth, int numCnt, int pickCnt) throws IOException {
		if(depth == pickCnt) {
			print(pickArr, pickCnt);
			return;
		}
		
		for(int i = 0; i < numCnt; i ++) {
			pickArr[depth] = numArr[i];
			permutation(numArr, pickArr, depth+1, numCnt, pickCnt);
		}
	}
	
	static void print2(int[] pickArr, int pickCnt) throws IOException {
		
		for(int i = 0; i < pickCnt; i ++) {
			sb.append(pickArr[i] + " ");
		}
		sb.append("\n");
	}
	
	static void print(int[] pickArr, int pickCnt) throws IOException {
		
		for(int i = 0; i < pickCnt; i ++) {
			bw.write(pickArr[i] + " ");
		}
		bw.write("\n");
	}

}
