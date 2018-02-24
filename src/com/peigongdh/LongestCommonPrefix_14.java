package com.peigongdh;

import java.util.*;

public class LongestCommonPrefix_14 {

    public static void main(String[] args) {
        String[] words = {"aa", "ab"};
        String result = new Solution().longestCommonPrefix(words);
        System.out.println(result);
    }

    static class Solution {

        String longestCommonPrefix(String[] strs) {
            String targetPrefix = "";
            for (String str : strs) {

                if ("".equals(str)) {
                    targetPrefix = str;
                    break;
                }

                if ("".equals(targetPrefix)) {
                    targetPrefix = str;
                    continue;
                }

                while (str.indexOf(targetPrefix) != 0) {
                    if (targetPrefix.length() <= 1) {
                        return "";
                    } else {
                        targetPrefix = targetPrefix.substring(0, targetPrefix.length() - 1);
                    }
                }
            }
            return targetPrefix;
        }

    }

//    static class Solution {
//
//        String longestCommonPrefix(String[] strs) {
//            Trie trie = new Trie();
//            for (String str : strs) {
//                trie.insert(str);
//            }
//            trie.strs = strs;
//            return trie.dfs();
//        }
//
//    }
//
//    static class Node {
//
//        char c;
//        int count;
//        Map<Character, Node> children = new HashMap<>();
//
//        Node(char c) {
//            this.c = c;
//            this.count = 0;
//        }
//    }
//
//    static class Trie {
//
//        Node root;
//        String[] strs;
//
//        Trie() {
//            root = new Node(' ');
//        }
//
//        public void insert(String word) {
//            Node cur = root;
//            for (char c : word.toCharArray()) {
//                cur.children.putIfAbsent(c, new Node(c));
//                cur = cur.children.get(c);
//                cur.count += 1;
//            }
//        }
//
//        public String dfs() {
//            StringBuilder ans = new StringBuilder();
//            Stack<Node> stack = new Stack<>();
//            stack.push(root);
//            while (!stack.empty()) {
//                Node node = stack.pop();
//                if (node.count > 0 || node == root) {
//                    if (node != root) {
//                        if (node.count == strs.length) {
//                            ans.append(node.c);
//                        }
//                    }
//                    for (Node nei : node.children.values()) {
//                        stack.push(nei);
//                    }
//                }
//            }
//            return ans.toString();
//        }
//    }
}
