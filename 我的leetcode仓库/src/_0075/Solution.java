package _0075;

class Solution {
    public void sortColors(int[] nums) {
        int[] count = {0, 0, 0};
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for (int j = 0; j < count[0]; j++) {
            nums[k++] = 0;
        }
        for (int j = 0; j < count[1]; j++) {
            nums[k++] = 1;
        }
        for (int j = 0; j < count[2]; j++) {
            nums[k++] = 2;
        }
    }

}