package com.example.myapplication.剑指offer.算法思想.双指针;

// https://github.com/CyC2018/CS-Notes/blob/master/notes/58.1%20%E7%BF%BB%E8%BD%AC%E5%8D%95%E8%AF%8D%E9%A1%BA%E5%BA%8F%E5%88%97.md

public class 翻转单词顺序列 {

    public String ReverseSentence(String str) {
        if (null == str || str.length() <= 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        int length = str.length();
        int i=0,j=0;
        while (j <= length) {
            if (j == length || chars[j] == ' ') {
                reverseStr(chars,i,j - 1);
                i = j + 1;
            }
            j++;
        }
        reverseStr(chars,0,length - 1);
        return new String(chars);
    }

    private void reverseStr(char[] chars, int i , int j) {
        while (i < j) {
            swap(chars,i++,j--);
        }
    }

    private void swap(char[] chars, int i , int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] =temp;
    }
}
