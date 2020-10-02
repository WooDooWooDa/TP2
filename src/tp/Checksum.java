package tp;

public class Checksum {

    private final int ENCODE = 1;
    private final int DECODE = 2;
    private final Menu menu;

    public Checksum() {
         menu = new Menu();
    }

    public void start() {
        while(menu.isNotQuit()) {
            do {
                menu.display();
                menu.chooseMode();
            } while (Keyboard.modeIsNotValid(menu.getMode()));
            executeMode(menu.getMode());
        }
    }

    private void executeMode(int mode) {
        if (mode == ENCODE) {
            new Encoder();
        }
        if (mode == DECODE) {
            new Decoder();
        }
    }

}
