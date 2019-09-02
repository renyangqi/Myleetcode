package _0003;

import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public static int lengthOfLongestSubstring(String s) {
        char[] sc = s.toCharArray();//在区间[j,i]左闭右闭的范围内是滑动窗口
        Map<Character, Integer> cm = new HashMap<Character, Integer>();
        int j = 0, maxLen = 0;
        String str = "";
        for (int i = 0; i < sc.length; ++i) {
            char cur = sc[i];
            if (cm.containsKey(cur)) {
                j = Math.max(j, cm.get(cur) + 1);
            }
            cm.put(cur, i);
            maxLen = Math.max(i - j + 1, maxLen);
            str = str.length() >= i - j + 1 ? str : s.substring(j, i + 1);
        }
        System.out.println(str);
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        lengthOfLongestSubstring(s);
        s = "bbbbb";
        lengthOfLongestSubstring(s);
        s = "pwwkew";
        lengthOfLongestSubstring(s);
    }
}