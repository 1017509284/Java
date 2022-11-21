package graph.LeetCode0785;

import java.util.Arrays;

/**
 * @author: zhaomeng
 * @Date: 2022/11/3 23:06
 */
class Solution {
    private boolean visited[];
    private int[] colors;
    private int[][] graph;

    public boolean isBipartite(int[][] graph) {
        this.graph = graph;
        // !the number of vertex
        int V = graph.length;

        visited = new boolean[V];
        colors = new int[V];

        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                if (!dfs(v, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    // !Start the dfs process from v, Check whether the connected component of v is a binary graph
    private boolean dfs(int v, int color) {
        visited[v] = true;
        colors[v] = color;

        for (int w : graph[v]) {
            if (!visited[w]) {
                if (!dfs(w, 1 - color)) {
                    return false;
                }
            }
            else if (colors[w] == colors[v]) {
                return false;
            }
        }
        return true;
    }
}
