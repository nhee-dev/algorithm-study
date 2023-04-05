import java.util.Scanner;

public class Main {
	static int N, K;
	static int answer;

	public static void main(String[] args) {
		inputData();
		solution();
		System.out.println(answer);
	}
	
	static void inputData() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		sc.close();
	}

	static void solution() {
		answer = binomialCoefficient(N, K);
	}
	
	static int binomialCoefficient(int n, int k) {
		if (k == 0 || n == k) {
			return 1;
		}
		else if (k == 1 || n-1 == k) {
			return n;
		}
		else { 
			return binomialCoefficient(n-1, k) + binomialCoefficient(n-1, k-1);
		}
	}
}
