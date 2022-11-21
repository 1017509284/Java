package graph.LeetCode1091;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: zhaomeng
 * @Date: 2022/11/5 18:53
 */
class Solution {
    private int[][] dirs = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    private int R;
    private int C;
    private int[][] dis;
    private boolean[][] visited;

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null) return 0;
        R = grid.length;
        if (R == 0) return 0;

        C = grid[0].length;
        if (C == 0) return 0;

        dis = new int[R][C];
        visited = new boolean[R][C];

        if (grid[0][0] == 1)
            return -1;

        if (R == 1 && C == 1)
            return 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0][0] = true;
        dis[0][0] = 1;
        while (!q.isEmpty()) {
            int cur = q.remove();
            int curX = cur / C;
            int curY = cur % C;
            for (int d = 0; d < 8; d++) {
                int nextX = curX + dirs[d][0];
                int nextY = curY + dirs[d][1];
                if (inArea(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
                    q.add(nextX * C + nextY);
                    visited[nextX][nextY] = true;
                    dis[nextX][nextY] = dis[curX][curY] + 1;
                    if (nextX == R - 1 && nextY == C - 1) {
                        return dis[nextX][nextY];
                    }
                }
            }
        }
        return -1;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}