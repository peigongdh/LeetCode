package com.peigongdh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

        Map<Integer, Integer> map = new HashMap<>();

        int longestUnivaluePath(TreeNode root) {
            longestUnivaluePathSub(root);
            int max = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                }
            }
            return max;
        }

        void longestUnivaluePathSub(TreeNode root) {
            if (root != null) {
                longestUnivaluePathSub(root, root.val);
                longestUnivaluePathSub(root.left);
                longestUnivaluePathSub(root.right);
            }
        }

        int longestUnivaluePathSub(TreeNode root, int target) {
            int length = 0;

            if (root != null) {
                if (root.val == target) {
                    if (root.left != null) {
                        if (root.left.val == target) {
                            length = 1 + longestUnivaluePathSub(root.left, target);
                        }
                    }
                    if (root.right != null) {
                        if (root.right.val == target) {
                            length += 1 + longestUnivaluePathSub(root.right, target);
                        }
                    }
                }
            }

            if (!map.containsKey(target)) {
                map.put(target, length);
            } else {
                if (length > map.get(target)) {
                    map.put(target, length);
                }
            }

            return length;
        }
    }

}
