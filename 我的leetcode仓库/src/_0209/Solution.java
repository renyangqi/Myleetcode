package _0209;


public class Solution {
    public static int minSubArrayLen(int s, int[] nums) {
        //leetcode 209 �û�������ʱ...if else��ʹ��ϸ��
        int l = 0;
        int r = -1;//��[l,r]�������������
        int ret = nums.length + 1;
        int sum = 0;
        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s) {
                r++;
                sum = sum + nums[r];
            } else {
                //���ﲻ��д��else if(nums>=s)
                // ��Ϊ��sum-nums[l]���ʱsum<s ������whileѭ����
                // ��ִ�е�if (r + 1 < nums.length && sum < s)
                //���r+1<nums.length������ ��ôֱ�ӽ��뵽else if(sum>=s)
                //��ʱsum<s ���ע���������� l++ �������Ͳ������
                //while ѭ������l < nums.length��Զ�����������ѭ��
                //������д��else if�����ӵĻ���ֻ��д�� else if (sum >= s || sum < s)
                //�ǻ����粻д��else if����ʽ ֱ������ʦ�� elseֱ�Ӹ㶨
                //����else�����l++һ����ִ�е�
                // ���while(l < nums.length)��ѭ������Ҫ�����ѭ���������� r=nums.length-1ʱ,l��������
                //һ������l++ִ�в���������������ѭ���Ͳ���
                //QAQѪ�Ľ�ѵ
                sum = sum - nums[l];
                l++;
            }
            if (sum >= s) {
                ret = Math.min(ret, r - l + 1);
            }
            if (ret == 1) {
                return 1;
            }
        }
        return ret == nums.length + 1 ? 0 : ret;
    }
}
