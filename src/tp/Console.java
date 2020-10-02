package tp;

public class Console {

    public static final String ANSI_RESET = (char)27 + "[0m";
    public static final String ANSI_RED = (char)27 + "[31m";
    public static final String ANSI_GREEN = (char)27 + "[32m";
    public static final String ANSI_YELLOW = (char)27 + "[33m";
    public static final String ANSI_BLUE = (char)27 + "[34m";
    public static final String ANSI_PURPLE = (char)27 + "[35m";
    public static final String ANSI_CYAN = (char)27 + "[36m";

    public static void print(String text) {
        System.out.print(text);
    }

    public static void print(String text, String color) {
        System.out.print(color + text + ANSI_RESET);
    }

    public static void printLine(String line) {
        System.out.println(line);
    }

    public static void printLine(String line, String color) {
        System.out.println(color + line + ANSI_RESET);
    }

    public static void clearScreen() {
        printSpace(50);
    }

    public static void printSpace(int spaces) {
        for(int i = 1; i <= spaces; i++)
            System.out.println();
    }

    public static void printChecksumHeader() {
        clearScreen();
        printLine("-- Bienvenue dans l'environement Checksum --");
    }

    public static void printOptions() {
        printSpace(1);
        printLine("Que désirez-vous faire?");
        printLine("1 : Encoder");
        printLine("1 : Décoder");
        printLine("9 : Quitter");
        printSpace(1);
        print("Entrez votre choix ici (1 ou 2): ");
    }

    public static void printModeError() {
        clearScreen();
        print("ERREUR! -- ", ANSI_RED);
        printLine("Entrez un mode valide (1, 2 ou 9)");
    }

    public static void quit() {
        clearScreen();
        printLine("-- Au revoir! --");
    }
}
