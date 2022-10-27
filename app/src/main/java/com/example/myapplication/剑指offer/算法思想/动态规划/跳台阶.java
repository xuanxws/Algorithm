package com.example.myapplication.剑指offer.算法思想.动态规划;


// https://github.com/CyC2018/CS-Notes/blob/master/notes/10.3%20%E8%B7%B3%E5%8F%B0%E9%98%B6.md
public class 跳台阶 {

    public int JumpFloor(int n) {
        if (n <= 2) {
            return n;
        }

        int pre1 = 1;
        int pre2 = 2;
        int result = 0;
        for (int i = 2; i < n; i++) {
            result = pre1 + pre2;
            pre1 = result;
            pre2 = pre1;
        }
        return pre1 + pre2;
    }
}
