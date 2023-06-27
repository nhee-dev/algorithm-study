package boj;
import java.io.*;
import java.util.*;

// int로 계산 시 오버플로우
// PQ로 하면 빠름!
public class BOJ_15903_카드합체놀이_S1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Long> list = new ArrayList();
		
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			list.add(Long.parseLong(st.nextToken()));
		}
		
		list.sort(Comparable::compareTo);
		
		for(int i = 0; i < m; i++) {
			long f = list.get(0);
			long l = list.get(1);
			long sum = f + l;
			list.set(0, sum);
			list.set(1, sum);			
			list.sort(Comparable::compareTo);
		}
		
		Long result = 0L;
		for(int i = 0; i < list.size(); i++) {
			result += list.get(i);			
		}
		System.out.println(result);
		
	}
}
