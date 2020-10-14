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

    public void addParityLine(Line line) {
        parityLine = line.getBinaryString();
    }

    public void showBlock() {
        for (int i = 0; i < Lines.size(); i++) {
            Lines.get(i).showLine();
        }
        Console.printLine("   " + parityLine);
    }

    public String decodeBlock() {
        String decodedString = "";
        for (int i = 0; i < Lines.size(); i ++) {
            Line line = Lines.get(i);
            if (hasToBeRecover(line)) {
                recoverBit(line);
            }
            int parseInt = Integer.parseInt(line.getBinaryStringWithoutParity(), 2);
            char letter = (char)parseInt;
            decodedString += letter;
        }
        return decodedString;
    }

    private void recoverBit(Line line) {
        for (int i = 0; i < 9; i++) {
            int oneCount = 0;
            for (int j = 0; j < Lines.size(); j++) {
                if (Lines.get(j).getBinaryString().charAt(i) == '1') {
                    oneCount++;
                }
            }
            char parityBit;
            if (oneCount % 2 == 0) {
                parityBit = '0';
            } else {
                parityBit = '1';
            }
            if (parityBit != parityLine.charAt(i)) {
                line.invertBit(i);
            }
        }
    }

    private boolean hasToBeRecover(Line line) {
        String binaryString = line.getBinaryString();
        int oneCount = 0;
        for (int i = 0; i < binaryString.length() - 1; i++) {
            if (binaryString.charAt(i) == '1') {
                ++oneCount;
            }
        }
        char parityBit;
        if (oneCount % 2 == 0) {
            parityBit = '0';
        } else {
            parityBit = '1';
        }
        return parityBit != binaryString.charAt(8);
    }

}
