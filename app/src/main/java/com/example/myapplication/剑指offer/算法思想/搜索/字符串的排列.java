package com.example.myapplication.剑指offer.算法思想.搜索;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

// https://github.com/CyC2018/CS-Notes/blob/master/notes/38.%20%E5%AD%97%E7%AC%A6%E4%B8%B2%E7%9A%84%E6%8E%92%E5%88%97.md
// https://blog.csdn.net/gaoyueace/article/details/89144549
public class 字符串的排列 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (null != str && str.length() > 0) {
            ranged(str.toCharArray(),0,result);
            Collections.sort(result);
        }
        return result;
    }

    private void ranged(char[] chars,int begin, ArrayList<String> result) {
         if (chars.length - 1 == begin) {
             result.add(String.valueOf(chars));
         } else {
             HashSet<Character> set = new HashSet<>();
             for (int i = begin; i < chars.length; i++) {
                  if (!set.contains(chars[i])) {
                      set.add(chars[i]);
                      swap(chars,begin,i);
                      ranged(chars,begin+1,result);
                      swap(chars,begin,i);
                  }
             }
         }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
