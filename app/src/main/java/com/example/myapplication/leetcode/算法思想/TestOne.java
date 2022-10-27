package com.example.myapplication.leetcode.算法思想;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestOne {


    public List<List<Integer>> threeSum(int[] nums) {
         List<List<Integer>> lists = new ArrayList<>();
         Arrays.sort(nums);
         if (nums.length < 3) {
             return lists;
         }

         int count = nums.length - 2;
         int second = 0;
        for (int first = 0; first < count; first++) {
            second = first + 1;
            for (int third = nums.length - 1; third > second ;) {
                if (nums[first] + nums[second] + nums[third] == 0) {
                    List<Integer> items = new ArrayList<>();
                    items.add(nums[first]);
                    items.add(nums[second]);
                    items.add(nums[third]);
                    lists.add(items);

                    second++;
                    third--;
                }

                if (nums[first] + nums[second] + nums[third] > 0) {
                    third--;
                }

                if (nums[first] + nums[second] + nums[third] < 0) {
                    second++;
                }
            }
        }

         return lists;
    }
}
