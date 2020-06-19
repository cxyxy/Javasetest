package common.thread.interrupt;

/**
 * 线程中断的相关方法
 *
 * @author futao
 * @date 2020/6/7
 */
public class InterruptMethod {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("线程任务执行中...");
            while (true) {
            }
        });

        //启动线程
        thread.start();
        System.out.println(thread.isInterrupted());
        //向线程发送中断信号
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        System.out.println(thread.isInterrupted());
        System.out.println(Thread.interrupted());
        System.out.println(thread.isInterrupted());
        //如果子线程对象直接调用静态方法interrupted()，
        // 返回的也是执行这段代码的线程的中断状态。此时为主线程，状态为未中断。
        System.out.println(thread.interrupted());
        System.out.println(thread.isInterrupted());
    }


    /**
     * thread.interrupt() 给线程发送中断信号，设置线程thread的中断状态为true。
     * thread.isInterrupted() 判断线程thread是否被中断。且不改变线程的中断状态
     * Thread.interrupted()/thread.interrupted() 判断执行这行代码的线程的中断状态，并且清除其中断状态。
     * private native boolean isInterrupted(boolean ClearInterrupted); native方法，真正判断线程中断状态和清除中断状态的代码。
     * thread.isInterrupted()和Thread.interrupted()/thread.interrupted()最终调用的都是这个方法。
     *
     * 被弃用的stop()，suspend()和resume()
     * 使用volatile设置boolean标记位的方式，不可靠
     */
}