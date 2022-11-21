package com.zhaomeng.graph03;

import com.zhaomeng.graph01.Graph;

import java.io.FileNotFoundException;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: zhaomeng
 * @Date: 2022/10/30 14:13
 */
// !图的深度优先遍历
public class Path{
    private Graph G;
    private boolean[] visited;
    // !源顶点,表示从这个顶点出发
    private int s;
    // !目标顶点
    private int t;
    // !pre数组，记录顶点的上一个顶点
    private int[] pre;

    public Path(Graph G, int s, int t) {
        G.validateVertex(s);
        G.validateVertex(t);
        this.G = G;
        this.s = s;
        this.t = t;
        visited = new boolean[G.V()];
        pre = new int[G.V()];
        // !初始时将pre数组全部赋值为-1
        Arrays.fill(pre, -1);
        dfs(s, s);
        for (boolean b : visited) {
            System.out.print(b + " ");
        }
        System.out.println();
    }

    private boolean dfs(int v, int parent) {
        // !将第一个顶点的visited数组置为true，表示已经遍历过这个节点了
        visited[v] = true;
        // !记录v节点的上一个节点为parent
        pre[v] = parent;
        if (v == t) {
            return true;
        }
        // !然后开始遍历这个节点的相邻节点
        for (int w : G.adj(v)) {
            // !如果相邻节点没有被访问过的话
            if (!visited[w]) {
                // !继续对这个节点进行dfs操作
                if (dfs(w, v)) {
                    return true;
                }
            }
        }
        return false;
    }

    // !验证从s源节点出发，是否可以到达t节点
    public boolean isConnected() {
        // !只需要校验t这个节点有没有校验到即可
        return visited[t];
    }

    // !求源s到目标t顶点的一条路径
    public Iterable<Integer> path() {
        List<Integer> res = new ArrayList<>();
        // !若s不能到达t，那么直接返回
        if (!isConnected()) {
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
        Path path = new Path(graph, 0, 6);
        System.out.println(path.path());

        Path path2 = new Path(graph, 0, 1);
        System.out.println(path2.path());

        Path path3 = new Path(graph, 0, 5);
        System.out.println(path3.path());
    }
}
