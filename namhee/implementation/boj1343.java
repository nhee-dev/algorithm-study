import java.util.Scanner;

public class Main {
	static String board;
	static int len = 0;
	static boolean isPossible = true;
	static String Answer = "";

	public static void main(String[] args) {
		initData();
		solution();
		output();
	}
	
	static void initData() {
		Scanner sc = new Scanner(System.in);
		board = sc.next();
		len = board.length();
		sc.close();
	}

	static void solution() {
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (board.charAt(i) == 'X') { count++; }
			else {
				if (count == 1 || count == 3) {
					isPossible = false;
					return;
				}
				else if (count == 2) {
					Answer += "BB";
					count = 0;
				}
				Answer += ".";
			}
			if (count == 4) {
				Answer += "AAAA";
				count = 0;
			}
		}

		if (count == 1 || count == 3) {
			isPossible = false;
			return;
		}
		if (count == 2) {
			Answer += "BB";
		}
	}

	static void output() {
		if (isPossible)
			System.out.print(Answer);
		else
			System.out.print(-1);
	}
}
