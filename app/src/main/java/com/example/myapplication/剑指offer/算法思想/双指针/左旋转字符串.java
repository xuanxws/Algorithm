package com.example.myapplication.剑指offer.算法思想.双指针;

// https://github.com/CyC2018/CS-Notes/blob/master/notes/58.2%20%E5%B7%A6%E6%97%8B%E8%BD%AC%E5%AD%97%E7%AC%A6%E4%B8%B2.md
public class 左旋转字符串 {

    public String LeftRotateString(String str,int n) {
        if (null == str || str.length() <= 0) {
            return "";
        }

        int length = str.length();
        int mid = n % length;
        if (mid == 0) {
            return str;
        }

        char[] chars = str.toCharArray();
        reverseStr(chars,0,mid - 1);
        reverseStr(chars,mid, length - 1);
        reverseStr(chars,0, length - 1);
        return new String(chars);
    }

    private void reverseStr(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars,i++,j--);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
