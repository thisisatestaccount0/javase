package module5;

import lombok.*;

public class Demo2_LombokDemo {
    public static void main(String[] args) {
        Person person = new Person("zhangsan",18);
        System.out.println("person.getAge() = " + person.getAge());
        LombokPerson lombokPerson = new LombokPerson("lisi", 19);
        System.out.println("lombokPerson.getAge() = " + lombokPerson.getAge());
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class LombokPerson{
    private String name;
    private int age;
}


class Person{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}