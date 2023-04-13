import java.io.*;
import java.util.*;

public class BOJ_13335_트럭_S1 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());

        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> truckQ = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            truckQ.offer(Integer.parseInt(st.nextToken()));
        }
        in.close();
        for (int i = 0; i < w; i++) {
            bridge.offer(0);
        }

        int result = 0, currentL = 0, tr;
        while (!bridge.isEmpty()) {
            while (!truckQ.isEmpty()) {
                tr = truckQ.peek();
                currentL += tr - bridge.poll();
                if (currentL > limit) {
                    bridge.offer(0);
                    currentL -= tr;
                } else {
                    bridge.offer(tr);
                    truckQ.poll();
                }
                result++;
            }
            result++;
            bridge.poll();
        }
        System.out.println(result);
    }
}