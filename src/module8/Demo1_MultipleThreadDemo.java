package module8;

// 穿件多线程的方式1，继承Thread类，有局限性：无法同时继承多个类
public class Demo1_MultipleThreadDemo extends Thread {
    private String threadName;

    public Demo1_MultipleThreadDemo(String threadName) {
        this.threadName = threadName;
    }


    @Override
    public void run() {
        // 线程要做的事情
        System.out.println("正在运行 " + this.threadName);
        for (int i = 0; i < 100; i++) {
            System.out.println(this.threadName+ "输出： " + i);
        }

        System.out.println(this.threadName+"执行完成");


    }
}
