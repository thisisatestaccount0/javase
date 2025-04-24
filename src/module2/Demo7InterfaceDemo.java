package module2;

import module2.inheritance.Cat;
import module2.inheritance.Dog;
import module2.interfacedemo.Swimmer;

public class Demo7InterfaceDemo {
    public static void main(String[] args) {
        Dog dog = new Dog("旺财",2,"柯基");
        dog.swim();
        dog.shangAn();
        Cat cat = new Cat("招财", 1, true);
        cat.swim();
        cat.shangAn();
        Swimmer.printTest();
    }
}



