package graph.LeetCode0695;

/**
 * @author: zhaomeng
 * @Date: 2022/11/4 22:49
 */
// !No need to create a graph
public class Solution2 {
    int dirs[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int[][] grid;
    private boolean[][] visited;
    int R;
    int C;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) return 0;
        R = grid.length;
        if (R == 0) return 0;

        C = grid[0].length;
        if (C == 0) return 0;

        this.grid = grid;
        visited = new boolean[R][C];

        int res = 0;

        // !Iterate over the two-dimensional array
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // !if current vertex has not been Iterated, and its land, Executing the dfs procedure
                if (!visited[i][j] && grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j));
                }
            }
        }
        return res;
    }

    // !The number of vertices of the connected component in which the current vertex is located is calculated
    private int dfs(int x, int y) {
        visited[x][y] = true;
        int res = 1;
        // !iterated over the 4 dir vertex, judge which vertex is land
        for (int d = 0; d < 4; d++) {
            int nextX = x + dirs[d][0];
            int nextY = y + dirs[d][1];
            // !If the vertex in some direction is land, and has noe been visited, continue execut the dfs procedure
            if (inArea(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                res += dfs(nextX, nextY);
            }
        }
        return res;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
