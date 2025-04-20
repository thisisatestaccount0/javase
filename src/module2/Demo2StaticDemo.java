package module2;

public class Demo2StaticDemo {
    // PI是静态变量，可以给所有的圆共享。好处是只在类加载的时候创建一次，不会在每个对象中重复存储
    // final的作用： 一旦赋值之后，就不能再修改了，可以理解为只读变量。
    public static final double PI;
    double r; // 半径

    static {
        System.out.println("这个是一个静态代码块，在类加载的时候就会被执行");
        System.out.println("静态代码块通常的作用是优先进行一次初始化的设置");
        PI = 3.14159265358979323846;
    }


    public Demo2StaticDemo(double r) {
        this.r = r;
    }

    // 计算圆的面积的方法
    public double calculateArea() {
        return r * r * PI;
    }

    // 静态方法，也叫做 类方法
    // 静态方法**不能访问非静态成员**：因为非静态成员属于对象，而静态方法不依赖对象。
    public static void staticMethod() {
        System.out.println("这是一个静态方法，可以不创建对象直接使用。");
        // 我想输出半径是多少，报错，原因是静态成员不能因为非静态的成员。
        // System.out.println("r = " + this.r);
    }


    public static void main(String[] args) {

        Demo2StaticDemo.staticMethod();
        // 报错：因为PI是final修饰的，不能修改值。
//        Demo2StaticDemo.PI = 3.14D;
        Demo2StaticDemo c1 = new Demo2StaticDemo(5);
        Demo2StaticDemo c2 = new Demo2StaticDemo(5.5);

        System.out.println("c1的面积为： " + c1.calculateArea());
        System.out.println("c2的面积为： " + c2.calculateArea());

        c1.staticMethod();


        // 无法访问构造器了，因为是私有的
        // 除了 在 module2.Demo3Singleton 类本身之外，其他地方都不能创建Demo3Singleton的实例。
        // Demo3Singleton instance = new Demo3Singleton();

        Demo3Singleton instance = Demo3Singleton.getInstance();
        Demo3Singleton instance2 = Demo3Singleton.getInstance(); //instance已经存在，直接返回已存在的instance

    }


}
