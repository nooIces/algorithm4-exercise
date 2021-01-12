package com.algorithm4.chapter1.unionfind;

import com.algorithm4.chapter1.abstracts.AbstractUnionFind;

public class PathCompressionWeightedQuickUnion extends AbstractUnionFind {

    private int[] countArr;

    public PathCompressionWeightedQuickUnion(int num) {
        super(num);
        this.countArr = new int[num];
    }

    @Override
    public void union(int p, int q) {
        int findP = find(p);
        int findQ = find(q);
        if(findP == findQ){
            return;
        }
        count--;
        if(countArr[p] > countArr[q]){
            arr[findQ] = arr[findP];
        } else {
            arr[findP] = arr[findQ];
        }
    }

    @Override
    public int find(int p) {
        int q = p;
        while(arr[q] != q){
            q = arr[q];
        }
        int r = p;
        while(arr[r] != r){
            int temp = arr[r];
            arr[r] = q;
            r = temp;
        }
        countArr[p] = 1;
        return q;
    }
}
