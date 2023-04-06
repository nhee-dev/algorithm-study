import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[][] medals;
    static int answer = 1;
    
    public static void main(String args[]) throws IOException {
        input();
        solve();
        output();
    }
    
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        int country;
        medals = new int[N + 1][4];        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            country = Integer.parseInt(st.nextToken());
            medals[country][1] = Integer.parseInt(st.nextToken());
            medals[country][2] = Integer.parseInt(st.nextToken());
            medals[country][3] = Integer.parseInt(st.nextToken());
        }
    }
    
    static void solve() {
        int gold = medals[K][1];
        int silver = medals[K][2];
        int bronze = medals[K][3];
        
        for (int i = 1; i <= N; i++) {
            if (medals[i][1] > gold ||
                (medals[i][1] == gold && medals[i][2] > silver) ||
                (medals[i][1] == gold && medals[i][2] == silver && medals[i][3] > bronze)) {
                    answer++;
            }            
        }
    }
    
    static void output() {
        System.out.println(answer);
    }
}
