package _0017;
import java.util.ArrayList;
import java.util.List;
/**
 *
 *                                         �ݹ���������
 *                                             2
 *                                 a /       b|       c\
 *                            3             3              3
 *                      d /  e|  f\    d /  e|  f\    d /  e|  f\
 *
 *                      �ֻ�����Ϊ2 ��Ӧ���ַ���Ϊ a b c ��˸�����ע�ͻ���ͼ
 *                      ���Ի��ֳ� �� a b c �������ڵ��Ӧ����������
 *
 *                      �����⻯����ÿһ�������Ӷ��㵽Ҷ�ӽ�������·����������·��
 *                      ����һ��LIst<String>�ļ�����
 *                      ע�� ���������ǽ�ע���е�ͼ�еı� ��Ϊ���Ľ�� ������������ 2 3Ϊ���
 *
 *                      �ٸ����� �������"23" Ҫ�󷵻ص��� ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 *                      ���ݵݹ��ҵ� "3" ������ֶ�Ӧ�ĸ���  �ֱ��� d�� e�� f�� ���Ǿ���Ҷ�ӽ�����Է���["d","e","f"]
 *                      ֮���� "2" ������ֶ�Ӧ��3�������ĸ��ڵ� Ϊ a b c
 *                      �ٽ��ַ���"abc"��ѭ��   ��a��[d,e,f]��� ����["ad", "ae", "af"] ��ÿһ��Ԫ�ؼ���list����
 *                      ����ѭ��                ��b��[d,e,f]��� ����[bd", "be", "bf"   ��ÿһ��Ԫ�ؼ���list����
 *                      ����ѭ��                ��c��[d,e,f]��� ����"cd", "ce", "cf"]] ��ÿһ��Ԫ�ؼ���list����
 *
 */
class Solution {
    //���� �ַ���ӳ���
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

    // leetcodeҪ���д�ĺ��� ���ذ�������·���ļ���
    public List<String> letterCombinations(String digits) {
        //��������ַ���Ϊ�շ���һ���յļ���
        if (digits.equals("") || digits == null) {
            return new ArrayList<String>();
        }
        //��������������� Ѱ��ÿһ�����ֶ�Ӧ�����������Ӹ��ڵ㵽Ҷ�ӽ�������·�� ���ظ�·����list
        // 2 ��Ӧ a b c ��������
        List<String> ret = findCombinations(digits, 0);
        return ret;
    }

    //����digits.charAt(index)�ҵ���Ӧ��Ӣ���ַ��� ����a ��Ӧ ��abc��
    // ����Ӣ���ַ��� ȡ��Ӣ���ַ�����ÿһ����ĸ ����"abc" �ֱ�ȡ�� a b c
    //Ѱ�ҷֱ��� a��b,cΪ���ڵ�����Ӷ��㵽Ҷ�ӽ�������·�� ���ظ�·���ļ���
    private List<String> findCombinations(String digits, int index) {
        List<String> res = new ArrayList<String>();
        //�ݹ鵽�׵���� �����������һ������ʱ,�����Ӧ�ַ�����ÿһ���ַ�����list������
        if (index == digits.length() - 1) {
            char c = digits.charAt(index);
            String letter = letterMap[c - '0'];
            for (int i = 0; i < letter.length(); i++) {
                res.add(letter.charAt(i) + "");
            }
            return res;
        }
        char c = digits.charAt(index);
        // ���ֶ�Ӧ���ַ��� 2��Ӧ "abc"
        String letter = letterMap[c - '0'];
        //���Ϸ�ע����˵���ķ��� ["d","e","f"]
        List<String> combinations = findCombinations(digits, index + 1);
        //�ٽ��ַ���"abc"��ѭ��   ��a��[d,e,f]��� ����["ad", "ae", "af"] ��ÿһ��Ԫ�ؼ���list����
        //����ѭ��                ��b��[d,e,f]��� ����[bd", "be", "bf"   ��ÿһ��Ԫ�ؼ���list����
        //����ѭ��                ��c��[d,e,f]��� ����"cd", "ce", "cf"]] ��ÿһ��Ԫ�ؼ���list����
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