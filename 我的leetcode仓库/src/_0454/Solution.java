package _0454;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, 1);
                } else {
                    map.put(sum, map.get(sum) + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int find = 0 - C[i] - D[j];
                if (map.containsKey(find)) {
                    res = res + map.get(find);
                }
            }
        }
        return res;
    }
}

