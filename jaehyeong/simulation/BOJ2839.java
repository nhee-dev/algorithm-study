package al.personal.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2839 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		int result = canculate(num);
		
		System.out.println(result);

	}
	
	static int canculate(int num) {
		
		int result = -1;

		int quotient = num / 5;
		
		for(int i = quotient; i >= 0; i--) {
			if((num - 5 * i) % 3 == 0) {
				result = i + (num - 5 * i) / 3;
				return result;
			}
		}

		return result;
	}

}

