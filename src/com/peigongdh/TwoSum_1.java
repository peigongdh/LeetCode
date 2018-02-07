package com.peigongdh;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 */

public class TwoSum_1 {

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        int[] result = new Solution().twoSum(nums, target);
        System.out.println(Arrays.toString(result));

        int[] result2 = new Solution().twoSum2(nums, target);
        System.out.println(Arrays.toString(result2));

        int[] result3 = new Solution().twoSum3(nums, target);
        System.out.println(Arrays.toString(result3));
    }
}

class Solution {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numsToMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsToMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int needNum = target - nums[i];
            if (numsToMap.containsKey(needNum)) {
                int otherIndex = numsToMap.get(needNum);

                // cannot use twice
                if (otherIndex == i) {
                    continue;
                }

                return new int[]{i, otherIndex};
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> numsToMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int needNum = target - nums[i];
            if (numsToMap.containsKey(needNum)) {
                int otherIndex = numsToMap.get(needNum);

                // cannot use twice
                if (otherIndex == i) {
                    continue;
                }

                return new int[]{i, otherIndex};
            }
            numsToMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}