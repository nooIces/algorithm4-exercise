package com.algorithm4.chapter1.unionfind;

import com.algorithm4.chapter1.abstracts.AbstractUnionFind;

public class WeightedQuickUnion extends AbstractUnionFind {

    private int[] countArr;

    public WeightedQuickUnion(int num) {
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
        int num = 0;
        int q = p;
        while(arr[q] != q){
            num++;
            q = arr[q];
        }
        countArr[p] = num;
        return q;
    }
}
