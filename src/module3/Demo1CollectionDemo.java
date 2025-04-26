package module3;

import java.util.*;

public class Demo1CollectionDemo {
    public static void main(String[] args) {

        System.out.println("========= java 集合类 =========");

        // List 特点： 1. 有序  2. 可重复

        // 1. ArrayList ： 底层是数组的  一个集合
        System.out.println("========= ArrayList =========");
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Java"); // 0号位置
        strings.add("Python"); // 1号位置
        strings.add("C++");
        strings.add("JavaScript");
        strings.add("C#");
        strings.add("Java");
        strings.add("Java");

        System.out.println("集合的包含的元素有：" + strings);
        System.out.println("集合的大小：" + strings.size());
        System.out.println("集合的第一个元素是：" + strings.get(0));

        strings.set(0, "Python");
        strings.remove(1);
        strings.remove("Java"); //删除从前往后 第一个匹配的Java元素（源码中是从小到大的索引进行遍历
        System.out.println("集合的包含的元素有：" + strings);

        System.out.println("集合的包含Java 吗？： " + strings.contains("Java"));


        // LinkedList
        System.out.println("========= LinkedList =========");

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("红色");
        linkedList.add("蓝色");
        linkedList.add("绿色");
        linkedList.add("红色");

        linkedList.addFirst("黑色");
        linkedList.addLast("白色");
        System.out.println("集合的包含的元素有：" + linkedList);
        System.out.println("集合第一个元素：" + linkedList.getFirst());
        System.out.println("集合第一个元素：" + linkedList.get(0));
        System.out.println("集合最后一个元素：" + linkedList.getLast());
        System.out.println("集合最后一个元素：" + linkedList.get(linkedList.size()-1));
        String removeFirst = linkedList.removeFirst();
        String removeLast = linkedList.removeLast();
        System.out.println("removeFirst = " + removeFirst);
        System.out.println("removeLast = " + removeLast);
        System.out.println("集合的包含的元素有：" + linkedList);

        // 特点：  无序、 不可重复
        System.out.println("========= Set =========");
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Java"); // 0号位置
        hashSet.add("Python"); // 1号位置
        hashSet.add("C++");
        hashSet.add("JavaScript");
        hashSet.add("C#");
        hashSet.add("Java");
        hashSet.add("Java");

        System.out.println("hashSet的包含的元素有：" + hashSet);


        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.add("Java"); // 0号位置
        linkedHashSet.add("Python"); // 1号位置
        linkedHashSet.add("C++");
        linkedHashSet.add("JavaScript");
        linkedHashSet.add("C#");
        linkedHashSet.add("Java");
        linkedHashSet.add("Java");
        System.out.println("linkedHashSet的包含的元素有：" + linkedHashSet);

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(1);
//        treeSet.add(4);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(6);
        System.out.println("treeSet的包含的元素有：" + treeSet);
        // treeSet的特有方法（基本跟数据的大小（排序）有关）
        System.out.println("大于3的元素： " + treeSet.tailSet(3, false));
        System.out.println("大于3（包含3）且小于5（包含5）的元素： " + treeSet.subSet(3, true,5,true));
        System.out.println("小于等于4的最大元素： " + treeSet.floor(4));
        System.out.println("大于等于4的最小元素： " + treeSet.ceiling(4));


        // 集合的遍历
        System.out.println("========= 集合的遍历 =========");

        List<String> anotherList = new ArrayList<>();

        // 1. for循环
        System.out.println("========= for循环 =========");
        for (int i = 0; i < strings.size(); i++) {
            // fori 索引遍历
            System.out.println("strings.get(i) = " + strings.get(i));
            if (i >= 2) {
                anotherList.add(strings.get(i));
            }
        }

        System.out.println("========= 增强for循环遍历 =========");
        // 2. 增强for循环遍历
        for (String ele : hashSet) {
            System.out.println("ele = " + ele);
        }

        System.out.println("========= 迭代器遍历 =========");
        // 3. 迭代器遍历
        Iterator<String> iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator.next() = " + iterator.next());
        }

        System.out.println("========= forEach+lambda =========");
        // 4. forEach+lambda (jdk8以上的方法）
        treeSet.forEach(item -> System.out.println("item = " + item));

        System.out.println("========= streamAPI =========");
        // 5. streamAPI
        treeSet.stream().forEach(item -> System.out.println("item = " + item));
    }
}
