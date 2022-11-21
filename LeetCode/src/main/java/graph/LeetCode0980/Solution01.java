package graph.LeetCode0980;

/**
 * @author: zhaomeng
 * @Date: 2022/11/6 20:16
 */
class Solution01 {

    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int[][] grid;
    private int R;
    private int C;
    // !record the start position
    private int start;
    // !record the end position
    private int end;

    public int uniquePathsIII(int[][] grid) {
        if (grid == null)
            return 0;

        R = grid.length;
        if (R == 0)
            return 0;

        C = grid[0].length;
        if (C == 0)
            return 0;

        this.grid = grid;
        // !the left numbers of vertex we need to iterate over
        int left = R * C;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    start = i * C + j;
                    // !The starting point is also a passable point
                    grid[i][j] = 0;
                } else if (grid[i][j] == 2) {
                    end = i * C + j;
                    // !The ending point is also a passable point
                    grid[i][j] = 0;
                } else if (grid[i][j] == -1) {
                    left--;
                }
            }
        }

        int visited = 0;
        return dfs(visited, start, left);
    }

    private int dfs(int visited, int v, int left) {
        // !One dimensional coordinates to two dimensional coordinates
        int x = v / C;
        int y = v % C;
        visited += (1 << v);
        left --;

        // !find out a passable path
        if (left == 0 && v == end) {
            // !set the value of visited[x][y] false to make sure the vertex (x, y) will be iterated over in the back invoke
            visited -= (1 << v);
            return 1;
        }

        int res = 0;
        for (int d = 0; d < 4; d++) {
            int nextX = x + dirs[d][0];
            int nextY = y + dirs[d][1];
            if (inArea(nextX, nextY) && ((visited & (1 << (nextX * C + nextY))) == 0) && grid[nextX][nextY] == 0) {
                res += dfs(visited, nextX * C + nextY, left);
            }
        }
        visited -= (1 << v);
        return res;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
