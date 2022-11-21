package com.zhaomeng.graph03;

import com.zhaomeng.graph01.Graph;

import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * @author: zhaomeng
 * @Date: 2022/10/30 14:13
 */
// !二分图的检测
public class BiPartitionDetection {
    private Graph G;
    private boolean[] visited;
    // !染色数组
    private int[] colors;
    // !图G是否是二分图
    private boolean isBipartite = true;

    public BiPartitionDetection(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        colors = new int[G.V()];
        Arrays.fill(colors, -1);
        // !对于多个联通分量的图，仅仅从一个顶点开始dfs的话，那么遍历不到所有的顶点，需要for遍历每个节点
        // !如果这个顶点没有被访问到的话，那么就对这个顶点执行dfs操作
        for (int i = 0; i < G.V(); i++) {
            if (!visited[i]) {
                if (!dfs(i, 0)) {
                    isBipartite = false;
                    // !如果某个联通分量不满足二分图的话，那么整个图都不是二分图
                    break;
                }
            }
        }
    }

    // !从顶点v出发，检测当前的连通分量是否是二分图
    private boolean dfs(int v, int color) {
        // !将第一个顶点的visited数组置为true，表示已经遍历过这个节点了
        visited[v] = true;
        colors[v] = color;
        // !然后开始遍历这个节点的相邻节点
        for (int w : G.adj(v)) {
            // !如果相邻节点没有被访问过的话
            if (!visited[w]) {
                // !继续对这个节点进行dfs操作
                if (!dfs(w, 1 - color)) {
                    return false;
                }
            }
            // !如果发现了当前的节点已经访问过了，那么判断当前节点和上一个节点的颜色是不是相等即可，相等的话，就不是二分图
            else if (colors[w] == colors[v]) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite() {
        return isBipartite;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new Graph("g.txt");
        BiPartitionDetection biPartitionDetection = new BiPartitionDetection(graph);
        System.out.println(biPartitionDetection.isBipartite());
    }
}
