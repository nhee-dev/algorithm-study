import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static BufferedReader br;
    
    static int N;
    static String word1, word2;
    static int len1, len2;
    static int[] alphabet1 = new int[26];
    static int[] alphabet2 = new int[26];
    static int answer = 0;
    
    public static void main(String args[]) throws IOException {
        input();
        solve();
        output();
    }
    
    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }
    
    static void initFirstWordAlphabet() throws IOException {
        char ch;
        word1 = br.readLine();
        len1 = word1.length();
        for (int i = 0; i < len1; i++) {
            ch = word1.charAt(i);
            alphabet1[ch - 'A']++;
        }
    }
    
    static void initNextWordAlphabet() throws IOException {
        for (int i = 0; i < 26; i++) {
            alphabet2[i] = 0;
        }
        
        char ch;
        word2 = br.readLine();
        len2 = word2.length();
        for (int i = 0; i < len2; i++) {
            ch = word2.charAt(i);
            alphabet2[ch - 'A']++;
        }
    }
    
    static void solve() throws IOException {
        initFirstWordAlphabet();
        
        for (int i = 2; i <= N; i++) {
            initNextWordAlphabet();

            if (isSimilarWord()) {
                answer++;
            }
        }
        
        br.close();
    }
    
    static boolean isSimilarWord() {
        if (len1 == len2) {
            if (compareDiff() <= 2) {
                return true;
            }
        }
        else if (Math.abs(len1 - len2) == 1) {
            if (compareDiff() == 1) {
                return true;
            }
        }
        return false;
    }
    
    static int compareDiff() {
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            diff += Math.abs(alphabet1[i] - alphabet2[i]);
        }
        return diff;
    }
    
    static void output() {
        System.out.println(answer);
    }
}
