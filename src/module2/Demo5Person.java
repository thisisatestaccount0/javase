package module2;

/**
 * 实体类
 * 通常是私有化所有属性，然后提供相应的public的方法进行访问。 getter和setter
 */
public class Demo5Person {

    private String name;
    private int age;
    private char gender;

    public Demo5Person() {
    }

    public Demo5Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Demo5Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
