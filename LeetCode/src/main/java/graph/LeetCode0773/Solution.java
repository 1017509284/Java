package graph.LeetCode0773;

import java.util.*;

/**
 * @author: zhaomeng
 * @Date: 2022/11/6 00:05
 */
class Solution {
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int slidingPuzzle(int[][] board) {
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> visited = new HashMap<>();
        String initialState = boardToString(board);
        if ("123450".equals(initialState))
            return 0;

        // !BFS
        q.add(initialState);
        visited.put(initialState, 0);
        while (!q.isEmpty()) {
            String cur = q.remove();
            List<String> nexts = getNexts(cur);

            for (String next : nexts) {
                if (!visited.containsKey(next)) {
                    q.add(next);
                    visited.put(next, visited.get(cur) + 1);
                    if ("123450".equals(next)) {
                        return visited.get(next);
                    }
                }
            }
        }
        return -1;
    }

    private String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] ints : board) {
            for (int anInt : ints) {
                sb.append(anInt);
            }
        }
        return sb.toString();
    }

    private List<String> getNexts(String s) {
        int[][] cur = StringToBoard(s);
        int zero;
        for (zero = 0; zero < 6; zero++) {
            if (cur[zero / 3][zero % 3] == 0) {
                break;
            }
        }

        List<String> res = new ArrayList<>();

        int zx = zero / 3;
        int zy = zero % 3;
        for (int d = 0; d < 4; d++) {
            int nextX = zx + dirs[d][0];
            int nextY = zy + dirs[d][1];
            if (inArea(nextX, nextY)) {
                swap(cur, zx, zy, nextX, nextY);
                res.add(boardToString(cur));
                swap(cur, zx, zy, nextX, nextY);
            }
        }
        return res;
    }

    private void swap(int[][] board, int x1, int y1, int x2, int y2) {
        int t = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = t;
    }

    private int[][] StringToBoard(String s) {
        int[][] board = new int[2][3];
        for (int i = 0; i < 6; i++) {
            board[i / 3][i % 3] = s.charAt(i) - '0';
        }
        return board;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < 2 && y >= 0 && y < 3;
    }
}
