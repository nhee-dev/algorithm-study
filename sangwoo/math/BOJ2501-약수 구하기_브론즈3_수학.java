import java.util.*;
import java.io.*;

public class BOJ_2501 {
	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int count = 0;
		for(int i = 1; i <= N; i++) {
			if(N % i == 0) {
				count++;
				if(count == K) {
					System.out.println(i);
					return;
				}
			}
		}
		System.out.println(0);
	}
}
