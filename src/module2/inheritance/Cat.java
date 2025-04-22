package module2.inheritance;

class Cat extends Animal {
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

}
