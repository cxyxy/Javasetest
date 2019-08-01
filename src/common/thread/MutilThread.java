package common.thread;

public class MutilThread implements Runnable{
        int a=0;

        @Override
        public void run() {
            synchronized (""){
            a++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a--;
            System.out.println(Thread.currentThread().getName()+"---------a======="+a);
        }}
    }