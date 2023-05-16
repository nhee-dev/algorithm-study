import java.util.Arrays;
import java.util.Scanner;

public class boj7568 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int[] w = new int[num];
		int[] h = new int[num];
		for (int i = 0; i < num; i++) {
			w[i] = sc.nextInt();
			h[i] = sc.nextInt();
		}
		sc.close();

		int[] rank = new int[num];
		Arrays.fill(rank, 1);
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (i != j) {
					if (w[i] < w[j] && h[i] < h[j]) {
						rank[i]++;
					}
				}
			}
		}
		
		for (int i = 0; i < num; i++) {
			System.out.printf("%d ", rank[i]);			
		}
	}
}
