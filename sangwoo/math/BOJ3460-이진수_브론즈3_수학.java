import java.io.*;

public class BOJ_3460 {
	static int T, n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());		
		
		for(int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			
			int count = 0;
			while(n > 1) {
				if(n%2 == 1) {
					bw.write(String.format("%d ", count));
				}				
				n /= 2;
				count++;
			}	
			bw.write(String.format("%d\n", count));
		}	
		
		bw.flush();
		bw.close();
	}
}
