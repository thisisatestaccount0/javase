package module1;

import java.util.Scanner;

public class Demo3ControlFlow {
    public static void main(String[] args) {


        // 1. 条件语句  if - else

        System.out.println("===== 条件语句  if - else =====");
//        Scanner input = new Scanner(System.in);
//        int score = input.nextInt();

        int score = 85;
        if (score >= 90) {
            System.out.println("S");
        } else if (score >= 80) {
            System.out.println("A");
        } else if (score >= 70) {
            System.out.println("B");
        } else {
            System.out.println("C");
        }

        // 三元表达式
        String result = score >= 60 ? "合格" : "不合格";
        System.out.println(result);
        System.out.println();
        // 三元表达式可以理解为是简化版的if-else

        // 2. switch - case
        System.out.println("===== switch - case =====");
        int day = 8;
        switch (day) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("工作日");
                break;
            case 6:
            case 7:
                System.out.println("休息日");
                break;
            default:
                System.out.println("无效日期");

        }

        // jdk 1.7 版本之后，Switch才支持 String类的Switch
        String month = "Feb";
        switch (month) {
            case "Jan":
                System.out.println("1月");
                break;
            case "Feb":
                System.out.println("2月");
                break;

        }

        System.out.println();
        // 3. 循环语句 -  for 循环
        System.out.println("===== 循环语句 -  for 循环 =====");
        // for 循环执行逻辑：
        // 先执行第一个分号前的代码 int i = 0;
        // 然后执行第二个分号前的代码 i<5，如果满足条件，执行循环体。
        // 最后再执行第三个语句 i++;
        // 之后循环往复执行判断语句、循环体、i++，直到判断条件不满足
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
        }

        System.out.println();
        // 4. 增强for循环 （for-each）， jdk5 版本引入的

        System.out.println("===== 增强for循环 （for-each） =====");
        int[] arrayVar = {1, 2, 3, 4, 5};
        for (int var : arrayVar) {
            System.out.println("var = " + var);
        }


        // 5. while 循环
        System.out.println("===== while 循环 =====");
        int count = 0;
        // 当xxx的时候，执行xxx，否则结束循环
        while (count <= 5) {
            System.out.println("count = " + count);
            count++;
        }

        // 7. do - while 循环
        System.out.println("===== do - while 循环 =====");
        int j = 1;
        // 不管循环条件是否满足，先执行do中的循环体一次，再进行条件判断。
        do {
            System.out.println("j = " + j);
            j++;
        } while (j < 5);


        // 6. 循环控制  break、continue
        System.out.println("===== 循环控制  break =====");

        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break; // 执行break，会跳出整个循环
            }
            System.out.println("i = " + i);
        }

        System.out.println("===== 循环控制  continue =====");

        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                continue; // 执行continue，会跳出当前这次的循环体
            }
            System.out.println("i = " + i);
        }



        //7. 嵌套循环 （输出 99乘法表）
        System.out.println("===== 嵌套循环 （输出 99乘法表） =====");
        for (int i = 1; i <= 9; i++) {
            for (int k = 1; k <= i; k++) {
                System.out.print(i + "x" + k + "=" +(i * k) + "\t");
            }
            System.out.println();
        }

        // 8. 带标签的循环
        System.out.println("===== 带标签的循环 =====");

        outerLoop:for (int i = 1; i <= 9; i++) {
            for (int k = 1; k <= i; k++) {
                System.out.print(i + "x" + k + "=" +(i * k) + "\t");
                if (k == 6) {
                    break outerLoop;
                }
            }
            System.out.println();
        }


    }
}
