package com.peigongdh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class LongestUnivaluePath_687 {

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

            int ret = new Solution().longestUnivaluePath(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

    static class Solution {

        int longestUnivaluePath(TreeNode root) {

        }

        int longestUnivaluePath(TreeNode root, int target) {
            int length = 0;

            if (root == null) {
                return 0;
            }

            if (root.val == target) {
                if (root.left != null) {
                    length = 1 + longestUnivaluePath(root.left, target);
                }
                if (root.right != null) {
                    length += 1 + longestUnivaluePath(root.right, target);
                }
            } else {
                length = Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right));
            }

            return length;
        }
    }

}
