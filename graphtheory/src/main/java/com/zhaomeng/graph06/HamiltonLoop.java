package com.zhaomeng.graph06;

import com.zhaomeng.graph01.Graph;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: zhaomeng
 * @Date: 2022/11/6 18:28
 */
// !哈密尔顿回路
public class HamiltonLoop {
    private Graph G;
    private boolean[] visited;
    private int[] pre;
    // !记录回到源点前的最后一个顶点
    private int end;

    public HamiltonLoop(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        pre = new int[G.V()];
        // !初始化为-1
        end = -1;

        dfs(0, 0);

    }

    private boolean dfs(int v, int parent) {

        visited[v] = true;
        pre[v] = parent;
        for (int w : G.adj(v)) {
            if (!visited[w]) {
                if (dfs(w, v)) return true;
            } else if (w == 0 && allVisited()) {      // !如果w为0并且剩下的所有节点都被访问到了，那么表示找到了一条回路
                end = v;
                return true;
            }
        }
        // !如果以顶点v进行dfs，查找结果是没有存在的一条回路是哈密尔顿路径的话，那么就将v置为false，表示这个节点没有访问过，然后回溯进行其他节点
        visited[v] = false;
        return false;
    }

    private boolean allVisited() {
        for (int i = 0; i < G.V(); i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }


    public List<Integer> result() {
        List<Integer> res = new ArrayList<>();
        if (end == -1)
            return res;

        int cur = end;
        while (cur != 0) {
            res.add(cur);
            cur = pre[cur];
        }
        res.add(0);
        Collections.reverse(res);
        return res;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new Graph("hamilton.txt");
        HamiltonLoop hamiltonLoop = new HamiltonLoop(graph);
        System.out.println(hamiltonLoop.result());
    }
}

