package _0077;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    ArrayList<List<Integer>> res;
    ArrayList<Integer> p;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<List<Integer>>();
        p = new ArrayList<Integer>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        generateCombination(arr, 0, p, k);
        return res;
    }

    //当前已经找到的组合存入p中，需要从arr[start]...到arr[last]中取新的元素
    private void generateCombination(int[] arr, int start, ArrayList<Integer> p, int k) {
        if (p.size() == k) {
            res.add((List<Integer>) p.clone());
            return;
        }
        for (int i=start; i < arr.length-(k-p.size())+1; i++) {
            p.add(arr[i]);
            generateCombination(arr, i + 1, p, k);
            p.remove(new Integer(arr[i]));
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> combine = s.combine(5, 3);
        for (List<Integer> list : combine) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
