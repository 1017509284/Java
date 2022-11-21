package graph.LeetCode0695;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: zhaomeng
 * @Date: 2022/11/3 23:45
 */
class Solution {
    // !dirs Clockwise from the top
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    // !the row and column of the area
    private int R, C;
    private int[][] grid;
    // !Graph
    private HashSet<Integer>[] G;

    private boolean visited[];

    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null) return 0;

        R = grid.length;
        if (R == 0) return 0;

        C = grid[0].length;
        if (C == 0) return 0;

        this.grid = grid;

        G = constructGraph();
        visited = new boolean[G.length];

        int res = 0;
        for (int v = 0; v < G.length; v++) {
            int x = v / C;
            int y = v % C;
            if (!visited[v] && grid[x][y] == 1) {
                res = Math.max(res, dfs(v));
            }
        }
        return res;
    }

    // !Returns the total number of vertices from the current connected component
    private int dfs(int v) {
        visited[v] = true;
        int res = 1;
        for (int w : G[v]) {
            if (!visited[w]) {
                res += dfs(w);
            }
        }
        return res;
    }

    private HashSet<Integer>[] constructGraph() {
        HashSet<Integer>[] g = new HashSet[R * C];
        for (int i = 0; i < g.length; i++) {
            g[i] = new HashSet<>();
        }

        // !Iterate over all vertex
        for (int v = 0; v < g.length; v++) {
            int x = v / C;
            int y = v % C;

            if (grid[x][y] == 1) {
                // !Explore in four directions: up, down, left and right
                for (int d = 0; d < 4; d++) {
                    int nextX = x + dirs[d][0];
                    int nextY = y + dirs[d][1];
                    if (inArea(nextX, nextY) && grid[nextX][nextY] == 1) {
                        int next = nextX * C + nextY;
                        g[v].add(next);
                        g[next].add(v);
                    }
                }
            }
        }



        return g;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static void main(String[] args) {
        int[][] grid = new int[8][13];
        grid[0] = new int[] {0,0,1,0,0,0,0,1,0,0,0,0,0};
        grid[1] = new int[] {0,0,0,0,0,0,0,1,1,1,0,0,0};
        grid[2] = new int[] {0,1,1,0,1,0,0,0,0,0,0,0,0};
        grid[3] = new int[] {0,1,0,0,1,1,0,0,1,0,1,0,0};
        grid[4] = new int[] {0,1,0,0,1,1,0,0,1,1,1,0,0};
        grid[5] = new int[] {0,0,0,0,0,0,0,0,0,0,1,0,0};
        grid[6] = new int[] {0,0,0,0,0,0,0,1,1,1,0,0,0};
        grid[7] = new int[] {0,0,0,0,0,0,0,1,1,0,0,0,0};

        Solution solution = new Solution();

        System.out.println(solution.maxAreaOfIsland(grid));
    }
}
