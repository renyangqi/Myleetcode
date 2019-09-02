package _0017;
import java.util.ArrayList;
import java.util.List;
/**
 *
 *                                         递归树形问题
 *                                             2
 *                                 a /       b|       c\
 *                            3             3              3
 *                      d /  e|  f\    d /  e|  f\    d /  e|  f\
 *
 *                      手机号码为2 对应的字符串为 a b c 因此根据我注释画的图
 *                      可以划分成 以 a b c 三个根节点对应的三个子树
 *
 *                      将问题化成求每一个子树从顶点到叶子结点的所有路径，将所有路径
 *                      放在一个LIst<String>的集合中
 *                      注意 我在这里是将注释中的图中的边 作为树的结点 而不是以数字 2 3为结点
 *
 *                      举个例子 传入的是"23" 要求返回的是 ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 *                      根据递归找到 "3" 这个数字对应的各树  分别是 d树 e树 f树 他们就是叶子结点所以返回["d","e","f"]
 *                      之后是 "2" 这个数字对应的3个子树的根节点 为 a b c
 *                      再将字符串"abc"用循环   将a和[d,e,f]组合 生成["ad", "ae", "af"] 将每一个元素加入list集合
 *                      继续循环                将b和[d,e,f]组合 生成[bd", "be", "bf"   将每一个元素加入list集合
 *                      继续循环                将c和[d,e,f]组合 生成"cd", "ce", "cf"]] 将每一个元素加入list集合
 *
 */
class Solution {
    //数字 字符串映射表
    private String[] letterMap = {
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    // leetcode要求编写的函数 返回包含所有路径的集合
    public List<String> letterCombinations(String digits) {
        //如果数字字符串为空返回一个空的集合
        if (digits.equals("") || digits == null) {
            return new ArrayList<String>();
        }
        //这个函数的语义是 寻找每一个数字对应的所有子树从根节点到叶子结点的所有路径 返回该路径的list
        // 2 对应 a b c 三棵子树
        List<String> ret = findCombinations(digits, 0);
        return ret;
    }

    //根据digits.charAt(index)找到对应的英文字符串 比如a 对应 “abc”
    // 根据英文字符串 取出英文字符串的每一个字母 比如"abc" 分别取出 a b c
    //寻找分别以 a，b,c为根节点的树从顶点到叶子结点的所有路径 返回该路径的集合
    private List<String> findCombinations(String digits, int index) {
        List<String> res = new ArrayList<String>();
        //递归到底的情况 当数字是最后一个数字时,将其对应字符串的每一个字符放入list并返回
        if (index == digits.length() - 1) {
            char c = digits.charAt(index);
            String letter = letterMap[c - '0'];
            for (int i = 0; i < letter.length(); i++) {
                res.add(letter.charAt(i) + "");
            }
            return res;
        }
        char c = digits.charAt(index);
        // 数字对应的字符串 2对应 "abc"
        String letter = letterMap[c - '0'];
        //最上方注释中说过的返回 ["d","e","f"]
        List<String> combinations = findCombinations(digits, index + 1);
        //再将字符串"abc"用循环   将a和[d,e,f]组合 生成["ad", "ae", "af"] 将每一个元素加入list集合
        //继续循环                将b和[d,e,f]组合 生成[bd", "be", "bf"   将每一个元素加入list集合
        //继续循环                将c和[d,e,f]组合 生成"cd", "ce", "cf"]] 将每一个元素加入list集合
        for (int i = 0; i < letter.length(); i++) {
            for (int j = 0; j < combinations.size(); j++) {
                String s = combinations.get(j);
                s = letter.charAt(i) + s;
                res.add(s);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.letterCombinations("234");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}