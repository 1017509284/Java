package com.zhaomeng.graph02;

import com.zhaomeng.graph01.Graph;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zhaomeng
 * @Date: 2022/10/30 20:21
 */
// !Connected Component求一个图的连通分量
public class CC {
    // !图G
    private Graph G;
    private int[] visited;
    // !联通分量的个数
    private int ccCount = 0;


    public CC(Graph G) {
        this.G = G;
        visited = new int[G.V()];
        // !将visited数组中的每个元素都置为-1，表示全部没有被访问过
        Arrays.fill(visited, -1);
        // !对于多个联通分量的图，仅仅从一个顶点开始dfs的话，那么遍历不到所有的顶点，需要for遍历每个节点
        // !如果这个顶点没有被访问到的话，那么就对这个顶点执行dfs操作
        for (int i = 0; i < G.V(); i++) {
            if (visited[i] == -1) {
                // !对于顶点i进行dfs的时候，传入ccCount，表示第几个连通分量
                dfs(i, ccCount);
                // !对于一个联通的图，ccCount = 1，如果当第二次进入这个if条件的时候
                // !就说明此时有些节点没遍历到，也就是存在其他的连通分量，因此在这里进行ccCount++
                ccCount ++;
            }
        }

    }

    private void dfs(int v, int ccid) {
        // !将顶点v的visited数组置为ccid，表示已经遍历过这个节点了，并且这个顶点属于，第ccid个连通分量
        visited[v] = ccid;
        // !然后开始遍历这个节点的相邻节点
        for (int w : G.adj(v)) {
            // !如果相邻节点没有被访问过的话
            if (visited[w] == -1) {
                // !继续对这个节点进行dfs操作
                dfs(w, ccid);
            }
        }
    }

    public int getCcCount() {
        for (int e : visited) {
            System.out.print(e + " ");
        }
        System.out.println();
        return ccCount;
    }

    // !顶点v和顶点w是否属于同一个连通分量
    public boolean isConnected(int v, int w) {
        G.validateVertex(v);
        G.validateVertex(w);
        return visited[v] == visited[w];
    }

    // !返回每个联通分量中的顶点数
    public List<Integer>[] components() {
        ArrayList<Integer>[] res= new ArrayList[ccCount];
        for (int i = 0; i < ccCount; i++) {
            res[i] = new ArrayList<>();
        }
        for (int v = 0; v < G.V(); v++) {
            res[visited[v]].add(v);
        }
        return res;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Graph g = new Graph("g.txt");
        CC cc = new CC(g);
        System.out.println(cc.getCcCount());

        System.out.println(cc.isConnected(0, 6));
        System.out.println(cc.isConnected(0, 5));

        for (List<Integer> component : cc.components()) {
            System.out.println(component);
        }
    }
}
