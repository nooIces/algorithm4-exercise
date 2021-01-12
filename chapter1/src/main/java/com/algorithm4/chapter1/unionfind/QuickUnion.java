package com.algorithm4.chapter1.unionfind;

import com.algorithm4.chapter1.abstracts.AbstractUnionFind;

public class QuickUnion extends AbstractUnionFind {

    public QuickUnion(int num) {
        super(num);
    }

    @Override
    public void union(int p, int q) {
        int findP = find(p);
        int findQ = find(q);
        if(findP == findQ){
            return;
        }
        count--;
        arr[findP] = findQ;
    }

    @Override
    public int find(int p) {
        int q = p;
        while(arr[q] != q){
            q = arr[q];
        }
        return q;
    }
}
