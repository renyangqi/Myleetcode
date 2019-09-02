package _0347;

import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        int key;
        int freq;

        public Pair(int key, int freq) {
            this.key = key;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair o) {
            return this.freq - o.freq;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (!map.containsKey(a)) {
                map.put(a, 1);
            } else {
                map.put(a, map.get(a) + 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Queue<Pair> queue = new PriorityQueue<Pair>();

        for (Map.Entry<Integer, Integer> entry : entries) {
            if (queue.size() == k) {
                Pair first = queue.peek();
                if (first.freq < entry.getValue()) {
                    queue.poll();
                    queue.add(new Pair(entry.getKey(), entry.getValue()));
                }
            } else {
                queue.add(new Pair(entry.getKey(), entry.getValue()));
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Pair pair : queue) {
            list.add(pair.key);
        }

        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 1, 1, 2, 2, 3};
        List<Integer> list = solution.topKFrequent(arr, 2);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
