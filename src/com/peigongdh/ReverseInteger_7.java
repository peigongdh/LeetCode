package com.peigongdh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReverseInteger_7 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            int ret = new Solution().reverse(x);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

    static class Solution {
        int reverse(int x) {
            int tmpX = x;

            if (x == Integer.MIN_VALUE) {
                return 0;
            }

            boolean isNegative = false;
            if (x < 0) {
                tmpX = -tmpX;
                isNegative = true;
            }

            List<Integer> list = new ArrayList<>();

            while (tmpX != 0) {
                int item = tmpX % 10;
                list.add(item);
                tmpX /= 10;
            }

            int reverseX = 0;
            for (Integer aList : list) {
                long overflows = (long)reverseX * 10 + aList;
                if (overflows > Integer.MAX_VALUE) {
                    return 0;
                }
                reverseX *= 10;
                reverseX += aList;
            }

            if (isNegative) {
                reverseX = -reverseX;
            }

            return reverseX;
        }
    }
}
