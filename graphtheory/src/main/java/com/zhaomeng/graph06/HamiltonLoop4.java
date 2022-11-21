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
public class HamiltonLoop4 {
    private Graph G;
    private int[] pre;
    // !记录回到源点前的最后一个顶点
    private int end;

    public HamiltonLoop4(Graph G) {
        this.G = G;
        pre = new int[G.V()];
        // !初始化为-1
        end = -1;
        int visited = 0;

        // !left表示当前还有多少剩余的顶点没有遍历
        dfs(visited, 0, 0, G.V());

    }

    // !表示在visited所表示的这个状态下，从v顶点开始，遍历left个个数的点，看是否有哈密尔顿路径
    private boolean dfs(int visited, int v, int parent, int left) {

        // !相当于visited[v] = true;
        visited += (1 << v);
        pre[v] = parent;
        left --;
        if (left == 0 && G.hasEdge(v, 0)) {
            end = v;
            return true;
        }
        for (int w : G.adj(v)) {
            // !等价于!visited[w]
            if ((visited & (1 << w)) == 0) {
                if (dfs(visited, w, v, left)) return true;
            }
        }
        // !如果以顶点v进行dfs，查找结果是没有存在的一条回路是哈密尔顿路径的话，那么就将v置为false，表示这个节点没有访问过，然后回溯进行其他节点
        visited -= (1 << v);
        return false;
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

