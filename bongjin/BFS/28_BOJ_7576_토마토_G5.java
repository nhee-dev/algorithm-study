import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class 28_BOJ_7576_토마토_G5 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        Queue<node> q = new LinkedList<node>();
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0) cnt++;
                else if(arr[i][j] == 1) q.add(new node(i,j));
            }
        }
        if(cnt == 0) {
            System.out.println("0");
            System.exit(0);
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int res = 1;
        while(!q.isEmpty()) {
            int qn = q.size();
            for(int qq = 0; qq < qn; qq++) {
                int x = q.peek().x;
                int y = q.peek().y;
                q.poll();
                for(int i=0;i<4;i++) {
                    int nowx = x+dx[i], nowy = y+dy[i];
                    if(0>nowx||0>nowy||n<=nowx||m<=nowy) continue;
                    if(arr[nowx][nowy]==0) {
                        arr[nowx][nowy] = 1;
                        cnt--;
                        q.add(new node(nowx,nowy));
                    }
                }
            }
            if(cnt == 0) {
                System.out.println(res);
                System.exit(0);
            }
            res++;
        }
        System.out.println("-1");

    }
}
class node{
    int x,y;
    public node(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
}