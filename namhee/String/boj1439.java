import java.util.Scanner;

public class boj1439 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		char preChar = str.charAt(0);
		char curChar;
		int changeCount = 0;
		for (int i = 1; i < str.length(); i++) {
			curChar = str.charAt(i);
			if (preChar != curChar) {
				changeCount++;
				preChar = curChar;
			}
		}
		
		int result;
		if (changeCount % 2 == 0) {
			result = changeCount / 2;
		}
		else {
			result = changeCount / 2 + 1;
		}
		
		System.out.print(result);
	}
}
