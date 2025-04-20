package module2;

/**
 * 单例设计模式
 * 懒汉式 单例设计模式 （懒加载）
 * 饿汉式 单例设计模式 （不管有没有人调用，先把单例对象创建出来）
 *
 * 线程不安全的
 */
public class Demo3Singleton {

    private static Demo3Singleton instance;

    //私有构造器：其他人都不允许访问
    private Demo3Singleton(){
        System.out.println("私有空参构造器被调用了");
    }

    public static Demo3Singleton getInstance(){
        if(instance == null){
            System.out.println("instance不存在，准备创建instance");
            instance = new Demo3Singleton();
        } else{
            System.out.println("instance已经存在，直接返回已存在的instance");
        }
        return instance;
    }
}
