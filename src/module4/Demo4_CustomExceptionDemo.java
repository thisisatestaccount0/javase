package module4;

public class Demo4_CustomExceptionDemo {
    public static void main(String[] args) throws InvalidAgeException {
        int age = Integer.valueOf(args[0]);
        if (age > 150) {
            throw new InvalidAgeException();
        } else if (age < 0) {
            throw new InvalidAgeException("年龄不能是负数");
        }

        System.out.println("age = " + age);

    }
}
