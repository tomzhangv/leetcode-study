package com.leetcode.demo;

import java.util.*;

/**
 * @description:
 * @Param:
 * @Return:
 * @Author: tom zhang
 * @Date: 2022/11/20 12:03
 */
public class MyCombine {
    public static void main(String[] args) {
        String[] a = {"01", "07", "03", "14","05"};
        int num = 3;
        MyCombine tp = new MyCombine();
        for (Object obj : tp.combine(a, num)) {
//            break;
System.out.println(obj);
        }
    }

    /**
     * 实现的算法
     *
     * @param a   数据数组
     * @param num M选N中 N的个数
     * @return
     */

    private List combine(String[] a, int num) {
        List list = new ArrayList();
        StringBuffer sb = new StringBuffer();
        String[] b = new String[a.length];
        for (int i = 0; i < b.length; i++) {
            if (i < num) {
                b[i] = "1";
            } else
                b[i] = "0";
        }
        int point = 0;
        int nextPoint = 0;
        int count = 0;
        int sum = 0;
        String temp = "1";
        while (true) {
// 判断是否全部移位完毕
            for (int i = b.length - 1; i >= b.length - num; i--) {
                if (b[i].equals("1"))
                    sum += 1;
            }
// 根据移位生成数据
            for (int i = 0; i < b.length; i++) {
                if (b[i].equals("1")) {
                    point = i;
                    sb.append(a[point]);
                    sb.append(" ");
                    count++;
                    if (count == num)
                        break;
                }
            }
// 往返回值列表添加数据
            list.add(sb.toString());
// 当数组的最后num位全部为1 退出
            if (sum == num) {
                break;
            }
            sum = 0;
// 修改从左往右第一个10变成01
            for (int i = 0; i < b.length - 1; i++) {
                if (b[i].equals("1") && b[i + 1].equals("0")) {
                    point = i;
                    nextPoint = i + 1;
                    b[point] = "0";
                    b[nextPoint] = "1";
                    break;
                }
            }
// 将 i-point个元素的1往前移动 0往后移动
            for (int i = 0; i < point - 1; i++)
                for (int j = i; j < point - 1; j++) {
                    if (b[i].equals("0")) {
                        temp = b[i];
                        b[i] = b[j + 1];
                        b[j + 1] = temp;
                    }
                }
// 清空 StringBuffer
            sb.setLength(0);
            count = 0;
        }
System.out.println("数据长度 " + list.size());
        return list;
    }


    //**********************************************************
    //elements为要操作的数据集合，即长度为M的容器，num为每次取的元素个数
//    public static List<List<String>> combiner(List<String> elements, int num,
//                                              List<List<String>> result){
//        //当num为1时，即返回结果集
//        if(num == 1){
//            return result;
//        }
//        //result的长度是变化的，故把原始值赋给变量leng
//        int leng = result.size();
//        //循环遍历，将 elements每两个元素放到一起，作为result中的一个元素
//        for (int i = 0; i < leng; i++) {
//            for (int j = 0; j < elements.size(); j++) {
//                if(!result.get(i).contains(elements.get(j))){
//                    List<String> list1 = new ArrayList<String>();
//                    for (int j2 = 0; j2 < result.get(i).size(); j2++) {
//                        list1.add(result.get(i).get(j2));
//                    }
//                    list1.add(elements.get(j));
//                    Collections.sort(list1);
//                    result.add(list1);
//                }
//            }
//        }
//        //将result中的循环遍历前的数据删除
//        for (int i = 0; i < leng; i++) {
//            result.remove(0);
//        }
//        //对result进行去重
//        Iterator<List<String>> it=result.iterator();
//        List<List<String>> listTemp= new ArrayList<List<String>>();
//        while(it.hasNext()){
//            List<String> a=it.next();
//            if (listTemp.contains(a)){
//                it.remove();
//            }else {
//                listTemp.add(a);
//            }
//        }
//        //递归计算，根据num的值来确定递归次数
//        combiner(elements, num - 1, result);
//        return result;
//    }
//
//    //elements为要操作的数据集合，即长度为M的容器，num为每次取的元素个数
//    public static List<List<String>> findsort(List<String> elements, int num){
//        List<List<String>> result = new ArrayList<List<String>>();
//        //将elements中的数据取出来，存到新的list中，为后续计算做准备
//        for (int i = 0; i < elements.size(); i++) {
//            List<String> list = new ArrayList<String>();
//            list.add(elements.get(i));
//            result.add(list);
//        }
//        return combiner(elements, num, result);
//    }
//
//    //验证
//    public static void main(String args[]) {
//        List<String> list = new ArrayList<String>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");
////        list.add("e");
//        //从list中每次取三个元素
//        List<List<String>> result =findsort(list, 4);
//        for (int i = 0; i < result.size(); i++) {
//            for (int j = 0; j < result.get(i).size(); j++) {
//                System.out.print(result.get(i).get(j) + " ");
//            }
//            System.out.println();
//        }
//    }


    /********************************************************************/
//    public static int[] getRandomList(int[] a, int n) {
//
//        int[] result = new int[n];
//        Random ran = new Random();
//        for (int i = 0; i < n; i++) {
//            int index = ran.nextInt(a.length - i);
//            result[i] = a[index];
//            a[index] = a[a.length - i - 1];
//            a[a.length - i - 1] = result[i];
//        }
//        return result;
//    }
//
//
//    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 4, 5};
//        int num = 4;
//        int[] randomList = getRandomList(a, num);
//
//        System.out.println(randomList);
//    }
}
