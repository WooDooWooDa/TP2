package tp;

import java.util.ArrayList;

public class Block {

    private final String CORRUPTED = Console.ANSI_RED + "Corruption dans la séquence" + Console.ANSI_RESET;

    private final ArrayList<Line> Lines;
    private String parityLine = "";

    public Block() {
        Lines = new ArrayList<>();
    }

    public void addLine(Line line) {
        Lines.add(line);
    }

    public String getParityLine() {
        return parityLine;
    }

    public void createParityLine() {
        for (int i = 0; i < 9; i++) {
            int oneCount = 0;
            for (Line line : Lines) {
                if (line.getBinaryString().charAt(i) == '1') {
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
        for (Line line : Lines) {
            line.showLine();
        }
        Console.print(parityLine);
    }

    public String decodeBlock() {
        String decodedString = "";
        for (Line line : Lines) {
            int corruptionError = recoverLine(line);
            if (corruptionError == 1) {
                decodedString = CORRUPTED;
                break;
            }
            int parseInt = Integer.parseInt(line.getBinaryStringWithoutParity(), 2);
            char letter = (char) parseInt;
            decodedString += letter;
        }
        return decodedString;
    }

    private int recoverLine(Line line) {
        int bitToInvert = 0;
        int bitPosition = 0;
        for (int i = 0; i < 9; i++) {
            int oneXCount = line.getOneCountInLine();
            int oneYCount = 0;
            for (Line row : Lines) {
                if (row.getBinaryString().charAt(i) == '1') {
                    oneYCount++;
                }
            }
            if (getParityBitForOneCount(oneXCount) != line.getParityBit() && getParityBitForOneCount(oneYCount) != parityLine.charAt(i)) {
                bitToInvert++;
                bitPosition = i;
            }
        }
        if (bitToInvert > 1) {
            return 1;
        }
        if (bitToInvert == 1) {
            line.invertBit(bitPosition);
        }
        return 0;
    }

    private char getParityBitForOneCount(int oneCount) {
        if (oneCount % 2 == 0) {
            return '0';
        }
        return '1';
    }

}
