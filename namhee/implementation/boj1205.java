import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static int N, P;
    static int newScore;
    static int[] score;
    static int[] rank;
    static int answer;
    
    public static void main(String args[]) throws IOException {
        input();
        solve();
        output();
    }
    
    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        newScore = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
    }
    
    static void initScoreAndRank() throws IOException {
        score = new int[N + 1];
        rank = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            
            if (i == 1) {
                rank[i] = i;
                continue;
            }
            
            if (score[i - 1] == score[i]) {
                rank[i] = rank[i - 1];
            }
            else {
                rank[i] = i;
            }
        }          
    }
    
    static void solve() throws IOException {
        if (N == 0) {
            answer = 1;
            return;
        }
        
        initScoreAndRank();
        if (N == P && newScore <= score[N]) {
            answer = -1;
            return;
        }

        getNewScoreRank();
    }
    
    static void getNewScoreRank() {
        int index = 1;
        while (index <= N && newScore < score[index]) {
            index++;
        }
        answer = index;
    }
    
    static void output() {
        System.out.println(answer);
    }
}
