import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int answer;
    static int[] schedule = new int[366];
    
    public static void main(String args[]) throws IOException {
        input();
        solve();
        output();
    }
    
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int S, E;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            
            for (int day = S; day <= E; day++) {
                schedule[day]++;
            }
        }
    }
    
    static void solve() {
        int connect, maxSchedule;        
        
        for (int day = 1; day <= 365; day++) {
            if (schedule[day] > 0) {
                connect = 1;
                maxSchedule = schedule[day];
                
                while (++day <= 365 && schedule[day] > 0) {
                    connect++;
                    maxSchedule = schedule[day] > maxSchedule ? schedule[day] : maxSchedule;
                }
                answer += connect * maxSchedule;
            }
        }
    }
    
    static void output() {
        System.out.println(answer);
    }
}
