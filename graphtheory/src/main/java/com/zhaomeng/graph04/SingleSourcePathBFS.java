package com.zhaomeng.graph04;

import com.zhaomeng.graph01.Graph;


import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author: zhaomeng
 * @Date: 2022/11/1 23:49
 */
// !广度优先遍历
// !单源路径BFS（最短路径）
public class SingleSourcePathBFS {

    private Graph G;
    private boolean[] visited;
    // !用户传来的源点s
    private int s;
    private List<Integer> order = new ArrayList<>();
    // !源点s到目标点t的距离
    private int[] dis;
    // !pre数组。记录每个顶点是从哪个顶点来的
    private int[] pre;


    public SingleSourcePathBFS(Graph G, int s) {
        this.G = G;
        this.s = s;
        visited = new boolean[G.V()];
        pre = new int[G.V()];
        dis = new int[G.V()];
        Arrays.fill(pre, -1);
        Arrays.fill(dis, -1);

        bfs(s);

        for (int dis : dis) {
            System.out.print(dis + " ");
        }
        System.out.println();
    }

    void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        // !初始时记录s的来源是s
        pre[s] = s;
        // !从源点s到源点s的距离为0
        dis[s] = 0;
        visited[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            order.add(v);
            for (int w : G.adj(v)) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                    // !每入队一个节点，都记录下它的上一个节点
                    pre[w] = v;
                    dis[w] = dis[v] + 1;
                }
            }
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    // !判断从源点是否能直接到达t
    public boolean isConnectedTo(int t) {
        G.validateVertex(t);
        return visited[t];
    }

    public Iterable<Integer> path(int t) {
        List<Integer> res = new ArrayList<>();
        if (!isConnectedTo(t)) {
            return res;
        }

        int cur = t;
        while (cur != s) {
            res.add(cur);
            cur = pre[cur];
        }
        res.add(s);
        Collections.reverse(res);

        return res;
    }

    // !求出源点s到t的距离，不关注路径是什么
    public int dis(int t) {
        G.validateVertex(t);
        return dis[t];
    }

    public static void main(String[] args) throws FileNotFoundException {
        Graph g = new Graph("g.txt");
        SingleSourcePathBFS singleSourcePathBFS = new SingleSourcePathBFS(g, 0);

        System.out.println(singleSourcePathBFS.path(6));

        System.out.println(singleSourcePathBFS.dis(6));
    }
}
