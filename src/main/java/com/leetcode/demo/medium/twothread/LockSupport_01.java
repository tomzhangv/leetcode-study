package com.leetcode.demo.medium.twothread;

import java.util.concurrent.locks.LockSupport;

/**
 * @description: 两个线程交替输出
 * @Param:
 * @Return:
 * @Author: tom zhang
 * @Date: 2022/8/7 15:57
 */
public class LockSupport_01 {
    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        char[] chars1 = "123456789".toCharArray();
        char[] chars2 = "ABCDEFGH".toCharArray();

        t1 = new Thread(() -> {
            for (char c : chars1) {

                System.out.print(c);
                //叫醒t2线程
                LockSupport.unpark(t2);
                //t1阻塞，当前线程阻塞
                LockSupport.park();
            }
        }, "t1");

        t2 = new Thread(() -> {
            for (char c : chars2) {

                //t2挂起
                LockSupport.park();
                System.out.print(c);
                //叫醒t1
                LockSupport.unpark(t1);
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
