import java.util.*;
import java.io.*;

public class BOJ_20437 {
	static int T, min, max;
	static Map<Character, List<Integer>> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			String str = br.readLine();
			int K = Integer.parseInt(br.readLine());		
			
			init();
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if(map.get(c) == null) {
					map.put(c, new ArrayList<>());
				}
				map.get(c).add(i);				
			}			
			
			for(char c : map.keySet()) {
				if(map.get(c).size() >= K) {
					solution(map.get(c), K);
				}
			}
			printResult(bw);			
		}		
		
		bw.flush();
		bw.close();
	}
	
	static void solution(List<Integer> list, int K) {
		int size = list.size();
		
		for(int i = 0; i + K <= size; i++) {
			int start = list.get(i);
			int end = list.get(i + K - 1);
			
			if(min > end - start + 1) {
				min = end - start + 1;
			}
			if(max < end - start + 1) {
				max = end - start + 1;
			}
		}
	}
	
	static void printResult(BufferedWriter bw) throws Exception {
		if(min == Integer.MAX_VALUE) {
			bw.write("-1\n");
		} else {
			bw.write(String.format("%d %d\n", min, max));
		}
	}
	
	static void init() {
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		map = new HashMap<>();
	}

}
