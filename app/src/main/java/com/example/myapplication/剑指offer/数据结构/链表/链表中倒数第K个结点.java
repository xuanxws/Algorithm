package com.example.myapplication.剑指offer.数据结构.链表;


// https://github.com/CyC2018/CS-Notes/blob/master/notes/22.%20%E9%93%BE%E8%A1%A8%E4%B8%AD%E5%80%92%E6%95%B0%E7%AC%AC%20K%20%E4%B8%AA%E7%BB%93%E7%82%B9.md
public class 链表中倒数第K个结点 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        if (null == pHead) {
            return null;
        }

        ListNode p1 = pHead;
        while(p1 != null && k-- > 0){
            p1 = p1.next;
        }

        if (k > 0) {
            return null;
        }

        ListNode p2 = pHead;
        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

}
