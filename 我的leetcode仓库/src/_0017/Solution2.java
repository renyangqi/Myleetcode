package _0017;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
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


    public List<String> letterCombinations(String digits) {
        if (digits.equals("") || digits == null) {
            return new ArrayList<String>();
        }
        List<String> res = findCombinations(digits, 0);
        return res;
    }

    private List<String> findCombinations(String digits, int index) {
        List<String> res = new ArrayList<String>();
        if (index == digits.length() - 1) {
            char c = digits.charAt(index);
            String letter = letterMap[c - '0'];
            for (int i = 0; i < letter.length(); i++) {
                res.add(letter.charAt(i) + "");
            }
            return res;
        }
        char c = digits.charAt(index);
        String letter = letterMap[c - '0'];
        List<String> combinations = findCombinations(digits, index + 1);
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
