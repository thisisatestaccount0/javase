package module5;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo6_DynamicObject {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Class<ReflectablePerson> class1 = ReflectablePerson.class;
        Constructor<?>[] declaredConstructors = class1.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            if (declaredConstructor.getParameterTypes().length == 2) {
                // 两个参数的构造函数
                /*
                   public ReflectablePerson(String name, int age) {
                        this.name = name;
                        this.age = age;
                    }
                 */
                ReflectablePerson zhangsan = (ReflectablePerson)declaredConstructor.newInstance("zhangsan", 18);
                zhangsan.introduce();
                // 如果想调用 私有化方法，可以通过反射的方式
                Method getInformation = class1.getDeclaredMethod("getInformation");
                getInformation.setAccessible(true); // 让这个私有化方法可以访问（绕过了权限）
                Object result = getInformation.invoke(zhangsan);
                // zhangsan.getInformation();
                System.out.println(result);

            }
        }
    }
}
