package _0075;


public class Solution2 {
    public void sortColors(int[] nums) {
        int l = 0;
        int zero = -1;//在[l...zero]为<1
        int two = nums.length;
        int r = nums.length - 1;//在[two...r]为>1
        //在[zero...i-1]等于1
        for (int i = 0; i < two; i++) {
            if (nums[i] == 1) {
            } else if (nums[i] < 1) {
                swap(nums, zero + 1, i);
                zero++;
            } else {
                swap(nums, i, two - 1);
                two--;
                i--;
            }
        }


    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
