package tp;

public class Checksum {

    Menu menu;

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

    }

}
