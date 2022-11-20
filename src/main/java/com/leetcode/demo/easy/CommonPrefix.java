package com.leetcode.demo.easy;

import java.util.Arrays;

/**
 * @description: 获取公共长度
 * @Param:
 * @Return:
 * @Author: tom zhang
 * @Date: 2022/10/12 21:06
 */
public class CommonPrefix {


    public static String longestCommonPrefix(String[] strs){
//        Arrays.sort(strs);
//        char[] first = strs[0].toCharArray();
//        char[] last = strs[strs.length - 1].toCharArray();
//        int i = 0;
//        while (i < first.length && i < last.length) {
//            if (first[i] != last[i]) {
//                break;
//            }
//            i ++;
//        }
//        return strs[0].substring(0, i);

//        if(strs.length == 0)
//            return "";
//        String ans = strs[0];
//        for(int i =1;i<strs.length;i++) {
//            int j=0;
//            System.out.println(ans.length());
//            for(;j<ans.length() && j < strs[i].length();j++) {
//                System.out.println(strs[i].length());
//                System.out.println(ans.charAt(j));
//                if(ans.charAt(j) != strs[i].charAt(j))
//                    break;
//            }
//            ans = ans.substring(0, j);
//            if(ans.equals(""))
//                return ans;
//        }
//        return ans;

        if (strs.length == 0) return "";
        // 初始值为首位元素
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            // 挨着对比
            while (j < res.length() && j < strs[i].length() && res.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            // substring 是左闭右开的
            res = res.substring(0, j);
        }
        return res;

    }



    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }

}
