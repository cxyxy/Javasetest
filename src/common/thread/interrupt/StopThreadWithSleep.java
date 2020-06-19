package common.thread.interrupt;

public class StopThreadWithSleep {
    public static void main(String[] args) throws InterruptedException {

        //程序执行完while循环之后，阻塞在sleep()方法，此时进行中断，sleep()方法响应该中断，
        // 抛出InterruptedException，打印异常堆栈。
        Thread thread = new Thread(() -> {
            int num = 0;
            while (!Thread.currentThread().isInterrupted() && num <= 300) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的整数倍");
                }
                ++num;
            }
            try {
                //sleep()方法会响应中断，且响应中断的方式为抛出InterruptException异常--- sleep interrupted
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程执行完毕");
        });
        //启动线程
        thread.start();
        //等待while循环执行完毕
        Thread.sleep(200L);
        //当线程处于sleep()状态时进行中断
        thread.interrupt();
    }
}