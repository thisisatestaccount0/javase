package module5;

class ReflectablePerson{
    private String name;
    private int age;
    protected String address = "Unknown";

    public ReflectablePerson() {
    }
    public ReflectablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public ReflectablePerson(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void introduce() {
        System.out.println("我的名字叫"+this.name+",今年"+this.age+"岁。");
    }

    private String getInformation(){
        return name + " " + age + " " + address;
    }


}



public class Demo4_ReflectionDemo {

    public static void main(String[] args) {
        // 获取 class 对象的方式
        // 1. 直接使用 .class获取
        // 优点： 最安全，编译时会检查
        // 缺点： 需要在编译时就知道类名称
        Class<ReflectablePerson> class1 = ReflectablePerson.class;
        // 获取全限定名
        System.out.println("class1.getName() = " + class1.getName());

        // java自带的类，也可以这样用
        Class<String> stringClass = String.class;
        Class<Integer> integerClass = int.class;
        Class<Void> voidClass = void.class;


        // 2. 通过调用 对象的.getClass方法
        // 缺点：必须要有实例，实际情况下用的比较少
        ReflectablePerson person = new ReflectablePerson();
        Class<? extends ReflectablePerson> class2 = person.getClass();
        // 获取全限定名
        System.out.println("class2.getName() = " + class2.getName());

        System.out.println(class1 == class2);
        String t1 = "abc";
        String t2 = "def";
        System.out.println("t1.getClass()==t2.getClass() = " + (t1.getClass() == t2.getClass()));

        // 3. 使用 Class.forName("全限定名") 来获取class对象。 Class.forName也常用来让jvm加载某个类
        // 优点：  动态传参，比较灵活
        // 缺点： 有可能找不到这个类，会抛出ClassNotFoundException异常
        try {
            Class<?> class3 = Class.forName("module5.ReflectablePerson");
            System.out.println("class3.getName() = " + class3.getName());
            Class<?> notFound = Class.forName("module5.ReflectablePerson1");
        } catch (ClassNotFoundException e) {
            System.err.println("无法找到\"module5.ReflectablePerson1\"类");
        }

        // 4. 类加载器：classloader （仅作为了解）
        // java 文件 -- 编译 --> class文件 --加载(用到了类加载器)--> jvm内存
        ClassLoader classLoader = Demo4_ReflectionDemo.class.getClassLoader();
        try {
            Class<?> class4 = classLoader.loadClass("module5.ReflectablePerson");
            System.out.println("class4.getName() = " + class4.getName());
        } catch (ClassNotFoundException e) {
            System.err.println("无法找到类");
        }


    }
}
