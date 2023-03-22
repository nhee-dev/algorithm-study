import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static String word, answer;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            word = br.readLine();
            if (word.equals("end")) { break; }
            
            solve();
            System.out.println(answer);
        }
    }
    
    static void solve() {
        boolean isAcceptable = true;
        boolean haveVowels = false;
        int vowels = 0, consonants = 0;
        for (int i = 0; i < word.length(); i++) {
            if (isVowels(word.charAt(i))) {
                haveVowels = true;
                vowels++;
                consonants = 0;
            }
            else {
                vowels = 0;
                consonants++;
            }
            
            if (vowels == 3 || consonants == 3) {
                isAcceptable = false;
                break;
            }
            
            if (i > 0) {
                if (word.charAt(i - 1) == word.charAt(i) && noteeoo(i)) {
                    isAcceptable = false;
                    break;
                }
            }
        }
        if (!haveVowels) {
            isAcceptable = false;
        }
        
        if (isAcceptable) {
            answer = "<" + word + "> is acceptable.";
        }
        else {
            answer = "<" + word + "> is not acceptable.";
        }
    }
    
    static boolean isVowels(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    
    static boolean noteeoo(int index) {
        return !(word.charAt(index) == 'e' || word.charAt(index) == 'o');
    }
}
