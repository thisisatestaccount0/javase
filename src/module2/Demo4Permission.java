package module2;

// Demo4Permission 和 Demo1Person 的关系是： 同包下的  不同的类
public class Demo4Permission {

    public static void main(String[] args) {

        Demo1Person xiaoming =  new Demo1Person("小明",18,'男');
        System.out.println("xiaoming的年龄是" + xiaoming.age);

    }
}
