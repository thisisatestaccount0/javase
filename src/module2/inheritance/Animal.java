package module2.inheritance;

public class Animal /*extends Object*/{
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("调用了动物的构造函数。");
    }

    public void eat() {
        System.out.println(this.name + "正在吃东西");
    }

    public void sleep() {
        System.out.println(this.name + "正在睡觉");
    }

}