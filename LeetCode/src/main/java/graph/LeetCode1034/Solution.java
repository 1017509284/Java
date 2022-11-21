package graph.LeetCode1034;

import java.util.Arrays;

/**
 * @author: zhaomeng
 * @Date: 2022/11/5 17:45
 */
class Solution {
    private int R;
    private int C;
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private boolean[][] visited;
    private int base;
    private int[][] pre;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        if (grid == null) return null;

        R = grid.length;
        if (R == 0) return null;

        C = grid[0].length;
        if (C == 0) return null;

        visited = new boolean[R][C];
        pre = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(pre[i], -1);
        }

        base = grid[row][col];

        dfs(grid, row, col, color);

        return grid;
    }

    private void dfs(int[][] grid, int row, int col, int color) {
        visited[row][col] = true;

        if (isBorder(grid, row, col)) {
            pre[row][col] = grid[row][col];
            grid[row][col] = color;
        }

        for (int d = 0; d < 4; d++) {
            int nextX = row + dirs[d][0];
            int nextY = col + dirs[d][1];
            if (inArea(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == base) {
                dfs(grid, nextX, nextY, color);
            }
        }

    }

    private boolean isBorder(int[][] grid, int row, int col) {
        for (int d = 0; d < 4; d++) {
            int nextX = row + dirs[d][0];
            int nextY = col + dirs[d][1];
            if (!inArea(nextX, nextY))
                return true;
            if (pre[nextX][nextY] == -1) {
                if (grid[row][col] != grid[nextX][nextY]) {
                    return true;
                }
            }
            else if (pre[nextX][nextY] != -1) {
                if (grid[row][col] != pre[nextX][nextY]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
