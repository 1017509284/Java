package com.zhaomeng.graph03;

import com.zhaomeng.graph01.Graph;

import java.io.FileNotFoundException;


/**
 * @author: zhaomeng
 * @Date: 2022/10/30 14:13
 */
// !图的深度优先遍历，环检测算法
public class CycleDetection {
    private Graph G;
    private boolean[] visited;
    // !图中是否有环
    private boolean hasCycle;

    public CycleDetection(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        // !对于多个联通分量的图，仅仅从一个顶点开始dfs的话，那么遍历不到所有的顶点，需要for遍历每个节点
        // !如果这个顶点没有被访问到的话，那么就对这个顶点执行dfs操作
        for (int v = 0; v < G.V(); v++) {
            if (!visited[v]) {
                if (dfs(v, v)) {
                    hasCycle = true;
                    break;
                }
            }
        }

    }

    // !从顶点v开始，判断图中是否有环
    private boolean dfs(int v, int parent) {
        // !将第一个顶点的visited数组置为true，表示已经遍历过这个节点了
        visited[v] = true;
        // !然后开始遍历这个节点的相邻节点
        for (int w : G.adj(v)) {
            // !如果相邻节点没有被访问过的话
            if (!visited[w]) {
                // !继续对这个节点进行dfs操作,如果从w节点开始，发现有环了，那么返回true
                if (dfs(w, v)) {
                    return true;
                }
            } else if (w != parent) {
                // !当要遍历的w节点已经遍历过了，并且它不等于上一个节点（parent），那么就是有环
                // !如果等于上一个节点的话，那么就是一条线
                // ?         0
                // ?      /     \
                // ?   1           3
                // ?      \      /
                // ?         2
                // !如果从0开始遍历，先走到1，如果从1走到了0，那么不能说明图中有环，这只是一条线
                // !然后从1走到2，从2走到3，从3开始，遍历到了0，此时发现0已经被遍历过了，并且0并不是3的父节点，因为3的父节点是2
                // !那么此时说明图中有环
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new Graph("g.txt");
        CycleDetection cycleDetection = new CycleDetection(graph);

        System.out.println(cycleDetection.hasCycle());

        Graph graph2 = new Graph("g2.txt");
        CycleDetection cycleDetection2 = new CycleDetection(graph2);

        System.out.println(cycleDetection2.hasCycle());
    }
}
