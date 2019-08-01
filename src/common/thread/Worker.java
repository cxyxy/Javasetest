package common.thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 让线程齐步走
 * User: Amos
 * Date: 2019/4/26
 * Time: 11:25
 */
public class Worker implements Runnable{
    //阑珊
    private CyclicBarrier cb;

    public Worker(CyclicBarrier cb) {
        this.cb = cb;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10000));
            System.out.println(Thread.currentThread().getName()+"到达汇合处");
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
