package _0001;

import java.util.Arrays;
import java.util.UUID;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;

    }

    public static void main(String[] args) {
        String s = UUID.randomUUID().toString();
        System.out.println(s);
    }
}
