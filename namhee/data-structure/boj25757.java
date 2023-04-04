import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

public class Main {
    static char gameType;
    static int peopleNum, answer;

    public static void main(String args[]) throws IOException {
        input();
        solve();
        output();
    }
    
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        gameType = st.nextToken().charAt(0);
        
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        peopleNum = set.size();
    }
    
    static void solve() {
        if (gameType == 'Y') {
            answer = peopleNum / 1;
        }
        else if (gameType == 'F') {
            answer = peopleNum / 2;
        }
        else if (gameType == 'O') {
            answer = peopleNum / 3;
        }
    }
    
    static void output() {
        System.out.println(answer);
    }
}
