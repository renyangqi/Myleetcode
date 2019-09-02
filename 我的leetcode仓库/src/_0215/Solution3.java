package _0215;

public class Solution3 {
    public int findKthLargest(int[] nums, int k) {
        int kthLargest = findKthLargest(nums, k, 0, nums.length - 1);
        return kthLargest;
    }

    //��nums�����[l,r]�У����ص�k���Ԫ��
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
        // �����arr[l...r]�ķ�Χ��, ѡ��һ����ֵ��Ϊ�궨��pivot
        swap(nums, l, (int) (Math.random() * (r - l + 1)) + l);

        int v = nums[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l + 1, j = r;
        while (true) {
            // ע������ı߽�, arr[i].compareTo(v) < 0, ������arr[i].compareTo(v) <= 0
            // ˼��һ��Ϊʲô?
            while (i <= r && nums[i] < v)
                i++;

            // ע������ı߽�, arr[j].compareTo(v) > 0, ������arr[j].compareTo(v) >= 0
            // ˼��һ��Ϊʲô?
            while (j >= l + 1 && nums[j] > v)
                j--;

            // ��������������߽���趨, �е�ͬѧ�ڿγ̵��ʴ����кܺõĻش�:)
            // ��ҿ��Բο�: http://coding.imooc.com/learn/questiondetail/4920.html

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
