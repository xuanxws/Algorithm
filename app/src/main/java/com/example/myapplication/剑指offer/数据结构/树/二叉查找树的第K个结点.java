package com.example.myapplication.剑指offer.数据结构.树;


import java.util.Stack;

//https://github.com/CyC2018/CS-Notes/blob/master/notes/54.%20%E4%BA%8C%E5%8F%89%E6%9F%A5%E6%89%BE%E6%A0%91%E7%9A%84%E7%AC%AC%20K%20%E4%B8%AA%E7%BB%93%E7%82%B9.md
public class 二叉查找树的第K个结点 {

    public TreeNode KthNode(TreeNode pRoot, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = pRoot;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                if (k-- == 0) {
                    return node;
                }
                node = node.right;
            }
        }
        return null;
    }



    TreeNode ret = null;
    int cnt = 0;

    public TreeNode KthNodes(TreeNode pRoot, int k) {
        inOrder(pRoot,k);
        return ret;
    }

    private void inOrder(TreeNode node,int k) {
        inOrder(node.left,k);
        cnt++;
        if (cnt == k){
            ret = node;
        }
        inOrder(node.right,k);
    }
}
