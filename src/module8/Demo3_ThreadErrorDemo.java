package module8;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static module8.Demo3_ThreadErrorDemo.MAX_COUNT;

// 共享资源类
class Counter {
    public int count = 0;
    // 排他锁
    private final Lock lock = new ReentrantLock();



    // 同步方法（对整个方法上锁）
    public synchronized void increment() {
        count++;
    }

    // 同步代码块（只对部分语句上锁，更细粒度）
    public void increment2() {
        //System.out.println(Thread.currentThread()+": 准备+1");
        synchronized (this) {
            count++;
        }
    }


    public void increment3() {
       // System.out.println(Thread.currentThread()+": 准备+1");

        lock.lock();

        try{
//            System.out.println("当前正在执行的线程是："+Thread.currentThread().getName()+" count = "+count);
            count++; // 假设出现异常，那么lock永远不会释放（死锁），所以释放锁一定要放在finally中
        }
        finally{
            lock.unlock();
        }
    }


}

class WokerThread extends Thread {
    private Counter counter;  // 持有的共享资源

    public WokerThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < MAX_COUNT; i++) {
            counter.count++;
        }
    }
}


public class Demo3_ThreadErrorDemo {
    public static int MAX_COUNT = 1000;

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        WokerThread thread1 = new WokerThread(counter);
        WokerThread thread2 = new WokerThread(counter);
        thread1.start();
        thread2.start();
        thread1.join();  // 主线程（waiting） 等待 thread1 完成后，再继续往下运行
        thread2.join();  // 主线程（waiting） 等待 thread2 完成后，再继续往下运行

        System.out.println("counter.count = " + counter.count); // count理想情况是 20000，但是每次执行可能都会小于2w，这个就是竞态导致的。
    }


}
