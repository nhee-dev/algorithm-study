import java.util.Scanner;

public class boj14470 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A, B, C, D, E;
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		D = sc.nextInt();
		E = sc.nextInt();
		
		int result = 0;
		if (A < 0) {
//			result = (0 - A)*C + D + (B - 1)*E; // 해동할 때는 온도가 오르지 않는다.
			result = (0 - A)*C + D + B*E;
		}
		else {
			result = (B - A)*E;
		}
		
		System.out.println(result);
	}
}
