package com.zhaomeng.graph08;

/**
 * @author: zhaomeng
 * @Date: 2022/11/20 22:56
 */
public class WeightedEdge implements Comparable<WeightedEdge>{
    private int v;
    private int w;
    private int weight;

    public WeightedEdge(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }

    @Override
    public String toString() {
        return String.format("(%d-%d : %d)", v, w, weight);
    }

    @Override
    public int compareTo(WeightedEdge another) {
        // !如果返回值为复数，代表当前的对象比传进来的要小
        // !如果是0代表相等
        // !如果是正数，代表当前对象比传进来的对象大
        return weight - another.weight;
    }
}
