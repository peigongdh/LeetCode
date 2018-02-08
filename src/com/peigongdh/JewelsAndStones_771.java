package com.peigongdh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones_771 {

    public static String stringToString(String input) {
        assert input.length() >= 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < input.length() - 1; i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '\\') {
                char nextChar = input.charAt(i + 1);
                switch (nextChar) {
                    case '\"':
                        sb.append('\"');
                        break;
                    case '/':
                        sb.append('/');
                        break;
                    case '\\':
                        sb.append('\\');
                        break;
                    case 'b':
                        sb.append('\b');
                        break;
                    case 'f':
                        sb.append('\f');
                        break;
                    case 'r':
                        sb.append('\r');
                        break;
                    case 'n':
                        sb.append('\n');
                        break;
                    case 't':
                        sb.append('\t');
                        break;
                    default:
                        break;
                }
                i++;
            } else {
                sb.append(currentChar);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String J = stringToString(line);
            line = in.readLine();
            String S = stringToString(line);

            int ret = new Solution().numJewelsInStones(J, S);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

    static class Solution {

        int numJewelsInStones(String J, String S) {
            Set<Character> jSet = new HashSet<>();
            char[] jArray = J.toCharArray();
            for (char jChar : jArray) {
                jSet.add(jChar);
            }

            char[] sArray = S.toCharArray();
            int count = 0;
            for (char sChar : sArray) {
                if (jSet.contains(sChar)) {
                    count++;
                }
            }
            return count;
        }
    }

}
