package Main;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {


        // ʹ��lambda���ʽ�������ײ������ѵ�PriorityQueue
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

        // ʹ���Զ����Comparator���������Ի���PriorityQueue
        // ע�⣺Ҳ����ʹ��lambda���ʽ��������ֻ��Ϊ����ʾPriorityQueue�Ĳ�ͬ�÷�
        // ͬ����һ������Ҳ����ʹ���Զ����Comparator�ķ�ʽ���
        class myCmp implements Comparator<Integer> {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;//a�����bС����һ������,����˵��a�����ȼ�С
                //a�����b�󷵻ص���һ������,���ظ���˵��a�����ȼ���
            }
        }
        PriorityQueue<Integer> pq3 = new PriorityQueue<Integer>(10, new myCmp());


        for (int i = 0; i < 10; i++) {
            int num = (int) (Math.random() * 100);
            pq3.add(num);
          //  System.out.println("insert " + num + " in priority queue.");
        }
        System.out.println("����1");
        Integer[] a = new Integer[pq3.size()];
        Integer[] integer = pq3.toArray(a);

        for (Integer integer1 : integer) {
            System.out.print(integer1+" ");
        }
        System.out.println();
        System.out.println("����2");
        while (!pq3.isEmpty())
            System.out.print(pq3.poll() + " ");

        System.out.println();
        System.out.println();
    }
}
