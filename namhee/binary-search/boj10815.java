import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static final int START = 10000000;
    static int[] haveCard = new int[20000000];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String args[]) throws IOException {
        initHaveCard();
        solution();
    }
    
    static void initHaveCard() throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] numStr = br.readLine().split(" ");

        int num, index;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(numStr[i]);
            index = START + num;
            haveCard[index] = 1;
        }
    }
    
    static void solution() throws IOException {
        int M = Integer.parseInt(br.readLine());
        String[] numStr = br.readLine().split(" ");

        int num, index;
        for (int i = 0; i < M; i++) {
            num = Integer.parseInt(numStr[i]);
            index = START + num;
            
            System.out.print(haveCard[index] + " ");
        }
    }
}
