package com.peigongdh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SecondMinimumNodeInaBinaryTree_671 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new Solution().findSecondMinimumValue(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

    static class Solution {

//        List<Integer> list = new ArrayList<>();
//
//        int findSecondMinimumValue(TreeNode root) {
//            findSecondMinimumValueSub(root);
//            list.sort(Integer::compareTo);
//            int minVal = root.val;
//            for (int i : list) {
//                if (i > minVal) {
//                    return i;
//                }
//            }
//            return -1;
//        }
//
//        void findSecondMinimumValueSub(TreeNode root) {
//            if (root != null) {
//                list.add(root.val);
//                findSecondMinimumValueSub(root.left);
//                findSecondMinimumValueSub(root.right);
//            }
//        }

        int findSecondMinimumValue(TreeNode root) {
            if (root == null) {
                return -1;
            }

            return findSecondMinimumValue(root, root.val);
        }

        int findSecondMinimumValue(TreeNode node, int rootVal) {
            if (node == null) {
                return -1;
            }

            if (node.val != rootVal) {
                return node.val;
            }

            int leftMinVal = findSecondMinimumValue(node.left, rootVal);
            int rightMinVal = findSecondMinimumValue(node.right, rootVal);

            if (leftMinVal == -1) {
                return rightMinVal;
            }

            if (rightMinVal == -1) {
                return leftMinVal;
            }

            return Math.min(leftMinVal, rightMinVal);
        }

    }
}
