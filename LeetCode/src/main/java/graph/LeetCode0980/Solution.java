package graph.LeetCode0980;

/**
 * @author: zhaomeng
 * @Date: 2022/11/6 20:16
 */
class Solution {

    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int[][] grid;
    private int R;
    private int C;
    // !visited array actually can be compress whit a decimal number, imagine its binary form
    // !Whether the ith bit is 1 ? visited & (1 << i) == 0 ?
    // !set the ith bit as 1, visited + (1 << i)
    // !set the ith bit as 0, visited - (1 << i)
    private boolean[][] visited;
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

        visited = new boolean[R][C];
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

        return dfs(start, left);
    }

    private int dfs(int v, int left) {
        // !One dimensional coordinates to two dimensional coordinates
        int x = v / C;
        int y = v % C;
        visited[x][y] = true;
        left --;

        // !find out a passable path
        if (left == 0 && v == end) {
            // !set the value of visited[x][y] false to make sure the vertex (x, y) will be iterated over in the back invoke
            visited[x][y] = false;
            return 1;
        }

        int res = 0;
        for (int d = 0; d < 4; d++) {
            int nextX = x + dirs[d][0];
            int nextY = y + dirs[d][1];
            if (inArea(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
                res += dfs(nextX * C + nextY, left);
            }
        }
        visited[x][y] = false;
        return res;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
