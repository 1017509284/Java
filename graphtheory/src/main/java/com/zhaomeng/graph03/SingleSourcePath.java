package com.zhaomeng.graph03;

import com.zhaomeng.graph01.Graph;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: zhaomeng
 * @Date: 2022/10/30 14:13
 */
// !图的深度优先遍历解决单源路径
public class  SingleSourcePath{
    private Graph G;
    private boolean[] visited;
    // !源顶点,表示从这个顶点出发
    private int s;
    // !pre数组，记录顶点的上一个顶点
    private int[] pre;

    public SingleSourcePath(Graph G, int s) {
        this.G = G;
        visited = new boolean[G.V()];
        pre = new int[G.V()];
        // !初始时将pre数组全部赋值为-1
        Arrays.fill(pre, -1);
        dfs(s, s);

    }

    private void dfs(int v, int parent) {
        // !将第一个顶点的visited数组置为true，表示已经遍历过这个节点了
        visited[v] = true;
        // !记录v节点的上一个节点为parent
        pre[v] = parent;
        // !然后开始遍历这个节点的相邻节点
        for (int w : G.adj(v)) {
            // !如果相邻节点没有被访问过的话
            if (!visited[w]) {
                // !继续对这个节点进行dfs操作
                dfs(w, v);
            }
        }
    }

    // !验证从s源节点出发，是否可以到达t节点
    public boolean isConnectedTo(int t) {
        G.validateVertex(t);
        // !只需要校验t这个节点有没有校验到即可
        return visited[t];
    }

    // !求源s到目标t顶点的一条路径
    public Iterable<Integer> path(int t) {
        List<Integer> res = new ArrayList<>();
        // !若s不能到达t，那么直接返回
        if (!isConnectedTo(t)) {
            return res;
        }
        // !定义当前顶点cur为t顶点，倒着推
        int cur = t;
        while (cur != s) {
            res.add(cur);
            // !让当前节点为自己的上一个节点，依次向上推
            cur = pre[cur];
        }
        // !将s加入res数组
        res.add(s);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new Graph("g.txt");
        SingleSourcePath singleSourcePath = new SingleSourcePath(graph, 0);

        System.out.println("0 -> 6 : " + singleSourcePath.path(6));
        System.out.println("0 -> 6 : " + singleSourcePath.path(5));
    }
}
