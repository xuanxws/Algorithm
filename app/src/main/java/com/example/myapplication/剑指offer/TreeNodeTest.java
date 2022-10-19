package com.example.myapplication.剑指offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNodeTest {

    static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        public int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 递归前序遍历
    public void preOrderTraveral(TreeNode root) {
        if (null == root) {
            return;
        }
        System.out.println(root.val);
        preOrderTraveral(root.left);
        preOrderTraveral(root.right);
    }

    // 递归中序遍历
    public void inOrderTraveral(TreeNode root) {
        if (null == root) {
            return;
        }
        inOrderTraveral(root.left);
        System.out.println(root.val);
        inOrderTraveral(root.right);
    }

    // 递归后序遍历
    public void postOrderTraveral(TreeNode root) {
        if (null == root) {
            return;
        }
        postOrderTraveral(root.left);
        postOrderTraveral(root.right);
        System.out.println(root.val);
    }

    /**
     * 非递归前序遍历
     * 1. 定义一个栈
     * 2. 当栈不为空或者node不为null
     *      1. 不断的往栈中压入左结点，直到左边没有左结点
     *      2. 弹栈，访问右节点
     */
     public void preOrderTraveralWithStack(TreeNode root) {
         Stack<TreeNode> stack = new Stack<>();
         TreeNode node = root;
         while (null != root || !stack.isEmpty()) {
             while (node != null) {
                 System.out.println(node.val);
                 stack.push(node);
                 node = node.left;
             }

             if (!stack.isEmpty()) {
                 node = stack.pop();
                 node = node.right;
             }
         }
     }

    /**
     *  非递归中序遍历
     * @param root
     */
    public void middleOrderTraversal(TreeNode root) {
         Stack<TreeNode> stack = new Stack<>();
         TreeNode node = root;
         while (null != root || !stack.isEmpty()) {
             while (node != null) {
                 stack.push(node);
                 node = node.left;
             }

             if (!stack.isEmpty()) {
                 node = stack.pop();
                 System.out.println(node.val);
                 node = node.right;
             }
         }
     }

    /**
     * 使用双栈法
     * 前序遍历是根左右
     * 第一步的时候我们不断压入左节点改成押入右结点，这样就得到根右左
     * 然后将根右左逆序的话就得到左右根，即后序遍历
     * @param root
     */
     public void postOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> res = new Stack<>();

        TreeNode node = root;
        while (node != null && !stack.isEmpty()) {
            while (node != null) {
                res.push(node);
                stack.push(node);
                node = node.right;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.left;
            }
        }

        while (!res.isEmpty()) {
            System.out.println(res.pop().val);
        }
     }


    /**
     * 层序遍历
     *
     * @param root
     */
     public void levelOrderTraversals(TreeNode root) {
         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
         while (!queue.isEmpty()) {
             TreeNode node = queue.poll();
             System.out.println(node.val);
             if (null != node.left) {
                 queue.offer(node.left);
             }
             if (null != node.right) {
                 queue.offer(node.right);
             }
         }
     }


}
