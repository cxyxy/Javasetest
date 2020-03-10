package common;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * User: Amos
 * Date: 2020/3/10
 * Time: 14:15
 */
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
