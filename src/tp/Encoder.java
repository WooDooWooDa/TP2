package tp;

import java.util.ArrayList;

public class Encoder {

    private ArrayList<Line> lineGroups = new ArrayList<>();
    private ArrayList<Block> blockGroups = new ArrayList<>();

    private final String stringToEncode;
    private int blockCount;

    public Encoder(String string) {
        this.stringToEncode = string;
        countNbBlock();
        createLines();
        groupLines();
    }

    public int getBlockCount() {
        return blockCount;
    }

    private void countNbBlock() {
        blockCount = Math.floorDiv(stringToEncode.length(), 8) + 1;
        if (stringToEncode.length() % 8 == 0) {
            --blockCount;
        }
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
                for (int j = 0; j < lineGroups.size(); j++) {
                    block.addLine(lineGroups.get(i));
                }
            }
            if (lineGroups.size() > 8) {
                for (int j = 0; j < 8; j++) {
                    block.addLine(lineGroups.get(i));
                    lineAdded++;
                }
            }
            blockGroups.add(block);
        }
    }

}
