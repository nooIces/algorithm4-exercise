package com.algorithm4.chapter1.unionfind;

import com.algorithm4.chapter1.abstracts.AbstractUnionFind;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class UnionFindTest {

    private static final int TOTAL_NUM = 10000000;

    @Test
    public void test(){
        testUnionFind(new QuickFind(TOTAL_NUM), TOTAL_NUM);
        System.out.println("------------------");
        testUnionFind(new QuickUnion(TOTAL_NUM), TOTAL_NUM);
        System.out.println("------------------");
        testUnionFind(new WeightedQuickUnion(TOTAL_NUM), TOTAL_NUM);
        System.out.println("------------------");
        testUnionFind(new PathCompressionWeightedQuickUnion(TOTAL_NUM), TOTAL_NUM);
    }

    @Test
    public void testQuickFind(){
        testUnionFind(new QuickFind(10), 10);
    }

    @Test
    public void testQuickUnion(){
        testUnionFind(new QuickUnion(TOTAL_NUM), TOTAL_NUM);
    }

    @Test
    public void testWeightedQuickUnion(){
        testUnionFind(new WeightedQuickUnion(TOTAL_NUM), TOTAL_NUM);
    }


    private void testUnionFind(AbstractUnionFind unionFind, int totalNum){
        long start = System.currentTimeMillis();
        for(int i = 0; i < totalNum-1; i++){
            unionFind.union(i, i+1);
        }
        long end = System.currentTimeMillis();
        System.out.println("cost time: " + (end-start) + "ms");

        int randomTestNum = 1000;
        Random random = new Random();
        long totalCost = 0;
        for(int i = 0; i < randomTestNum; i++){
            long s = System.currentTimeMillis();
            int r = (int)Math.floor(random.nextInt(totalNum));
            unionFind.find(r);
            long e = System.currentTimeMillis();
            totalCost += e-s;
        }
        System.out.println("find avg cost time: " + totalCost/randomTestNum + "ms");
    }

}
