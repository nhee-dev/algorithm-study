import java.util.*;

class Solution {
    boolean[] visited;    
    Map<String, Integer> menu;
    List<String> result;
    
    public String[] solution(String[] orders, int[] course) {
        int order_max = Integer.MIN_VALUE;
        result = new ArrayList();
        
        String[] copy_orders = new String[orders.length];
        for(int i = 0; i < orders.length; i++) {
            copy_orders[i] = sortString(orders[i]);
        }
                
        for(int i = 0; i < orders.length; i++) {
            int length = orders[i].length();
            if(order_max < length) {
                order_max = length;
            }
        }

        for(int i = 0; i < course.length; i++) {
            if(course[i] > order_max) {
                continue;
            }
            menu = new HashMap();
            for(int j = 0; j < orders.length; j++) {
                if(orders[j].length() < course[i]) {
                    continue;
                }                
                visited = new boolean[orders[j].length()];
                combi(copy_orders[j], 0, 0, copy_orders[j].length(), course[i]);
            }   
            
            int max = Integer.MIN_VALUE;
            List<String> list = new ArrayList<>();
            for(String key : menu.keySet()) {
                if(menu.get(key) < 2) {
                    continue;
                }
                if(menu.get(key) > max) {
                    max = menu.get(key);
                    list.clear();
                    list.add(key);
                    continue;
                }
                if(menu.get(key) == max) {
                    list.add(key);
                    continue;
                }
            }
            
            for(String s : list) {
                result.add(s);
            }           
        }    
        Collections.sort(result);
        String[]  answer = new String[result.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    public String sortString(String str) {
        char[] c = str.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
    
    public void combi(String order, int start, int depth, int n, int r) {
        if(depth == r) {   
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++) {
                if(visited[i]) {
                    sb.append(order.charAt(i));
                }
            }
            String single = sb.toString();
            menu.put(single, menu.getOrDefault(single, 0) + 1);
            return;
        }
        for(int i = start; i < n; i++) {
            visited[i] = true;
            combi(order, i + 1, depth + 1, n, r);
            visited[i] = false;
        }
    }
}

/*
A B C D E
F G H I J
K L M N O
P Q R S T
U V W X Y
Z
*/
