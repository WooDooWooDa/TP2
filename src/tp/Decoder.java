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
    }

    public void decode() {
        groupBitsLine();
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
    
    private void groupBitsLine() {
        for (int i = 0; i < bitsLine.length() / 9; i++) {
            String bitLine = bitsLine.substring(9 * i, (9 * i) + 9);
            lineGroups.add(new Line(bitLine));
            lineInLastBlock++;
            if (lineInLastBlock == 9) {
                addLinesInBlocks();
                lineInLastBlock = 0;
                lineGroups.clear();
            }
        }
        if (lineInLastBlock < 9) {
            addLinesInBlocks();
        }
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
}
