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
        mode = Keyboard.ReadKeyBoardInt();
        if (mode == QUIT) {
            Console.quit();
            quit = true;
        }
    }

    public String getStringToEncode() {
        Console.clearScreen();
        Console.printLine("Entrez la chaine de caractère à encoder : ");
        return Keyboard.ReadKeyBoardString();
    }

    public String getBitsLine() {
        String bitsLine;
        Console.clearScreen();
        Console.printLine("Entrez la chaine binaire à décoder : ");
        do {
            bitsLine = Keyboard.ReadKeyBoardString();
            if (containsOtherThanBit(bitsLine)) {
                Console.printLengthError();
            }
        } while (containsOtherThanBit(bitsLine));
        return bitsLine;
    }

    private boolean containsOtherThanBit(String bitLine) {
        for (int i = 0; i < bitLine.length(); i++) {
            if (bitLine.charAt(i) != '0' && bitLine.charAt(i) != '1') {
                return true;
            }
        }
        return (bitLine.length() % 9 != 0);
    }
}
