package com.peigongdh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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

        boolean isPalindrome(int x) {
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
            for (Integer aList : list) {
                reverseX *= 10;
                reverseX += aList;
            }

            return reverseX == x;
        }
    }
}