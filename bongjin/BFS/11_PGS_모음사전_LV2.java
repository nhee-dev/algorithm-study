import java.util.*;

class Solution {

    static char[] arr = {'A','E','I','O','U'};
    static List<String> list;

    public static int solution(String word){
        int answer = 0;
        list = new ArrayList<>();
        int index = 1;

        for(int i = 1; i<=5;i++){
            dfs(i, 0, "");
        }
        Collections.sort(list);

        for(String tmp : list){
            if(tmp.equals(word)){
                answer = index;
                break;
            }
            index++;
        }
        return answer;
    }

    public static void dfs(int len, int depth, String tmp){
        if(depth == len){
            list.add(tmp);
            return;
        }
        for(int i = 0; i < 5; i++){
            dfs(len, depth + 1, tmp + arr[i]);
        }
    }
}