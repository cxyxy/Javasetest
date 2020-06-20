package common;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * User: Amos
 * Date: 2020/3/10
 * Time: 14:15
 */

//PriorityQueue实现了一个优先队列：从队首获取元素时，总是获取优先级最高的元素。

//PriorityQueue默认按元素比较的顺序排序（必须实现Comparable接口），也可以通过Comparator自定义排序算法（元素就不必实现Comparable接口）。
public class Test8 {

        public static void main(String[] args) {
            Queue<String> q = new PriorityQueue<>();
            // 添加3个元素到队列:
            q.offer("apple");
            q.offer("pear");
            q.offer("banana");
            System.out.println(q.poll()); // apple
            System.out.println(q.poll()); // banana
            System.out.println(q.poll()); // pear
            System.out.println(q.poll()); // null,因为队列为空
        }

}
