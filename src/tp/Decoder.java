package tp;

import java.util.ArrayList;
import java.util.function.ToDoubleBiFunction;

public class Decoder {

    private final String CORRUPTED = Console.ANSI_RED + "Corruption dans la séquence" + Console.ANSI_RESET;

    private final ArrayList<Line> lineGroups;
    private final ArrayList<Block> blockGroups;

    private String bitsLine;
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
    
    public void setBitsLine(String bitsLine) {
        this.bitsLine = bitsLine;
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
        do {
            do {
                bitsLine = Keyboard.ReadKeyBoardString();
                if (containsOtherThanBit(bitsLine)) {
                    Console.printLengthError();
                }
            } while (containsOtherThanBit(bitsLine));

            if (!bitsLine.equals("")) {
                lineGroups.add(new Line(bitsLine));
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
        } while (!bitsLine.equals(""));
        addLinesInBlocks();
    }
    
    private void groupBitsLine() {
        // TODO: 2020-10-28 group bitsline from bitsline 
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
        return (bitLine.length() % 8 == 0) && !bitLine.equals("");
    }
}
