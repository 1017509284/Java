package com.zhaomeng.graph08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author: zhaomeng
 * @Date: 2022/10/30 12:44
 */


// !无向带权图
public class WeightedGraph implements Cloneable{
    private int V;
    private int E;
    // ! key为和第i个顶点相邻的顶点，value是权值
    private TreeMap<Integer, Integer>[] adj;

    public WeightedGraph(String filename) throws FileNotFoundException {
        File file = new File(filename);

        Scanner scanner = new Scanner(file);

        V = scanner.nextInt();
        if (V < 0) {
            throw new IllegalArgumentException("V must be non-negative");
        }
        adj = new TreeMap[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new TreeMap<>();
        }
        E = scanner.nextInt();
        if (E < 0) {
            throw new IllegalArgumentException("E must be non-negative");
        }
        for (int i = 0; i < E; i++) {

            int a = scanner.nextInt();
            validateVertex(a);
            int b = scanner.nextInt();
            validateVertex(b);
            int weight = scanner.nextInt();

            // !检测自环边
            if (a == b) {
                throw new IllegalArgumentException("Self Loop i Detected");
            }
            // !校验平行边
            if (adj[a].containsKey(b)) {
                throw new IllegalArgumentException("Parallel Edges are Detected");
            }
            adj[a].put(b, weight);
            adj[b].put(a, weight);
        }
    }

    public void validateVertex(int v) {
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
            for (Map.Entry<Integer, Integer> entry : adj[i].entrySet()) {
                sb.append(String.format("(%d : %d) ", entry.getKey(), entry.getValue()));
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
        return adj[v].containsKey(w);
    }

    // !计算和顶点v所有相邻的顶点集合
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v].keySet();
    }

    // !获取v和w之间的权值
    public int getWeight(int v, int w) {
        if (hasEdge(v, w)) {
            return adj[v].get(w);
        }
        throw new IllegalArgumentException(String.format("No edge %d-%d", v, w));
    }

    // !求一个顶点的度（degree）
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }


    public static void main(String[] args) throws FileNotFoundException {
        WeightedGraph weightedGraph = new WeightedGraph("weightedgraph.txt");
        System.out.println(weightedGraph);

    }
}
