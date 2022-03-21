package com.leetcode.demo.leetcodestudy.twosum;

import java.util.Arrays;
import java.util.HashMap;

public class twoSum {
    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
//        int[] arr = solution1(nums, 9);
        int[] arr = solution2(nums, 9);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 暴力解法，双重循环依次判断数组中每两个值的和，时间复杂度：O(n方)
     */
    public static int[] solution1(int[] nums, int target) {
        //  下标
        int result[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }


    /**
     * 注意：和map.find(target-nums[i])执行时间一致，unordered_map的查找o(1)
     */
    public static int[] solution2(int[] nums, int target) {
        int result[] = new int[2];
        //  key存储差值，value存储下标
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //  map中存在对应的差值，即当前数据为所求
            //  例：nums[1,4,6,2,7] target= 7
            //  map{6,0;    3,1;    1,2;    5,3;    0,4}
            //  执行到6的位置时，发现Map中存在，返回value，即6对应的数组下标 int nums[] = {2, 7, 11, 15};
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            }
            map.put(target - nums[i], i);
        }
        return null;
    }


}
