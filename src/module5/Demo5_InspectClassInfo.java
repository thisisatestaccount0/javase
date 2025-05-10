package module5;

import java.lang.reflect.*;
import java.util.Arrays;

public class Demo5_InspectClassInfo {

    public static void inspectClass(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            System.out.println("--- 检查类: " + clazz.getName() + " ---");

            // 1. 获取类名
            System.out.println("\n1. 类名:");
            System.out.println("   简单名: " + clazz.getSimpleName());
            System.out.println("   规范名: " + clazz.getCanonicalName());
            System.out.println("   包名: " + clazz.getPackage().getName());

            // 2. 获取修饰符
            System.out.println("\n2. 修饰符:");
            int modifiers = clazz.getModifiers();
            System.out.println("   修饰符(int): " + modifiers);
            System.out.println("   是否public: " + Modifier.isPublic(modifiers));
            System.out.println("   是否abstract: " + Modifier.isAbstract(modifiers));
            System.out.println("   是否final: " + Modifier.isFinal(modifiers));
            System.out.println("   是否接口: " + Modifier.isInterface(modifiers));

            // 3. 获取父类
            System.out.println("\n3. 父类:");
            Class<?> superclass = clazz.getSuperclass();
            if (superclass != null) {
                System.out.println("   父类名: " + superclass.getName());
            } else {
                System.out.println("   没有父类（如Object类或接口）。");
            }

            // 4. 获取实现的接口
            System.out.println("\n4. 实现的接口:");
            Class<?>[] interfaces = clazz.getInterfaces();
            if (interfaces.length > 0) {
                for (Class<?> iface : interfaces) {
                    System.out.println("   接口: " + iface.getName());
                }
            } else {
                System.out.println("   没有实现接口。");
            }

            // 5. 获取构造方法
            System.out.println("\n5. 构造方法:");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors(); // 获取所有构造方法
            if (constructors.length > 0) {
                for (Constructor<?> constructor : constructors) {
                    System.out.println("   构造方法: " + constructor.getName());
                    System.out.println("     修饰符: " + Modifier.toString(constructor.getModifiers()));
                    System.out.print("     参数: ");
                    Parameter[] params = constructor.getParameters();
                    if (params.length == 0) {
                        System.out.println("无");
                    } else {
                        for (int i = 0; i < params.length; i++) {
                            System.out.print(params[i].getType().getSimpleName() + " " + params[i].getName() + (i == params.length - 1 ? "" : ", "));
                        }
                        System.out.println();
                    }
                }
            } else {
                System.out.println("   没有声明构造方法。");
            }

            // 6. 获取字段（成员变量）
            System.out.println("\n6. 字段:");
            Field[] declaredFields = clazz.getDeclaredFields(); // 获取所有声明的字段（不包括继承）
            if (declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    System.out.println("   字段: " + field.getName());
                    System.out.println("     类型: " + field.getType().getSimpleName());
                    System.out.println("     修饰符: " + Modifier.toString(field.getModifiers()));
                }
            } else {
                System.out.println("   该类未声明字段。");
            }
            System.out.println("   （如需获取继承字段，可用clazz.getFields()获取public字段，或遍历父类）");

            // 7. 获取方法
            System.out.println("\n7. 方法:");
            Method[] declaredMethods = clazz.getDeclaredMethods(); // 获取所有声明的方法（不包括继承）
            if (declaredMethods.length > 0) {
                for (Method method : declaredMethods) {
                    System.out.println("   方法: " + method.getName());
                    System.out.println("     返回类型: " + method.getReturnType().getSimpleName());
                    System.out.println("     修饰符: " + Modifier.toString(method.getModifiers()));
                    System.out.print("     参数: ");
                    Parameter[] params = method.getParameters();
                    if (params.length == 0) {
                        System.out.println("无");
                    } else {
                        for (int i = 0; i < params.length; i++) {
                            System.out.print(params[i].getType().getSimpleName() + " " + params[i].getName() + (i == params.length - 1 ? "" : ", "));
                        }
                        System.out.println();
                    }
                    System.out.println("     异常类型: " + Arrays.toString(method.getExceptionTypes()));
                }
            } else {
                System.out.println("   该类未声明方法。");
            }
            System.out.println("   （如需获取继承方法，可用clazz.getMethods()获取public方法，或遍历父类）");

            System.out.println("\n--- 检查完成: " + clazz.getName() + " ---");

        } catch (ClassNotFoundException e) {
            System.err.println("未找到类: " + className);
            e.printStackTrace();
        } catch (SecurityException e) {
            System.err.println("检查类时发生安全异常: " + className);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 检查 Demo1 中创建的 ReflectablePerson 类
        inspectClass("module5.ReflectablePerson");

        System.out.println("\n=======================================================\n");

        // 检查标准Java类，如 ArrayList
        inspectClass("java.util.ArrayList");

        System.out.println("\n=======================================================\n");
        // 检查接口
        inspectClass("java.lang.Runnable");
    }
}

