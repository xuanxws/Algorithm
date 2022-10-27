package com.example.myapplication.剑指offer.数据结构.链表;


// https://github.com/CyC2018/CS-Notes/blob/master/notes/24.%20%E5%8F%8D%E8%BD%AC%E9%93%BE%E8%A1%A8.md
public class 反转链表 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = null;
        ListNode newList = ReverseLists(next);
        next.next = head;
        return newList;
    }

    public ListNode ReverseLists(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }

}
