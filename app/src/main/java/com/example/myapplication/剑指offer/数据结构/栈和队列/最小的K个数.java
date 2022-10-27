package com.example.myapplication.剑指offer.数据结构.栈和队列;

import java.util.ArrayList;
import java.util.PriorityQueue;

// https://github.com/CyC2018/CS-Notes/blob/master/notes/40.%20%E6%9C%80%E5%B0%8F%E7%9A%84%20K%20%E4%B8%AA%E6%95%B0.md
public class 最小的K个数 {

    // 维护一个大小为 K 的最小堆过程如下：使用大顶堆。在添加一个元素之后，如果大顶堆的大小大于 K，
    // 那么将大顶堆的堆顶元素去除，也就是将当前堆中值最大的元素去除，从而使得留在堆中的元素都比被去除的元素来得小。

    // Java 的 PriorityQueue 实现了堆的能力，PriorityQueue 默认是小顶堆，
    // 可以在在初始化时使用 Lambda 表达式 (o1, o2) -> o2 - o1 来实现大顶堆
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (null == input || input.length <= 0 || k > input.length) {
            return result;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < input.length; i++) {
            maxHeap.add(input[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }


    // 用快速排序来解决也可以
    public ArrayList<Integer> GetLeastNumbers_Solutions(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (null == input || input.length <= 0 || k > input.length) {
            return result;
        }
        findMinK(input,k);
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    private void findMinK(int[] input, int k) {
        int l = 0,r = input.length - 1;
        while (l < r) {
            int index = getMiddle(input,l , r);
            if (index == k) {
                break;
            }
            if (index > k) {
                r = index - 1;
            } else {
                l = index + 1;
            }
        }
    }

    private int getMiddle(int[] input, int l, int r) {
        int key = input[l];
        while (l < r) {
            while (l < r && input[r] >= key) {
                r--;
            }
            input[l] = input[r];

            while (l < r && input[l] <= key) {
                l++;
            }
            input[r] = input[l];
        }
        input[l] = key;
        return r;
    }


}
