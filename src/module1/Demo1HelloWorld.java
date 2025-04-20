package module1;

public class Demo1HelloWorld {

    private final static String MYSQL_URL = "jdbc:mysql://localhost:3306/test";

    /**
     * 这个是文档注释，文档注释在生成文档的时候会被解析。
     *
     * @param args
     */
    public static void main(String[] args) {
        // println = print line
        System.out.println("Hello World");

        // 这个是一个单行注释，注释是给人看的，对于计算机来说，会自动忽略

        /*
        这个是多行注释
        sdfasdfsdjlkf
        sadf
        asd
        asdfasdjlfjaldsf
         */
        // sum是变量名称，也叫做标识符。
        int sum = 0;


        int sum1 = 1;
        int _sum = 10;

        for (int i = 0; i < 10; i++) {
            sum = sum + i;
        }

        System.out.println("sum = " + sum);


        // 变量的作用域:其定义所在的一对{ }内
        String test = "test";
        // 这里可以访问到test
        System.out.println(test);
        System.out.println(MYSQL_URL);

        // 不能重复定义，
//        String test = "test222";
        // 如果需要修改值，直接修改即可
        test = "test2222";

    }

    public void a1() {
        // 这里访问不到test，因为 test变量不在这个大括号内中定义。
        // System.out.println(test);
        // 可以访问到 MYSQL_URL ，因为在同个大括号范围内。
        System.out.println(MYSQL_URL);
    }

    public void a2() {

    }
}


