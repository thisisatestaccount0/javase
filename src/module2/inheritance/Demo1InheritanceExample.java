package module2.inheritance;


public class Demo1InheritanceExample {
    public static void main(String[] args) {
        module2.inheritance.Animal animal = new Animal("大象", 3);
        animal.eat();
        animal.sleep();

        Dog dog = new Dog("旺财", 2, "金毛");
        dog.eat();
        dog.sleep();
        dog.bark();

        Dog dog2 = new Dog("旺财", 2, "金毛");
        dog.eat();
        dog.sleep();
        dog.bark();
        // Dog没有定义equals方法，Animal也没有定义equals
        // equals来源于 Object
        if (dog2.equals(dog)) {
            System.out.println("dog 和 dog2 是同一条狗");
        } else{
            System.out.println("dog 和 dog2 不是同一条狗");
        }

        Cat cat = new Cat("招财猫", 3, false);
        cat.eat();
        cat.sleep();
        cat.catchMouse();


        System.out.println("=============");
        // 多态：
        Animal animal1 = new Dog("小黑", 2, "柯基");
        Animal animal2 = new Cat("狸花猫", 1, true);

        animal1.eat();
        animal2.eat();
        //  父类 是不知道子类有什么方法的 ，所以下面这个直接调用会报错：
        // Cannot resolve method 'bark' in 'Animal'
        // animal1.bark();
        // 虽然我们知道 animal1 是狗，animal2 是猫，但是对于编译器来说，他不知道。
        // 将 animal1 强制转换成 Dog对象
        // ((Dog)animal1).bark();

        Dog dog1 = (Dog) animal1;
        dog1.bark();

        if (animal2 instanceof Dog) {
            Dog dog3 = (Dog) animal2;
            dog3.bark();
        } else {
            System.err.println("animal2 不是狗的实例，不能强转为狗");
        }


        ((Cat)animal2).catchMouse();


        Cat[] cats = new Cat[5];
        Dog[] dogs = new Dog[5];


        Animal[] animals = new Animal[10];
        animals[0] = animal1;
        animals[1] = animal2;
        animals[2] = cat;

        System.out.println("==================");
        for (Animal tmpAnimal : animals) {
            if (tmpAnimal != null) {
                tmpAnimal.eat();
            }
            if (tmpAnimal instanceof Dog) {
                Dog dog3 = (Dog) tmpAnimal;
                dog3.bark();
            }

            if(tmpAnimal instanceof Cat){
                Cat cat2 = (Cat) tmpAnimal;
                cat2.catchMouse();
            }

        }
    }
}



