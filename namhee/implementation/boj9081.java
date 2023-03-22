import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int T;
    static BufferedReader br;
    static int len;
    static char[] word;
    
    public static void main(String args[]) throws IOException {
        inputTestCaseCount();
        while(T-- > 0) {
            inputWord();
            solve();
            output();
        }
        br.close();
    }
    
    static void inputTestCaseCount() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
    }
    
    static void inputWord() throws IOException {
        String str = br.readLine();
        word = str.toCharArray();
        len = word.length;
    }    
    
    static void solve() {
        for (int i = len - 2; i >= 0; i--) {
            if (word[i] < word[i + 1]) {
                int nextBiggerCharIndex = getNextBiggerCharIndex(i, i + 1);
                swapChar(i, nextBiggerCharIndex);
                sort(i + 1);
                break;
            }
        }
    }
    
    static int getNextBiggerCharIndex(int curIndex, int start) {
        char ch = 'Z' + 1;
        int index = -1;
        for (int i = start; i < len; i++) {
            if (word[curIndex] < word[i] && word[i] < ch) {
                ch = word[i];
                index = i;
            }
        }
        return index;
    }
    
    static void swapChar(int i, int j) {
        char tmp;
        tmp = word[i];
        word[i] = word[j];
        word[j] = tmp;
    }
    
    static void sort(int start) {
        for (int i = start; i < len - 1; i++) {
            for(int j = i + 1; j < len; j++) {
                if (word[i] > word[j]) {
                    swapChar(i, j);
                }
            }
        }
    }
    
    static void output() {
        System.out.println(word);
    }
}
