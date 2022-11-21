package com.zhaomeng.graph01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: zhaomeng
 * @Date: 2022/10/30 12:44
 */

/**
 * 邻接表
 * V = 7, E = 9
 * 0 : 1 3
 * 1 : 0 2 6
 * 2 : 1 3 5
 * 3 : 0 2 4
 * 4 : 3 5
 * 5 : 2 4 6
 * 6 : 1 5
 *
 * 空间复杂度：O(V+E)
 * 时间复杂度
 * 建图：O(E*V)
 * 查看两点是否相邻：O(degree(v))
 * 求一个点的相邻节点：O(degree(v))
 */
public class AdjacencyList {
    // !顶点
    private int V;
    // !边
    private int E;
    // !邻接表（二维数组）
    private LinkedList<Integer>[] adj;

    public AdjacencyList(String filename) throws FileNotFoundException {
        File file = new File(filename);

        Scanner scanner = new Scanner(file);
        // !顶点数是文件中第一行第一个数
        V = scanner.nextInt();
        if (V < 0) {
            throw new IllegalArgumentException("V must be non-negative");
        }
        // !获取到顶点数后new出邻接矩阵的大小
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
        // !第一行第二个数是边数
        E = scanner.nextInt();
        if (E < 0) {
            throw new IllegalArgumentException("E must be non-negative");
        }
        for (int i = 0; i < E; i++) {
            // !校验顶点数索引不能大于总顶点数
            int a = scanner.nextInt();
            validateVertex(a);
            int b = scanner.nextInt();
            validateVertex(b);
            // !检测自环边
            if (a == b) {
                throw new IllegalArgumentException("Self Loop i Detected");
            }
            // !校验平行边
            if (adj[a].contains(b)) {
                throw new IllegalArgumentException("Parallel Edges are Detected");
            }
            adj[a].add(b);
            adj[b].add(a);
        }
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + "is invalid");
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("V = %d, E = %d\n", V, E));
        for (int i = 0; i < V; i++) {
            sb.append(String.format("%d : ", i));
            for (int w : adj[i]) {
                sb.append(String.format("%d ", w));
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    // !检查入参中的两个顶点是否有边
    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return adj[v].contains(w);
    }

    // !计算和顶点v所有相邻的顶点集合
    public List<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    // !求一个顶点的度（degree）
    public int degree(int v) {
        return adj(v).size();
    }

    public static void main(String[] args) throws FileNotFoundException {
        AdjacencyList adjacencyList = new AdjacencyList("g.txt");
        System.out.println(adjacencyList);

    }
}
