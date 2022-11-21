package com.zhaomeng.graph01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: zhaomeng
 * @Date: 2022/10/30 00:01
 */

/**
 * 邻接矩阵
 * V = 7, E = 9
 * 0 1 0 1 0 0 0
 * 1 0 1 0 0 0 1
 * 0 1 0 1 0 1 0
 * 1 0 1 0 1 0 0
 * 0 0 0 1 0 1 0
 * 0 0 1 0 1 0 1
 * 0 1 0 0 0 1 0
 *
 * 空间复杂度O(V^2)
 * 时间复杂度
 * 建图：O(E)
 * 查看两点是否相邻：O(1)
 * 求一个点的相邻节点：O(V)
 *
 */
public class AdjacencyMatrix {
    // !顶点
    private int V;
    // !边
    private int E;
    // !邻接矩阵
    private int[][] adj;

    public AdjacencyMatrix(String filename) throws FileNotFoundException {
        File file = new File(filename);

        Scanner scanner = new Scanner(file);
        // !顶点数是文件中第一行第一个数
        V = scanner.nextInt();
        if (V < 0) {
            throw new IllegalArgumentException("V must be non-negative");
        }
        // !获取到顶点数后new出邻接矩阵的大小
        adj = new int[V][V];
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
            if (adj[a][b] == 1) {
                throw new IllegalArgumentException("Parallel Edges are Detected");
            }
            adj[a][b] = 1;
            adj[b][a] = 1;
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
            for (int j = 0; j < V; j++) {
                sb.append(String.format("%d ", adj[i][j]));
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
        return adj[v][w] == 1;
    }

    // !计算和顶点v所有相邻的顶点集合
    public List<Integer> adj(int v) {
        validateVertex(v);
        List<Integer> res= new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (adj[i][v] == 1) {
                res.add(i);
            }
        }
        return res;
    }

    // !求一个顶点的度（degree）
    public int degree(int v) {
        return adj(v).size();
    }

    public static void main(String[] args) throws FileNotFoundException {
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix("g.txt");
        System.out.println(adjacencyMatrix);

    }
}
