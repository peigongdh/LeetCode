package com.peigongdh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SameTree_100 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode stringToTreeNode(String input) {
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode p = stringToTreeNode(line);
            line = in.readLine();
            TreeNode q = stringToTreeNode(line);

            boolean ret = new Solution().isSameTree(p, q);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }

    static class Solution {

        boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q != null) {
                return false;
            }
            if (p != null && q == null) {
                return false;
            }
            if (p == null && q == null) {
                return true;
            }

            // now only remained p != null && q != null
            if (p.val == q.val) {
                boolean isLeftTreeSame = isSameTree(p.left, q.left);
                boolean isRightTreeSame = isSameTree(p.right, q.right);
                return isLeftTreeSame && isRightTreeSame;
            } else {
                return false;
            }
        }

    }

}
