package module2.inheritance;

import module2.interfacedemo.Fly;
import module2.interfacedemo.Swimmer;

public class Cat extends Animal implements Swimmer, Fly {
    private boolean eatFish;

    public Cat(String name, int age, boolean eatFish) {
        super(name, age);
        this.eatFish = eatFish;
        System.out.println("调用了 Cat 的构造函数");
    }

    @Override
    public void eat() {
        if (eatFish) {
            System.out.println(this.name + "正在吃鱼");
        } else {
            System.out.println(this.name + "正在吃猫粮");
        }
    }

    public void catchMouse() {
        System.out.println(this.name + "正在抓老鼠");
    }

    @Override
    public void swim() {
        System.out.println(this.name + "也学会了游泳");
    }

    @Override
    public void fly() {
        System.out.println("猫飞天了");
    }
}
