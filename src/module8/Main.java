package module8;

public class Main {

    public static void main(String[] args) {
        Demo1_MultipleThreadDemo thread1 = new Demo1_MultipleThreadDemo("线程1");
        Demo1_MultipleThreadDemo thread2 = new Demo1_MultipleThreadDemo("线程2");
        Demo1_MultipleThreadDemo thread3 = new Demo1_MultipleThreadDemo("线程3");
        Demo1_MultipleThreadDemo thread4 = new Demo1_MultipleThreadDemo("线程4");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        Demo2_MultipleThreadByInterface thread11 = new Demo2_MultipleThreadByInterface("线程11");
        Demo2_MultipleThreadByInterface thread22 = new Demo2_MultipleThreadByInterface("线程22");
        Demo2_MultipleThreadByInterface thread33 = new Demo2_MultipleThreadByInterface("线程33");
        Demo2_MultipleThreadByInterface thread44 = new Demo2_MultipleThreadByInterface("线程44");
        new Thread(thread11).start();
        new Thread(thread22).start();
        new Thread(thread33).start();
        new Thread(thread44).start();
    }
}
