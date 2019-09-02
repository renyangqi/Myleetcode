package Main;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {


        // 使用lambda表达式，创建底层是最大堆的PriorityQueue
       /* PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(10, (a, b) -> b - a);

        for(int i = 0 ; i < 10 ; i ++){
            int num = (int)(Math.random() * 100);
            pq2.add(num);
            System.out.println("insert " + num + " in priority queue.");
        }

        while (!pq2.isEmpty())
            System.out.print(pq2.poll() + " ");

        System.out.println();
        System.out.println();
*/

        // 使用自定义的Comparator，创建个性化的PriorityQueue
        // 注意：也可以使用lambda表达式。在这里只是为了演示PriorityQueue的不同用法
        // 同理，上一个例子也可以使用自定义的Comparator的方式完成
        class myCmp implements Comparator<Integer> {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;//a如果比b小返回一个正数,正数说明a的优先级小
                //a如果比b大返回的是一个负数,返回负数说明a的优先级大
            }
        }
        PriorityQueue<Integer> pq3 = new PriorityQueue<Integer>(10, new myCmp());


        for (int i = 0; i < 10; i++) {
            int num = (int) (Math.random() * 100);
            pq3.add(num);
          //  System.out.println("insert " + num + " in priority queue.");
        }
        System.out.println("数组1");
        Integer[] a = new Integer[pq3.size()];
        Integer[] integer = pq3.toArray(a);

        for (Integer integer1 : integer) {
            System.out.print(integer1+" ");
        }
        System.out.println();
        System.out.println("数组2");
        while (!pq3.isEmpty())
            System.out.print(pq3.poll() + " ");

        System.out.println();
        System.out.println();
    }
}
