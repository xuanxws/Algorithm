package com.example.myapplication.剑指offer.数据结构.树;

import java.util.ArrayList;


// https://github.com/CyC2018/CS-Notes/blob/master/notes/34.%20%E4%BA%8C%E5%8F%89%E6%A0%91%E4%B8%AD%E5%92%8C%E4%B8%BA%E6%9F%90%E4%B8%80%E5%80%BC%E7%9A%84%E8%B7%AF%E5%BE%84.md
public class 序列二叉树中和为某一值的路径 {

    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
         if (null == root) {
             return new ArrayList<>();
         }
         backTracking(root,target, new ArrayList<>());
         return ret;
    }

    private void backTracking(TreeNode node,int target, ArrayList<Integer> paths) {
        if (null == node) {
            return;
        }

        target = target - node.val;
        if (target == 0 && node.left == null && node.right == null) {
            ret.add(new ArrayList<>(paths));
        } else {
            backTracking(node.left, target, paths);
            backTracking(node.right, target, paths);
        }
        paths.remove(paths.size() - 1);
    }

}
