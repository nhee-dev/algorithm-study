import java.util.Scanner;

public class boj5622 {
	
	static int[] dialTime = { 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10 };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += dialTime[str.charAt(i) - 'A'];
		}
		
		System.out.print(sum);
	}
}

// 2 - ABC(012) - 3s
// 3 - DEF(345) - 4s
// ...
// 7 - PQRS(15,16,17,18) - 8s
// 8 - TUV(19,20,21) - 9s
// 9 - WXYZ(22,23,24,25) - 10s
