package graph.IQ;

/**
 * @author: zhaomeng
 * @Date: 2022/11/5 22:58
 */
// ! one bucket's volume is 5L
// ! one bucket's volume is 3L
// ! how to get water that its volume is 4L

import java.util.*;

/**
 *
 *            (5, y) or (x, 3)
 *          /
 * (x, y)   -  (0, y) or (x, 0)                      ......           --->>>         target : (4, ?) or (?, 4)
 *         \
 *            Pour the water from x into y
 *         \
 *            Pour the water from y into x
 */

// !use a num like 53 to show 1st bucket is 5L water, and 2nd bucket is 3L water
public class WaterPuzzle {
    private List<Integer> end;
    private int[] pre;
    public WaterPuzzle() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[100];
        pre = new int[100];
        end = new ArrayList<>();

        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int cur = q.remove();
            int a = cur / 10;
            int b = cur % 10;
            // !max a = 5, max b = 3
            List<Integer> nexts = new ArrayList<>();
            // !find all possibility
            nexts.add(5 * 10 + b);
            nexts.add(a * 10 + 3);
            nexts.add(0 * 10 + b);
            nexts.add(a * 10 + 0);

            int x = Math.min(a, 3 - b);
            nexts.add((a - x) * 10 + (b + x));
            int y = Math.min(5 - a, b);
            nexts.add((a + y) * 10 + (b - y));
            for (Integer next : nexts) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    pre[next] = cur;
                    if (next / 10 == 4 || next % 10 == 4) {
                        end.add(next);
                    }
                }
            }
        }
    }
    public Iterable<List<Integer>> result() {
        if (end.size() == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> path = new ArrayList<>();


        for (int i = 0; i < end.size(); i++) {
            List<Integer> spath = new ArrayList<>();
            int cur = end.get(i);
            while (cur != 0) {
                spath.add(cur);
                cur = pre[cur];
            }
            spath.add(53);
            Collections.reverse(spath);
            path.add(spath);
        }


        return path;
    }

    public static void main(String[] args) {
        for (List<Integer> integers : new WaterPuzzle().result()) {
            System.out.println(integers);
        }
    }
}
