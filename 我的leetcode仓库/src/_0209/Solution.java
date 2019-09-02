package _0209;


public class Solution {
    public static int minSubArrayLen(int s, int[] nums) {
        //leetcode 209 用滑动窗口时...if else的使用细节
        int l = 0;
        int r = -1;//在[l,r]区间内求数组和
        int ret = nums.length + 1;
        int sum = 0;
        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s) {
                r++;
                sum = sum + nums[r];
            } else {
                //这里不能写成else if(nums>=s)
                // 因为当sum-nums[l]后此时sum<s ，继续while循环。
                // 但执行到if (r + 1 < nums.length && sum < s)
                //如果r+1<nums.length不成立 那么直接进入到else if(sum>=s)
                //此时sum<s 因此注释下面这行 l++ 这个代码就不会更新
                //while 循环条件l < nums.length永远成立，变成死循环
                //因此如果写成else if的样子的话，只能写成 else if (sum >= s || sum < s)
                //那还不如不写成else if的形式 直接用老师的 else直接搞定
                //这样else里面的l++一定会执行到
                // 这个while(l < nums.length)的循环条件要想结束循环，必须在 r=nums.length-1时,l不断自增
                //一旦出现l++执行不到的情况，变成死循环就惨了
                //QAQ血的教训
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
