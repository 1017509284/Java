package graph.LeetCode1020;

/**
 * @author: zhaomeng
 * @Date: 2022/11/4 23:49
 */
class Solution {
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int R;
    private int C;
    private boolean[][] visited;
    private int[][] grid;
    public int numEnclaves(int[][] grid) {

        if (grid == null) return 0;
        R = grid.length;
        if (R == 0) return 0;

        C = grid[0].length;
        if (C == 0) return 0;

        this.grid = grid;
        visited = new boolean[R][C];



        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && grid[i][j] == 1 && !notBoundary(i, j)) {
                    dfs2(i, j);
                }
            }
        }

        int res = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && grid[i][j] == 1 && notBoundary(i, j)) {
                    res += dfs(i, j);
                }
            }
        }

        return res;
    }

    private int dfs(int x, int y) {
        visited[x][y] = true;
        int res = 1;
        for (int d = 0; d < 4; d++) {
            int nextX = x + dirs[d][0];
            int nextY = y + dirs[d][1];
            if (inArea(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == 1 && notBoundary(nextX, nextY)) {
                res += dfs(nextX, nextY);
            }
        }
        return res;
    }

    // !fill the connected component of vertex(x, y) with 0
    private void dfs2(int x, int y) {
        visited[x][y] = true;
        grid[x][y] = 0;
        for (int d = 0; d < 4; d++) {
            int nextX = x + dirs[d][0];
            int nextY = y + dirs[d][1];
            if (inArea(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                dfs2(nextX, nextY);
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
