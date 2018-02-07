package com.peigongdh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class PalindromeNumber_9 {

    private static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            boolean ret = new Solution().isPalindrome(x);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }

    static class Solution {

        public boolean isPalindrome(int x) {
            int tmpX = x;

            List<Integer> list = new ArrayList<>();

            if (x < 0) {
                return false;
            }

            while (tmpX != 0) {
                int item = tmpX % 10;
                list.add(item);
                tmpX /= 10;
            }

            int reverseX = 0;
            ListIterator<Integer> li = list.listIterator();
            while (li.hasNext()) {
                reverseX *= 10;
                reverseX += li.next();
            }

            return reverseX == x;
        }
    }
}