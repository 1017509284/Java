package com.zhaomeng.graph07;

import com.zhaomeng.graph01.Graph;
import com.zhaomeng.graph02.CC;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: zhaomeng
 * @Date: 2022/11/6 22:14
 */
public class EulerLoop01 {
    private Graph G;

    public EulerLoop01(Graph G) {
        this.G = G;
    }

    public boolean hasEulerLoop() {
        CC cc = new CC(G);
        if (cc.getCcCount() > 1)
            return false;

        for (int v = 0; v < G.V(); v++) {
            // !If the degree of some vertex is not even, then it is not EulerLoop
            if (G.degree(v) % 2 == 1)
                return false;
        }
        return true;
    }

    public List<Integer> result() throws CloneNotSupportedException {
        List<Integer> res = new ArrayList<>();
        if (!hasEulerLoop())
            return res;

        Graph g = (Graph) G.clone();

        Stack<Integer> stack = new Stack<>();
        int curv = 0;
        stack.push(curv);
        while (!stack.empty()) {
            if (g.degree(curv) != 0) {
                stack.push(curv);
                int w = g.adj(curv).iterator().next();
                g.removeEdge(curv, w);
                curv = w;
            } else {
                res.add(curv);
                curv = stack.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) throws FileNotFoundException, CloneNotSupportedException {
        Graph g = new Graph("eulerLoop.txt");
        EulerLoop01 eulerLoop01 = new EulerLoop01(g);
        System.out.println(eulerLoop01.result());
    }
}
