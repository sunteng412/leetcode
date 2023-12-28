package com.qingxuan.tree;

import lombok.Data;

import java.util.Objects;

/**
 * binary tree
 * 红黑树
 * */
public class BinaryTree {


    @Data
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }



    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        insertNode(null,n1);
        insertNode(n1,n2);
        insertNode(n1,n3);

        System.out.println(n1);
    }

    public static void insertNode(TreeNode root,TreeNode newNode){
        if(root == null){
            root = newNode;
            return ;
        }
        if(root.val > newNode.val){
            if(root.left == null){
                root.left = newNode;
            }else{
                insertNode(root.left,newNode);
            }
        }else{
            if(root.right == null){
                root.right = newNode;
            }else{
                insertNode(root.right,newNode);
            }
        }
    }
}
