package com.algorithm4.chapter1.abstracts;

public abstract class AbstractUnionFind {

    protected int count;

    protected int[] arr;

    public AbstractUnionFind(int num){
        this.count = num;
        this.arr = new int[num];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
    }

    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    public abstract void union(int p, int q);

    public abstract int find(int p);

    public int count(){
        return count;
    }

}
