package com.zhaomeng.graph04;

import com.zhaomeng.graph01.Graph;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: zhaomeng
 * @Date: 2022/11/1 23:49
 */
// !广度优先遍历
// !时间复杂度：O(V+E)
public class GraphBFS {

    private Graph G;
    private boolean[] visited;
    private List<Integer> order = new ArrayList<>();


    public GraphBFS(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!visited[v]) {
                bfs(v);
            }
        }
    }

    void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            order.add(v);
            for (int w = 0; w < G.V(); w++) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                }
            }
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Graph g = new Graph("g.txt");
        GraphBFS graphBFS = new GraphBFS(g);
        System.out.println(graphBFS.order());
    }
}
