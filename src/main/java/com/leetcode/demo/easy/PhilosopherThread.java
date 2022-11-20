package com.leetcode.demo.easy;

/**
 * @description: 哲学家用餐问题
 * @Param:
 * @Return:
 * @Author: tom zhang
 * @Date: 2022/8/6 17:32
 */
public class PhilosopherThread extends Thread {

    private Chopsticks left;

    private Chopsticks right;

    private int index;


    public PhilosopherThread(Chopsticks left, Chopsticks right, int index) {
        this.left = left;
        this.index = index;
        this.right = right;
    }

    @Override
    public void run() {

        if (index % 2 == 0) {
            synchronized (right) {
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println(index + "等待获取筷子LEFT进行吃饭");
                synchronized (left) {
                    System.out.println(index + "获取筷子LEFT进行吃饭");
                }
            }
        } else {
            synchronized (left) {
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println(index + "等待获取筷子RIGHT进行吃饭");
                synchronized (right) {
                    System.out.println(index + "获取筷子RIGHT进行吃饭");
                }
            }
        }

    }

    public static void main(String[] args) {
        Chopsticks chopsticks1 = new Chopsticks();
        Chopsticks chopsticks2 = new Chopsticks();
        Chopsticks chopsticks3 = new Chopsticks();
        Chopsticks chopsticks4 = new Chopsticks();
        Chopsticks chopsticks5 = new Chopsticks();

        PhilosopherThread philosopherThread1 = new PhilosopherThread(chopsticks1, chopsticks2, 1);
        PhilosopherThread philosopherThread2 = new PhilosopherThread(chopsticks2, chopsticks3, 2);
        PhilosopherThread philosopherThread3 = new PhilosopherThread(chopsticks3, chopsticks4, 3);
        PhilosopherThread philosopherThread4 = new PhilosopherThread(chopsticks4, chopsticks5, 4);
        PhilosopherThread philosopherThread5 = new PhilosopherThread(chopsticks5, chopsticks1, 5);
        philosopherThread1.start();
        philosopherThread2.start();
        philosopherThread3.start();
        philosopherThread4.start();
        philosopherThread5.start();

    }
}


