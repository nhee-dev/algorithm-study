package boj;
import java.util.*;

public class BOJ_1931_회의실배정_S1 {
    static List<Time> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        list = new ArrayList<Time>();

        for(int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Time(s, e));
        }

        list.sort(Time::compareTo);

        int result = 1;
        int end = list.get(0).end;
        for(int i = 0; i < list.size() - 1; i++) {
            int ns = list.get(i + 1).start;
            if(ns < end) {
                continue;
            }else {
                end = list.get(i + 1).end;
                result++;
            }
        }
        System.out.println(result);
    }

    static class Time implements Comparable<Time>{
        int start;
        int end;
        public Time(int start, int end) {
            super();
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if(o.end == this.end)
                return this.start - o.start;
            return this.end - o.end;
        }

        @Override
        public String toString() {
            return "Time [start=" + start + ", end=" + end + "]";
        }


    }
}


