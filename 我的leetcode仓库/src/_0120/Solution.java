package _0120;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int res = 0;

    public int minimumTotal(List<List<Integer>> triangle) {
        return res;
    }

    public static void main(String[] args) {
        List list0 = new ArrayList();
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        List list3 = new ArrayList();

        list0.add(2);
        list1.add(3);
        list1.add(4);
        list2.add(6);
        list2.add(5);
        list2.add(7);
        list3.add(4);
        list3.add(1);
        list3.add(8);
        list3.add(3);

        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(list0);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        Solution s = new Solution();
        int i = s.minimumTotal(lists);
        System.out.println(i);
    }
}
