package module1;

import module2.Demo1Person;

public class Demo4Permission {
    public static void main(String[] args) {

        Demo1Person xiaoming =  new Demo1Person("小明",18,'男');
        // 无法访问 age属性，因为这个属性是默认权限  —— 同包下可以访问，但是不同包不允许访问。
        // 如果给age加上public的修饰符，那么就可以访问到了。
        System.out.println("xiaoming的年龄是" + xiaoming.age);

    }
}
