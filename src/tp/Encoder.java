package tp;

import java.util.ArrayList;

public class Encoder {

    private ArrayList<CharGroup> charGroups = new ArrayList<>();

    private String stringToEncode;
    private int eightCharCount;
    
    public void getStringToEncode() {
        Console.clearScreen();
        Console.printLine("Entrez la chaine de caractère à encoder : ");
        stringToEncode =  Keyboard.ReadKeyBoardString();
    }

    public int getEightCharCount(String string) {
        int eightCharCount = Math.floorDiv(string.length(), 8) + 1;
        if (string.length() % 8 == 0) {
            eightCharCount--;
        }
        return eightCharCount;
    }

    public void createCharGroup() {
        eightCharCount = getEightCharCount(stringToEncode);
        for (int i = 1; i <= eightCharCount; i++) {
            
        }
    }

    public void encode() {
    }
}
