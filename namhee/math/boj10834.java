import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        
        int dir, dirAnswer = 0;
        double a, b, answer = 1.0;
        StringTokenizer st;
        for (int tc = 0; tc < M; tc++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            dir = Integer.parseInt(st.nextToken());
            
            answer *= b;
            answer /= a;
            if (dir == 1) { dirAnswer = 1 - dirAnswer; }
        }

        System.out.println(dirAnswer + " " + (int)answer);
    }
}
