package tp;

import java.util.ArrayList;

public class Decoder {

    private final ArrayList<Line> lineGroups;
    private final ArrayList<Block> blockGroups;

    private int lineInLastBlock;
    private String decodedString = "";

    public Decoder() {
        lineGroups = new ArrayList<>();
        blockGroups = new ArrayList<>();
        Console.clearScreen();
        Console.printLine("Appuyer sur ENTER deux fois pour terminer");
        readBitLines();
    }

    public void decode() {
        StringBuilder decodedStringBuilder = new StringBuilder();
        for (Block block : blockGroups) {
            decodedStringBuilder.append(block.decodeBlock());
        }
        decodedString = decodedStringBuilder.toString();
    }

    public void printDecodedString() {
        Console.printLine("Chaine décodé : " + decodedString);
    }

    private void readBitLines() {
        String bitLine = "";
        do {
            do {
                bitLine = Keyboard.ReadKeyBoardString();
                if ((bitLine.length() != 9) && !bitLine.equals("") || containsOtherThanBit(bitLine)) {
                    Console.printLengthError();
                }
            } while ((bitLine.length() != 9) && !bitLine.equals("") || containsOtherThanBit(bitLine));

            if (!bitLine.equals("")) {
                lineGroups.add(new Line(bitLine));
                lineInLastBlock++;
            }
            if (lineInLastBlock == 8) {
                addLinesInBlocks();
                lineInLastBlock = 0;
            }
        } while (!bitLine.equals(""));
        addLinesInBlocks();
    }

    private void addLinesInBlocks() {
        Block block = new Block();
        for (int i = 0; i < lineInLastBlock; i++) {
            if (i == lineInLastBlock - 1) {
                block.addParityLine(lineGroups.get(i));
                continue;
            }
            block.addLine(lineGroups.get(i));
        }
        blockGroups.add(block);
    }

    private boolean containsOtherThanBit(String bitLine) {
        for (int i = 0; i < bitLine.length(); i++) {
            if (bitLine.charAt(i) != '0' && bitLine.charAt(i) != '1') {
                return true;
            }
        }
        return false;
    }
}
