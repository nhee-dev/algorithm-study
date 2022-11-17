import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class BOJ_1010 {
	static int T, N, M;
	static BigInteger[] factorial;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		factorial = new BigInteger[31];
		factorial[0] = BigInteger.ONE;
		factorial[1] = BigInteger.ONE;
		for (int i = 2; i < 31; i++) {
			factorial[i] = factorial[i - 1].multiply(BigInteger.valueOf(i));
		}

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			bw.write(String.valueOf(getCombi(n, r)));
			bw.write('\n');
		}
		bw.flush();
		bw.close();
	}

	static BigInteger getCombi(int n, int r) {
		return factorial[n].divide(factorial[n-r].multiply(factorial[r]));
	}
}
