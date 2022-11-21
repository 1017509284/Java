package graph.LeetCode0130;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zhaomeng
 * @Date: 2022/11/5 16:37
 */
class Solution {
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int R;
    private int C;
    private boolean[][] visited;

    private List<Pair<Integer, Integer>> record;

    public void solve(char[][] board) {
        if (board == null) return;

        R = board.length;
        if (R == 0) return;

        C = board[0].length;
        if (C == 0) return;

        visited = new boolean[R][C];
        record = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && !notBoundary(i, j) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < R; i++) {
            Arrays.fill(visited[i], false);
        }


        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    dfs2(board, i, j);
                }
            }
        }

        for (Pair<Integer, Integer> pair : record) {
            board[pair.getKey()][pair.getValue()] = 'O';
        }

    }

    private void dfs(char[][] board, int x, int y) {
        visited[x][y] = true;
        board[x][y] = 'X';
        record.add(new Pair<>(x, y));

        for (int d = 0; d < 4; d++) {
            int nextX = x + dirs[d][0];
            int nextY = y + dirs[d][1];
            if (inArea(nextX, nextY) && !visited[nextX][nextY] && board[nextX][nextY] == 'O') {
                dfs(board, nextX, nextY);
            }
        }
    }

    private void dfs2(char[][] board, int x, int y) {
        visited[x][y] = true;
        board[x][y] = 'X';
        for (int d = 0; d < 4; d++) {
            int nextX = x + dirs[d][0];
            int nextY = y + dirs[d][1];
            if (inArea(nextX, nextY) && !visited[nextX][nextY] && board[nextX][nextY] == 'O') {
                dfs2(board, nextX, nextY);
            }
        }
    }

    private boolean notBoundary(int x, int y) {
        return x != 0 && x != R - 1 && y != 0 && y != C - 1;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
