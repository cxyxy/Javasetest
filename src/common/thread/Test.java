package common.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * User: Amos
 * Date: 2019/4/19
 * Time: 16:11
 *stop
 * 1.使用stop api过时
 * 2.会导致方法 逻辑不完整
 * 3.会破坏原子性
 */
public class Test {
//    public static void main(String[] args) {
//        MutilThread t = new MutilThread();
//        Thread t1 = new Thread(t);
//        t1.start();
//        for (int i = 0; i <5 ; i++) {
//            new Thread(t,"thread----"+i).start();
//        }
//        t1.stop();
//    }

    //跑步
//    public static void main(String[] args) throws Exception {
//
//        //跑步人数
//        int num=10;
//        //发令枪
//        CountDownLatch begin = new CountDownLatch(1);
//        //参人
//        CountDownLatch end = new CountDownLatch(num);
//        //没人一个跑到
//        ExecutorService es = Executors.newFixedThreadPool(num);
//        ArrayList<Future<Integer>> futures = new ArrayList<>();
//        for (int i = 0; i <num ; i++) {
//            futures.add(es.submit(new Runner(begin,end)));
//        }
//
//        //法令开始跑
//        begin.countDown();
//        //等所有人跑完
//        end.await();
//        System.out.println("都跑完了！！！");
//        int count=0;
//        for (Future<Integer> future:futures){
//            count+=future.get();
//        }
//        System.out.println("平均分"+count/10);
//    }

    //会和到一起   ,CyclicBarrier
    public static void main(String[] args) {

        CyclicBarrier sb = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("隧道已经打通");
            }
        });

        new Thread(new Worker(sb),"工人1   ").start();
        new Thread(new Worker(sb),"工人2    ").start();
    }
}
