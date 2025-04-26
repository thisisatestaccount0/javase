package module2.homework;

/**
 * 赌数游戏（用面向对象的编程思想实现）
 *
 * 提供三个1-6的随机数，作为掷骰子得到的点数。（赋值） （庄家）
 *
 * 如果各个点数相同，则为豹子。（判断）
 * 如果三个骰子点数和，小于或等于9，则为“小”。
 * 如果三个骰子点数和，大于9，则为“大”。
 *
 * 用户随机选择：押大、押小或者押豹子。（玩家）
 * 通过判断，输出玩家是否押正确，并输出当前三位数字的值。
 * 如果正确三次，结束游戏。（循环）while\for\do-while
 *
 * 提示：
 * 面向对象编程思想，第一步要做的事情是 找到我需要创建的类。
 *
 *  （庄家）、骰子、（玩家）
 *
 * 庄家.摇色子()
 * 玩家.猜大小()
 * 庄家.开结果()*/
public class Main {
    public static void main(String[] args) {

        Banker banker = new Banker();
        Player player = new Player();

        while (player.rightNum < 3) {
            banker.rollDice();

            String guess = player.guess();

            boolean result = banker.announceResult(guess);
            if (result) {
                player.rightNum++;
            }

        }
        System.out.println("玩家猜对了3次，游戏结束。");



    }

}
