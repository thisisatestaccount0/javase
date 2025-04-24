package module2.interfacedemo;

/**
 * 定义了游泳的接口
 */
public interface Swimmer {
    // swim方法是一个抽象方法
    // 默认就是抽象的，所以abstract关键字可以省略
    void swim();
//    abstract void swim();
    // 默认方法： 所有实现了这个接口的类 默认的行为  (JDK8以上引入的特性)
    default void shangAn(){
        System.out.println("从岸边爬起来");
    }

    //  (JDK8以上引入的特性)
    static void printTest() {
        System.out.println("这个是一个接口的定义");
    }


}
