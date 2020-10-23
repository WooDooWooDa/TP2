package tp;

import java.util.ArrayList;

public class Decoder {

    private final String CORRUPTED = Console.ANSI_RED + "Corruption dans la séquence" + Console.ANSI_RESET;

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
        Console.clearScreen();
        Console.printLine("-- Chaine de caractère décodé --");
        if (decodedString == CORRUPTED) {
            Console.printLine(CORRUPTED);
            return;
        }
        Console.printLine(decodedString);
    }

    private void readBitLines() {
        String bitLine;
        do {
            do {
                bitLine = Keyboard.ReadKeyBoardString();
                if (containsOtherThanBit(bitLine)) {
                    Console.printLengthError();
                }
            } while (containsOtherThanBit(bitLine));

            if (!bitLine.equals("")) {
                lineGroups.add(new Line(bitLine));
                lineInLastBlock++;
            }
            if (lineInLastBlock == 8) {
                Console.printLine("Entrez votre ligne de parité maintenant");
            }
            if (lineInLastBlock == 9) {
                addLinesInBlocks();
                lineInLastBlock = 0;
                lineGroups.clear();
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
        return (bitLine.length() != 9) && !bitLine.equals("");
    }
}
