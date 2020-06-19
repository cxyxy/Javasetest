package common.thread.interrupt;

/**
 * 正确停止线程---run()方法内没有sleep()或者wait()方法-未处理中断信号
 *
 * @author futao
 * @date 2020/6/6
 */
public class StopThreadWithoutSleepWait implements Runnable {

    @Override
    public void run() {
        unHandleInterrupt();
    }

    /**
     * 未处理中断
     */
    public void unHandleInterrupt() {
        int num = 0;
        //打印最大整数一半的范围内10000的倍数
//        while (num <= Integer.MAX_VALUE / 2) {
        //1.加入响应中断判断
        while (!Thread.currentThread().isInterrupted() &&num <= Integer.MAX_VALUE / 2) {
            if (num % 10000 == 0) {
                System.out.println(num + "是10000倍数");
            }
            ++num;

        }
        System.out.println("任务执行完毕");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopThreadWithoutSleepWait());
        //启动线程
        thread.start();
        //增加子线程处于运行状态的可能性
        Thread.sleep(500L);
        //尝试中断子线程
        thread.interrupt();
    }
}