package com.algorithm4.chapter1.unionfind;

import com.algorithm4.chapter1.abstracts.AbstractUnionFind;

public class QuickFind extends AbstractUnionFind {

    public QuickFind(int num) {
        super(num);
    }

    @Override
    public void union(int p, int q) {
        if(isConnected(p, q)){
            return;
        }
        count--;
        int m = arr[p];
        int n = arr[q];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == n){
                arr[i] = m;
            }
        }
    }

    @Override
    public int find(int p) {
        return arr[p];
    }
}
