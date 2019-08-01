package common.thread;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class CommunicationInReentrantLock {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();//同步锁对象
        Condition condition = lock.newCondition();//对应于同步锁对象的用于执行等待和通知命令的对象
        CommunicationInReentrantLock cis = new CommunicationInReentrantLock ();//实例化对象，用于创建内部类的实例
        Thread threadW = new Thread(cis.new ThreadW(lock,condition));//实例化等待线程
        threadW.setName("W");//命名等待线程
        threadW.start();//启动等待线程
        Thread threadN = cis.new ThreadN(lock,condition);//实例化通知线程
        threadN.setName("N");//命名通知线程
        threadN.start();//启动通知线程
    }
//实现Runnable接口的等待线程类
class ThreadW implements Runnable{
    private Lock lock;
    private Condition condition;
    public ThreadW(ReentrantLock lock,Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }
    @Override
    public void run() {
        lock.lock();//上锁
        try {
            System.out.println(Thread.currentThread().getName()
 + " begin wait time:" + System.currentTimeMillis());
            condition.await();//使当前线程进入等待队列，同时释放当前持有的锁
            System.out.println(Thread.currentThread().getName() 
 + " end wait time:" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();//释放锁
        }   
    }   
}
//通知线程类
class ThreadN extends Thread{
    private Lock lock;
    private Condition condition;
    public ThreadN(ReentrantLock lock,Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }
    @Override
    public void run() {
        lock.lock();//上锁
        try {
            System.out.println(Thread.currentThread().getName() + 
            " begin notify time:" + System.currentTimeMillis());
            condition.signal();//通知等待队列中的线程，使其进入就绪队列，准备获取锁
            Thread.sleep(3000); 
            System.out.println(
            Thread.currentThread().getName() +
             " end notify time:" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();//释放当前持有的锁
        }
    }
}
}