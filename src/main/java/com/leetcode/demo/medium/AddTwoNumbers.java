package com.leetcode.demo.medium;

/**
 * @description: 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * @Param:
 * @Return:
 * @Author: tom zhang
 * @Date: 2022/6/4 17:53
 */
public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode pre = new ListNode(0);
            ListNode cur = pre;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int x = l1 == null ? 0 : l1.val;
                int y = l2 == null ? 0 : l2.val;
                int sum = x + y + carry;

                carry = sum / 10;
                sum = sum % 10;
                cur.next = new ListNode(sum);

                cur = cur.next;
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }
            if (carry == 1) {
                cur.next = new ListNode(carry);
            }
            return pre.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
