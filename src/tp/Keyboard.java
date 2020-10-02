package tp;

import java.util.Scanner;

public class Keyboard {

    public static int ReadKeyBoard() {
        Scanner keyBoard = new Scanner(System.in);
        return keyBoard.nextInt();
    }

    public static boolean modeIsNotValid(int mode) {
        if (!(mode == 1 || mode == 2 || mode == 9)) {
            Console.printModeError();
        }
        return !(mode == 1 || mode == 2 || mode == 9);
    }
}
