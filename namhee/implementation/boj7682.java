import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static final int N = 3;
    static BufferedReader br;
    static int countX, countO;
    static char[][] board = new char[N][N];
    static String answer;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            if (!input()) { 
                break; 
            }
            solve();
            output();
        }
        
        br.close();
    }
    
    static boolean input() throws IOException {
        String line = br.readLine();
        if (line.equals("end")) {
            return false;
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(i * N + j);
            }
        }
        
        return true;
    }
    
    static void solve() {
        getPieceCount();
        
        if (!isValidPieceCount()) {
            answer = "invalid";
        }
        else if (!haveThreeLine()) {
            if (isFull()) {
                answer = "valid";
            }
            else {
                answer = "invalid";
            }
        }
        else if (isAlreadyDone()) {
            answer = "invalid";
        }
        else {
            answer = "valid";
        }
    }
    
    static void getPieceCount() {
        countX = 0;
        countO = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'X') {
                    countX++;
                }
                else if (board[i][j] == 'O') {
                    countO++;
                }
            }
        }
    }
    
    static boolean isValidPieceCount() {
        return (countX == countO) || (countX - 1 == countO);
    }
    
    static boolean isFull() {
        return countX + countO == N * N;
    }
    
    static boolean haveThreeLine() {
        // 행 탐색
        int count = 1;
        for (int i = 0; i < N; i++) {
            if (board[i][0] == '.') { continue; }

            count = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][0] == board[i][j]) {
                    count++;
                }
            }
            if (count == N) {
                return true;
            }
        }
        
        // 열 탐색
        for (int j = 0; j < N; j++) {
            if (board[0][j] == '.') { continue; }
            
            count = 1;
            for (int i = 1; i < N; i++) {
                if (board[0][j] == board[i][j]) {
                    count++;
                }
            }
            if (count == N) {
                return true;
            }
        }        
        
        // 대각선 탐색
        count = 1;
        for (int i = 1; i < N; i++) {
            if (board[0][0] == '.') { continue; }
            
            if (board[0][0] == board[i][i]) {
                count++;
            }
        }
        if (count == N) {
            return true;
        }
        
        count = 1;
        for (int i = 1; i < N; i++) {
            if (board[0][N-1] == '.') { continue; }
            
            if (board[0][N-1] == board[i][N-1-i]) {
                count++;
            }
        }
        if (count == N) {
            return true;
        }        
        
        return false;
    }

    static boolean isAlreadyDone() {
        if (countX == countO) {
            if (isAlreadyDoneRemove('O')) {
                return true;
            }
        }
        else if (countX - 1 == countO) {
            if (isAlreadyDoneRemove('X')) {
                return true;
            }
        }
        return false;
    }

    static boolean isAlreadyDoneRemove(char c) {
        boolean isDone = true;
        outLoop:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == c) {
                    board[i][j] = '.';
                    if (!haveThreeLine()) {
                        board[i][j] = c;
                        isDone = false;
                        break outLoop;
                    }
                    board[i][j] = c;
                }
            }
        }
        return isDone;
    }
    
    static void output() {
        System.out.println(answer);
    }
}
