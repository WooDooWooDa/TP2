package tp;

public class Menu {

    private final int QUIT = 9;

    private boolean quit = false;
    private int mode;

    public Menu() {
        Console.printChecksumHeader();
    }

    public int getMode() {
        return mode;
    }

    public boolean isNotQuit() {
        return !quit;
    }

    public void display() {
        Console.printOptions();
    }

    public void chooseMode() {
        mode = Keyboard.ReadKeyBoard();
        if (mode == QUIT) {
            Console.quit();
            quit = true;
        }
    }


}
