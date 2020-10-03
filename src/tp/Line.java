package tp;

public class Line {

    private String binaryString;

    public Line(char inputChar) {
        this.binaryString = addParityBit(convertToBinary(inputChar));
    }

    public String getBinaryString() {
        return binaryString;
    }

    private String convertToBinary(char inputChar) {
        String inputCharToBinary = Integer.toBinaryString(inputChar);
        if (inputCharToBinary.length() == 7) {
            inputCharToBinary = "0" + inputCharToBinary;
        }
        return inputCharToBinary;
    }

    private String addParityBit(String binaryString) {
        return binaryString;
    }
}
