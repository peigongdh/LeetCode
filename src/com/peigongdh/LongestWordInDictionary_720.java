package com.peigongdh;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary_720 {

    public static void main(String[] args) {
        // String[] words = {"w", "wo", "wor", "worl", "world"};
        // String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String[] words = {"yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"};
        String result = new Solution().longestWord(words);
        System.out.println(result);
    }

    static class Solution {

//        public String longestWord(String[] words) {
//            Arrays.sort(words);
//            Set<String> built = new HashSet<String>();
//            String res = "";
//            for (String w : words) {
//                if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
//                    res = w.length() > res.length() ? w : res;
//                    built.add(w);
//                }
//            }
//            return res;
//        }

        String longestWord(String[] words) {
            String targetWord = "";
            Set<String> wordSet = new HashSet<>();
            Collections.addAll(wordSet, words);
            for (String word : words) {
                if (word.length() > targetWord.length() || word.length() == targetWord.length() && word.compareTo(targetWord) < 0) {
                    boolean isTargetWord = true;
                    for (int k = 1; k < word.length(); k ++) {
                        if (! wordSet.contains(word.substring(0, k))) {
                            isTargetWord = false;
                            break;
                        }
                    }
                    if (isTargetWord) {
                        targetWord = word;
                    }
                }
            }
            return targetWord;
        }
    }
}
