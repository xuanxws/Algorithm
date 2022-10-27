package com.example.myapplication.剑指offer.算法思想.双指针;

import java.util.ArrayList;
import java.util.Arrays;

// https://github.com/CyC2018/CS-Notes/blob/master/notes/57.1%20%E5%92%8C%E4%B8%BA%20S%20%E7%9A%84%E4%B8%A4%E4%B8%AA%E6%95%B0%E5%AD%97.md
public class 和为S的两个数 {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if (null == array || array.length < 2) {
            return new ArrayList<>();
        }

        int l = 0,r = array.length - 1;
        while (l < r) {
            int s = array[l] + array[r];
            if (s == sum) {
                return new ArrayList<>(Arrays.asList(array[l], array[r]));
            } else if (s > sum) {
                r--;
            } else {
                l++;
            }
        }
        return new ArrayList<>();
    }
}


