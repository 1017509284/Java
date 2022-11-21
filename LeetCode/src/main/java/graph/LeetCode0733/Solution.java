package graph.LeetCode0733;

/**
 * @author: zhaomeng
 * @Date: 2022/11/5 17:22
 */
class Solution {
    private int R;
    private int C;
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private boolean[][] visited;
    private int base;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if (image == null) return null;
        R = image.length;
        if (R == 0) return null;

        C = image[0].length;
        if (C == 0) return null;

        visited = new boolean[R][C];
        base = image[sr][sc];

        dfs(image, sr, sc, color);

        return image;
    }

    private void dfs(int[][] image, int x, int y, int color) {
        visited[x][y] = true;
        image[x][y] = color;

        for (int d = 0; d < 4; d++) {
            int nextX = x + dirs[d][0];
            int nextY = y + dirs[d][1];
            if (inArea(nextX, nextY) && !visited[nextX][nextY] && image[nextX][nextY] == base && image[nextX][nextY] != color) {
                dfs(image, nextX, nextY, color);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
