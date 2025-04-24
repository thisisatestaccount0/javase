package module2;

public class Demo8FunctionalInterface {

    // JDK8 出现函数式接口之前的实现方式。
    private static class IntegerToDoubleMapper implements MyMapper<Integer,Double>{
        @Override
        public Double map(Integer i) {
            return Double.valueOf(i).doubleValue();
        }
    }

    public static void main(String[] args) {

        // 内部类，具体的实现参考main函数上面的 private static class IntegerToDoubleMapper 定义
        IntegerToDoubleMapper mapper = new IntegerToDoubleMapper();
        System.out.println(mapper.map(10));

        // 匿名内部类
        MyMapper<Integer,Double> mapper1 = new MyMapper<Integer,Double>() {
            @Override
            public Double map(Integer i) {
                return Double.valueOf(i);
            }
        };
        System.out.println(mapper1.map(10));

        // Lambda表达式
        MyMapper<Integer,Double> mapper2 = input ->  Double.valueOf(input);
        System.out.println(mapper2.map(10));


        MyMapper<String,Integer> mapper3 = input ->  input.length();
        System.out.println(mapper3.map("test"));

        MyMapper<String,Integer> mapper4 = String::length;  //方法引用。
        System.out.println(mapper3.map("test"));

    }


}

// 函数式接口指的是  **仅包含一个抽象方法** 的接口
// 注解（告诉编译器额外的信息）
@FunctionalInterface
interface MyMapper<INT,OUT>{
    OUT map(INT i);
}

