package module5;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class Demo3_AnnationProcessing {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> userClazz = Class.forName(User.class.getName()); // 获取到user类的定义时的代码
        Field[] declaredFields = userClazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(MyFieldAnnotation.class)) {
                MyFieldAnnotation fieldAnnotation = field.getAnnotation(MyFieldAnnotation.class);
                System.out.println("字段名是： " + field.getName());
                System.out.println("它拥有一个注解是： " + MyFieldAnnotation.class.getSimpleName());
                System.out.println("注解中的columnName： " + fieldAnnotation.columnName());
                System.out.println("注解中的columnType： " + fieldAnnotation.columnType());
                System.out.println("注解中的nullable： " + fieldAnnotation.nullable());
            } else {
                System.out.println("这个属性"+field.getName()+"没有注解");
            }
        }

//        test();
    }

    // 浏览器访问   http://localhost:8080/test
//    @GetMapping("/test")
//    public static String test() {
//        return "test";
//    }




}




@Target(ElementType.FIELD) // 设置注解范围是字段
@Retention(RetentionPolicy.RUNTIME)
@interface MyFieldAnnotation{
    String columnName();
    String columnType() default "String";
    boolean nullable() default true;
}


class User{
    @MyFieldAnnotation(columnName = "id",columnType = "INT",nullable = false)
    private int userId;
    @MyFieldAnnotation(columnName = "user_name",columnType = "varchar(255)")
    private String username;
    private String password;
}