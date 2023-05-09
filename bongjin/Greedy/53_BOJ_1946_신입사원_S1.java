import java.util.*;

public class BOJ_1946_신입사원_S1 {
    static List<Grade> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 0; t < T; t++) {
            int N = sc.nextInt();
            list = new ArrayList<Grade>();

            for(int i = 0; i < N; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                list.add(new Grade(a, b));
            }

            list.sort(Grade::compareTo);

            int result = 1;
            int min = list.get(0).b;
            for(int i = 1; i < N; i++) {
                if(list.get(i).b < min) {
                    result++;
                    min = list.get(i).b;
                }
            }
            System.out.println(result);
        }
    }
    static class Grade implements Comparable<Grade> {
        int a;
        int b;
        Grade(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Grade o) {
            return this.a - o.a;
        }
    }
}