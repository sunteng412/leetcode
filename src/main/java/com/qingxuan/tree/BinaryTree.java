package com.qingxuan.tree;

import com.qingxuan.common.Tuple2;
import lombok.Data;

import java.util.Objects;

/**
 * binary tree
 * 红黑树
 */
public class BinaryTree {


    @Data
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "{值:" + val + (Objects.nonNull(left) ?
                    ("，左:" + left) : "") + (Objects.nonNull(right) ?
                    ("，右:" + right) : "") + "}";
        }

    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        insertNode(null, n1);
        insertNode(n1, n2);
        insertNode(n1, n3);

        System.out.println(n1);
        System.out.println(searchNode(n1, 2));
        System.out.println(deleteNode(n1, 2));
    }


    public static TreeNode deleteNode(TreeNode root, int val) {
        if (Objects.isNull(root)) {
            return null;
        }

        Tuple2<TreeNode, TreeNode> treeNodeTuple2 = searchNode(root, val);

        if (Objects.isNull(treeNodeTuple2)) {
            //找不到就不删除
            return root;
        }

        TreeNode parent = treeNodeTuple2.getKey();
        TreeNode node = treeNodeTuple2.getValue();
        if (Objects.isNull(parent)) {
            //没有父 说明它就是根
            //那么就把他的左节点当成新的根
            node.left.right = node.right;
            return node.left;
        }


        //如果不是空，说明是非根节点
        if(Objects.nonNull(parent.left) && parent.left.equals(node)){
            parent.left = Objects.isNull(node.left)
                    ? node.right : node.left;
        } else {
            parent.right = Objects.isNull(node.left)
                    ? node.right : node.left;
        }
        //那么就把他的左节点当成新的根
        return root;
    }

    public static Tuple2<TreeNode, TreeNode> searchNode(TreeNode root, int val) {
        if (Objects.isNull(root)) {
            return null;
        }

        if (root.val == val) {
            return Tuple2.of(null, root);
        }

        if (Objects.nonNull(root.right) && root.right.val == val) {
            return Tuple2.of(root, root.right);
        }

        if (Objects.nonNull(root.left) && root.left.val == val) {
            return Tuple2.of(root, root.left);
        }

        if (root.right.val < val) {
            return searchNode(root.right, val);
        }

        if (root.left.val > val) {
            return searchNode(root.left, val);
        }

        return null;
    }


    public static void insertNode(TreeNode root, TreeNode newNode) {
        if (root == null) {
            return;
        }

        if (root.val > newNode.val) {
            if (root.left == null) {
                root.left = newNode;
            } else {
                insertNode(root.left, newNode);
            }
        } else {
            if (root.right == null) {
                root.right = newNode;
            } else {
                insertNode(root.right, newNode);
            }
        }
    }
}
