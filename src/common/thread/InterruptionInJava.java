package common.thread;

public class InterruptionInJava implements Runnable{
//
//    public static void main(String[] args) throws InterruptedException {
//        Thread testThread = new Thread(new InterruptionInJava(),"InterruptionInJava");
//        //start thread
//        testThread.start();
//        Thread.sleep(1000);
//        //interrupt thread
//        testThread.interrupt();
//
//        System.out.println("main end");
//
//    }
//
//    @Override
//    public void run() {
//        while(true){
//            if(Thread.currentThread().isInterrupted()){
//                System.out.println("Yes,I am interruted,but I am still running");
//
//            }else{
//                System.out.println("not yet interrupted");
//            }
//        }
//    }

//    private volatile static boolean on = false;
//    public static void main(String[] args) throws InterruptedException {
//        Thread testThread = new Thread(new InterruptionInJava(),"InterruptionInJava");
//        //start thread
//        testThread.start();
//        Thread.sleep(1000);
//        InterruptionInJava.on = true;
//
//        System.out.println("main end");
//
//    }
//
//    @Override
//    public void run() {
//        while(!on){
//            if(Thread.currentThread().isInterrupted()){
//                System.out.println("Yes,I am interruted,but I am still running");
//            }else{
//                System.out.println("not yet interrupted");
//            }
//        }
//    }



    private volatile static boolean on = false;
    public static void main(String[] args) throws InterruptedException {
        Thread testThread = new Thread(new InterruptionInJava(),"InterruptionInJava");
        //start thread
        testThread.start();
        Thread.sleep(1000);
        InterruptionInJava.on = true;
        testThread.interrupt();

        System.out.println("main end");

    }

    @Override
    public void run() {
        while(!on){
            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                System.out.println("caught exception right now: "+e);
            }
        }
    }
}