package module8;

import static module8.Demo3_ThreadErrorDemo.MAX_COUNT;

class NewWorker extends Thread{
    private Counter counter;  // 持有的共享资源
    private String name;


    public NewWorker(String name,Counter counter) {
        this.counter = counter;
        this.name=name;
    }

    @Override
    public void run() {
        for (int i = 0; i < MAX_COUNT; i++) {
            counter.increment3();
        }
        System.out.println(this.name + " --- 结束");
    }


}

public class Demo4_ThreadSyncDemo {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        NewWorker thread1 = new NewWorker("thread1",counter);
        NewWorker thread2 = new NewWorker("thread2",counter);
        thread1.start();
        thread2.start();
        thread1.join();  // 主线程（waiting） 等待 thread1 完成后，再继续往下运行
        thread2.join();  // 主线程（waiting） 等待 thread2 完成后，再继续往下运行

        System.out.println("MAX_COUNT = " + MAX_COUNT);
        System.out.println("counter.count = " + counter.count); // count永远正确，因为用同步方法解决了问题。
    }


}
