package tp;

import java.util.ArrayList;

public class Encoder {

    private ArrayList<Line> lineGroups = new ArrayList<>();
    private ArrayList<Block> blockGroups = new ArrayList<>();

    private String stringToEncode;
    private int blockCount;
    
    public void getStringToEncode() {
        Console.clearScreen();
        Console.printLine("Entrez la chaine de caractère à encoder : ");
        stringToEncode =  Keyboard.ReadKeyBoardString();
    }

    public int getBlockCount(String string) {
        int eightCharCount = Math.floorDiv(string.length(), 8) + 1;
        if (string.length() % 8 == 0) {
            --eightCharCount;
        }
        return eightCharCount;
    }

    public void createLines() {
        char[] chars = stringToEncode.toCharArray();
        for (int i = 1; i <= chars.length; i++) {
            lineGroups.add(new Line(chars[i]));
        }
    }

}
