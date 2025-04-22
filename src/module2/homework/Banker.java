package module2.homework;

public class Banker {

    String result ;
    int a, b, c;
    public void rollDice() {
        a = (int) (Math.random() * 6 + 1);
        b = (int) (Math.random() * 6 + 1);
        c = (int) (Math.random() * 6 + 1);

        if (a == b && b == c) {
            result = "豹子";
        } else if (a + b + c <= 9) {
            result = "小";
        } else {
            result = "大";
        }

        System.out.println("请玩家下注（大、小、豹子）：");

    }

    public boolean announceResult(String guess) {
        System.out.printf("a=%d,b=%d,c=%d，结果是：%s\n", a, b, c,result);
        if(guess.equals(result)) {
            System.out.println("恭喜猜对了");
            return true;
        } else {
            System.out.println("很遗憾，猜错了");
            return false;
        }
    }
}
