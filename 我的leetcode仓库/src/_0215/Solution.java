package _0215;

class Solution {
    public static int findKthLargest(int[] nums, int k) {
        //将数组通过partition操作放到排好序时所在的位置返回该位置所在的索引
        int p = partition(nums, 0, nums.length - 1);
        while (p != nums.length - k) {
            if (p < nums.length - k) {
                p = partition(nums, p + 1, nums.length - 1);
            } else {
                p = partition(nums, 0, p - 1);
            }
        }
        return nums[p];
    }

    private static int partition(int[] nums, int l, int r) {
        int e = nums[l];
        //在[l+1..lt]<e
        //在[lt+1...i-1]>e

        int random = (int) (Math.random() * (r - l + 1) + l);
        swap(nums, l, random);

        int lt = l;
        int i = l + 1;
        while (i <= r) {
            if (nums[i] >= e) {
                i++;
            } else {
                swap(nums, lt + 1, i);
                lt++;
                i++;
            }
        }
        swap(nums, l, lt);
        return lt;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int kthLargest = findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }

}