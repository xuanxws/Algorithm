package com.example.myapplication.剑指offer.数据结构.栈和队列;

import java.util.LinkedList;
import java.util.Queue;


// https://github.com/CyC2018/CS-Notes/blob/master/notes/41.2%20%E5%AD%97%E7%AC%A6%E6%B5%81%E4%B8%AD%E7%AC%AC%E4%B8%80%E4%B8%AA%E4%B8%8D%E9%87%8D%E5%A4%8D%E7%9A%84%E5%AD%97%E7%AC%A6.md
public class 字符流中第一个不重复的字符 {

    private Queue<Character> queue = new LinkedList<>();
    private int[] cnts = new int[128];

    //Insert one char from stringstream
    public void Insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        if (!queue.isEmpty() && cnts[queue.peek()] > 1) {
            queue.poll();
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
       return queue.isEmpty()? '#' : queue.peek();
    }

}
