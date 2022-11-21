package com.zhaomeng.graph02;

import com.zhaomeng.graph01.Graph;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhaomeng
 * @Date: 2022/10/30 14:13
 */
// !图的深度优先遍历
public class GraphDFS {
    private Graph G;
    private boolean[] visited;
    // !先序遍历的结果集合
    private List<Integer> pre = new ArrayList<>();
    // !后序遍历的结果集合
    private List<Integer> post = new ArrayList<>();

    public GraphDFS(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        // !对于多个联通分量的图，仅仅从一个顶点开始dfs的话，那么遍历不到所有的顶点，需要for遍历每个节点
        // !如果这个顶点没有被访问到的话，那么就对这个顶点执行dfs操作
        for (int i = 0; i < G.V(); i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

    }

    private void dfs(int v) {
        // !将第一个顶点的visited数组置为true，表示已经遍历过这个节点了
        visited[v] = true;
        // !将第一个顶点加入pre中
        pre.add(v);
        // !然后开始遍历这个节点的相邻节点
        for (int w : G.adj(v)) {
            // !如果相邻节点没有被访问过的话
            if (!visited[w]) {
                // !继续对这个节点进行dfs操作
                dfs(w);
            }
        }
        // !后序遍历的结果
        post.add(v);
    }

    public Iterable<Integer> getPre() {
        return pre;
    }

    public Iterable<Integer> getPost() {
        return post;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new Graph("g.txt");
        GraphDFS graphDFS = new GraphDFS(graph);
        System.out.println(graphDFS.getPre());
        System.out.println(graphDFS.getPost());
    }
}
