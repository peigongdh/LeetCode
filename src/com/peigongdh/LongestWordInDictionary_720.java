package com.peigongdh;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary_720 {

    public static void main(String[] args) {
        // String[] words = {"w", "wo", "wor", "worl", "world"};
        // String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String[] words = {"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        String result = new Solution().longestWord(words);
        System.out.println(result);
    }

    static class Solution {
        String longestWord(String[] words) {
            Arrays.sort(words);
            String targetWord = "";

            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if ("".equals(targetWord)) {
                        targetWord = words[i];
                        continue;
                    }
                    if (words[i].indexOf(words[j]) == 0) {
                        // System.out.println(words[i] + "  " + words[j] + "  " + targetWord + "  " + words[i].compareTo(targetWord));
                        if (words[i].length() > targetWord.length()) {
                            targetWord = words[i];
                        } else if (words[i].length() == targetWord.length()) {
                            if (words[i].compareTo(targetWord) < 0) {
                                targetWord = words[i];
                            }
                        }
                    }
                }
            }

            return targetWord;
        }

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
    }
}
