package tp;

import java.util.ArrayList;

public class Decoder {

    private ArrayList<Line> lineGroups = new ArrayList<>();
    private ArrayList<Block> blockGroups = new ArrayList<>();

    private String bitLine = "";
    private int blockCount;
    private int lineInLastBlock;

    public Decoder() {
        Console.clearScreen();
        Console.printLine("Appuyer sur ENTER deux fois pour terminer");
        Console.printSpace(1);
        readBitLines();
    }

    public void decode() {
        for (int i = 0; i < lineGroups.size(); i++) {
            Console.printLine(lineGroups.get(i).getBinaryString());
        }
    }

    private void readBitLines() {
        String lastLine;
        do {
            lastLine = bitLine;
            do {
                bitLine = Keyboard.ReadKeyBoardString();
                if ((bitLine.length() != 9) && !bitLine.equals("")) {
                    Console.printLengthError();
                }
            } while ((bitLine.length() != 9) && !bitLine.equals(""));

            lineGroups.add(new Line(bitLine));
        } while (!bitLine.equals(lastLine) && !bitLine.equals(""));
    }
}
