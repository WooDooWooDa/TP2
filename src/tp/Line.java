package tp;

public class Line {

    private final String binaryString;
    private char stringChar;

    public Line(char inputChar) {
        this.stringChar = inputChar;
        this.binaryString = addParityBit(convertToBinary(inputChar));
    }

    public Line(String binaryString) {
        this.binaryString = binaryString;
    }

    public String getBinaryString() {
        return binaryString;
    }

    public String getStringChar() {
        return String.valueOf(stringChar);
    }

    public char getCharAt(int index) {
        return binaryString.charAt(index);
    }

    public void showLine() {
        Console.print(stringChar + " : ");
        Console.printLine(binaryString);
    }

    private String convertToBinary(char inputChar) {
        String inputCharToBinary = Integer.toBinaryString(inputChar);
        if (inputCharToBinary.length() <= 7) {
            for (int i = 0; i <= (8 - inputCharToBinary.length()); i++) {
                inputCharToBinary = "0" + inputCharToBinary;
            }
        }
        return inputCharToBinary;
    }

    private String addParityBit(String binaryString) {
        int oneCount = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                ++oneCount;
            }
        }
        if (oneCount % 2 == 0) {
            return binaryString + "0";
        }
        return binaryString + "1";
    }

}
