package _0026;

class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] != nums[i]) {
                nums[count++] = nums[i + 1];
            }
        }
        return count;
    }
}