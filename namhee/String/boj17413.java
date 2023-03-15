import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static char[] S;

    public static void main(String []args) throws IOException {
        input();
        solve();
        output();
    }
     
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine().toCharArray();
        br.close();
    }
    
    static void solve() {
        for (int i = 0; i < S.length; i++) {
            if (S[i] == '<') {
                i = getTagEndIndex(i);
            }
            else if (S[i] != ' '){
                int wordEndIndex = getWordEndIndex(i);
                reverseWord(i, wordEndIndex);
                i = wordEndIndex;
            }
        }
    }
    
    static int getTagEndIndex(int tagStartIndex) {
        int tagEndIndex = tagStartIndex + 2;
        for (int i = tagStartIndex + 2; i < S.length; i++) {
            if (S[i] == '>') {
                tagEndIndex = i;
                break;
            }
        }
        return tagEndIndex;
    }
    
    static int getWordEndIndex(int wordStartIndex) {
        int wordEndIndex = wordStartIndex;
        for (int i = wordStartIndex; i < S.length; i++) {
            if (S[i] == ' ' || S[i] == '<') {
                wordEndIndex = i - 1;
                break;
            }
            if (i == S.length - 1) {
                wordEndIndex = i;
                break;
            }
        }
        return wordEndIndex;
    }
    
    static void reverseWord(int startIndex, int endIndex) {
        char tmp;
        int area = endIndex - startIndex + 1;
        for (int i = 0; i < (area / 2); i++) {
            tmp = S[endIndex - i];
            S[endIndex - i] = S[startIndex + i];
            S[startIndex + i] = tmp;
        }
    }
    
    static void output() {
        System.out.println(S);
    }
}
