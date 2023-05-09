package src.main.kotlin.dfs;

import java.util.*;

public class pg121685 {
    ArrayList[] list = new ArrayList[17];
    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        list[1].add("Rr");
        for(int i = 0; i < queries.length; i++){
            int[] query = queries[i];
            int n = query[0];
            int p = query[1];
            if(n == 1 &p == 1){
                answer[i] = "Rr";
                continue;
            }

            int q = query[1] % 4;

            if(q == 0){
                q = 4;
            }

            String res = findParent(n,p,q);
            answer[i] = res;
        }

        return answer;
    }

    private String findParent(int n, int p, int q){

        if(n == 1){
            if(q == 1){
                return "RR";
            }else if(q == 2){
                return "Rr";
            }else if(q == 3){
                return "Rr";
            }else if(q == 4){
                return "rr";
            }
        }
        int num = 0;
        int num2 = p % 4;
        if(num2 == 0){
            num2 = 4;
            num = p/4;
        }else{
            num = p/4 + 1;
        }


        String parent = findParent(n-1,num,num2);
        return getChild(parent,q);

    }

    private String getChild(String parent, int num2){
        String[] arr = new String[4];

        for(int i =0; i < 2; i++){
            char c = parent.charAt(i);
            for(int j = 0; j < 2; j++){
                char ch = parent.charAt(j);
                String res = ""+c+ch;
                if(res.equals("rR")){
                    res = "Rr";
                }
                arr[2*i + j] = res;
            }
        }
        return arr[num2-1];

    }
}
