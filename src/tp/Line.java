package tp;

public class Line {

    private final String binaryString;
    private final char stringChar;

    public Line(char inputChar) {
        this.stringChar = inputChar;
        this.binaryString = addParityBit(convertToBinary(inputChar));
    }

    public String getBinaryString() {
        return binaryString;
    }

    public char getStringChar() {
        return stringChar;
    }

    private String convertToBinary(char inputChar) {
        String inputCharToBinary = Integer.toBinaryString(inputChar);
        if (inputCharToBinary.length() == 7) {
            inputCharToBinary = "0" + inputCharToBinary;
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
