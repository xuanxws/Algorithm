package com.example.myapplication.基本思想;

public class ListNodes {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 递归实现反转链表
    private ListNode reverseListNode(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverseListNode(next);
        next.next = head;
        return newHead;
    }

    // 头插法实现链表反转
    private ListNode reverseListNodes(ListNode head) {
        ListNode nextList = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = nextList.next;
            nextList.next = head;
            head = next;
        }
        return nextList.next;
    }


}
