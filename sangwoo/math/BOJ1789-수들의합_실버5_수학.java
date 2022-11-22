import java.io.*;

public class BOJ_1789 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		if(S == 1) {
			System.out.println(1);
			return;
		}
		int count = 0;
		long sum = 0;
		for (int i = 1; sum <= S; i++, count++) {
			sum += i;
		}
		System.out.println(--count);
	}
}
