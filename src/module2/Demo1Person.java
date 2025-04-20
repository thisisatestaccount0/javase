package module2;

public class Demo1Person {

    // person类中的属性（成员变量）
    String name;
    int age;
    char gender; // 男/女

    public Demo1Person(){}

    public Demo1Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.gender = '无';
    }
    /*
    构造器的特征 （强制规定）
        它具有与类相同的名称
        它不声明返回值类型。(与声明为void不同)，如果写了返回值类型，就变成了一个方法，而不是构造方法，构造方法是一种特殊的方法
        不能被static、final、synchronized、abstract、native修饰
        不能有return语句返回值
     */
    public Demo1Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    // 每个人都能够进行自我介绍
    // 方法的定义： [修饰符]  返回值类型 方法名(形式参数列表){方法体}`
    public void introduce() {
        System.out.println("大家好，我是" + this.name +
                "，今年" + this.age + "岁了" +
                "，性别是" + this.gender
        );
    }

    public static void main(String[] args) {
        // 类名 对象名 = new 类名();
        Demo1Person xiaoming = new Demo1Person();
        xiaoming.name = "小明";
        xiaoming.age = 18;
        xiaoming.gender = '男';

        // 调用方法
        xiaoming.introduce();


        Demo1Person xiaohong = new Demo1Person("小红", 20, '女');
        xiaohong.introduce();

        Demo1Person xiaoli = new Demo1Person("小李", 22);
        xiaoli.introduce();
    }

}
