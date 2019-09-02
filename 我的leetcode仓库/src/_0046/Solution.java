import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res;
    boolean[] used;//判断nums第i个元素有没有添加到长度为index的排列动态数组中
    ArrayList<Integer> p;

    public List<List<Integer>> permute(int[] nums) {

        res = new ArrayList<List<Integer>>();
        p = new ArrayList<Integer>();
        used = new boolean[nums.length];
        generatePermutation(nums, 0, p);
        return res;
    }

    private void generatePermutation(int[] nums, int index, ArrayList<Integer> p) {
        if (p.size() == nums.length) {
            res.add((List<Integer>) p.clone());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                p.add(nums[i]);
                used[i] = true;
                generatePermutation(nums, index + 1, p);
                p.remove(new Integer((nums[i])));
                used[i]=false;
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> permute = solution.permute(new int[]{1, 2, 3});

        for (List<Integer> list : permute) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}