package src.main.kotlin.simulation

class pg160585 {
    fun solution(board: Array<String>): Int {

        var oCnt = 0
        var xCnt = 0

        for(i in board.indices){
            for(j in board[i].indices){
                if(board[i][j] == 'O'){
                    oCnt++
                }else if(board[i][j] == 'X'){
                    xCnt++
                }
            }
        }
        //1. X 개수 > O 개수
        if(xCnt > oCnt){
            return 0
        }

        //2. O 개수 > X 개수 + 1
        if(oCnt > xCnt + 1){
            return 0
        }

        //3. O가 승리한 후 X개수가 O개수보다 같거나 많을 때
        if(isWin('O',board) && xCnt >= oCnt){
            return 0
        }
        //4. X가 승리한 후 O개수가 X개수보다 많을 때
        if(isWin('X',board) && oCnt > xCnt){
            return 0
        }
        return 1

    }
    fun isWin(turn : Char, board : Array<String>) : Boolean{
        //가로
        for(i in 0 until 3){
            if(turn == board[i][0] && board[i][0] ==  board[i][1] && board[i][1] == board[i][2]){
                return true
            }
        }
        //세로
        for(i in 0 until 3){
            if(turn == board[0][i]&&board[0][i] == board[1][i] &&  board[1][i] == board[2][i]){
                return true
            }
        }

        //대각선 좌상우하
        if(turn == board[0][0] &&board[0][0] == board[1][1] &&  board[1][1] == board[2][2]){
            return true
        }
        //대각선 우상좌하
        if(turn == board[2][0] && board[2][0] == board[1][1]&&   board[1][1] == board[0][2]){
            return true
        }

        return false
    }
}