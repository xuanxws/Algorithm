package com.example.myapplication.基本思想;

public class Sort {


    // 二分查找
    public int binarySearch(int nums[],int key) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == key) {
                return m;
            } else if (nums[m] > key) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    // 快速排序
    public void quickSort(int[] nums,int low,int high) {
        if (low < high) {
            int mid = getMiddle(nums,low,high);
            quickSort(nums,0,mid - 1);
            quickSort(nums, mid + 1, high);
        }
    }

    private int getMiddle(int[] nums,int low,int high) {
        int key = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= key) {
                high--;
            }
            nums[low] = nums[high];

            while (low < high && nums[low] <= key) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = key;
        return low;
    }

}
