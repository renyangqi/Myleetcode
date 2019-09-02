package _0752;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
//leetcode 752号问题
//看bobo敲代码前 自己先写的代码
class Solution2 {
    public int openLock(String[] deadends, String target) {
        //num[i]表示的是从0000 到 i经过几步
        int[] num = new int[100000];
        //deadset存入所有死序列
        HashSet<String> deadset = new HashSet<>();
        for (int i = 0; i < deadends.length; i++) {
            deadset.add(deadends[i]);
        }
        //如果死序列包含"0000",或者目标本身是死亡序列，那就直接返回-1
        if (deadset.contains("0000")||deadset.contains(target)) {
            return -1;
        }
        //初始化是0000 如果目标就是0000 则什么都不用做返回0即可
        if (target.equals("0000")) {
            return 0;
        }
        //visited用于存放转锁产生的各种状态(即图中的点)用于判断新状态是否访问过
        HashSet<String> visited = new HashSet<>();
        //初始状态
        String state = "0000";


        //下面代码进行队列进行广度优先遍历
        Queue<String> queue = new LinkedList<>();
        queue.add(state);
        visited.add(state);
        while (!queue.isEmpty()) {
            String cur = queue.remove();
            for (int i = 0; i < 4; i++) {
                //对第一个位置到第四个位置 将数字分别向上和向下拨动
                String next1 = change(cur, i, 1);
                String next2 = change(cur, i, -1);
                //如果新状态之前没有过,并且新状态不是死亡数字那就放入队列和set1中
                if (!visited.contains(next1) && !deadset.contains(next1)) {
                    queue.add(next1);
                    visited.add(next1);
                    //步数更新为 "0000"到上一个状态的步数再加1
                    num[Integer.parseInt(next1)] = num[Integer.parseInt(cur)] + 1;
                }

                if (!visited.contains(next2) && !deadset.contains(next2)) {
                    queue.add(next2);
                    visited.add(next2);
                    num[Integer.parseInt(next2)] = num[Integer.parseInt(cur)] + 1;
                }

            }
            if (cur.equals(target)) {
                break;
            }
        }
        //如果能解开返回最少拨动次数,无论如何都解不开返回-1
        return num[Integer.parseInt(target)] > 0 ? num[Integer.parseInt(target)] : -1;
    }

    // str是状态 比如0000 index代表拨动第几个数字
    // x为+1表示加一,x为-1表示-1 ,比如传入change("0000",0,-1)返回的是9000
    private String change(String str, int index, int x) {
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(sb.append(str.charAt(index)).toString());
        num = (num + 10 + x) % 10;
        sb.deleteCharAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (i == index) {
                sb.append(num);
                continue;
            }
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        int x = s.openLock(deadends, target);
        System.out.println(x);
    }
}