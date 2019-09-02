package _0001;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int item = target - nums[i];
            if (map.containsKey(item)) {
                int[] arr = {map.get(item), i};
                return arr;
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int[] ints = twoSum(arr, 9);
    }
}
