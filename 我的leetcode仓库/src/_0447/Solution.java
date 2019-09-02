package _0447;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ret = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int dis2 = dis(points[i], points[j]);
                    if (!map.containsKey(dis2)) {
                        map.put(dis2, 1);
                    } else {
                        map.put(dis2, map.get(dis2) + 1);
                    }
                }
            }
            for (Integer value : map.values()) {
                ret += value * (value - 1);
            }
        }
        return ret;
    }

    private static int dis(int[] point, int[] point1) {
        return (point[0] - point1[0]) * (point[0] - point1[0]) + (point[1] - point1[1]) * (point[1] - point1[1]);
    }
}