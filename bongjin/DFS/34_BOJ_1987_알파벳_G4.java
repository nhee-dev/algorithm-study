public class 34_BOJ_1987_알파벳_G4 {
    static String[][] arr;
    static boolean[][] v;
    static int R, C;
    static int ans = 0;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        arr = new String[R][C];
        v = new boolean[R][C];

        sc.nextLine();

        for(int i = 0; i < R; i++) {
            String temp = sc.nextLine();

            for(int j = 0; j < C; j++) {
                arr[i][j] = temp.charAt(j) + "";
            }
        }
        v[0][0] = true;
        dfs(0, 0, arr[0][0], 1);

        System.out.println(ans);
    }

    public static void dfs(int x, int y, String str, int length) {
        if(ans < length) {
            ans = length;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= R || ny >= C || v[nx][ny])
                continue;

            if(!str.contains(String.valueOf(arr[nx][ny]))) {
                v[nx][ny] = true;
                dfs(nx, ny, str+arr[nx][ny], length+1);
                v[nx][ny] = false;
            }
        }
    }

}