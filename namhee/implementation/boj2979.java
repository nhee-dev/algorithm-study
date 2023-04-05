import java.util.Scanner;

public class Main {
	static final int NUM_CAR = 3;
	static final int MAX_TIME = 100;
	static int[] prices;
	static int[] count = new int[MAX_TIME+1];

	public static void main(String[] args) {
		initData();
		int cost = getCost();
		System.out.println(cost);
	}

	static void initData() {
		Scanner sc = new Scanner(System.in);
		
		prices = new int[NUM_CAR + 1];
		for (int i = 1; i <= NUM_CAR; i++) {
			prices[i] = sc.nextInt();
		}

		int arrival, departure;
		for (int i = 0; i < NUM_CAR; i++) {
			arrival = sc.nextInt();
			departure = sc.nextInt();
			for (int t = arrival; t < departure; t++) {
				count[t]++;
			}
		}
	}
	
	static int getCost() {
		int cost = 0;
		for (int i = 1; i <=MAX_TIME; i++) {
			cost += prices[count[i]] * count[i];
		}
		return cost;
	}
}
