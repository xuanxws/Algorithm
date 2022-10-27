package com.example.myapplication.剑指offer.数据结构.树;

// 二叉搜索树的后序遍历最后一个是根节点，根据根节点把前面的数组切根成两半，然后递归执行

public class 二叉搜索树的后序遍历 {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (null == sequence || sequence.length <= 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int first, int last) {
        if (last - first <= 1) {
            return true;
        }
        int rootVal = sequence[last];
        int currentIndex = first;
        while (currentIndex < last && sequence[currentIndex] <= rootVal) {
            currentIndex++;
        }
        for (int i = currentIndex; i < last; i++) {
            if (sequence[i] < rootVal) {
                return false;
            }
        }
        return verify(sequence, first, currentIndex - 1) &&
                verify(sequence, currentIndex, last - 1);
    }
}
