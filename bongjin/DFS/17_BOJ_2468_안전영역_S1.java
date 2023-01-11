import java.util.*;

public class 17_BOJ_2468_안전영역_S1{
    
    static int[][] arr;
    static int n;
    static boolean[][] v;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int count;
    static ArrayList<Integer> list;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arr = new int[100][100];
        v = new boolean[100][100];
        int max = -1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = scan.nextInt();
                max = Math.max(max, arr[i][j]);
            }
        }
        list = new ArrayList<>();
        list.add(1);
        for(int k = 1; k < max; k++) {
            count = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(v[i][j] == false && arr[i][j] > k) {
                        dfs(i,j,k);
                        count++;
                    }
                }
            }
            list.add(count);
            v = new boolean[n][n];
        }
        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
    }

    static void dfs(int a, int b, int x) {
        v[a][b] = true;
        int nx,ny;
        for(int i = 0; i < 4; i++) {
            nx = a + dx[i];
            ny = b + dy[i];
            if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if(arr[nx][ny] > x && v[nx][ny] == false) {
                    dfs(nx,ny,x);
                }
            }
        }
    }
}