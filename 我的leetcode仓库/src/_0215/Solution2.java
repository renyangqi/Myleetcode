package _0215;

public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        //������ͨ��partition�����ŵ��ź���ʱ���ڵ�λ�÷��ظ�λ�����ڵ�����
        int kthLargest = findKthLargest(nums, k, 0, nums.length - 1);
        return kthLargest;
    }

    private int findKthLargest(int[] nums, int k, int l, int r) {
        int p = partition(nums, l, r);
        if (p == nums.length - k) {
            return nums[p];
        } else if (p < nums.length - k) {
            return findKthLargest(nums, k, p + 1, r);
        } else {
            return findKthLargest(nums, k, l, p - 1);
        }

    }

    private int partition(int[] nums, int l, int r) {
        int random = (int) (Math.random() * (r - l + 1) + l);
        //ע��ֻ��һ��Ԫ�ص��������Բ���д��int random = (int) (l + Math.random() * (r - l)+1)
        swap(nums, l, random);
        int v = nums[l];
        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
        for (int i = l + 1; i <= r; i++)
            if (nums[i] < v) {
                j++;
                swap(nums, j, i);
            }
        swap(nums, l, j);

        return j;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
