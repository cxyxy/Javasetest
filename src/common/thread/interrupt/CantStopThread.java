package common.thread.interrupt;

/**
 * 3. 无法停止的线程
 *
 * @author futao
 * @date 2020/6/6
 */
public class CantStopThread {

    public static void main(String[] args) throws InterruptedException {

        //结果：：slee()响应了中断，打印了异常堆栈。但是线程并没有停下来，而是继续执行。就像什么都没有发生一样。
        Thread thread = new Thread(() -> {
            int num = 1;
            while (num <= 1000 && !Thread.currentThread().isInterrupted()) {
                if (num % 2 == 0) {
                    System.out.println(num + "是2的整数倍");
                }
                ++num;
                //查看sleep()方法的描述：当InterruptedException异常被抛出后，线程的中断状态将被清除。
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程执行完毕");
        });

        //启动线程
        thread.start();
        //主线程休眠500毫秒
        Thread.sleep(500L);
        //中断线程
        thread.interrupt();
    }

    /**
     * 类似的会响应中断的方法还有那些？
     * 响应中断的方法总结
     * Object.wait()/wait(long)/wait(long,int)
     * Thread.sleep(long)/sleep(long,int)
     * Thread.join()/join(long)/join(long,int)
     * juc.BlockingQueue.take()/put(E)
     * juc.Lock.lockInterruptibly()
     * juc.CountDownLatch.await()
     * juc.CyclicBarrier.await()
     * juc.Exchanger.exchange(V)
     * jio.InterruptibleChannel相关方法
     * jio.Selector相关方法
     */
}