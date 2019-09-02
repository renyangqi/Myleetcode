package _0215;

public class Solution3 {
    public int findKthLargest(int[] nums, int k) {
        int kthLargest = findKthLargest(nums, k, 0, nums.length - 1);
        return kthLargest;
    }

    //在nums数组的[l,r]中，返回第k大的元素
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
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(nums, l, (int) (Math.random() * (r - l + 1)) + l);

        int v = nums[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l + 1, j = r;
        while (true) {
            // 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            // 思考一下为什么?
            while (i <= r && nums[i] < v)
                i++;

            // 注意这里的边界, arr[j].compareTo(v) > 0, 不能是arr[j].compareTo(v) >= 0
            // 思考一下为什么?
            while (j >= l + 1 && nums[j] > v)
                j--;

            // 对于上面的两个边界的设定, 有的同学在课程的问答区有很好的回答:)
            // 大家可以参考: http://coding.imooc.com/learn/questiondetail/4920.html

            if (i > j)
                break;

            swap(nums, i, j);
            i++;
            j--;
        }

        swap(nums, l, j);

        return j;
    }

    //     4 1 2 3 9 5 6 7
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
