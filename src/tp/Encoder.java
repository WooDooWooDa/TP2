package tp;

import java.util.ArrayList;

public class Encoder {

    private ArrayList<Line> lineGroups = new ArrayList<>();
    private ArrayList<Block> blockGroups = new ArrayList<>();

    private final String stringToEncode;
    private int blockCount;
    private int lineInlastBlock;

    public Encoder(String string) {
        this.stringToEncode = string;
        countNbBlock();
        createLines();
        groupLines();
    }

    public int getBlockCount() {
        return blockCount;
    }

    public int getLineInlastBlock() {
        return lineInlastBlock;
    }

    public void show() {
        Console.clearScreen();
        Console.printLine("-- Chaine de caractère encodée --");
        Console.printSpace(1);
        for (int i = 0; i < blockCount; i++) {
            blockGroups.get(i).showBlock();
            Console.printSpace(1);
        }
    }

    private void countNbBlock() {
        blockCount = Math.floorDiv(stringToEncode.length(), 8) + 1;
        if (stringToEncode.length() % 8 == 0) {
            --blockCount;
        }
        lineInlastBlock = stringToEncode.length() % 8;
    }

    private void createLines() {
        char[] chars = stringToEncode.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            lineGroups.add(new Line(chars[i]));
        }
    }

    private void groupLines() {
        int lineAdded = 0;
        for (int i = 0; i < blockCount; i++) {
            Block block = new Block();
            if (lineGroups.size() <= 8) {
                for (int j = lineAdded; j < lineGroups.size(); j++) {
                    block.addLine(lineGroups.get(j));
                    lineAdded++;
                }
            }
            if ((lineGroups.size() - lineAdded) == lineInlastBlock) {
                int linesLimit = (lineAdded) + lineInlastBlock;
                for (int j = lineAdded; j < linesLimit; j++) {
                    block.addLine(lineGroups.get(j));
                    lineAdded++;
                }
            }
            if (lineGroups.size() > 8 && lineAdded != lineGroups.size()) {
                int linesLimit = lineAdded + 8;
                for (int j = lineAdded; j < linesLimit; j++) {
                    block.addLine(lineGroups.get(j));
                    lineAdded++;
                }
            }
            block.createParityLine();
            blockGroups.add(block);
        }
    }

}
