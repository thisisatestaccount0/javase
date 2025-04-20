package module1;

import java.util.Scanner;

/*
赌数游戏

提供三个1-6的随机数，作为掷骰子得到的点数。（赋值） （庄家）

如果各个点数相同，则为豹子。（判断）
如果三个骰子点数和，小于或等于9，则为“小”。
如果三个骰子点数和，大于9，则为“大”。

用户随机选择：押大、押小或者押豹子。（玩家）
通过判断，输出玩家是否押正确，并输出当前三位数字的值。
如果正确三次，结束游戏。（循环）while\for\do-while

提示：
随机数可以采用 (int) (Math.random() * 6 + 1); 产生，math.random()本身返回0～1d的double类型数值，使用强转转成int类型。
获取用户输入可以采用Scanner input = new Scanner(System.in);每次需要获取用户输入时，直接使用 String guess = input.next();
Scanner使用前需要import java.util.Scanner;
 */
public class Homework {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String result = null;
        int rightNum = 0; // 记录答对的次数
        while (true) {
            // 产生随机数：
            int a = (int) (Math.random() * 6 + 1);
            int b = (int) (Math.random() * 6 + 1);
            int c = (int) (Math.random() * 6 + 1);

            if (a == b && b == c) {
                result = "豹子";
            } else if (a + b + c <= 9) {
                result = "小";
            } else {
                result = "大";
            }

            System.out.println("等待玩家押注（请输入 大、小或者豹子）： ");
            String guess = input.next();
            System.out.println("玩家猜的是： " + guess);

            if (guess.equals(result)) {
                System.out.println("恭喜你猜对了");
                rightNum++;
                if (rightNum >= 3) {
                    break;
                }
            } else {
                System.out.println("很遗憾回答错误");
            }

            // 格式化输出
            // printf  =  print formatted
            // %d = digit 数字
            // %s = string 字符串
            System.out.printf("a=%d,b=%d,c=%d,result=%s\n", a, b, c, result);
            System.out.println("a=" + a + ",b=" + b + ",c=" + c + ",result=" + result);
        }

        System.out.println("玩家答对了3次，游戏结束。");

    }

}
