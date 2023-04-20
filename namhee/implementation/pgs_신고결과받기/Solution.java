import java.util.StringTokenizer;

class Solution {
    int userNum;
    boolean[][] isChecked;
    boolean[] isStopped;
    
    public int[] solution(String[] id_list, String[] report, int k) {
        userNum = id_list.length;
        check(id_list, report);
        stopUser(k);
        
        int[] answer = getAnswer();        
        return answer;
    }
    
    int[] getAnswer() {
        int count;
        int[] answer = new int[userNum];
        for (int user = 0; user < userNum; user++) {
            count = 0;
            for (int checkUser = 0; checkUser < userNum; checkUser++) {
                if (isChecked[user][checkUser] && isStopped[checkUser]) {
                    count++;
                }
            }
            answer[user] = count;
        }
        return answer;
    }
    
    void stopUser(int k) {
        int[] count = new int[userNum];
        for (int j = 0; j < userNum; j++) {
            for (int i = 0; i < userNum; i++) {
                if (isChecked[i][j]) {
                    count[j]++;
                }
            }
        }
        
        isStopped = new boolean[userNum];
        for (int i = 0; i < userNum; i++) {
            if (count[i] >= k) {
                isStopped[i] = true;
            }
        }
    }
    
    void check(String[] id_list, String[] report) {
        isChecked = new boolean[id_list.length][id_list.length];
        for (int n = 0; n < report.length; n++) {
            StringTokenizer st = new StringTokenizer(report[n]);
            int userId = getIdIndex(st.nextToken(), id_list);
            int checkId = getIdIndex(st.nextToken(), id_list);

            isChecked[userId][checkId] = true;
        }
    }
    
    int getIdIndex(String id, String[] id_list) {
        int index = -1;
        for (int i = 0; i < id_list.length; i++) {
            if (id.equals(id_list[i])) {
                index = i;
                break;
            }
        }        
        return index;
    }
}
