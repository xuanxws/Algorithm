package com.example.myapplication.剑指offer.算法思想.二分查找;


// https://github.com/CyC2018/CS-Notes/blob/master/notes/11.%20%E6%97%8B%E8%BD%AC%E6%95%B0%E7%BB%84%E7%9A%84%E6%9C%80%E5%B0%8F%E6%95%B0%E5%AD%97.md
public class 旋转数组的最小数字 {

    public int minNumberInRotateArray(int [] array) {
        if (null == array || array.length == 0) {
            return 0;
        }

        int length = array.length;
        int l = 0,r = length - 1;
        while (l <= r) {
            int key = l + (r - l) / 2;
            if (array[key] == array[l] && array[key] == array[r]) {
                return getMinKey(array,l,r);
            }else if (array[key] > array[r]) {
                l = key + 1;
            } else {
                r = key;
            }
        }
        return array[l];
    }

    private int getMinKey(int [] array,int l,int r) {
        for (int i = l; i < r; i++) {
            if (array[i] > array[i+1]) {
                return array[i];
            }
        }
        return array[l];
    }


}
