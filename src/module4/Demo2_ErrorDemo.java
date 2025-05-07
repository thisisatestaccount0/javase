package module4;


import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Demo2_ErrorDemo {
    public static void main(String[] args) {

        // StackOverflowError
//        test();

        // OutOfMemoryError
        List<Object> list = new ArrayList<Object>();
        int i = 0;
        // OutOfMemoryError
        // -Xms10m   表示配置jvm虚拟机的起始堆内存大小为10mb
        // -Xmx10m   表示配置jvm虚拟机的最大堆内存大小为10mb
        while (true) {
            list.add(new byte[1024*1024]); //每次分配1MB内存
            System.out.println(i++);
        }



    }


    // 循环调用，不停地压栈，直到栈内存溢出
    public static void test() {
        System.out.println("in test");
        // 避免方式：增加一个循环结束条件
        test();
    }
}
