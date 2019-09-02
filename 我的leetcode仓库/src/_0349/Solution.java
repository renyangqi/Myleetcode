package _0349;

import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        List list = new ArrayList();
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> resultSet = new HashSet<Integer>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                resultSet.add(num);
            }
        }
        int[] arr = new int[resultSet.size()];
        int i = 0;
        for (Integer integer : resultSet) {
            arr[i++] = integer;
        }
        return arr;
    }
}
