package module1;

public class Demo2DataTypes {
    public static void main(String[] args) {

        // 1. 基本数据类型 （primitive）

        // 整数类型 （表数范围）
        byte byteVar = 127;                  // 1字节，8位，范围：-128 到 127
        short shortVar = 32767;              // 2字节，16位，范围：-32768 到 32767
        int intVar = 2147483647;             // 4字节，32位，范围：-2147483648 到 2147483647
        long longVar = 9223372036854775807L; // 8字节，64位，注意后缀L


        // 浮点类型
        float floatVar = 3.14159F;           // 32位，注意后缀F
        double doubleVar = 3.141592653589793D; // 64位，D可省略

        // 字符类型
        char charVar = 'A';                  // 16位Unicode字符

        // 布尔类型
        boolean booleanVar = true;           // true或false
        boolean booleanVar2 = false;           // true或false


        // 输出所有基本数据类型
        System.out.println("===== 基本数据类型 =====");
        System.out.println("byte类型: " + byteVar);
        System.out.println("short类型: " + shortVar);
        System.out.println("int类型: " + intVar);
        System.out.println("long类型: " + longVar);
        System.out.println("float类型: " + floatVar);
        System.out.println("double类型: " + doubleVar);
        System.out.println("char类型: " + charVar);
        System.out.println("boolean类型: " + booleanVar);
        System.out.println("boolean类型2: " + booleanVar2);


        // 2. 引用数据类型 （所有的对象都是引用数据类型）
        System.out.println("===== 引用数据类型 =====");

        // 字符串（String是Java中最常用的引用类型之一）
        String stringVar = "Hello Java";
        System.out.println("String类型: " + stringVar);


        // 数组
        int[] arrayVar = {1, 2, 3, 4, 5};
        System.out.print("Array类型: ");
        for (int i = 0; i < arrayVar.length; i++) {
            System.out.print(arrayVar[i] + " ");
        }
        System.out.println();


        // 3. 数据类型转换
        System.out.println("===== 数据类型转换 =====");
        int i = 10;
        // 自动类型转换
        long l = i;
        System.out.println("自动类型转换（int --> long）：");
        System.out.println("i = " + i);
        System.out.println("l = " + l);


        long l2 = 1000000000000L;  // 远远大于int的最大值
        // 报错，因为int类型存放不了 long类型的值
        // int i2 = l2;

        long l3 = 10L;
        // 报错，因为int类型存放不了 long类型的值，编译器不会管long的具体的值是多少，只在乎数据类型。
        // int i3 = l3;

        // 强制类型转型
        int i4 = (int) l3;
        System.out.println("强制类型转换（long --> int）无精度丢失：");
        System.out.println("l3 = " + l3);
        System.out.println("i4 = " + i4);


        long l4 = 21474836470L;
        i4 = (int) l4; // 超过了取值范围，会造成精度丢失
        System.out.println("强制类型转换（long --> int）有精度丢失：");
        System.out.println("l4 = " + l4);
        System.out.println("i4 = " + i4);


        double doubleValue = 9.99;
        int intValue = (int) doubleValue; // 从double强制转换为int  --> 小数部分会被截断
        System.out.println("从double强制转换为int  --> 小数部分会被截断：");
        System.out.println("doubleValue = " + doubleValue); //9.99
        System.out.println("intValue = " + intValue); // 9
        double doubleValue2 = intValue;
        System.out.println("doubleValue2 = " + doubleValue2);

        // 4. 包装类

        // 基本数据类型
        int int4 = 10; // 存放在栈内存
        int int4_ = 10; // 存放在栈内存
        System.out.println("int4 == int4_ = " + (int4 == int4_)); //   true
        // 包装类
        Integer intger4 = 10; // 存放在堆内存
        Integer intger4_ = 10; // 存放在堆内存
        // 因为 integer4 = 10  小于127，所以存放在常量池中，所以 == 得到的结果是true
        System.out.println("intger4 == intger4_ = " + (intger4 == intger4_)); //   true
        System.out.println("intger4.equals(intger4_) = " + intger4.equals(intger4_)); //  true
        // 包装类
        Integer intger5 = 128; // 存放在堆内存
        Integer intger5_ = 128; // 存放在堆内存
        System.out.println("intger5 == intger5_ = " + (intger5 == intger5_)); //   false  因为超过了127，不是放在常量池中


        // 基本数据类型和包装类型 默认值不同
        Integer intger6 = null;
        int int6 = 0;
        System.out.println("int6 = " + int6);
        System.out.println("intger6 = " + intger6);


        // 5. 运算符
        int int7 = 0;
        // 自增： int7的值加1
        int7++;  // int7 = int7+1;
        int7++;
        int7++;
        // 自减： int7的值减1
        int7--;
        System.out.println("int7 = " + int7);  // 2


        boolean b = int6 > int7; // false
        System.out.println("b = " + b);

        int int8 = 0;
        // 短路与
        // 从左到右判断，一旦前面的判断能整体确认最终表达式的值，那么后面的不再执行。
        if (false && int8++ > 0) {
//        if ( int8++ > 0 && false) { // 这种写法，int8 = 1
            System.out.println("int8++ >0");
        }

        System.out.println("int8 = " + int8); // 0


        int int9 = 0;
        // 逻辑与
        if (false & int9++ > 0) {
            System.out.println("int9++ >0");
        }
        System.out.println("int9 = " + int9); // 1


        // 三元表达式  （三目表达式）
        //select case when aaa>3 then aaa else 3  as bbb
        int aaa = 100;
        int bbb = aaa > 3 ? aaa : 333;
        System.out.println("bbb = " + bbb);


    }
}
