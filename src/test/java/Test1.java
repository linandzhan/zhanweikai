import java.util.Comparator;

public class Test1 {
    public static Object baozidian = null;

    public static void suspendTest() throws InterruptedException {
        Thread consumerThread = new Thread(()->{
            if(baozidian == null){
                System.out.println("等待包子");
                Thread.currentThread().suspend();
            }
            System.out.println("买到包子，回家");
        });

        consumerThread.start();

        Thread.sleep(3000);

        baozidian = new Object();

        consumerThread.resume();
        System.out.println("通知你买包子");
    }



    public static void suspendLockDemo() throws InterruptedException {
        Thread resumerThread = new Thread(()->{
           if(baozidian == null){
               System.out.println("等待包子");
               synchronized (Object.class){
                   Thread.currentThread().suspend();
               }
               System.out.println("拿包子走人");
           }
        });
        resumerThread.start();

        Thread.sleep(3000);
        synchronized (Object.class){
            resumerThread.resume();
        }

        System.out.println("通知你拿包子");
    }

    public static void suspendLockDemo2() throws InterruptedException {
        Thread consumer = new Thread(()->{
           if (baozidian == null){
               System.out.println("等包子");
               try {
                   Thread.sleep(5000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("等待中");
               Thread.currentThread().suspend();
               System.out.println("买到包子了");
           }
        });

        consumer.start();
        Thread.sleep(300);
        baozidian = new Object();
        consumer.resume();
        System.out.println("吃包子啦");
        consumer.join();
}



    public static void main(String[] args) throws InterruptedException {
  //      suspendTest();
  //      suspendLockDemo();
        suspendLockDemo2();
    }
}
