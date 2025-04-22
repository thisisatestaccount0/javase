package module2.inheritance;

class Dog extends Animal{
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);// this指代当前类的对象，super指代父类，在构造函数中的super就是调用父类的构造函数
        this.breed = breed;
        System.out.println("调用了 dog 的构造函数");
    }

    // 子类重写父类的方法
    @Override
    public void eat() {
        System.out.println(this.breed + "犬" + this.name + "正在吃肉");
    }

    // 增加子类特有的方法
    public void bark() {
        System.out.println(this.name + "汪汪叫");
    }

    @Override
    public boolean equals(Object obj) {
        if( obj instanceof Dog) {
            Dog tmpDog = (Dog) obj;
            if(tmpDog.breed.equals(this.breed) && tmpDog.age == this.age && tmpDog.name.equals(this.name)) {
                return true;
            }

        }
        return false;
    }
}
