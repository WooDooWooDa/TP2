package tp;

import java.util.ArrayList;

public class Block {

    private ArrayList<Line> Lines;
    private String parityLine;

    public Block() {
        Lines = new ArrayList<>();
    }

    public void addLine(Line line) {
        Lines.add(line);
    }

    public void createParityLine() {
        for (int i = 0; i < Lines.size(); i++) {
            for (int j = 0; j < 9; j++) {
                Lines.get(j).getBinaryString();
            }
        }
    }

    public void showBlock() {
        for (int i = 0; i < Lines.size(); i++) {
            Lines.get(i).showLine();
        }
        Console.printLine("    " + parityLine);
    }

}
