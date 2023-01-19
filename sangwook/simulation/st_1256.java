package src.main.kotlin.simulation;

import java.util.*;
import java.io.*;


public class st_1256 {
    static int H, K, R;
    static Node[] tree;
    static int ans = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int treeNum = ((int) Math.pow(2.0, H + 1));
        tree = new Node[treeNum];

        for (int i = 0; i < treeNum; i++) {
            LinkedList<Integer> left = new LinkedList<>();
            LinkedList<Integer> right = new LinkedList<>();
            LinkedList<Integer> cur = new LinkedList<>();
            tree[i] = new Node(left, right, cur);
        }
        
        int workerStartIdx = (int) Math.pow(2.0, H);
        int workerEndIdx = ((int) Math.pow(2.0, H + 1)) - 1;

        for (int i = workerStartIdx; i <= workerEndIdx; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                tree[i].cur.offer(Integer.parseInt(st.nextToken()));
            }

        }

        int lastIdx = ((int) Math.pow(2.0, H)) - 1;

        for (int t = 1; t <= R; t++) {
            if (t == 1) {
                goWork(workerStartIdx, workerEndIdx);
                continue;

            }

            if (t % 2 == 0) {
                if (!tree[1].right.isEmpty()) {
                    ans += tree[1].right.poll();
                }
            } else {
                if (!tree[1].left.isEmpty()) {
                    ans += tree[1].left.poll();
                }
            }


            for (int i = 2; i <= lastIdx; i++) {
                if (t % 2 == 0) {
                    if (!tree[i].right.isEmpty()) {
                        if (i % 2 == 0) {
                            tree[i / 2].left.offer(tree[i].right.poll());
                        } else {
                            tree[i / 2].right.offer(tree[i].right.poll());
                        }

                    }

                } else {
                    if (!tree[i].left.isEmpty()) {
                        if (i % 2 == 0) {
                            tree[i / 2].left.offer(tree[i].left.poll());
                        } else {
                            tree[i / 2].right.offer(tree[i].left.poll());
                        }

                    }

                }

            }

            if (!tree[workerStartIdx].cur.isEmpty()) {
                goWork(workerStartIdx, workerEndIdx);

            }

        }

        System.out.println(ans);

    }

    private static void goWork(int workerStartIdx, int workerEndIdx) {
        for (int i = workerStartIdx; i <= workerEndIdx; i++) {
            int work = tree[i].cur.poll();

            if (i % 2 == 0) {
                tree[i / 2].left.offer(work);
            } else {
                tree[i / 2].right.offer(work);
            }

        }
    }

    static class Node {
        LinkedList<Integer> left;
        LinkedList<Integer> right;
        LinkedList<Integer> cur;

        Node(LinkedList<Integer> left, LinkedList<Integer> right, LinkedList<Integer> cur) {
            this.left = left;
            this.right = right;
            this.cur = cur;
        }

    }
}
