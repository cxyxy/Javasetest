package common.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: Amos
 * Date: 2019/6/26
 * Time: 15:37
 */
public class T {


    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        pool.submit(()->{
            try {
                String qq=pool.submit(()->"QQ").get();
                System.out.println(qq);
            } catch (Exception e) {
            }
        });
    }

}
