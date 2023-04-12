import java.io.*;
import java.util.*;

public class BOJ_9019_DSLR_BFS_G4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st ;
        int cnt = Integer.parseInt(br.readLine());

        for (int i  = 0 ; i < cnt ; i ++){
            st = new StringTokenizer(br.readLine()," ");
            String s = st.nextToken();
            String t = st.nextToken();
            sb.append(bfs(Integer.parseInt(s),Integer.parseInt(t))).append("\n");
        }

        System.out.println(sb);
    }

    static String bfs(int s, int t) {
        Queue<Integer> q = new LinkedList<>();
        String[] result = new String[100000];
        boolean[] visit = new boolean[100000];

        q.add(s);
        visit[s] = true;
        result[s] = "";

        while(!q.isEmpty()){

            int x = q.poll();
            if(x == t){
                break;
            }

            for (int i = 0 ; i < 4;i++){
                int nx = check(i,x);
                if(!visit[nx]){
                    visit[nx] = true;
                    q.add(nx);
                    result[nx] = result[x] + convert(i);
                }
            }

        }
        return result[t];
    }

    static int check(int way, int data){
        int result = 0;
        switch (way){
            case 0:
                result = (2 * data) % 10000;
                break;
            case 1:
                result = data == 0 ? 9999 : data - 1;
                break;
            case 2:
                int temp3 = (data / 1000);
                result = data % 1000 * 10 + temp3 ;
                break;
            case 3:
                int temp4 = data % 10;
                result = temp4 * 1000 + data / 10;
                break;
        }
        return result;
    }

    static String convert(int i){
        String result ="";
        switch (i){
            case 0:
                result = "D";
                break;
            case 1:
                result = "S";
                break;
            case 2:
                result = "L";
                break;
            case 3:
                result = "R";
                break;

        }
        return result;
    }


}