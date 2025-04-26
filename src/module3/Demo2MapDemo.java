package module3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.function.BiConsumer;

public class Demo2MapDemo {
    public static void main(String[] args) throws IOException {

        // 1. HashMap
        //  名字  和  分数
        // 1班
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put(null, 0);
        scores.put("张三", 90);
        scores.put("李四", 88);
        scores.put("王五", 59);
        scores.put("赵六", 100);
        scores.put("田七", 100);

        // 通过key 找到value
        System.out.println("张三的分数是： " + scores.get("张三"));

        scores.put("王五", 60); // 相同的key多次写入数据，值会被覆盖
        System.out.println("修改后的王五的分数是： " + scores.get("王五"));

        // 判断
        System.out.println("是否包含赵六？ " + scores.containsKey("赵六"));
        System.out.println("是否有人考了85分？： " + scores.containsValue(85));

        Set<String> names = scores.keySet();
        System.out.println("所有考生的名字： " + names);
        Collection<Integer> values = scores.values();
        System.out.println("所有分数： " + values);
        System.out.println("有多少个键值对： " + scores.size());


        // putAll
        // 2班
        HashMap<String, Integer> scores2 = new HashMap<>();
        scores2.put("张三", 100);
        scores2.put("李四2", 88);
        scores2.put("王五2", 59);
        scores2.put("赵六2", 100);
        scores2.put("田七2", 100);

        scores.putAll(scores2);

        System.out.println("所有考生的名字： " + scores.keySet());
        System.out.println("所有分数： " + scores.values());

        // 遍历map
        // 1. keySet遍历
        System.out.println("==========keySet遍历==========");
        for (String key : scores.keySet()) {
            Integer value = scores.get(key);
            System.out.println(key + ":" + value);
        }
        // 2. entrySet
        System.out.println("==========entrySet==========");
        Set<Map.Entry<String, Integer>> entries = scores.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        // 3. forEach + lambda
        System.out.println("==========forEach + lambda==========");
        scores.forEach((key,value) -> System.out.println(key + ":" + value));

        System.out.println("==========BiConsumer==========");
        BiConsumer<String, Integer> first = (key, value) -> System.out.println(key + ":" + value);
        BiConsumer<String, Integer> after = (key, value) -> System.out.println("加分后的结果："+key + ":" + value);
        BiConsumer<String, Integer> biConsumer = first.andThen(after);
        scores.forEach(biConsumer);

//        scores.forEach(
//                ((BiConsumer<String, Integer>)(key, value) -> System.out.println(key + ":" + value))
//                        .andThen((key, value) -> System.out.println(key + ":" + value))
//                );

        //  嵌套Map结构   Map<name,Map<Subject,Score>>
        Map<String,Map<String,Integer>> map = new HashMap<>();

        Map<String,Integer> subject = new HashMap<>();
        subject.put("语文", 90);
        subject.put("数学", 80);

        map.put("张三",subject);

        Map<String,Integer> subject2 = new HashMap<>();
        subject2.put("语文", 80);
        subject2.put("数学", 90);

        map.put("李四",subject2);
        System.out.println("==========嵌套keySet遍历==========");
        for (String name : map.keySet()) {
            Map<String,Integer> tmpSubject = map.get(name);
            System.out.println("下面开始公布"+name+"的成绩：");
            for (String temSubjectKey : tmpSubject.keySet()) {
                System.out.println(temSubjectKey + ":" + tmpSubject.get(temSubjectKey));
            }
        }

        TreeMap<Integer, String> salaries = new TreeMap<>();
        salaries.put(10000, "助理");
        salaries.put(50000, "经理");
        salaries.put(35000, "主程");
        salaries.put(40000, "主管");
        salaries.put(30000, "工程师");
        System.out.println("salaries = " + salaries);

        System.out.println("key小于38000的元素 " + salaries.headMap(38000));
        System.out.println("key大于等于38000的元素 " + salaries.tailMap(38000));


//        Properties properties = new Properties();
//        properties.setProperty("username", "admin");
//        properties.setProperty("passwod", "123456");
//        properties.setProperty("database", "mysql");
//        properties.setProperty("table", "user");
//        properties.setProperty("url", "jdbc:mysql://localhost:3306/user");
//
//
//        // properties特有的方法
//        properties.store(new FileOutputStream("database.properties"),"database configuration");

        Properties fromFile = new Properties();
        fromFile.load(new FileInputStream("database.properties"));
        System.out.println("fromFile.getProperty(\"username\") = " + fromFile.getProperty("username"));
    }
}
