package module3;

import module2.Demo1Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 泛型可以使我们的代码更加健壮，不容易出现
 */
public class Demo4GenericDemo {
    public static void main(String[] args) {

        // 1. 为什么有泛型  —— 规范数据的类型
        System.out.println("======= 不使用泛型 =======");
        ArrayList arrayList = new ArrayList();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add(123);
        arrayList.add(1.23);
        arrayList.add(9999999L);
        double sum = 0.0;
        // 没有泛型的情况下，集合中的元素的类型信息缺失，使用的时候就要自行判断类型（很麻烦）
        for (Object o : arrayList) {
            if (o instanceof Integer) {
                sum = sum + (Integer) o;
            } else if (o instanceof Double) {
                sum = sum + (Double) o;
            }else if (o instanceof Long) {
                sum = sum + (Long) o;
            }
        }
        System.out.println(sum);

        // 1. 使用上不方便：每增加一种类型，我需要增加一个 instanceof 判断
        // 2. 假设不判断直接累加，会出现 类型转换错误 的异常
        ArrayList<Double> arrayList1 = new ArrayList<Double>();
        arrayList1.add(123D);
        arrayList1.add(1.23D);
        arrayList1.add(9999999D);
        sum = 0.0;
        for (Double v : arrayList1) {
            sum = sum + v;
        }
        System.out.println(sum);


        Box<Integer> integerBox = new Box<>();
        integerBox.setItem(123);

        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        integerArrayList.add(123);
        integerArrayList.add(1);
        integerArrayList.add(9999999);
        Collections.sort(integerArrayList, new IntegerComparator());

        Double[] doubleArray = new Double[integerArrayList.size()];
        printArray(doubleArray);

        System.out.println("compareObjects(10,20) = " + compareObjects(10, 20));
        Demo1Person person = new Demo1Person("张三", 18);
        Demo1Person person2 = new Demo1Person("李四", 19);

        // 报错，因为 Demo1Person 没有实现 Comparable 接口，所以 T = Demo1Person 不满足 T extends Comparable<T> 这个条件，所以报错。
        // compareObjects(person, person2);
    }

//    public static <T> int compareObjects(T a, T b) {
//        // T是任意类型，所以任意类型没有compareTo的方法
//        return a.compareTo(b);
//    }

    // 有界类型参数
    public static <T extends Comparable<T>> int compareObjects(T a, T b) {
        // T是继承自Comparable的类型，所以可以直接使用compareTo方法
        return a.compareTo(b);
    }


    // 通配泛型（通配符）
    public static void printList(List<?> array) {
        for (Object e : array) {
            System.out.println(e);
        }
    }
    // 除了Number之外，我希望所有子类都可以使用这个方法
    // 上界（number的子类）通配符 ： 泛型的类型 最高只能去到 Number
    public static void printNumberList(List<? extends Number> array) {
        for (Number e : array) {
            System.out.println(e);
        }
    }
    // 下界
    public static void printIntegerList(List<? super Integer> array) {
        for (Object e : array) {
            if (e instanceof Integer) {
                System.out.println("xxx");
            } else if (e instanceof Number) {
                System.out.println("xxx");
            } else {
                System.out.println("xxx");
            }
            System.out.println(e);
        }
    }


    // 泛型方法 , <E> 含义是告诉编译器  E 是个泛型 而不是类 （空泛 的指代）
    public static <E> void printArray(E[] array) {
        for (E e : array) {
            System.out.println(e);
        }
    }

    // 普通方法
    public static void printArray(Integer[] array) {
        for (Integer e : array) {
            System.out.println(e);
        }
    }

    // 普通方法
    public static void printArray(String[] array) {
        for (String e : array) {
            System.out.println(e);
        }
    }

}

// 泛型类
class Box<T>{
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
// 泛型接口
class IntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}