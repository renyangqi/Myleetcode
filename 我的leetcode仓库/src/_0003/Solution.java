package _0003;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = -1;//�������ڵķ�Χ��[l,r] �տ�ʼΪ��
        int[] rec = new int[256];
        int ret = 0;
        while (l < s.length()) {
            if (r + 1 < s.length() && rec[s.charAt(r + 1)] == 0) {
                r++;
                rec[s.charAt(r)] = 1;
            } else {
                rec[s.charAt(l)] = 0;
                l++;
            }
            ret = Math.max(ret, r - l + 1);
        }
        return ret;
    }
}
