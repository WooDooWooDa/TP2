package tp;

import java.util.ArrayList;

public class Encoder {

    private ArrayList<Line> lineGroups = new ArrayList<>();
    private ArrayList<Block> blockGroups = new ArrayList<>();

    private String stringToEncode;
    private int blockCount;

    public Encoder(String string) {
        this.stringToEncode = string;
        countNbBlock();
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

    public void createLines() {
        char[] chars = stringToEncode.toCharArray();
        for (int i = 1; i <= chars.length; i++) {
            lineGroups.add(new Line(chars[i]));
        }
    }

}
