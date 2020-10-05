package tp;

import java.util.ArrayList;

public class Block {

    private final ArrayList<Line> Lines;
    private String parityLine = "";

    public Block() {
        Lines = new ArrayList<>();
    }

    public void addLine(Line line) {
        Lines.add(line);
    }

    public void createParityLine() {
        for (int i = 0; i < 9; i++) {
            int oneCount = 0;
            for (int j = 0; j < Lines.size(); j++) {
                if (Lines.get(j).getBinaryString().charAt(i) == '1') {
                    oneCount++;
                }
            }
            if (oneCount % 2 == 0) {
                parityLine += "0";
                continue;
            }
            parityLine += "1";
        }
    }

    public void showBlock() {
        for (int i = 0; i < Lines.size(); i++) {
            Lines.get(i).showLine();
        }
        Console.printLine("    " + parityLine);
    }

}
