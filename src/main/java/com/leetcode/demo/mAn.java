package com.leetcode.demo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @Param:
 * @Return:
 * @Author: tom zhang
 * @Date: 2022/11/20 14:47
 */
public class mAn {
    private int all;
    public mAn()
    {
        this.all=0;
    }
    public int getAll() {
        return all;
    }
    public void setAll(int all) {
        this.all = all;
    }
    public static void main(String[] args) {
        String[] n ={"1","2","3","4","5"};
        mAn m=new mAn();
        List lst = Arrays.asList(n);
        m.take("",4,lst);
        System.out.println(m.getAll());
    }

    public  void take(String s, int total, List lst) {
        for (int i = 0; i < lst.size(); i++) {
            //System.out.println("i="+i);
            List templst=new LinkedList(lst);
            String n =  (String) templst.remove(i);// 取出来的数字
            String str = s + n;
            if (total == 1) {
                System.out.println(str);//以最极端 n个里面只取一个，直接把取出来的结果输出即可
                //total=all;
                all++;

            } else {
                int temp=total-1;//在同一层中total总量不能减,不能再原有变量的基础上
                take(str, temp, templst);// 这里的temp以及templst都是全新的变量和集合
            }
        }

    }

}
