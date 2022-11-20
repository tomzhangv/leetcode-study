package com.leetcode.demo;

/**
 * @description:
 * @Param:
 * @Return:
 * @Author: tom zhang
 * @Date: 2022/11/20 14:55
 */
public class text {
    static int N = 5;
    static int M = 4;
    static int[] a= new int[]{1,2,3,4,5};
    static int[] b = new int[M];

    public static void main(String[] args){
        C(N,M);
    }

    static void C(int m,int n){
        int i,j;
        for(i=n;i<=m;i++) {
            b[n-1] = i-1;
            if(n>1)
                C(i-1,n-1);
            else {
                for(j=0;j<=M-1;j++)
                    System.out.print(a[b[j]] + "  ");
                System.out.println();
            }
        }
    }

}
