package module2;

import module1.Demo1HelloWorld;
import module2.inheritance.Dog;

// 静态导入
import static module1.Demo1HelloWorld.MYSQL_URL;
// 不太推荐
import static module1.Demo1HelloWorld.main1;


public class Demo9KeywordDemo {
    // 被final修饰的变量，只能被赋值一次，不能再修改。（只读）
    private static final int A = 10;

    public static void main(String[] args) {
        String test = new String("abc");
        System.out.println("Math.PI = " + Math.PI);
        System.out.println("A = " + A);
        //报错：不能再被修改了
        // A = 100;
        String s = "123";

        testFinal(10);

        // 全限定名的用法
        module2.inheritance.Cat cat = new module2.inheritance.Cat("招财", 2,true);
        // import之后的用法
        Dog dog = new Dog("旺财",3,"萨摩耶");
        dog.bark();
        // 静态导入方法，比较少用
        main1(args);
        // 类名.静态方法  比较常用
        Demo1HelloWorld.main1(args);

        System.out.println("Demo1HelloWorld.MYSQL_URL = " + MYSQL_URL);
    }

    // 方法的局部参数 a 被final修饰，于是不能再被修改值
    public static void testFinal(final int a) {
        if (a < 10) {
            System.out.println("a<10");
            // 报错，因为a是final变量
            // a = 10;
        }
        System.out.println("a = " + a);
    }
}


// 被final修饰的类，不允许被其他类继承，相当于是个最终类。
final class Parent {

}

// String是final修饰的，不能被子类扩展
//class Children1 extends String {
//
//}

// Parent是final修饰的，不能被子类扩展
//class Children2 extends Parent {
//
//}