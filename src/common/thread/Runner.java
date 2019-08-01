package common.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 *
 * 模拟百米赛跑
 * CountDownLatch 来协调子线程
 * User: Amos
 * Date: 2019/4/26
 * Time: 10:41
 */
public class Runner implements Callable<Integer>{
    //开始
    private CountDownLatch begin;
    //结束
    private CountDownLatch end;

    public Runner(CountDownLatch begin, CountDownLatch end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int score = new Random().nextInt(25);
        begin.await();
        System.out.println(Thread.currentThread().getName()+"开始跑步");
        //跑步中
        TimeUnit.MILLISECONDS.sleep(score);
        System.out.println(Thread.currentThread().getName()+"分数为"+score);
        //完成跑步
        end.countDown();
        System.out.println(Thread.currentThread().getName()+"完成跑步");
        return score;
    }
}
