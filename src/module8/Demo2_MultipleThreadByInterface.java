package module8;

public class Demo2_MultipleThreadByInterface implements Runnable {
    private String threadName;

    public Demo2_MultipleThreadByInterface(String threadName) {
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
