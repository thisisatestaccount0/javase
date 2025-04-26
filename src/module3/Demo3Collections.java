package module3;

import module2.Demo1Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo3Collections {
    public static void main(String[] args) {
        // 静态工具类
        // Collections

        List<Integer> intList = new ArrayList<>();
        intList.add(5);
        intList.add(3);
        intList.add(1);
        intList.add(1);
        intList.add(4);
        intList.add(2);
        System.out.println("排序前：");
        System.out.println("intList = " + intList);
//        Collections.sort(intList);
//        System.out.println("排序后：");
//        System.out.println("intList = " + intList);
//        System.out.println("逆转结果：");
//        Collections.reverse(intList);
//        System.out.println("intList = " + intList);
//        Collections.sort(intList, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        });
        Collections.sort(intList, (x, y) -> y.compareTo(x));
        System.out.println("intList = " + intList);


        Integer max = Collections.max(intList);
        System.out.println("max = " + max);
        Integer min = Collections.min(intList);
        System.out.println("min = " + min);

        // 随机打散
        System.out.println("shuffle：");
        Collections.shuffle(intList);
        System.out.println("intList = " + intList);
        System.out.println("交换0和1号位置的元素：");
        Collections.swap(intList, 0, 1);
        System.out.println("intList = " + intList);
        int frequency = Collections.frequency(intList, 1);
        System.out.println("元素1在集合中出现了几次 ："+frequency);

        List<Demo1Person> personList = new ArrayList<>();
        personList.add(new Demo1Person("王五", 28));
        personList.add(new Demo1Person("张三", 18));
        personList.add(new Demo1Person("李四", 20));
        // 按照年龄降序排序
        Collections.sort(personList,(p1,p2) -> p2.age - p1.age);
        System.out.println("personList = " + personList);

    }
}
