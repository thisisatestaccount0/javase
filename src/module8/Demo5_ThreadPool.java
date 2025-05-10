package module8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Demo5_ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        // 连接池 --> 线程池

        // 1. 固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Counter counter = new Counter();

        for (int i = 0; i < 20; i++) {
            NewWorker worker = new NewWorker("thread"+i,counter);
            executorService.submit(worker);
        }
        executorService.shutdown(); // 关闭线程池：不再接受新的任务，但是会等待当前所有已提交任务执行完毕
        executorService.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println(counter.count);
    }
}