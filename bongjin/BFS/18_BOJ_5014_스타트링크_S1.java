import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 18_BOJ_5014_스타트링크_S1 {
    static int v[];
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        v = new int [input[0] + 1];
        System.out.println(bfs(input));
    }

    static String bfs(int []input){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(input[1]);
        v[input[1]] = 1;
        while(!queue.isEmpty()){
            int c = queue.poll();
            if(c == input[2]){
                return String.valueOf(v[c] - 1);
            }

            if(c + input[3] <= input[0] && v[c + input[3]] == 0){//press U
                v[c + input[3]] = v[c] + 1;
                queue.add(c + input[3]);
            }

            if(c - input[4] > 0 && v[c - input[4]] == 0) {//press D
                v[c - input[4]] = v[c] + 1;
                queue.add(c - input[4]);
            }
        }
        return "use the stairs";
    }

}