package com.zhaomeng.graph08;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: zhaomeng
 * @Date: 2022/11/20 22:54
 */
// !使用Kruskal算法求解最小生成树
// !相当于给定v个顶点，选择v-1条边，使得权值最小
// !时间复杂度 O(ElogE)
public class Kruskal {
    private WeightedGraph G;
    private ArrayList<WeightedEdge> mst;

    public Kruskal(WeightedGraph G) {
        this.G = G;
        mst = new ArrayList<>();

        // !判断连通分量
        CCWG ccwg = new CCWG(G);
        if (ccwg.getCcCount() > 1)
            return;

        // Kruskal
        ArrayList<WeightedEdge> edges = new ArrayList<>();
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                // !使用v<w是防止无向图中v-w和w-v都添加进去
                if (v < w) {
                    edges.add(new WeightedEdge(v, w, G.getWeight(v, w)));
                }
            }
        }
        // !对边按照权值排序
        Collections.sort(edges);

        // !判断环
        UF uf = new UF(G.V());
        for (WeightedEdge edge : edges) {
            int v = edge.getV();
            int w = edge.getW();
            // !如果v和w已经连接起来了，那么就扔掉，否则再添加
            if (!uf.isConnected(v, w)) {
                mst.add(edge);
                uf.unionElements(v, w);
            }
        }
    }

    public ArrayList<WeightedEdge> result() {
        return mst;
    }

    public static void main(String[] args) throws FileNotFoundException {
        WeightedGraph g = new WeightedGraph("weightedgraph.txt");
        Kruskal kruskal = new Kruskal(g);
        System.out.println(kruskal.result());
    }
}
