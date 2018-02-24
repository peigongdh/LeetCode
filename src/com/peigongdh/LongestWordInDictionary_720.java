package com.peigongdh;

import java.util.*;

public class LongestWordInDictionary_720 {

    public static void main(String[] args) {
        // String[] words = {"w", "wo", "wor", "worl", "world"};
        // String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String[] words = {"yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"};
        String result = new Solution().longestWord(words);
        System.out.println(result);
    }

    static class Solution {

//        String longestWord(String[] words) {
//            Arrays.sort(words);
//            Set<String> built = new HashSet<>();
//            String res = "";
//            for (String w : words) {
//                if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
//                    res = w.length() > res.length() ? w : res;
//                    built.add(w);
//                }
//            }
//            return res;
//        }

//        String longestWord(String[] words) {
//            String targetWord = "";
//            Set<String> wordSet = new HashSet<>();
//            Collections.addAll(wordSet, words);
//            for (String word : words) {
//                if (word.length() > targetWord.length() || word.length() == targetWord.length() && word.compareTo(targetWord) < 0) {
//                    boolean isTargetWord = true;
//                    for (int k = 1; k < word.length(); k ++) {
//                        if (! wordSet.contains(word.substring(0, k))) {
//                            isTargetWord = false;
//                            break;
//                        }
//                    }
//                    if (isTargetWord) {
//                        targetWord = word;
//                    }
//                }
//            }
//            return targetWord;
//        }

        String longestWord(String[] words) {
            Trie trie = new Trie();
            int index = 0;
            for (String word : words) {
                trie.insert(word, ++index); //indexed by 1
            }
            trie.words = words;
            return trie.dfs();
        }
    }

    static class Node {
        char c;
        Map<Character, Node> children = new HashMap();
        int end;

        Node(char c) {
            this.c = c;
        }
    }

    static class Trie {
        Node root;
        String[] words;

        Trie() {
            root = new Node('0');
        }

        public void insert(String word, int index) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                cur.children.putIfAbsent(c, new Node(c));
                cur = cur.children.get(c);
            }
            cur.end = index;
        }

        // 按层遍历，只选取有数字的节点(node.end > 0)
        public String dfs() {
            String ans = "";
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.empty()) {
                Node node = stack.pop();
                if (node.end > 0 || node == root) {
                    if (node != root) {
                        String word = words[node.end - 1];
                        if (word.length() > ans.length() ||
                                word.length() == ans.length() && word.compareTo(ans) < 0) {
                            ans = word;
                        }
                    }
                    for (Node nei : node.children.values()) {
                        stack.push(nei);
                    }
                }
            }
            return ans;
        }
    }
}
