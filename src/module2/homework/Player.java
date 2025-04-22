package module2.homework;

import java.util.Scanner;

public class Player {
    int rightNum = 0;
    Scanner input = new Scanner(System.in);

    public String guess() {
        return input.next();
    }
}
