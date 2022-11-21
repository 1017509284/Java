package graph.LeetCode0200;

/**
 * @author: zhaomeng
 * @Date: 2022/11/4 23:24
 */
// !calculate the connected component num in a graph
public class Solution {
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int R;
    private int C;
    private boolean[][] visited;
    private char[][] grid;

    public int numIslands(char[][] grid) {

        if (grid == null) return 0;
        R = grid.length;
        if (R == 0) return 0;

        C = grid[0].length;
        if (C == 0) return 0;

        this.grid = grid;
        visited = new boolean[R][C];

        int res = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(i, j);
                    res ++;
                }
            }
        }
        return res;
    }

    private void dfs(int x, int y) {
        visited[x][y] = true;
        for (int d = 0; d < 4; d++) {
            int nextX = x + dirs[d][0];
            int nextY = y + dirs[d][1];
            if (inArea(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == '1') {
                dfs(nextX, nextY);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
